package no.itera.tia;

import no.itera.tia.beans.model.Document;
import no.itera.tia.unmarshalling.EntityConverter;

public enum TestDocuments {
    PREMIEVARSEL("premievarsel", "Premievarsel");
    
    private String fileName;
    private String value;
    
    TestDocuments(String fileName, String value) {
        this.fileName = fileName;
        this.value = value;
    }
    
    private String getFileName() {
        return "test_data/documents/" + fileName + ".xml";
    }
    
    public Document get() {
        return EntityConverter.convert(getFileName(), Document.class);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
