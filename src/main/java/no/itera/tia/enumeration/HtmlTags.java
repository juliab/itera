package no.itera.tia.enumeration;

import org.openqa.selenium.By;

public enum HtmlTags {
	BODY("body"),
	LINK("a"),
	INPUT("input"),
	SELECT("select");
	
    private String value;
	
	HtmlTags(String value) {
	    this.value = value;
	}
	
	public By locator() {
		return By.tagName(value);
	}
	
	@Override
	public String toString() {
	    return value;
	}
}
