package no.itera.tia.ui.model.party;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WidgetObject;
import no.itera.tia.ui.model.party.impl.PartySearchResultImpl;

@ImplementedBy(PartySearchResultImpl.class)
public interface PartySearchResult extends WidgetObject {
	
	/**
     * Panel locator.
     */
    String XPATH = "//*[@id[contains(., 'pt:P2000PartySearchPC:P2000PartySearchTab::db')]]//tbody";
    
    void selectFirst();
    void waitForResults();
}
