package no.itera.tia.ui.model.policy;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.Popup;
import no.itera.tia.ui.model.policy.impl.SelectProductPopupImpl;

@ImplementedBy(SelectProductPopupImpl.class)
public interface SelectProductPopup extends Popup {
	
    void selectPrivat();
}
