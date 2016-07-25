package no.itera.tia.beans.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import no.itera.tia.beans.FormData;

@XmlRootElement
public class Property implements FormData {
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	@XmlElement
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Property (" + name + ", value=" + value + "]\n";
	}
}
