package no.itera.tia.beans.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import no.itera.tia.beans.Entity;
import no.itera.tia.enumeration.Country;

@XmlRootElement
public class Address implements Entity {
	
    @XmlElement
    private Country country;
    
    @XmlElement
	private String county;
    
    @XmlElement
	private String city;
    
    @XmlElement(name = "streetcode")
	private String streetCode;
    
    @XmlElement(name = "postcode")
	private String postCode;
    
    @XmlElement
	private String street;
    
    @XmlElement(name = "streetno")
	private String streetNo;
    
    @XmlElement
	private String floor;
    
    @XmlElement
	private String door;
	
	private Address() {}
	
	private Address(Country country, String county, String city, String streetCode, String postCode, String street,
			String streetNo, String floor, String door) {
		this.country = country;
		this.county = county;
		this.city = city;
		this.streetCode = streetCode;
		this.postCode = postCode;
		this.street = street;
		this.streetNo = streetNo;
		this.floor = floor;
		this.door = door;
	}

	public Country getCountry() {
		return country;
	}

	public String getCounty() {
		return county;
	}

	public String getCity() {
		return city;
	}

	public String getStreetCode() {
		return streetCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getStreet() {
		return street;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public String getFloor() {
		return floor;
	}

	public String getDoor() {
		return door;
	}

	@Override
    public String toString() {
        return "Address [country=" + country + ", county=" + county + ", city=" + city + ", streetCode=" + streetCode
                + ", postCode=" + postCode + ", street=" + street + ", streetNo=" + streetNo + ", floor=" + floor
                + ", door=" + door + "]";
    }

    public static class Builder {
		private Country country;
		private String county;
		private String city;
		private String streetCode;
		private String postCode;
		private String street;
		private String streetNo;
		private String floor;
		private String door;
		
		public Builder country(Country country) {
			this.country = country;
			return this;
		}
		
		public Builder county(String county) {
			this.county = county;
			return this;
		}
		
		public Builder city(String city) {
			this.city = city;
			return this;
		}
		
		public Builder streetCode(String streetCode) {
			this.streetCode = streetCode;
			return this;
		}
		
		public Builder postCode(String postCode) {
			this.postCode = postCode;
			return this;
		}
		
		public Builder street(String street) {
			this.street = street;
			return this;
		}
		
		public Builder streetNo(String streetNo) {
			this.streetNo = streetNo;
			return this;
		}
		
		public Builder floor(String floor) {
			this.floor = floor;
			return this;
		}
		
		public Builder door(String door) {
			this.door = door;
			return this;
		}
		
		public Address build() {
			return new Address(country, county, city, streetCode, postCode, street, streetNo, floor, door);
		}
	}
}
