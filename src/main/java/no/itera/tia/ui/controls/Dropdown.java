package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.DropdownImpl;

/**
 * This interface represents TIA drowdown element.
 *
 * @author yulia.siroshtan
 */
@ImplementedBy(DropdownImpl.class)
public interface Dropdown extends Control, Editable {
	void select(String value);
}
