package no.itera.tia.ui.controls.impl;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.ui.controls.Dropdown;

/**
 * This class represents TIA drowdown element.
 *
 * @author yulia.siroshtan
 */
public class DropdownImpl extends ControlImpl implements Dropdown {

	public DropdownImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}
	
	public DropdownImpl(WebDriver driver, ElementLocator locator, WebElement webElement,
            long implicitTimeoutInMilliseconds) {
        super(driver, locator, webElement, implicitTimeoutInMilliseconds);
    }

    @Override
	public void select(String value) {
        String option = value;
        List<String> selectOptions = getSelectOptions();
        if (!selectOptions.contains(value)) {
            option = selectOptions.stream()
                    .filter(o -> o.contains(value))
                    .findFirst()
                    .get(); 
        }
        selectByVisibleText(option);
	}

	@Override
	public void fill(String value) {
		select(value);
	}
	
	@Override
	public String getValue() {
	    return getAttribute(HtmlAttributes.TITLE);
	}
}
