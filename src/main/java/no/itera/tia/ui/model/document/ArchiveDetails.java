package no.itera.tia.ui.model.document;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.model.document.impl.ArchiveDetailsImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(ArchiveDetailsImpl.class)
public interface ArchiveDetails extends Panel {

	String CSS = "[id$='ArchiveCOTopLcSdi::body']";
	
	void downloadFile();

	String getFileName();
}
