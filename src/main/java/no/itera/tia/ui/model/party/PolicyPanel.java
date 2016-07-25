package no.itera.tia.ui.model.party;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.model.party.impl.PolicyPanelImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(PolicyPanelImpl.class)
public interface PolicyPanel extends Panel {

	/**
     * Panel locator.
     */
    String CSS = "[id$='CustomerWrkPlCustomerWrkPlRegionContainerCoverTab::body']";
    
	void addPolicy();
}
