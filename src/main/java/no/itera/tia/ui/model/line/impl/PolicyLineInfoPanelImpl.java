package no.itera.tia.ui.model.line.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.ui.model.line.PolicyLineInfoPanel;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class PolicyLineInfoPanelImpl extends PanelImpl implements PolicyLineInfoPanel {

	public PolicyLineInfoPanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

}
