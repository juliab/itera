package no.itera.tia.enumeration;

public enum Language {
	GERMAN(6, "de"),
	DUTCH(2, "nl"),
	NORWEGIAN(4, "no"),
	SWEDISH(1, "sv"),
	DANISH(5, "da"),
	POLISH(3, "pl"),
	TIA(7, ""),
	ENGLISH(0, "en");
	
	private int index;
	private String code;
	
	private Language(int index, String code) {
		this.index = index;
		this.code = code;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public String getCode() {
		return this.code;
	}
}
