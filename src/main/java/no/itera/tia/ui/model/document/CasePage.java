package no.itera.tia.ui.model.document;

import net.serenitybdd.core.annotations.findby.FindBy;
import no.itera.tia.ui.pages.BasePage;

public class CasePage extends BasePage {
	
	@FindBy(css = ArchiveDetails.CSS)
	private ArchiveDetails archiveDetails;
	
	public ArchiveDetails archiveDetailsPanel() {
	    return archiveDetails;
	}
}
