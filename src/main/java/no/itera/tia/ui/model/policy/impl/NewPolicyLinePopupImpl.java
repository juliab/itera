package no.itera.tia.ui.model.policy.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.model.Line;
import no.itera.tia.ui.controls.DatePicker;
import no.itera.tia.ui.controls.Dropdown;
import no.itera.tia.ui.controls.impl.PopupImpl;
import no.itera.tia.ui.model.policy.NewPolicyLinePopup;

public class NewPolicyLinePopupImpl extends PopupImpl implements NewPolicyLinePopup {

	@FindBy(xpath = ".//*[contains(@id, 'TIADynamicTaskFlowRg:1:pt:PolicyNewPolicyLineStartDate::content')]")
	private DatePicker coverStartDate;
	
	@FindBy(xpath = ".//*[contains(@id, 'TIADynamicTaskFlowRg:1:pt:PolicyNewPolicyLineEndDate::content')]")
	private DatePicker coverEndDate;
	
	@FindBy(css = "[id$='PolicyPolicyLineDropDown::content']")
	private Dropdown policyLineId;
	
	@FindBy(xpath = ".//*[contains(@id, 'TIADynamicTaskFlowRg:1:pt:PolicyCancelCodeOnCreate::content')]")
	private Dropdown cancelCode;
	
	public NewPolicyLinePopupImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public void fillData(Line line) {
		waitUntilPresent();
		// TODO fill dynamic form
		policyLineId.select(line.getObject().getName());
		cancelCode.select(line.getCancelCode().toString());
		accept();
	}
}
