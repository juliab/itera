package no.itera.tia.beans.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import no.itera.tia.beans.Entity;
import no.itera.tia.beans.FormData;
import no.itera.tia.enumeration.InsuranceCompany;

@XmlRootElement(name = "previous_info")
public class PastInsuranceInfo implements Entity, FormData {
	
    @XmlElement(name = "previous")
    private InsuranceCompany previousInsurance;
    
    @XmlElement(name = "cause")
	private CreateCause createCause;
    
    @XmlElement(name = "number")
	private String previousPolicyNumber;
    
    @XmlElement(name = "transfer")
	private String stampDutyTransfer;
    
    @XmlElement(name = "next")
	private InsuranceCompany nextInsurance;
    
    @SuppressWarnings("unused")
    private PastInsuranceInfo() {}
	
	public PastInsuranceInfo(InsuranceCompany previousInsurance, CreateCause createCause,
							 String previousPolicyNumber, String stampDutyTransfer) {
		this.previousInsurance = previousInsurance;
		this.createCause = createCause;
		this.previousPolicyNumber = previousPolicyNumber;
		this.stampDutyTransfer = stampDutyTransfer;
	}
	
	public InsuranceCompany getPreviousInsurance() {
		return previousInsurance;
	}

	public CreateCause getCreateCause() {
		return createCause;
	}

	public String getPreviousPolicyNumber() {
		return previousPolicyNumber;
	}

	public String getStampDutyTransfer() {
		return stampDutyTransfer;
	}

	public InsuranceCompany getNextInsurance() {
		return nextInsurance;
	}
	
	@Override
    public String toString() {
        return "PastInsuranceInfo [previousInsurance=" + previousInsurance + ", createCause=" + createCause
                + ", previousPolicyNumber=" + previousPolicyNumber + ", stampDutyTransfer=" + stampDutyTransfer
                + ", nextInsurance=" + nextInsurance + "]";
    }

    @XmlType(name = "cause")
	@XmlEnum
	public enum CreateCause {
	    @XmlEnumValue("0") DEMO("0 Demo");
		
		private String value;
		
		CreateCause(String value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return value;
		}
	}
}
