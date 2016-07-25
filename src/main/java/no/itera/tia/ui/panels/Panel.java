package no.itera.tia.ui.panels;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WidgetObject;
import no.itera.tia.beans.FormData;
import no.itera.tia.ui.panels.impl.PanelImpl;

@ImplementedBy(PanelImpl.class)
public interface Panel extends WidgetObject {
    
    Logger logger = LoggerFactory.getLogger(Panel.class);
	
	By COVER = By.xpath(".//preceding-sibling::*[contains(@id, 'head')][1]");
	
	void expand();
	void collapse();
	void waitForPageAction();
	
	/**
     * Fill form. Data is taken from entity properties.
     * To work properly, editable form controls should be defined as class properties and to be instance of Editable.
     * Entity properties and corresponding form control fields should have matching variable names.
     * 
     * @param panel Form to be filled
     * @param entity Intitialized entity instance
     */
	void fillForm(FormData entity);
	
	void waitForDownload();
}
