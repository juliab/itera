package no.itera.tia.ui.panels;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.panels.impl.WorkflowsSidePanelImpl;

/**
 * This interface represents side panel User Workflows (Brukerarbeidsflyter) of TIA application
 * 
 * @author yulia.siroshtan
 */
@ImplementedBy(WorkflowsSidePanelImpl.class)
public interface WorkflowsSidePanel extends Panel {
	
	 /**
     * Panel locator.
     */
    String CSS = "[id$='HomeNavigationSidebarUserWorkFlowsTab::body']";
    
    /**
     * Click Find/Create Party link to open Search Party tab.
     */
    void openSearch();
}
