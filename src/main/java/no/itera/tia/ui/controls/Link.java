package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.controls.impl.LinkImpl;

/**
 * This interface represents TIA link element.
 *
 * @author yulia.siroshtan
 */
@ImplementedBy(LinkImpl.class)
public interface Link extends Control {
}
