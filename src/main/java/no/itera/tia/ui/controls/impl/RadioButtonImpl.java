package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.ui.controls.RadioButton;

/**
 * This class represents TIA application radio button element.
 *
 * @author yulia.siroshtan
 */
public class RadioButtonImpl extends ControlImpl implements RadioButton {
	
	public RadioButtonImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void select(String value) {
		// TODO implement
	}

	@Override
	public void fill(String value) {
		select(value);
	}
}
