package no.itera.tia.ui.panels.impl;

import java.util.List;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import no.itera.tia.beans.model.Document;
import no.itera.tia.beans.model.Document.Printer;
import no.itera.tia.beans.model.Document.Priority;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.controls.impl.PopupImpl;
import no.itera.tia.ui.panels.PolicyDocumentsPopup;

public class PolicyDocumentsPopupImpl extends PopupImpl implements PolicyDocumentsPopup {

	public PolicyDocumentsPopupImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@FindBy(css = "[id$='PolicyDocumentsTab::db'] tr")
	private List<WebElementFacade> documents;
	
	@FindBy(css = "[id$='PolicyDocumentsPC:PolicyDocumentsTab::db'] table")
	private Table<Document> table;

	@Override
	public void printAll() {
	    table.fillAllRows(new Document.Builder()
	            .online(true)
	            .printer(Printer.TIA)
	            .priority(Priority.NORMAL)
	            .copies(1)
	            .build());
		accept();
	}
}
