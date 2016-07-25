package no.itera.tia.beans.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import no.itera.tia.beans.Entity;

@XmlRootElement
public class User implements Entity {
    
    @XmlElement
    private String login;
    
    @XmlElement
    private String password;
   
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
}
