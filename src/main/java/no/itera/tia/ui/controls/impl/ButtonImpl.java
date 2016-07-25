package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.Button;

public class ButtonImpl extends ControlImpl implements Button {

    public ButtonImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}

	@Override
	public void click() {
	    try {
	        waitUntilEnabled();
	    } catch (ElementShouldBeEnabledException e) {
	        throw e; // TODO fix: sometimes is thrown on new policy button click
	    }
	    
	    waitUntilClickable();
		
		// sometimes click can't be completed with first try
		boolean success = false;
		for (int i = 0; i < 3; i++) {
		    try {
	            super.click();
	            success = true;
	            break;
	        } catch (WebDriverException e) {
	            logger.debug("WebDriverException on click " + getLocator());
	        }
		}
		if (!success) {
		    throw TestException.get("Can't click button by locator " + getLocator());
		}
	}
}
