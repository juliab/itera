package no.itera.tia.beans.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import no.itera.tia.annotations.Column;
import no.itera.tia.annotations.RowMatch;
import no.itera.tia.beans.Entity;
import no.itera.tia.enumeration.Language;

@XmlRootElement
public class Risk implements Entity {
	
    @XmlElement
    @Column(title = " ", language = Language.NORWEGIAN)
    @Column(title = " ", language = Language.ENGLISH)
    @RowMatch
    private String name;
    
    @XmlElement(name = "covered")
    @Column(title = "Dekket", language = Language.NORWEGIAN)
    @Column(title = "Covered", language = Language.ENGLISH)
	private boolean isCovered = false;
    
    @XmlElement
	@Column(title = "Forsikringssum", language = Language.NORWEGIAN)
    @Column(title = "Risk Sum", language = Language.ENGLISH)
    private Integer sum;
    
    @XmlElement
	@Column(title = "Egenandel", language = Language.NORWEGIAN)
    @Column(title = "Risk Excess", language = Language.ENGLISH)
    private Integer excess;
    
    @Column(title = "Risikopris", language = Language.NORWEGIAN)
    @Column(title = "Risk Price", language = Language.ENGLISH)
	private Integer price;
	
	public String getName() {
		return name;
	}
	
	public Boolean isCovered() {
		return isCovered;
	}
	
	public Integer getSum() {
		return sum;
	}
	
	public Integer getExcess() {
		return excess;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Risk (" + name + ", covered=" + isCovered + ", sum: " + sum + ", excess: " + excess + "]\n";
	}
}
