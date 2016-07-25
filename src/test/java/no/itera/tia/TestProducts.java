package no.itera.tia;

import no.itera.tia.beans.model.InsuranceObject;
import no.itera.tia.unmarshalling.EntityConverter;

public enum TestProducts {
    HOUSE_2006("house2006", "House (Bolig/Hus)"),
    HOUSE_2010("house2010", "House (Bolig/Hus)");

    private String fileName;
    private String value;

    TestProducts(String fileName, String value) {
        this.fileName = fileName;
        this.value = value;
    }

    private String getFileName() {
        return "test_data/products/" + fileName + ".xml";
    }
    
    public InsuranceObject getInsuranceObject() {
        return EntityConverter.convert(getFileName(), InsuranceObject.class);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
