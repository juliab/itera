package no.itera.tia.ui.model.policy.impl;

import java.util.List;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.controls.impl.PopupImpl;
import no.itera.tia.ui.model.policy.SelectProductPopup;

public class SelectProductPopupImpl extends PopupImpl implements SelectProductPopup {
	
	public SelectProductPopupImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}
	
	@FindBy(xpath = ".//*[contains(@id, 'CoverRgLc0:0:pt:CoverTreeProductIdDropDown::listHolder')]/li")
	private List<Control> products;
	
	@FindBy(xpath = ".//*[contains(@id, 'TIADynamicTaskFlowRg:0:pt:CoverRgLc0:0:pt:NewQuotePopup::yes')]")
	private Button acceptProduct;
	
	public void selectPrivat() {
		waitUntilPresent();
		products.get(0).click();
		accept();
	}
}
