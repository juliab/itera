package no.itera.tia.ui.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.enumeration.Language;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.controls.Dropdown;
import no.itera.tia.ui.panels.RecentCustomersSidePanel;
import no.itera.tia.ui.panels.WorkflowsSidePanel;
import no.itera.tia.beans.System;

/**
 * This class represents Master Homepage of TIA application
 * 
 * @author yulia.siroshtan
 */
public class HomePage extends BasePage {
	
	@FindBy(css = WorkflowsSidePanel.CSS)
	private WorkflowsSidePanel workflowsPanel;
	
	@FindBy(css = RecentCustomersSidePanel.CSS)
	private RecentCustomersSidePanel recentCustomersPanel;
	
	@FindBy(css = "[id$='languageTB:localeSwitcher::content']")
	private Dropdown languageSwitcher;
	
	@FindBy(css = "html")
	private Control rootElement;
	
	public WorkflowsSidePanel userWorkflowsSidePanel() {
	    return workflowsPanel;
	}
	
	public RecentCustomersSidePanel recentCustomersSidePanel() {
	    return recentCustomersPanel;
	}
	
	public void switchLanguage(Language language) {
		if (!rootElement.getAttribute(HtmlAttributes.LANG).equals(language.getCode())) {
			languageSwitcher.selectByIndex(language.getIndex());
			waitForPageAction();
		}
		System.get().setLanguage(language);
	}
}
