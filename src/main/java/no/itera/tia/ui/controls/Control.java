package no.itera.tia.ui.controls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WebElementFacade;
import no.itera.tia.enumeration.HtmlAttributes;
import no.itera.tia.ui.controls.impl.ControlImpl;

@ImplementedBy(ControlImpl.class)
public interface Control extends WebElementFacade {
	
    Logger logger = LoggerFactory.getLogger(Control.class);
    
    void waitForPageAction();
    String getAttribute(HtmlAttributes attribute);
}
