package no.itera.tia.beans.model;

import java.util.stream.Stream;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import no.itera.tia.beans.Entity;
import no.itera.tia.beans.FormData;

@XmlRootElement(name = "payment")
public class PaymentInfo implements Entity, FormData {
	
    @XmlElement
    private Frequency frequency;
	
    @SuppressWarnings("unused")
    private PaymentInfo() {}
    
	public PaymentInfo(Frequency frequency) {
		super();
		this.frequency = frequency;
	}
	
	public Frequency getFrequency() {
		return frequency;
	}
	
	@Override
	public String toString() {
	    return "Payment frequency: " + frequency;
	}

	@XmlType
	@XmlEnum
	public enum Frequency {
	    @XmlEnumValue("1") YEARLY("1 Betaling hvert år"),
	    @XmlEnumValue("12") MONTHLY("12 Månedlig betaling"),
	    @XmlEnumValue("2") HALF_YEARLY("2 Halvårlig betaling"),
	    @XmlEnumValue("4") QUARTERLY("4 Kvartalsvis betaling");
		
		private String value;
		
		private Frequency(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
		
		public static Frequency getByValue(String value) {
			return Stream.of(Frequency.values()).filter(f -> f.value.equals(value)).findFirst().get();
		}
	}
}
