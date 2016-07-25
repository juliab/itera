package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.CheckBoxImpl;

@ImplementedBy(CheckBoxImpl.class)
public interface CheckBox extends Control, Editable {
	void select();
	void deselect();
	void setValue(Boolean value);
}
