package no.itera.tia.ui.model.object.controls;

import no.itera.tia.ui.controls.Control;
import no.itera.tia.ui.controls.Editable;
import org.openqa.selenium.WebDriver;

public interface Controls {
    Editable init(WebDriver driver);
}
