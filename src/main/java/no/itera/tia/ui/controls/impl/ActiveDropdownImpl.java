package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.ui.controls.ActiveDropdown;

public class ActiveDropdownImpl extends DropdownImpl implements ActiveDropdown {

	public ActiveDropdownImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, 10000);
	}

	@Override
	public void fill(String value) {
		super.select(value);
		waitForPageAction();
	}
}
