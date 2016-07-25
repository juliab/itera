package no.itera.tia.ui.model.party;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.beans.model.Document;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.model.party.impl.CasePanelImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(CasePanelImpl.class)
public interface CasePanel extends Panel {
	
	String CSS = "[id$='CustomerWrkPlCustomerWrkPlRegionContainerCaseTab::body']";
	
	void openDocument(Document document);
    void waitForDocument(Document document);
    Table<Document> getTable();
}
