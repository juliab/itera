package no.itera.tia.ui.model.policy;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.model.policy.impl.CoveragePanelImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(CoveragePanelImpl.class)
public interface CoveragePanel extends Panel {

	String CSS = "[id$='DynamicObjectAccordionContainerRiskInformationAccordionTab::body']";
	
	void calculatePrice();
	Double getTotalRiskPrice();
}
