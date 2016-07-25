package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.ui.controls.Link;

public class LinkImpl extends ControlImpl implements Link {

	/**
	 * {@inheritDoc}
	 */
	public LinkImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}
}
