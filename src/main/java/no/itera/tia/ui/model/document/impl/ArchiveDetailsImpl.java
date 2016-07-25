package no.itera.tia.ui.model.document.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.ui.controls.Link;
import no.itera.tia.ui.model.document.ArchiveDetails;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class ArchiveDetailsImpl extends PanelImpl implements ArchiveDetails {

	@FindBy(css = "[id$='pt:ArchiveCODownloadDocument']")
	private Link attachedFile;
	
	public ArchiveDetailsImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public synchronized void downloadFile() {
		attachedFile.click();
		waitForDownload();
	}

	@Override
	public String getFileName() {
		return attachedFile.getText().trim().replace("/", "_");
	}
}
