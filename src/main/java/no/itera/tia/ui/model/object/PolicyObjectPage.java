package no.itera.tia.ui.model.object;

import net.serenitybdd.core.annotations.findby.FindBy;
import no.itera.tia.beans.LocalizedString;
import no.itera.tia.beans.model.InsuranceObject;
import no.itera.tia.enumeration.Language;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.model.policy.CoveragePanel;
import no.itera.tia.ui.pages.BasePage;
import no.itera.tia.ui.panels.CompletePolicyPopup;
import no.itera.tia.ui.panels.PoliciesSidePanel;
import no.itera.tia.ui.panels.PolicyDocumentsPopup;

public class PolicyObjectPage extends BasePage {
	
	@FindBy(css = ObjectPanel.CSS)
	private ObjectPanel objectPanel;
	
	@FindBy(css = CoveragePanel.CSS)
	private CoveragePanel coveragePanel;
	
	@FindBy(css = CompletePolicyPopup.CSS)
    private CompletePolicyPopup completePolicyPopup;
    
    @FindBy(css = PolicyDocumentsPopup.CSS)
    private PolicyDocumentsPopup policyDocumentsPopup;
    
    @FindBy(css = PoliciesSidePanel.CSS)
    private PoliciesSidePanel policies;
	
	@FindBy(css = "[id$='DynamicObjectSave']")
	private Button save;
	
	@FindBy(css = "[id$='DynamicObjectComplete']")
	private Button complete;
	
	public ObjectPanel objectPanel() {
	    return objectPanel;
	}
	
	public CoveragePanel coveragePanel() {
	    return coveragePanel;
	}
	
	public PoliciesSidePanel policiesSidePanel() {
	    return policies;
	}
	
	public void fillData(InsuranceObject object) {
		objectPanel.fillForm(object);
		coveragePanel.fillForm(object);
		coveragePanel.calculatePrice();
	}
	
	public void save() {
		save.click();
		waitForPageAction();
	}
	
	public void complete() {
		complete.click();
		waitForPageAction();
		setWaitForTimeout(20000);
		waitFor(completePolicyPopup);
		completePolicyPopup.selectAction(CompleteAction.POLICY);
		policyDocumentsPopup.printAll();
	}
	
	public enum CompleteAction {
		CONTINUE_EDIT(LocalizedString.of(Language.NORWEGIAN, "Fortsett redigering")
		        .addTranslation(Language.ENGLISH, "Continue Edit")),
		POLICY(LocalizedString.of(Language.NORWEGIAN, "Avtale")
		        .addTranslation(Language.ENGLISH, "Policy")),
		QUOTATION(LocalizedString.of(Language.NORWEGIAN, "Tilbud")
		        .addTranslation(Language.ENGLISH, "Quotation")),
		DECLINATURE(LocalizedString.of(Language.NORWEGIAN, "Avslag")
		        .addTranslation(Language.ENGLISH, "Declinature")),
		SUSPEND_TRANSACTION(LocalizedString.of(Language.NORWEGIAN, "Suspender transaksjon")
		        .addTranslation(Language.ENGLISH, "Suspend Transaction")),
		CANCEL_TRANSACTION(LocalizedString.of(Language.NORWEGIAN, "Annuller transaksjon")
		        .addTranslation(Language.ENGLISH, "Cancel Transaction"));
		
		private LocalizedString value;
		
		private CompleteAction(LocalizedString value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return this.value.getLocalizedValue();
		}
	}
}
