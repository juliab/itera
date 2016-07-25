package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.ui.controls.Input;

public class InputImpl extends ControlImpl implements Input {

	public InputImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}
	
	public InputImpl(WebDriver driver, ElementLocator locator, WebElement webElement,
            long implicitTimeoutInMilliseconds) {
        super(driver, locator, webElement, implicitTimeoutInMilliseconds);
    }

    @Override
	public void fill(String value) {
		if (isCurrentlyEnabled()) {
		    type(value);
		}
	}
    
    @Override
    public String getValue() {
        return getAttribute(HtmlAttributes.VALUE);
    }
}
