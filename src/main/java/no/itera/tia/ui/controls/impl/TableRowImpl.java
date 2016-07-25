package no.itera.tia.ui.controls.impl;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.annotations.Column;
import no.itera.tia.annotations.RowMatch;
import no.itera.tia.beans.Entity;
import no.itera.tia.beans.System;
import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.enumeration.HtmlTags;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.Editable;
import no.itera.tia.ui.controls.TableRow;
import no.itera.tia.ui.controls.impl.TableImpl.Header;
import no.itera.tia.ui.pages.BasePage;

public class TableRowImpl<T extends Entity> extends ControlImpl implements TableRow<T> {

    private String columnsCss = "td[nowrap]";
    private By allElements = By.cssSelector("*");
    private List<TableImpl.Header> headings;
    private BasePage page;
    private ElementLocator rowLocator;
    private WebElement row;
    
    public TableRowImpl(BasePage page, ElementLocator locator, 
            long implicitTimeoutInMilliseconds, List<TableImpl.Header> headings) {
        super(page.getDriver(), locator, implicitTimeoutInMilliseconds);
        this.rowLocator = locator;
        this.page = page;
        this.headings = headings;
        this.row = rowLocator.findElement();
    }

    @Override
    public boolean contains(T object) {
        boolean comparisonTookPlace = false;
        
        for (Header header : headings) {
            Field entityField = getMatchingEntityField(object, header.getTitle(), true);
            if (entityField == null) {
                continue;
            }
            Object value = getEntityFieldValue(object, entityField);
            if (value != null) {
                comparisonTookPlace = true;
                if (!value.toString()
                        .equals(getCell(header.getIndex()).getAttribute(HtmlAttributes.TEXT.toString().trim()))) {
                    return false;
                }
            }
        }
        if (!comparisonTookPlace) {
            return false;
        }
        return true;
    }
    
    private Field getMatchingEntityField(T object, String columnName, boolean rowMatch) {
        List<Field> fieldsToCheck;
        if (rowMatch) {
            fieldsToCheck = getFieldsToCompare(object);
        } else {
            fieldsToCheck = Arrays.asList(object.getClass().getDeclaredFields());
        }
        for (Field field : fieldsToCheck) {
            field.setAccessible(true);
            for (Column annotation : field.getAnnotationsByType(Column.class)) {
                if (annotation.language().equals(System.get().getLanguage()) 
                        && annotation.title().trim().equals(columnName)) {
                    return field;
                }
            }
        }
        return null;
    }
    
    private Object getEntityFieldValue(T object, Field field) {
        try {
            return field.get(object);
        } catch (ReflectiveOperationException e) {
            throw TestException.get("Can't access field + " + field.getName(), e);
        }
    }

    private List<Field> getFieldsToCompare(T object) {
        Field[] fields = object.getClass().getDeclaredFields();
        
        List<Field> result = Stream.of(fields).filter(f -> {
            f.setAccessible(true);
            return f.getAnnotation(RowMatch.class) != null;
        }).collect(Collectors.toList());
        
        if (result.isEmpty()) {
            return Arrays.asList(fields);
        }
        
        return result;
    }
    
    private WebElement getCell(int index) {
        try {
            return row.findElement(By.cssSelector(columnsCss + ":nth-child(" + index + ")"));
        } catch (StaleElementReferenceException e) {
            java.lang.System.out.println("row StaleElementReferenceException");
            row = rowLocator.findElement();
            return row
                    .findElement(By.cssSelector(columnsCss + ":nth-child(" + index + ")"));
        }
        
    }

    @Override
    public void open() {
        WebElement link;
        try {
            link = getElement().findElement(HtmlTags.LINK.locator());
        } catch (NoSuchElementException e1) {
            throw TestException.get("This row doesn't contain any active link");
        }
        link.click();
        page.waitForPageAction();
    }

    @Override
    public void fill(T object) {
        for (Header header : headings) {
            WebElement cell = getCell(header.getIndex());
            if (isEditable(cell)) {
                Object value = getEntityFieldValue(object, getMatchingEntityField(object, header.getTitle(), false));
                if (value != null) {
                    Editable control = initializeControl(cell);
                    control.fill(value.toString());
                }
            }
        }
        
    }
    
    private boolean isEditable(WebElement cell) {
        Optional<WebElement> input = cell.findElements(allElements).stream().filter(e -> {
            return e.getTagName().equals(HtmlTags.INPUT.toString()) 
                    || e.getTagName().equals(HtmlTags.SELECT.toString());
        }).findFirst();
        
        return input.isPresent();
    }
    
    private Editable initializeControl(WebElement cell) {
        WebElement input = cell.findElements(allElements).stream().filter(e -> {
            return e.getTagName().equals(HtmlTags.INPUT.toString()) 
                    || e.getTagName().equals(HtmlTags.SELECT.toString());
        }).findFirst().get();
        
        Editable result;
        
        switch (input.getTagName()) {
        case "input":
            
            ElementLocator locator = new ControlLocator(cell, HtmlTags.INPUT.locator()); 
            if (input.getAttribute(HtmlAttributes.TYPE.toString()).equals("checkbox")) {
                result = new ActiveCheckBoxImpl(page.getDriver(), locator,
                        getImplicitTimeoutInMilliseconds());
            } else if (input.getAttribute(HtmlAttributes.TYPE.toString()).equals("text")) {
                result = new InputImpl(page.getDriver(), locator, 
                        getImplicitTimeoutInMilliseconds());
            } else {
                throw TestException.get("Can't initialize editable control");
            }
            break;
            
        case "select":
            
            result = new DropdownImpl(page.getDriver(), new ControlLocator(cell, HtmlTags.SELECT.locator()), 
                    getImplicitTimeoutInMilliseconds());
            break;
            
        default:
            throw TestException.get("Can't initialize editable control");
        }
        return result;
    }
    
    private class ControlLocator implements ElementLocator {
        
        WebElement cell;
        private By finalLocator;
        
        public ControlLocator(WebElement cell, By finalLocator) {
            this.cell = cell;
            this.finalLocator = finalLocator;
        }
        
        @Override
        public WebElement findElement() {
            return cell.findElement(finalLocator);
        }

        @Override
        public List<WebElement> findElements() {
            return cell.findElements(finalLocator);
        }
    }
}
