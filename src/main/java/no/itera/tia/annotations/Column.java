package no.itera.tia.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import no.itera.tia.enumeration.Language;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Columns.class)
public @interface Column {
    String title();
    Language language() default Language.NORWEGIAN;
}
