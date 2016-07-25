package no.itera.tia.ui.model.line;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.model.line.impl.PolicyLineInfoPanelImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(PolicyLineInfoPanelImpl.class)
public interface PolicyLineInfoPanel extends Panel {
	
	String CSS = "[id$='PolicyLineAccordionContainerPolicyLineItemRegionPLTab::body']";
}
