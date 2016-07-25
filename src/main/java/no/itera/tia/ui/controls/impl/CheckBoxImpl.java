package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.CheckBox;

public class CheckBoxImpl extends ControlImpl implements CheckBox {

	public CheckBoxImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}
	
	public CheckBoxImpl(WebDriver driver, ElementLocator locator, WebElement webElement,
            long implicitTimeoutInMilliseconds) {
        super(driver, locator, webElement, implicitTimeoutInMilliseconds);
    }

    @Override
	public void select() {
		if (!this.isSelected()) {
			this.changeValue();
		}
	}
	
	@Override
	public void deselect() {
		if (this.isSelected()) {
			this.changeValue();
		}
	}
	
	private void changeValue() {
	    this.click();
	}

	@Override
	public void fill(String value) {
		if (!(value.equals(Boolean.TRUE.toString()) || value.equals(Boolean.FALSE.toString()))) {
			throw TestException.get("Field value should be true/false. Actual: " + value);
		}
		Boolean flag = Boolean.valueOf(value);
		
		if (flag) {
			select();
		} else {
			deselect();
		}
	}

	@Override
	public void setValue(Boolean value) {
		fill(value.toString());
	}
}
