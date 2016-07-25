package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.InputImpl;

/**
 * This interface represents TIA input element.
 */
@ImplementedBy(InputImpl.class)
public interface Input extends Control, Editable {
}
