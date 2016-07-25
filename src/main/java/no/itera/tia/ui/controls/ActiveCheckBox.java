package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.ActiveCheckBoxImpl;

@ImplementedBy(ActiveCheckBoxImpl.class)
public interface ActiveCheckBox extends CheckBox, Editable {
    
}
