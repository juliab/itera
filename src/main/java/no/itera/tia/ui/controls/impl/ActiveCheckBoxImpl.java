package no.itera.tia.ui.controls.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import no.itera.tia.ui.controls.ActiveCheckBox;

public class ActiveCheckBoxImpl extends CheckBoxImpl implements ActiveCheckBox {

    public ActiveCheckBoxImpl(WebDriver driver, ElementLocator locator, long implicitTimeoutInMilliseconds) {
        super(driver, locator, implicitTimeoutInMilliseconds);
    }

    @Override
    public void select() {
        if (!this.isSelected()) {
            this.changeValue();
        }
    }
    
    @Override
    public void deselect() {
        if (this.isSelected()) {
            this.changeValue();
        }
    }
    
    private void changeValue() {
        this.click();
        waitForPageAction();
    }
}
