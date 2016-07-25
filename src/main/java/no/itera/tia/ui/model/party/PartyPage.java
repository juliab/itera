package no.itera.tia.ui.model.party;

import net.serenitybdd.core.annotations.findby.FindBy;
import no.itera.tia.ui.model.policy.SelectProductPopup;
import no.itera.tia.ui.pages.BasePage;
import no.itera.tia.ui.panels.PoliciesSidePanel;

public class PartyPage extends BasePage {
		
	@FindBy(xpath = ".//*[contains(@id, 'pt:NewQuotePopup')]")
	private SelectProductPopup selectProductPopup;
	
	@FindBy(css = PolicyPanel.CSS)
	private PolicyPanel policyPanel;
	
	@FindBy(css = PoliciesSidePanel.CSS)
	private PoliciesSidePanel policies;
	
	@FindBy(css = CasePanel.CSS)
	private CasePanel casePanel;
	
	public PolicyPanel policyPanel() {
	    return policyPanel;
	}
	
	public PoliciesSidePanel policiesSidePanel() {
	    return policies;
	}
	
	public CasePanel casePanel() {
	    return casePanel;
	}
	
	public void startPolicyCreation() {
		policyPanel.addPolicy();
		setWaitForElementTimeout(5000);
		selectProductPopup.selectPrivat();
	}
}
