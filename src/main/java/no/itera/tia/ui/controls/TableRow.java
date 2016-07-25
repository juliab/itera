package no.itera.tia.ui.controls;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.beans.Entity;
import no.itera.tia.ui.controls.impl.TableRowImpl;

@ImplementedBy(TableRowImpl.class)
public interface TableRow<T  extends Entity> extends Control {
    boolean contains(T object);
    void open();
    void fill(T object);
}
