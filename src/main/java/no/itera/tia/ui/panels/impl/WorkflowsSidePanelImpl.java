package no.itera.tia.ui.panels.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.ui.controls.Link;
import no.itera.tia.ui.panels.WorkflowsSidePanel;

/**
 * This class represents side panel User Workflows (Brukerarbeidsflyter) of TIA application
 * 
 * @author yulia.siroshtan
 */
public class WorkflowsSidePanelImpl extends PanelImpl implements WorkflowsSidePanel {

	public WorkflowsSidePanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@FindBy(xpath = ".//a[contains(@id, 'HomePartySearch')]")
	private Link findCreateParty;
	
	@FindBy(xpath = ".//a[contains(@id, 'HomeConfiguration::icon')]")
	private Link configuration;
	
	@FindBy(xpath = ".//a[contains(@id, 'HomeManagement')]")
	private Link management;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void openSearch() {
		findCreateParty.click();
		waitForPageAction();
	}
}
