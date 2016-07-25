package no.itera.tia.ui.panels;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.Popup;
import no.itera.tia.ui.panels.impl.PolicyDocumentsPopupImpl;

@ImplementedBy(PolicyDocumentsPopupImpl.class)
public interface PolicyDocumentsPopup extends Popup {

	String CSS = "[id$='CompletePopup']";
	
	public void printAll();
}
