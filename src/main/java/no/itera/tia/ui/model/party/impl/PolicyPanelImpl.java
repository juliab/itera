package no.itera.tia.ui.model.party.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.model.Policy;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.controls.Table;
import no.itera.tia.ui.model.party.PolicyPanel;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class PolicyPanelImpl extends PanelImpl implements PolicyPanel {
	
	@FindBy(xpath = ".//*[contains(@id, 'CoverTreePC:CoverTreeNewQuoteTtb')]")
	private Button newPolicy;
	
	@FindBy(css = "[id$='CoverRgLc0:0:pt:CoverTreePC:CoverTreeTab::db'] table")
	private Table<Policy> table;
	
	public PolicyPanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public void addPolicy() {
		newPolicy.click();
		waitForPageAction();
	}
}
