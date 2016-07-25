package no.itera.tia.ui.model.party.impl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WidgetObjectImpl;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.model.party.PartySearchResult;

public class PartySearchResultImpl extends WidgetObjectImpl implements PartySearchResult {
	
	@FindBy(tagName = "tbody")
	private Control table;
	
	@FindBy(tagName = "tr")
	private List<Control> rows;
	
	private By idNo = By.xpath(".//*[@id[contains(., 'P2000PartySearchIdNoAlt')]]");
	
	public PartySearchResultImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public void selectFirst() {
		rows.get(0).then(idNo).click();
	}

	@Override
	public void waitForResults() {
		waitUntilElementAvailable();
	}
}
