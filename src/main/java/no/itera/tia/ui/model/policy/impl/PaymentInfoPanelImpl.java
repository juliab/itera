package no.itera.tia.ui.model.policy.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.model.PaymentInfo.Frequency;
import no.itera.tia.ui.controls.Dropdown;
import no.itera.tia.ui.controls.Input;
import no.itera.tia.ui.model.policy.PaymentInfoPanel;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class PaymentInfoPanelImpl extends PanelImpl implements PaymentInfoPanel {

	@FindBy(css = "[id$='PolicyPaymentFrequency::content']")
	private Dropdown frequency;
	
	@FindBy(css = "[id$='PolicyPaymentMethod::content']")
	private Dropdown method;
	
	@FindBy(css = "[id$='PolicyPaymentInstruction::content']")
	private Input instructions;
	
	@FindBy(css = "[id$='PolicyAccountNo::content']")
	private Input accountNo;
	
	public PaymentInfoPanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public Frequency getPaymentFrequency() {
		return Frequency.getByValue(frequency.getValue());
	}
}
