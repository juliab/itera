package no.itera.tia.ui.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.utility.WaitConditions;

public class BasePage extends PageObject {

	public void waitForPageAction() {
		setWaitForTimeout(50000);
		try {
            waitFor(WaitConditions.waitingState());
            waitFor(WaitConditions.actionCompleted());
        } catch (TimeoutException e) {
            throw TestException.get("Timeout waiting for action to complete", e);
        }
	}
	
	public void waitForPageToLoad() {
	    setWaitForTimeout(25000);
        try {
            waitFor(WaitConditions.waitingState());
            waitFor(WaitConditions.actionCompleted());
            Sleeper.sleepTight(500);
            waitFor(WaitConditions.actionCompleted());
        } catch (TimeoutException e) {
            throw TestException.get("Timeout waiting for page to load", e);
        }
	}
}
