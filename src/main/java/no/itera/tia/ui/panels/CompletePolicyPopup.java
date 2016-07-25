package no.itera.tia.ui.panels;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.Popup;
import no.itera.tia.ui.model.object.PolicyObjectPage;
import no.itera.tia.ui.panels.impl.CompletePolicyPopupImpl;

@ImplementedBy(CompletePolicyPopupImpl.class)
public interface CompletePolicyPopup extends Popup {
	
	String CSS = "table [id$='ActionsAllowedRegionContainer']";
	
	void selectAction(PolicyObjectPage.CompleteAction action);
}
