package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.beans.LocalizedString;
import no.itera.tia.enumeration.Language;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.Toggle;

public class ToggleImpl extends ControlImpl implements Toggle {

	public ToggleImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
		super(driver, locator, implicitTimeoutInMilliseconds);
	}
	
	@Override
	public void fill(String value) {
		if (!(value.equals(Boolean.TRUE.toString()) || value.equals(Boolean.FALSE.toString()))) {
			throw TestException.get("Field value should be true/false. Actual: " + value);
		}
		Boolean flag = Boolean.valueOf(value);
		
		if (flag) {
		    selectByVisibleText(Values.YES.getValue());
		} else {
		    selectByVisibleText(Values.NO.getValue());
		}
	}
	
	private enum Values {
		YES(LocalizedString.of(Language.NORWEGIAN, "Ja").addTranslation(Language.ENGLISH, "YES Yes")),
		NO(LocalizedString.of(Language.NORWEGIAN, "Nei").addTranslation(Language.ENGLISH, "NO No"));
		
		private LocalizedString value;
		
		private Values(LocalizedString value) {
			this.value = value;
		}
		
		public String getValue() {
			return value.getLocalizedValue();
		}
	}
}
