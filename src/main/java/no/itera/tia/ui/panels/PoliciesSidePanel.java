package no.itera.tia.ui.panels;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.panels.impl.PoliciesSidePanelImpl;

@ImplementedBy(PoliciesSidePanelImpl.class)
public interface PoliciesSidePanel extends Panel {
	
	String CSS = "[id$='OverviewPageTreesAccordionPolicyTreeTab::body']";
	
	void openLastPolicy();
	void openLastPolicyLine();
	void openLastPolicyObject();
}
