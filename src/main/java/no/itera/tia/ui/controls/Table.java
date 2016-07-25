package no.itera.tia.ui.controls;

import java.util.List;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WidgetObject;
import no.itera.tia.beans.Entity;
import no.itera.tia.ui.controls.impl.TableImpl;
import no.itera.tia.ui.controls.impl.TableImpl.Header;

@ImplementedBy(TableImpl.class)
public interface Table<T extends Entity> extends WidgetObject {
    
    List<TableRow<T>> getRows();
    TableRow<T> getRow(int index);
    List<Header> getHeadings();
    boolean contains(T object);
    boolean contains(T object, int numberOfRows);
    TableRow<T> findRowContaining(T object);
    List<TableRow<T>> findRowsContaining(T object);
    void fill(T object);
    void fillAllRows(T object);
}
