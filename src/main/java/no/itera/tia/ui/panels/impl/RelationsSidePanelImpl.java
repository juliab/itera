package no.itera.tia.ui.panels.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.model.Party;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.panels.RelationsSidePanel;

public class RelationsSidePanelImpl extends PanelImpl implements RelationsSidePanel {

	@FindBy(css = "[id$='PartyTreeParentTree::db'] table")
	private Table<Party> table;
	
	public RelationsSidePanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public void openRelation() {
		table.getRow(1).open();
	}

}
