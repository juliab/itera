package no.itera.tia.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum InsuranceCompany {
    @XmlEnumValue("Ace Europe") ACE_EUROPE("Ace Europe"),
    @XmlEnumValue("AIG Europe") AIG_EUROPE("AIG Europe");
	
	private String value;
	
	private InsuranceCompany(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
