package no.itera.tia.ui.model.object.impl;

import no.itera.tia.beans.model.Property;
import no.itera.tia.ui.model.object.controls.Controls;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import no.itera.tia.beans.FormData;
import no.itera.tia.beans.model.InsuranceObject;
import no.itera.tia.exceptions.TestException;
import no.itera.tia.ui.controls.ActiveDropdown;
import no.itera.tia.ui.controls.Dropdown;
import no.itera.tia.ui.controls.Input;
import no.itera.tia.ui.controls.Toggle;
import no.itera.tia.ui.model.object.ObjectPanel;
import no.itera.tia.ui.panels.impl.PanelImpl;

public class ObjectPanelImpl extends PanelImpl implements ObjectPanel {

    @FindBy(css = "[id$='TIA_IT1::content']") // Vei
    private Input street;
    
    @FindBy(css = "[id$='TIA_OC3::content']")
    private ActiveDropdown type;
    
    @FindBy(css = "[id$='TIA_IT10::content']")
    private Input identifyBuilding; // Fritekst til å identifisere bygningen
    
    @FindBy(css = "[id$='TIA_IT2::content']")
    private Input number; // Nummer
    
    @FindBy(css = "[id$='TIA_IT3::content']")
    private Input letter; // Oppgang
    
    @FindBy(css = "[id$='TIA_IT4::content']")
    private Input houseNo; // Bolignummer
    
    @FindBy(css = "[id$='TIA_OC1::content']")
    private Dropdown postCode; // Postnummer og by
    
    @FindBy(css = "[id$='TIA_OC2::content']")
    private Dropdown numberOfInjuries; // Antall skader
    
    @FindBy(css = "[id$='TIA_OC6::content']")
    private Dropdown residenceType; // Type bolig
    
    @FindBy(css = "[id$='TIA_IT7::content']")
    private Input year; // Byggeår
    
    @FindBy(css = "[id$='TIA_IT8::content']")
    private Input grossArea; // Bruttoareal
    
    @FindBy(css = "[id$='TIA_OC7::content']")
    private Dropdown coverageType; // Deknings type
    
    @FindBy(css = "[id$='TIA_OC8::content']")
    private Dropdown numberOfResidents; // Antall beboere
    
    @FindBy(css = "[id$='TIA_OC10::content']")
    private Dropdown isRented; // Er boligen utleid
    
    @FindBy(css = "[id$='TIA_OC11::content']")
    private Toggle isListed; // Er det en fredet bygning?
    
    @FindBy(css = "[id$='TIA_OC15::content']")
    private Toggle waterGuard; // Er det montert waterguard?
    
    @FindBy(css = "[id$='TIA_OC16::content']")
    private Toggle fireAlarm; // Er det brannalarm?
    
    @FindBy(css = "[id$='TIA_OC17::content']")
    private Toggle mortgage; // Er det pant i boligen
    
    @FindBy(css = "[id$='TIA_OC12::content']")
    private Input promotionalDiscount; // Kampanjerabatt
    
    @FindBy(css = "[id$='TIA_OC13::content']")
    private Input marketDiscount; // Markedsrabatt
    
    @FindBy(css = "[id$='TIA_IT14::content']")
    private Input uwDiscount; // UW rabatt
    
    @FindBy(css = "[id$='TIA_IT5::content']")
    private Input farmNumber; // Gårdsnummer
    
    @FindBy(css = "[id$='TIA_IT6::content']")
    private Input useNumber; // Bruksnummer
    
    @FindBy(css = "[id$='TIA_OC9::content']")
    private Toggle isHolidayHomeRented; // Er fritidsboligen utleid
    
    @FindBy(css = "[id$='TIA_OC13::content']")
    private Toggle hasElectricity; // Er det innlagt strøm?
    
    @FindBy(css = "[id$='TIA_OC14::content']")
    private Toggle hasWater; // Er det innlagt vann?
    
    @FindBy(css = "[id$='TIA_OC5::content']")
    private Dropdown constructionMethod; // Byggemåte
    
    @FindBy(css = "[id$='TIA_OC12::content']")
    private Toggle hasEmergencyAlarm; // Er det alarm med overføring til alarmsentral?

    @FindBy(css = "[id$='TIA_IT11::content']")
    private Input bicycleFrameNumber; // Rammenummer sykkel
    
    @FindBy(css = "[id$='TIA_OC4::content']")
    private Dropdown insuredObosFurniture; // Forsikringssum for Obos Innbo
    
    @FindBy(css = "[id$='TIA_OC1::content']")
    private Toggle manualLookup; // Manuelt oppslag mod OFV
    
    @FindBy(css = "[id$='TIA_OC2::content']")
    private Dropdown cartype; // Type
    
    @FindBy(css = "[id$='TIA_OC3::content']")
    private Toggle nyreg; // Nyreg
    
    @FindBy(css = "[id$='TIA_IT1::content']")
    private Input registrationNumber; // Registreringsnummer
    
    @FindBy(css = "[id$='TIA_IT2::content']")
    private Input registration; // Registreringsår

    @FindBy(css = "[id$='TIA_IT3::content']")
    private Input statementNumber; // Erklæringsnummer
    
    @FindBy(css = "[id$='TIA_IT4::content']")
    private Input vin; // Chassisnummer
    
    @FindBy(css = "[id$='TIA_IT5::content']")
    private Input carSearch; // Bilsøk
    
    @FindBy(css = "[id$='TIA_IT6::content']")
    private Input productionYear; // Årsmodell
    
    @FindBy(css = "[id$='TIA_IT7::content']")
    private Input brand; // Merke
    
    @FindBy(css = "[id$='TIA_IT8::content']")
    private Input model; // Modell
    
    @FindBy(css = "[id$='TIA_IT9::content']")
    private Input variant; // Variant
    
    @FindBy(css = "[id$='TIA_OC6::content']")
    private Dropdown segmentModel; // Segmentmodell OFV
    
    @FindBy(css = "[id$='TIA_IT10::content']")
    private Input effectKw; // Effekt KW
    
    @FindBy(css = "[id$='TIA_IT11::content']")
    private Input effectHk; // Effekt HK
    
    @FindBy(css = "[id$='TIA_IT12::content']")
    private Input curbWeight; // Egenvekt
    
    @FindBy(css = "[id$='TIA_IT13::content']")
    private Input width; // Bredde
    
    @FindBy(css = "[id$='TIA_IT14::content']")
    private Input usedCarValue; // Bilens verdi
    
    @FindBy(css = "[id$='TIA_IT15::content']")
    private Input mileage;
    
	public ObjectPanelImpl(PageObject page, ElementLocator locator, long timeoutInMilliseconds) {
		super(page, locator, timeoutInMilliseconds);
	}



	@Override
	public void fillForm(FormData object) {
	    if (!(object instanceof InsuranceObject)) {
            throw TestException.get("Can't fill insurance object form using entity other than InsuranceObject");
        }
		expand();

		((InsuranceObject) object).getProperties().stream().forEach(p -> super.fillForm(p));
	}

    private void fillProperty(Property property) {
        String propertyName = getFieldValue(property, "name").toString();
        String propertyValue = getFieldValue(property, "value").toString();

        fillField(controls.init(getPage().getDriver()), propertyValue);
    }
	
    public String getStreet() {
        return street.getValue();
    }
    
    public String getNumber() {
        return number.getValue();
    }
    
    public String getLetter() {
        return letter.getValue();
    }
    
    public String getHouseNo() {
        return houseNo.getValue();
    }
    
    public String getPostCode() {
        return postCode.getValue();
    }
}
