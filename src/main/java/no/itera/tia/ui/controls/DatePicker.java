package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.beans.Date;
import no.itera.tia.ui.controls.impl.DatePickerImpl;

/**
 * This interface represents TIA datepicker element.
 *
 * @author yulia.siroshtan
 */
@ImplementedBy(DatePickerImpl.class)
public interface DatePicker extends Control, Editable {
	
	/**
	 * Select date.
	 * @param date Date to select.
	 */
	void select(Date date);
}
