package no.itera.tia;

import no.itera.tia.beans.model.Party;
import no.itera.tia.unmarshalling.EntityConverter;

public enum TestCustomers {
    MONA_STENSVOLD("mstensvold", "Mona Stensvold"),
    JULIA_SIROSHTAN("jseroshtan", "Julia Siroshtan"),
    SIGBRITH_SONSTEBY("ssonsteby", "Sigbrith Sønsteby");
    
    private String fileName;
    private String value;

    TestCustomers(String fileName, String value) {
        this.fileName = fileName;
        this.value = value;
    }

    private String getFileName() {
        return "test_data/customers/" + fileName + ".xml";
    }
    
    public Party get() {
        return EntityConverter.convert(getFileName(), Party.class);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
