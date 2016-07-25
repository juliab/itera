package no.itera.tia.enumeration;

import no.itera.tia.beans.LocalizedString;

public enum PolicyStatusCode {
    SUCCESS(LocalizedString.of(Language.NORWEGIAN, "POL Avtale").addTranslation(Language.ENGLISH, "POL Policy"),
            LocalizedString.of(Language.NORWEGIAN, "P Opprett avtale").addTranslation(Language.ENGLISH, "P Create Policy"),
            LocalizedString.of(Language.NORWEGIAN, "OK").addTranslation(Language.ENGLISH, "OK"),
            LocalizedString.of(Language.NORWEGIAN, "11 Ny forsikring").addTranslation(Language.ENGLISH, "11 New Policy Line"));
    
    private LocalizedString policyStatus;
    private LocalizedString policyTransactionType;
    private LocalizedString policyLineStatus;
    private LocalizedString transactionCode;
    
    private PolicyStatusCode(LocalizedString policyStatus, LocalizedString policyTransactionType,
            LocalizedString policyLineStatus, LocalizedString transactionCode) {
        this.policyStatus = policyStatus;
        this.policyTransactionType = policyTransactionType;
        this.policyLineStatus = policyLineStatus;
        this.transactionCode = transactionCode;
    }
    
    public String getPolicyStatus() {
        return policyStatus.getLocalizedValue();
    }
    
    public String getPolicyTransactionType() {
        return policyTransactionType.getLocalizedValue();
    }
    
    public String getPolicyLineStatus() {
        return policyLineStatus.getLocalizedValue();
    }
    
    public String getTransactionCode() {
        return transactionCode.getLocalizedValue();
    }
    
    public String getTransactionCode(Language language) {
        return transactionCode.getValue(language);
    }
}
