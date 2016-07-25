package no.itera.tia.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private LocalDate date;
    
    private Date() {}
    
    private Date(LocalDate date) {
        this.date = date;
    }
    
    public static Date of(String date) {
        return new Date(LocalDate.parse(date, FORMATTER));
    }
    
    @Override
    public String toString() {
        return date.format(FORMATTER);
    }
}
