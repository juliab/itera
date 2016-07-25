package no.itera.tia.beans.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import no.itera.tia.beans.Entity;

@XmlRootElement
public class Policy implements Entity {
    
    @XmlElement(name = "payment")
	private PaymentInfo paymentInfo;
    
    @XmlElementWrapper(name = "lines")
    @XmlElement(name = "line")
    private List<Line> lines = new ArrayList<>();
	
	@SuppressWarnings("unused")
    private Policy() {}
	
	public Policy(Line line, PaymentInfo paymentInfo) {
        this(line);
        this.paymentInfo = paymentInfo;
    }
	
	public Policy(Line line) {
		lines.add(line);
	}
	
	public Line getLine() {
		return lines.get(0); // TODO add multi-line support
	}
	
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	
	@Override
	public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(paymentInfo);
	    lines.stream().forEach(l -> System.out.println(l));
	    return builder.toString();
	}
}