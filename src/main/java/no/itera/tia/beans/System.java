package no.itera.tia.beans;

import no.itera.tia.enumeration.Language;

/**
 * This class is a singleton. It contains properties applicable to the whole application.
 */
public class System {
    
    private static System instance;
    
    private Language language;
    
    private System() {
        this.language = Language.ENGLISH; // default language
    };
    
    public static System get() {
        if (instance == null) {
            instance = new System();
        }
        
        return instance;
    }
    
    public void setLanguage(Language language) {
        this.language = language;
    }
    
    public Language getLanguage() {
        return this.language;
    }
}
