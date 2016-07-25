package no.itera.tia.beans.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import no.itera.tia.annotations.Column;
import no.itera.tia.beans.Date;
import no.itera.tia.beans.Entity;
import no.itera.tia.beans.LocalizedString;
import no.itera.tia.enumeration.Language;

@XmlRootElement
public class Document implements Entity {
    
    @Column(title = "Oppgavenr", language = Language.NORWEGIAN)
    @Column(title = "Case No", language = Language.ENGLISH)
    private Integer number;
    
    @Column(title = "Oppgavekategori", language = Language.NORWEGIAN)
    @Column(title = "Case Type", language = Language.ENGLISH)
    private Type type;
    
    @Column(title = "Generell oppgavetype", language = Language.NORWEGIAN)
    @Column(title = "Case Subtype", language = Language.ENGLISH)
    private SubType subType;
    
    @XmlElement
    @Column(title = "Beskrivelse", language = Language.NORWEGIAN)
    @Column(title = "Description", language = Language.ENGLISH)
    private String description;
    
    @Column(title = "Opprettelsestidspunkt", language = Language.NORWEGIAN)
    @Column(title = "Writing Date", language = Language.ENGLISH)
    private Date writingDate;
    
    @Column(title = "Handlingstype", language = Language.NORWEGIAN)
    @Column(title = "Action Type", language = Language.ENGLISH)
    private ActionType actionType;
    
    @Column(title = "Avslutningsdato", language = Language.NORWEGIAN)
    @Column(title = "Completed Date", language = Language.NORWEGIAN)
    private Date completedDate;
    
    @XmlElementWrapper
    @XmlElement(name = "string")
    private List<String> text;
    
    @Column(title = "Skriv ut", language = Language.NORWEGIAN)
    @Column(title = "Print", language = Language.ENGLISH)
    private boolean print;
    
    @Column(title = "Online", language = Language.NORWEGIAN)
    @Column(title = "Online", language = Language.ENGLISH)
    private boolean online;
    
    @Column(title = "Skriver", language = Language.NORWEGIAN)
    @Column(title = "Printer", language = Language.ENGLISH)
    private Printer printer;
    
    @Column(title  = "Prioritet", language = Language.NORWEGIAN)
    @Column(title = "Priority", language = Language.ENGLISH)
    private Priority priority;
    
    @Column(title = "Kopier", language = Language.NORWEGIAN)
    @Column(title = "Copies", language = Language.ENGLISH)
    private Integer copies;
    
    private Document() {}
    
    private Document(Integer number, Type type, SubType subType, String description, 
            Date writingDate, ActionType actionType, Date completedDate, boolean print, 
            boolean online, Printer printer, Priority priority, Integer copies) {
        
        this.number = number;
        this.type = type;
        this.subType = subType;
        this.description = description;
        this.writingDate = writingDate;
        this.actionType = actionType;
        this.completedDate = completedDate;
        this.print = print;
        this.online = online;
        this.printer = printer;
        this.priority = priority;
        this.copies = copies;
    }
    
    public Integer getNumber() {
        return number;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Date getWritingDate() {
        return writingDate;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Date getCompletedDate() {
        return completedDate;
    }
    
    public List<String> getText() {
        return text;
    }

    public enum Type {
        LETTER_OUT(LocalizedString.of(Language.NORWEGIAN, "LTOT Brev ut")
                .addTranslation(Language.ENGLISH, "LTOT Letter Out"));
        
        private LocalizedString value;
        
        private Type(LocalizedString value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value.getLocalizedValue();
        }
    }
    
    public enum SubType {
        BOLIG(LocalizedString.of(Language.NORWEGIAN, "BOL Bolig")
                .addTranslation(Language.ENGLISH, "BOL Bolig"));
        
        private LocalizedString value;
        
        private SubType(LocalizedString value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value.getLocalizedValue();
        }
    }
    
    private enum ActionType {
        ACTION_TAKEN(LocalizedString.of(Language.NORWEGIAN, "0 Oppgave utført/ingen oppfølging")
                .addTranslation(Language.ENGLISH, "0 Action has been taken/Take no action"));
        
        private LocalizedString value;
        
        private ActionType(LocalizedString value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value.getLocalizedValue();
        }
    }
    
    public enum Printer {
        TIA(LocalizedString.of(Language.NORWEGIAN, "99 Platelagerskriver TIA Virtuel skriver"));
        
        private LocalizedString value;
        
        private Printer(LocalizedString value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value.getLocalizedValue();
        }
    }
    
    public enum Priority {
        HIGH(LocalizedString.of(Language.NORWEGIAN, "Høy").addTranslation(Language.ENGLISH, "High")),
        NORMAL(LocalizedString.of(Language.NORWEGIAN, "Normal").addTranslation(Language.ENGLISH, "Normal"));
        
        private LocalizedString value;
        
        private Priority(LocalizedString value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return value.getLocalizedValue();
        }
    }
    
    public static class Builder {
        private Integer number;
        private Type type;
        private SubType subType;
        private String description;
        private Date writingDate;
        private ActionType actionType;
        private Date completedDate;
        private boolean print = true;
        private boolean online;
        private Printer printer;
        private Priority priority;
        private Integer copies;
        
        public Builder number(Integer number) {
            this.number = number;
            return this;
        }
        
        public Builder type(Type type) {
            this.type = type;
            return this;
        }
        
        public Builder subType(SubType subType) {
            this.subType = subType;
            return this;
        }
        
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        
        public Builder writingDate(Date writingDate) {
            this.writingDate = writingDate;
            return this;
        }
        
        public Builder actionType(ActionType actionType) {
            this.actionType = actionType;
            return this;
        }
        
        public Builder completedDate(Date completedDate) {
            this.completedDate = completedDate;
            return this;
        }
        
        public Builder print(boolean print) {
            this.print = print;
            return this;
        }
        
        public Builder online(boolean online) {
            this.online = online;
            return this;
        }
        
        public Builder printer(Printer printer) {
            this.printer = printer;
            return this;
        }
        
        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }
        
        public Builder copies(Integer copies) {
            this.copies = copies;
            return this;
        }
        
        public Document build() {
            return new Document(number, type, subType, description, writingDate, 
                    actionType, completedDate, print, online, printer, priority, copies);
        }
    }
}
