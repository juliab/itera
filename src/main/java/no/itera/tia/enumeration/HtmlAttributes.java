package no.itera.tia.enumeration;

public enum HtmlAttributes {
	LANG("lang"),
	STYLE("style"),
	TITLE("title"),
	TEXT("textContent"),
	TYPE("type"),
	ID("id"),
	VALUE("value");
	
	private String value;
	
	HtmlAttributes(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
