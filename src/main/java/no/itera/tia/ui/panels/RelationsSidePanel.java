package no.itera.tia.ui.panels;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.panels.impl.RelationsSidePanelImpl;

@ImplementedBy(RelationsSidePanelImpl.class)
public interface RelationsSidePanel extends Panel {

	String CSS = "[id$='OverviewPageTreesAccordionRelatedPartiesTreeTab::body']";
	
	void openRelation();
}
