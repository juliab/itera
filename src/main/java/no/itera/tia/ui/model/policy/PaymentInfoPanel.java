package no.itera.tia.ui.model.policy;

import net.serenitybdd.core.annotations.ImplementedBy;
import no.itera.tia.beans.model.PaymentInfo.Frequency;
import no.itera.tia.ui.model.policy.impl.PaymentInfoPanelImpl;
import no.itera.tia.ui.panels.Panel;

@ImplementedBy(PaymentInfoPanelImpl.class)
public interface PaymentInfoPanel extends Panel {
	
	String CSS = "[id$='PolicyAccordionContainerPolicyPaymentInformationRegionTab::body']";
	
	Frequency getPaymentFrequency();
}
