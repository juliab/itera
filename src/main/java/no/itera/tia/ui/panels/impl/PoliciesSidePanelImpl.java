package no.itera.tia.ui.panels.impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.LocalizedString;
import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.enumeration.Language;
import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.panels.PoliciesSidePanel;

public class PoliciesSidePanelImpl extends PanelImpl implements PoliciesSidePanel {
	
	@FindBy(xpath = ".//*[contains(@id, 'PolicyMenuTree::db')]//tr[.//span[@_afrnddth='0']]//span[img]//a[last()]")
	private Control lastPolicy;
	
	@FindBy(xpath = ".//*[contains(@id, 'PolicyMenuTree::db')]//tr[.//span[@_afrnddth='1']]//span[img]//a[last()]")
	private Control lastPolicyLine;
	
	@FindBy(xpath = ".//*[contains(@id, 'PolicyMenuTree::db')]//tr[.//span[@_afrnddth='2']]//span[img]//a[last()]")
	private Control lastPolicyObject;
	
	private By expand = By.xpath(".//ancestor::span[img]/preceding-sibling::span/a");
	
	public PoliciesSidePanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}

	@Override
	public void openLastPolicy() {
		lastPolicy.click();
		waitForPageAction();
	}

	@Override
	public void openLastPolicyLine() {
	    expand(lastPolicy);
		lastPolicyLine.click();
		waitForPageAction();
	}

	@Override
	public void openLastPolicyObject() {
	    expand(lastPolicy);
	    expand(lastPolicyLine);
	    lastPolicyObject.click();
		waitForPageAction();
	}
	
	private void expand(Control item) {
	    WebElement expand = item.find(this.expand);
	    if (ExpanderValues.EXPAND.getString()
	            .equals(expand.getAttribute(HtmlAttributes.TITLE.toString()))) {
	        expand.click();
	        waitForPageAction();
	    }
	}
	
	private enum ExpanderValues {
	    EXPAND(LocalizedString.of(Language.NORWEGIAN, "Utvid")
	            .addTranslation(Language.ENGLISH, "Expand")),
	    COLLAPSE(LocalizedString.of(Language.NORWEGIAN, "Trekk sammen")
	            .addTranslation(Language.ENGLISH, "Collapse"));
	    
	    private LocalizedString value;
	    
	    private ExpanderValues(LocalizedString value) {
            this.value = value;
        }
	    
	    public LocalizedString getString() {
	        return value;
	    }
	    
	    @Override
	    public String toString() {
	        return value.getLocalizedValue();
	    }
	}
}
