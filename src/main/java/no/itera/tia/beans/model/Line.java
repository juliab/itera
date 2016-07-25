package no.itera.tia.beans.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import no.itera.tia.beans.Date;
import no.itera.tia.beans.Entity;
import no.itera.tia.enumeration.CancelCode;
import no.itera.tia.unmarshalling.DateAdapter;
import no.itera.tia.unmarshalling.EntityConverter;

/**
 * This class represents policy line.
 */
@XmlRootElement
public class Line implements Entity {
    
    @XmlElement(name = "start")
    @XmlJavaTypeAdapter(type = Date.class, value = DateAdapter.class)
	private Date startDate;
    
    @XmlElement(name = "end")
    @XmlJavaTypeAdapter(type = Date.class, value = DateAdapter.class)
	private Date endDate;
    
    private CancelCode cancelCode;
    
    private InsuranceObject object;
	
    @XmlElement(name = "previous_info")
    private PastInsuranceInfo pastInsuranceInfo;
	
    public Line() {
		this.cancelCode = CancelCode.IN_FORCE;
	}
	
	public Line(InsuranceObject object, PastInsuranceInfo info) {
		this();
		this.object = object;
		this.pastInsuranceInfo = info;
	}

	public Line(String fileName) {
	    this();
	    this.object = EntityConverter.convert(fileName, InsuranceObject.class);
	}
	
	public Date getCoverStartDate() {
		return startDate;
	}
	
	public void setCoverStartDate(Date coverStartDate) {
		this.startDate = coverStartDate;
	}
	
	public Date getCoverEndDate() {
		return endDate;
	}
	
	public void setCoverEndDate(Date coverEndDate) {
		this.endDate = coverEndDate;
	}
	
	public CancelCode getCancelCode() {
		return cancelCode;
	}
	
	public void setCancelCode(CancelCode cancelCode) {
		this.cancelCode = cancelCode;
	}
	
	public InsuranceObject getObject() {
		return object;
	}
	
	public void setObject(InsuranceObject object) {
		this.object = object;
	}

	public PastInsuranceInfo getPastInsuranceInfo() {
		return pastInsuranceInfo;
	}

    @Override
    public String toString() {
        return "Line: startDate = " + startDate + ", endDate = " + endDate 
                + "\ncancelCode = " + cancelCode + "\n" + pastInsuranceInfo;
    }
}