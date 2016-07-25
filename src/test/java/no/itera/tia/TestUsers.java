package no.itera.tia;

import no.itera.tia.beans.model.User;
import no.itera.tia.unmarshalling.EntityConverter;

public enum TestUsers {
    OALEXAV("oalexav");
    
    private String fileName;

    TestUsers(String fileName) {
        this.fileName = fileName;
    }

    private String getFileName() {
        return "test_data/users/" + fileName + ".xml";
    }
    
    public User get() {
        return EntityConverter.convert(getFileName(), User.class);
    }
    
    @Override
    public String toString() {
        return fileName;
    }
}
