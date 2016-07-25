package no.itera.tia.enumeration;

import no.itera.tia.beans.LocalizedString;

public enum CancelCode {
    IN_FORCE(LocalizedString.of(Language.NORWEGIAN, "0 I kraft")
            .addTranslation(Language.ENGLISH, "0 In Force")),
    CUSTOMER_HAS_CANCELLED(LocalizedString.of(Language.NORWEGIAN, "1 Kunde har annullert  død")
            .addTranslation(Language.ENGLISH, "1 Customer has cancelled - died"));
	
	private LocalizedString value;
	
	CancelCode(LocalizedString value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.getLocalizedValue();
	}
}
