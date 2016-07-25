package no.itera.tia.enumeration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum Country {
    @XmlEnumValue("Denmark") DENMARK,
    @XmlEnumValue("UK") UK,
    @XmlEnumValue("Netherlands") NETHERLANDS,
    @XmlEnumValue("Sweden") SWEDEN,
    @XmlEnumValue("Canada") CANADA,
    @XmlEnumValue("Russia") RUSSIA,
	@XmlEnumValue("Norway") NORWAY;
}
