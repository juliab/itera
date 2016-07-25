package no.itera.tia.ui.model.line;

import net.serenitybdd.core.annotations.findby.FindBy;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.model.object.PolicyObjectPage.CompleteAction;
import no.itera.tia.ui.pages.BasePage;
import no.itera.tia.ui.panels.CompletePolicyPopup;
import no.itera.tia.ui.panels.PoliciesSidePanel;
import no.itera.tia.ui.panels.PolicyDocumentsPopup;
import no.itera.tia.ui.panels.RelationsSidePanel;

public class PolicyLinePage extends BasePage {
	
	@FindBy(css = RelationsSidePanel.CSS)
	private RelationsSidePanel relationsPanel;
	
    @FindBy(css = PoliciesSidePanel.CSS)
    private PoliciesSidePanel policiesSidePanel;
	
	@FindBy(css = PolicyLineInfoPanel.CSS)
	private PolicyLineInfoPanel policyLineInfoPanel;
	
	@FindBy(css = PreviousAndNextInsurancePanel.CSS)
    private PreviousAndNextInsurancePanel previousAndNextInsurancePanel;
    
    @FindBy(css = CompletePolicyPopup.CSS)
    private CompletePolicyPopup completePolicyPopup;
    
    @FindBy(css = PolicyDocumentsPopup.CSS)
    private PolicyDocumentsPopup policyDocumentsPopup;
	
	@FindBy(css = "[id$='PolicyLineStatus::content']")
	private Control status;
	
	@FindBy(css = "[id$='PolicyLineTransCode::content']")
	private Control transactionCode;
	
	@FindBy(css = "[id$='PolicyLineCustomSaveButton']")
	private Button save;
	
	@FindBy(css = "[id$='PolicyLineSaveAs']")
	private Button complete;
	
	public RelationsSidePanel relationsSidePanel() {
	    return relationsPanel;
	}
	
	public PolicyLineInfoPanel policyLineInfoPanel() {
	    return policyLineInfoPanel;
	}
	
	public PreviousAndNextInsurancePanel previousAndNextInsurancePanel() {
	    return previousAndNextInsurancePanel;
	}
	
	public String getStatus() {
		return status.getTextValue().trim();
	}
	
	public String getTransactionCode() {
		return transactionCode.getSelectedVisibleTextValue().trim();
	}

	public void complete() {
		complete.click();
		waitForPageAction();
		setWaitForTimeout(20000);
		waitFor(completePolicyPopup);
		completePolicyPopup.selectAction(CompleteAction.POLICY);
		policyDocumentsPopup.printAll();
	}
	
	public PoliciesSidePanel policiesSidePanel() {
        return policiesSidePanel;
    }
}
