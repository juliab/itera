package no.itera.tia.ui.panels.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WidgetObjectImpl;
import no.itera.tia.beans.FormData;
import no.itera.tia.beans.model.Property;
import no.itera.tia.enumeration.Properties;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.Editable;
import no.itera.tia.ui.pages.BasePage;
import no.itera.tia.ui.panels.Panel;

public abstract class PanelImpl extends WidgetObjectImpl implements Panel {
	
    public PanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, 5000);
	}

	@Override
	public void expand() {
		if (!isVisible()) {
			then(COVER).click();
		}
	}

	@Override
	public void collapse() {
		if (isVisible()) {
			then(COVER).click();
		}
	}
	
	@Override
	public void waitForPageAction() {
		((BasePage) getPage()).waitForPageAction();
	}
	
	/**
	 * Wrapper around WebElementFacade method to avoid StaleElementReferenceException.
	 * This method is called by every WebElementFacade driver operation.
	 */
	protected WebElement getElement() {
	    WebElement element = super.getElement();
	    try {
	        element.getTagName();
	    } catch (StaleElementReferenceException e) {
	        logger.debug("StaleElementReferenceException");
	        ElementLocator locator = getLocator();
	        if (locator == null) {
	            throw TestException.get("Can't find element: no locator");
	        }
	        element = locator.findElement();
	    }
	    return element;
	}
	
	/**
     * {@inheritDoc}
     */
    @Override
    public void fillForm(FormData entity) {
        if (entity == null) {
            return;
        }
        Stream.of(this.getClass().getDeclaredFields()).forEach(f -> f.setAccessible(true));
        
        for (Field property : entity.getClass().getDeclaredFields()) {
            property.setAccessible(true);
            Object propertyValue = getFieldValue(entity, property);
            if (propertyValue == null) {
                continue;
            }
            Editable control = findMatchingControl(property.getName());
            fillField(control, propertyValue.toString());
        }
    }
    
    protected void fillField(Editable control, String value) {
        control.fill(value);
    }
    
    protected Object getFieldValue(FormData entity, String fieldName) {
        Field field;
        try {
            field = entity.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw TestException.get("Entity " + entity + " doesn't have field " + fieldName, e);
        }
        field.setAccessible(true);
        return getFieldValue(entity, field);
    }
    
    protected Object getFieldValue(FormData entity, Field field) {
        Object result;
        try {
            result = field.get(entity);
        } catch (ReflectiveOperationException e) {
            throw TestException.get("Unable to access field " + field.getName() + " value", e);
        }
        return result;
    }
    
    private Editable findMatchingControl(String name) {
        Field control = Stream.of(this.getClass().getDeclaredFields())
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> TestException.get("Can't find matching control for entity property " 
                        + name + " in the form " + this.getClass().getName()));
        
        control.setAccessible(true);
        
        Object result;
        try {
            result = control.get(this);
        } catch (ReflectiveOperationException e) {
            throw TestException.get("Unable to access " + this.getClass().getSimpleName() + " " + name + " field value", e);
        }
        
        if (!(result instanceof Editable)) {
            throw TestException.get(this.getClass().getSimpleName() + " control " + name + " is not Editable type");
        }
        
        return (Editable) result;
    }
    
    /**
     * Waits until file(-s) download completes.
     * Particularly, waits until all new files in the download directory length is not 0 
     * and none of the new files doesn't have .part extension.
     */
    @Override
    public void waitForDownload() {
        List<Path> originalContent = getDownloadsContent();
        
        try {
            waitForCondition().until(input -> {
                List<Path> newContent = getDownloadsContent();
                if (newContent.size() <= originalContent.size()) {
                    return false;
                }
                List<Path> difference = new ArrayList<>();
                difference.addAll(newContent);
                difference.removeAll(originalContent);
                return difference.stream().allMatch(f -> {
                    return f.toFile().length() > 0 && !f.endsWith(".part");
                });
            });
        } catch (TimeoutException e) {
            throw TestException.get("Timeout waiting until download completes", e);
        }
    }
    
    private List<Path> getDownloadsContent() {
        try {
            return Files.list(Paths.get(Properties.DOWNLOADS_PATH)).collect(Collectors.toList());
        } catch (IOException e) {
            throw TestException.get("Unable to access downloads directory", e);
        }
    }
}
