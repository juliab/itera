package no.itera.tia.ui.model.line;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.model.line.impl.PreviousAndNextInsurancePanelImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(PreviousAndNextInsurancePanelImpl.class)
public interface PreviousAndNextInsurancePanel extends Panel {

	String CSS = "[id$='PolicyLineAccordionContainerPolicyLinePreviousInsuranceRegionTab::body']";
}
