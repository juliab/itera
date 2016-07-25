package no.itera.tia.ui.model.policy;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.beans.model.Line;
import no.itera.tia.ui.controls.Popup;
import no.itera.tia.ui.model.policy.impl.NewPolicyLinePopupImpl;

@ImplementedBy(NewPolicyLinePopupImpl.class)
public interface NewPolicyLinePopup extends Popup {
	String CSS = "table [id$='NewPolicyLinePopup']";
	
	void fillData(Line line);
}
