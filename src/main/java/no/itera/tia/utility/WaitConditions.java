package no.itera.tia.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.enumeration.HtmlTags;
import no.itera.tia.exceptions.TestException;

/**
 * Set of custom expected conditions to be used in waits.
 */
public final class WaitConditions {
    
    /**
     * An expectation for checking that page cursor changed to waiting state.
     * @return true when cursor is in waiting state, false otherwise
     */
    public static ExpectedCondition<Boolean> waitingState() {
        return driver -> {
            String bodyStyle = getBodyStyle(driver);
            return bodyStyle != null && bodyStyle.contains(CursorStyle.WAIT.toString());
        };
    }
    
    /**
     * An expectation for checking that some action that changed part of the page has been completed.
     * @return true when page action completed, false otherwise
     */
    public static ExpectedCondition<Boolean> actionCompleted() {
        return driver -> {
            String bodyStyle = getBodyStyle(driver);
            return bodyStyle != null && (bodyStyle.contains(CursorStyle.AUTO.toString())
                    || bodyStyle.equals(CursorStyle.EMPTY.toString()));
        };
    }

    protected static String getBodyStyle(WebDriver driver) {
        String style;
        try {
            // if method was called from the page then look inside
            style = driver.findElement(HtmlTags.BODY.locator())
                    .getAttribute(HtmlAttributes.STYLE.toString());
        } catch (NoSuchElementException e) {
            try {
                // if method was called from the webelement then look outside
                style = driver.findElement(By.xpath(".//ancestor::body"))
                        .getAttribute(HtmlAttributes.STYLE.toString());
            } catch (NoSuchElementException e2) {
                throw TestException.get("Can't find body on the page");
            }
        } catch (StaleElementReferenceException e) {
            return null;
        }
        return style;
    }

    private enum CursorStyle {
        WAIT("wait"),
        AUTO("auto"),
        EMPTY("");
        
        private String value;
        
        private CursorStyle(String value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value;
        }
    }
    
    
}
