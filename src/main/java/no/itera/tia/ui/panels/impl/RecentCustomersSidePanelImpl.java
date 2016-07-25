package no.itera.tia.ui.panels.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.model.Party;
import no.itera.tia.ui.controls.Link;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.panels.RecentCustomersSidePanel;

public class RecentCustomersSidePanelImpl extends PanelImpl implements RecentCustomersSidePanel {

	@FindBy(xpath = ".//*[contains(@id, 'TiaWebRecentCustomersTab:0:TiaWebRecentCustomersIdNoAlt')]")
	private Link topCustomer;
	
	@FindBy(css = "[id$='TiaWebRecentCustomersTab::db'] table")
	private Table<Party> table;
	
	public RecentCustomersSidePanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

    @Override
    public Table<Party> getTable() {
        return table;
    }
}
