package no.itera.tia.ui.panels.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.controls.impl.PopupImpl;
import no.itera.tia.ui.model.object.PolicyObjectPage;
import no.itera.tia.ui.panels.CompletePolicyPopup;

public class CompletePolicyPopupImpl extends PopupImpl implements CompletePolicyPopup {

	public CompletePolicyPopupImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}
	
	@FindBy(css = "[id$='listHolder']")
	private Control list;
	
	@Override
	public void selectAction(PolicyObjectPage.CompleteAction action) {
		By itemLocator = By.cssSelector("li[title='" + action.toString() + "']");
		getPage().setWaitForTimeout(5000);
		waitForCondition().until(ExpectedConditions.presenceOfNestedElementLocatedBy(list, itemLocator));
		list.find(itemLocator).click();
		accept();
	}
}
