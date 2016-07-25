package no.itera.tia.beans;

import java.util.HashMap;
import java.util.Map;

import no.itera.tia.enumeration.Language;
import no.itera.tia.exceptions.TestException;

public class LocalizedString {
    private Map<Language, String> values = new HashMap<>();
    
    private LocalizedString() {}
    
    private LocalizedString(Language language, String value) {
        values.put(language, value);
    }
    
    public static LocalizedString of(Language language, String value) {
        return new LocalizedString(language, value);
    }
    
    public LocalizedString addTranslation(Language language, String value) {
        this.values.put(language, value);
        return this;
    }
    
    public String getValue(Language language) {
        StringBuilder message = new StringBuilder("No " + language.name() + " translation for string ");
        values.entrySet().forEach(v -> message.append(v + "; "));
        
        Language searchKey = this.values.keySet().stream()
                .filter(l -> l.equals(language))
                .findAny()
                .orElseThrow(() -> TestException.get(message.toString()));
        
        return values.get(searchKey);
    }
    
    public String getLocalizedValue() {
        return getValue(System.get().getLanguage());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((values == null) ? 0 : values.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return values.values().stream().anyMatch(v -> v.equals(obj));
    }
}
