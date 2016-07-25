package no.itera.tia;

import no.itera.tia.beans.model.Policy;
import no.itera.tia.unmarshalling.EntityConverter;

public enum TestPolicies {
    WITH_PREVIOUS_INSURANCE_INFO("with_previous_info", "with previous insurance information"),
    WITH_12_INSTALLMENTS("with_12_installments", "with 12 installments");
    
    private String fileName;
    private String value;

    TestPolicies(String fileName, String value) {
        this.fileName = fileName;
        this.value = value;
    }

    private String getFileName() {
        return "test_data/policies/" + fileName + ".xml";
    }
    
    public Policy get() {
        return EntityConverter.convert(getFileName(), Policy.class);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
