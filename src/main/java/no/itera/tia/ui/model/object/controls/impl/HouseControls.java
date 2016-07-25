package no.itera.tia.ui.model.object.controls.impl;

import no.itera.tia.ui.controls.Editable;
import no.itera.tia.ui.model.object.controls.Controls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum HouseControls implements Controls {
    STREET("street", "[id$='TIA_IT1::content']");

    private String objectPropertyName;
    private String css;

    HouseControls(String objectPropertyName, String css) {
        this.objectPropertyName = objectPropertyName;
        this.css = css;
    }

    private By locator() {
        return By.cssSelector(css);
    }

    @Override
    public Editable init(WebDriver driver) {
        return null;
    }
}
