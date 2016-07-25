package no.itera.tia.beans.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import no.itera.tia.beans.Entity;
import no.itera.tia.beans.FormData;

@XmlRootElement(name = "object")
public class InsuranceObject implements Entity, FormData {
	
    @XmlElement(name = "product")
    private String name;
    
    @XmlElementWrapper
    @XmlElement(name = "property")
	private List<Property> properties;
    
    @XmlElementWrapper(name = "coverage")
    @XmlElement(name = "risk")
	private List<Risk> risks;
	
	public String getName() {
		return name;
	}

	public List<Property> getProperties() {
		return properties;
	}
	
	public List<Risk> getRisks() {
		return risks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("InsuranceObject [name: " + name + "\n");
		properties.stream().forEach(p -> builder.append(p.toString()));
		risks.stream().forEach(p -> builder.append(p.toString()));
		return builder.toString();
	}
}
