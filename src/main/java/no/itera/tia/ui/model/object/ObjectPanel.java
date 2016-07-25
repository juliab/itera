package no.itera.tia.ui.model.object;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.ui.model.object.impl.ObjectPanelImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(ObjectPanelImpl.class)
public interface ObjectPanel extends Panel {
	
	String CSS = "[id$='DynamicObjectAccordionContainerPolicySpecificInformation1AccordionTab::body']";
	String CSS_COVER = CSS + Panel.COVER;
	
    String getStreet();
    String getNumber();
    String getLetter();
    String getHouseNo();
    String getPostCode();  
}
