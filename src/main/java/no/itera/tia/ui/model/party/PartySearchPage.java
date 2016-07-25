package no.itera.tia.ui.model.party;

import net.serenitybdd.core.annotations.findby.FindBy;
import no.itera.tia.ui.controls.CheckBox;
import no.itera.tia.ui.controls.DatePicker;
import no.itera.tia.ui.controls.Dropdown;
import no.itera.tia.ui.controls.Input;
import no.itera.tia.ui.controls.RadioButton;
import no.itera.tia.ui.pages.BasePage;
import no.itera.tia.beans.model.Party;
import no.itera.tia.ui.controls.Button;

/**
 * This class represents Party Search page (Kundesøk) of TIA application
 * 
 * @author yulia.siroshtan
 */
public class PartySearchPage extends BasePage {
	
	public static final String PAGE_NAME = "Party Search";
	
	private final static String ID_PREFIX = "pt:sf_c:r1:1:pt:P2000PartySearchSbf:SearchP2000PartySearch";
	private final static String ID_POSTFIX = "::content";
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "NameTypeSearch" + ID_POSTFIX + "')]")
	private RadioButton type;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "IdNoAltSearch" + ID_POSTFIX + "')]")
	private Input id;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "Title" + ID_POSTFIX + "')]")
	private Input title;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "Forename" + ID_POSTFIX + "')]")
	private Input forename;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "UseSurnameSearch" + ID_POSTFIX + "')]")
	private CheckBox useSurname;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "SurnameSearch" + ID_POSTFIX + "')]")
	private Input surname;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "UseCivilRegCodeSearch" + ID_POSTFIX + "')]")
	private CheckBox useCivilRegNo;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "CivilRegCodeSearch" + ID_POSTFIX + "')]")
	private Input civilRegNo;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "StreetNoSearch" + ID_POSTFIX + "')]")
	private Input streetNo;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "FloorExtSearch" + ID_POSTFIX + "')]")
	private Input floor;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "FloorSearch" + ID_POSTFIX + "')]")
	private Input door;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "StreetSearch" + ID_POSTFIX + "')]")
	private Input street;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "PostAreaCodeSearch" + ID_POSTFIX + "')]")
	private Input postCode;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "PostStreetSearch" + ID_POSTFIX + "')]")
	private Input streetCode;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "CitySearch" + ID_POSTFIX + "')]")
	private Input city;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "CountyCodeSearch" + ID_POSTFIX + "')]")
	private Input county;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "CountryCodeSearch" + ID_POSTFIX + "')]")
	private Dropdown country; 
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "LanguageSearch" + ID_POSTFIX + "')]")
	private Dropdown language;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "PhoneNoSearch" + ID_POSTFIX + "')]")
	private Input phoneNo;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "TelephoneTypeSearch" + ID_POSTFIX + "')]")
	private Dropdown phoneType;  
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "RoleSearch" + ID_POSTFIX + "')]")
	private Dropdown role;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "CompanyRegCodeSearch" + ID_POSTFIX + "')]")
	private Input companyRegNo;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "BirthdateSearch" + ID_POSTFIX + "')]")
	private DatePicker dateOfBirth;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "Sbf:obos_no" + ID_POSTFIX + "')]")
	private Input obosMembershipNo;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "Sbf:digital_cons" + ID_POSTFIX + "')]")
	private CheckBox accept;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "Sbf:housingcomp" + ID_POSTFIX + "')]")
	private Input housingCompany;
	
	@FindBy(xpath = ".//*[contains(@id, '" + ID_PREFIX + "Sbf:membersince" + ID_POSTFIX + "')]")
	private Input registration;
	
	@FindBy(xpath = ".//*[contains(@id, 'P2000PartySearchSbf:cb4')]")
	private Button search;
	
	@FindBy(xpath = PartySearchResult.XPATH)
	private PartySearchResult searchResult;
	
	public void waitUntilOpen() {
		setWaitForTimeout(30000);
		waitForTextToAppear(PAGE_NAME);
    }

	public void searchAndOpen(Party party) {
		// TODO implement search

		useCivilRegNo.deselect();
		useSurname.select();
		forename.type(party.getForename());
		surname.type(party.getSurname());
		search.click();
		waitForPageAction();
		searchResult.selectFirst();
		waitForPageAction();
	}
}
