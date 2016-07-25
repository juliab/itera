package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.RadioButtonImpl;

/**
 * This interface represents TIA radio button element.
 *
 * @author yulia.siroshtan
 */
@ImplementedBy(RadioButtonImpl.class)
public interface RadioButton extends Control, Editable {
	
	/**
	 * Selects required radio button.
	 * 
	 * @param value Radio button label
	 */
	void select(String value);
}
