package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WidgetObject;
import no.itera.tia.ui.controls.impl.PopupImpl;

@ImplementedBy(PopupImpl.class)
public interface Popup extends WidgetObject {
	void accept();
	void decline();
}
