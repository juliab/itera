package no.itera.tia.ui.controls.impl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.Wait;

import net.serenitybdd.core.pages.WebElementFacadeImpl;
import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.utility.WaitConditions;

public class ControlImpl extends WebElementFacadeImpl implements Control {
    
    private WebDriver driver;
    private final Clock webdriverClock = new org.openqa.selenium.support.ui.SystemClock();
    private final Sleeper sleeper = Sleeper.SYSTEM_SLEEPER;
    private static final int WAIT_FOR_ELEMENT_PAUSE_LENGTH = 100;

	public ControlImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
		this.driver = driver;
	}
	
    public ControlImpl(WebDriver driver, ElementLocator locator, WebElement webElement,
            long implicitTimeoutInMilliseconds) {
        super(driver, locator, webElement, implicitTimeoutInMilliseconds);
        this.driver = driver;
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

    public Wait<WebDriver> waitForCondition(long timeoutInMilliseconds) {
        return new FluentWait<>(driver, webdriverClock, sleeper)
                .withTimeout(timeoutInMilliseconds, TimeUnit.MILLISECONDS)
                .pollingEvery(WAIT_FOR_ELEMENT_PAUSE_LENGTH, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class, NoSuchFrameException.class);
    }

    @Override
    public void waitForPageAction() {
        try {
            waitForCondition(200).until(WaitConditions.waitingState());
            try {
                waitForCondition().until(WaitConditions.actionCompleted());
            } catch (TimeoutException e) {
                throw TestException.get("Timeout waiting for page action to finish", e);
            }
        } catch (TimeoutException e) {
            //
        }
    }

    @Override
    public String getAttribute(HtmlAttributes attribute) {
        String value = StringUtils.strip(super.getAttribute(attribute.toString()).trim(), " ");
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        
        return value;
    }
}
