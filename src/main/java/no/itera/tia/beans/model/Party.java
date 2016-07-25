package no.itera.tia.beans.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import no.itera.tia.annotations.Column;
import no.itera.tia.beans.Entity;
import no.itera.tia.enumeration.Language;

@XmlRootElement
public class Party implements Entity {
    
    @XmlElement
	private Type type;
    
    @XmlElement
    @Column(title = "Kundenummer", language = Language.NORWEGIAN)
    @Column(title = "Party Id", language = Language.ENGLISH)
	private String id;
    
    @XmlElement
	private String title;
    
    @XmlElement
	private String forename;
    
    @XmlElement
	private String surname;
    
    @Column(title = "Etternavn", language = Language.NORWEGIAN)
    @Column(title = "Name", language = Language.ENGLISH)
    private String fullName;
    
    @XmlElement
	private String civilRegNo;
    
    @XmlElement
	private Address address;
    
	private Language language;
	
	private Party() {}
	
	private Party(Type type, String id, String title, String forename, String surname, String civilRegNo,
			Address address, Language language) {
		this.type = type;
		this.id = id;
		this.title = title;
		this.forename = forename;
		this.surname = surname;
		this.fullName = forename + " " + surname;
		this.civilRegNo = civilRegNo;
		this.address = address;
		this.language = language;
	}

	public Type getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getForename() {
		return forename;
	}

	public String getSurname() {
		return surname;
	}

	public String getCivilRegNo() {
		return civilRegNo;
	}

	public Address getAddress() {
		return address;
	}

	public Language getLanguage() {
		return language;
	}
	
	public String getName() {
		return forename + " " + surname;
	}
	
	@Override
    public String toString() {
	    StringBuilder result = new StringBuilder("Party:\n");
	    result.append("type: " + (type != null ? type.toString() : null) + "\n");
	    result.append("id: " + id + "\n");
	    result.append("first name: " + forename + "\n");
	    result.append("last name: " + surname + "\n");
	    result.append("address: " + (address != null ? address.toString() : null) + "\n");
	    return result.toString();
    }

    public static class Builder {
		private Type type;
		private String id;
		private String title;
		private String forename;
		private String surname;
		private String civilRegNo;
		private Address address;
		private Language language;
		
		public Builder type(Type type) {
			this.type = type;
			return this;
		}
		
		public Builder builder(String id) {
			this.id = id;
			return this;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder forename(String forename) {
			this.forename = forename;
			return this;
		}
		
		public Builder surname(String surname) {
			this.surname = surname;
			return this;
		}
		
		public Builder civilRegNo(String civilRegNo) {
			this.civilRegNo = civilRegNo;
			return this;
		}
		
		public Builder address(Address address) {
			this.address = address;
			return this;
		}
		
		public Builder language(Language language) {
			this.language = language;
			return this;
		}
		
		public Party build() {
			return new Party(type, id, title, forename, surname, civilRegNo, address, language);
		}
	}

	@XmlType
	@XmlEnum
	public enum Type {
	    @XmlEnumValue("person") PERSON("Person", "Person"), 
	    @XmlEnumValue("institution") INSTITUTION("Institution", "Organisasjon"),
	    @XmlEnumValue("location") LOCATION("Location", "Sted"),
	    @XmlEnumValue("unknown") UNKNOWN("Unknown", "Ukjent");
		
	    private String value;
		private String label;
		
		Type(String value, String label) {
			this.value = value;
		    this.label = label;
		}
		
		public String getLabel() {
			return this.label;
		}
		
		@Override
		public String toString() {
		    return value;
		}
	}
}
