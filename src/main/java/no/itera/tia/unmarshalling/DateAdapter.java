package no.itera.tia.unmarshalling;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import no.itera.tia.beans.Date;

/**
 * Custom adapter for successful LocalDate un-/marshalling.
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    @Override
    public Date unmarshal(String v) throws Exception {
        return Date.of(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return v.toString();
    }

}
