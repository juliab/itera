package no.itera.tia.ui.panels;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.beans.model.Party;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.panels.impl.RecentCustomersSidePanelImpl;

@ImplementedBy(RecentCustomersSidePanelImpl.class)
public interface RecentCustomersSidePanel extends Panel {
	
	String CSS = "[id$='HomeNavigationSidebarRecentCustomersTab::body']";
	
	Table<Party> getTable();
}
