package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WidgetObjectImpl;
import no.itera.tia.ui.controls.Button;
import no.itera.tia.ui.controls.Popup;

public class PopupImpl extends WidgetObjectImpl implements Popup {

    private long startTime;
    
	@FindBy(css = "button[_afrpdo = 'yes'], button[_afrpdo = 'ok']")
	private Button yes;
	
	@FindBy(css = "button[_afrpdo = 'no'], button[_afrpdo = 'cancel']")
	private Button no;
	
	public PopupImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, 20000);
	}

	@Override
	public void accept() {
		yes.click();
		waitUntilNotVisible();
	}

	@Override
	public void decline() {
		no.click();
		waitUntilNotVisible();
	}
	
    protected void startPoint() {
        startTime = System.currentTimeMillis();
    }
    
    protected void printTime(String message) {
        System.out.println(message + ": " + (System.currentTimeMillis() - startTime));
        startPoint();
    }
}
