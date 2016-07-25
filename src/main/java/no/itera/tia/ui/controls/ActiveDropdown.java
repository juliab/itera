package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.ActiveDropdownImpl;

/**
 * This class represents dropdown UI element that may change the form looks after value change.
 */
@ImplementedBy(ActiveDropdownImpl.class)
public interface ActiveDropdown extends Dropdown, Editable {

}
