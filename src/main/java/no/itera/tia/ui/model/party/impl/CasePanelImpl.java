package no.itera.tia.ui.model.party.impl;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.model.Document;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.controls.TableRow;
import no.itera.tia.ui.model.party.CasePanel;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class CasePanelImpl extends PanelImpl implements CasePanel {
    
	@FindBy(css = "[id$='CaseOverviewReusablePC:CaseOverviewReusableTab::db'] table[_selstate]")
	private Table<Document> table;
	
	public CasePanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public void openDocument(Document document) {
	    TableRow<Document> row = table.findRowContaining(document);
	    if (row == null) {
	        throw TestException.get("Can't open document " + document.getDescription() + ". It not in the table.");
	    }
		row.open();
	}

    @Override
    public void waitForDocument(Document document) {
        for (int i = 0; i < 18; i++) {
            try {
                waitForCondition().until(input -> {
                    return table.getRow(1).contains(document);
                });
            } catch (TimeoutException e) {
                Sleeper.sleepTightInSeconds(10);
                getPage().getDriver().navigate().refresh();
            }
        }
    }

    @Override
    public Table<Document> getTable() {
        return table;
    }
}
