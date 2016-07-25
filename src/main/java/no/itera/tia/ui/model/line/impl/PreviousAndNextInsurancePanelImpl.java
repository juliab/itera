package no.itera.tia.ui.model.line.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.ui.controls.Dropdown;
import no.itera.tia.ui.controls.Input;
import no.itera.tia.ui.model.line.PreviousAndNextInsurancePanel;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class PreviousAndNextInsurancePanelImpl extends PanelImpl implements PreviousAndNextInsurancePanel {

	@FindBy(css = "[id$='PolicyLinePrevInsuranceCompany::content']")
	private Dropdown previousInsurance;
	
	@FindBy(css = "[id$='PolicyLineCreateCause::content']")
	private Dropdown createCause;
	
	@FindBy(css = "[id$='PolicyLinePrevPolicyNo::content']")
	private Input previousPolicyNumber;
	
	@FindBy(css = "[id$='PolicyLineStampDutyTransferred::content']")
	private Input stampDutyTransfer;
	
	public PreviousAndNextInsurancePanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}
}
