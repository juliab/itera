package no.itera.tia.ui.model.policy;

import net.serenitybdd.core.annotations.findby.FindBy;
import no.itera.tia.beans.model.Line;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.pages.BasePage;
import no.itera.tia.ui.panels.PoliciesSidePanel;

public class PolicyPage extends BasePage {
	
	@FindBy(css = NewPolicyLinePopup.CSS)
    private NewPolicyLinePopup newLinePopup;
    
    @FindBy(css = PaymentInfoPanel.CSS)
    private PaymentInfoPanel paymentInfoPanel;
    
    @FindBy(css = PoliciesSidePanel.CSS)
    private PoliciesSidePanel policies;
	
	@FindBy(xpath = ".//*[contains(@id, 'TIADynamicTaskFlowRg:1:pt:PolicyNewPolicyLine')]")
	private Button newPolicyLine;
	
	@FindBy(css = "[id$='PolicyPolicyStatus'] select")
	private Control status;
	
	@FindBy(css = "[id$='PolicyTransactionType'] select")
	private Control transactionType;

	public PaymentInfoPanel paymentInfoPanel() {
	    return paymentInfoPanel;
	}
	
	public PoliciesSidePanel policiesSidePanel() {
	    return policies;
	}
	
	public void addNewLine(Line line) {
		setWaitForElementTimeout(5000);
		setWaitForTimeout(10000);
		newPolicyLine.click();
		waitForPageAction();
		newLinePopup.fillData(line);
	}
	
	public String getStatus() {
		return status.getSelectedVisibleTextValue().trim();
	}
	
	public String getTransactionType() {
		return transactionType.getSelectedVisibleTextValue().trim();
	}
}
