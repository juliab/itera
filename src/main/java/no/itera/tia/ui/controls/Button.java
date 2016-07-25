package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.ButtonImpl;

@ImplementedBy(ButtonImpl.class)
public interface Button extends Control {
	
    void click();
}
