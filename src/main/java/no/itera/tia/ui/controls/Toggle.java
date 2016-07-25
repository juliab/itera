package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.ToggleImpl;

@ImplementedBy(ToggleImpl.class)
public interface Toggle extends Control, Editable {

}
