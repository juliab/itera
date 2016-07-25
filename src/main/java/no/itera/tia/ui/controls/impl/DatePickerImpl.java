package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.beans.Date;
import no.itera.tia.ui.controls.DatePicker;

/**
 * This class represents TIA datepicker element.
 *
 * @author yulia.siroshtan
 */
public class DatePickerImpl extends ControlImpl implements DatePicker {

	public DatePickerImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void select(Date date) {
		// TODO implement
	}

	@Override
	public void fill(String value) {
		// TODO implement
	}
}
