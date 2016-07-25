package no.itera.tia.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import no.itera.tia.TestCustomers;
import no.itera.tia.TestPolicies;
import no.itera.tia.TestProducts;
import no.itera.tia.TestUsers;
import no.itera.tia.steps.PolicyCreationSteps;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class PolicyCreationTest {

	@Managed
    private WebDriver driver;
	
    @Steps
    PolicyCreationSteps steps;

    @Test
    @Ignore
    @Screenshots(onlyOnFailures = true)
    public void shouldBeAbleToCreateHousePolicy() {
    	// given
        steps.userSignsInToTiaSystem(TestUsers.OALEXAV);
        // and
        steps.whenHeUsesCustomer(TestCustomers.MONA_STENSVOLD);
        // when
        steps.userCreatesPolicyWithPreviousInsuranceInfoForCustomer(TestPolicies.WITH_PREVIOUS_INSURANCE_INFO, 
                TestProducts.HOUSE_2006);
        // then
        String documentName = "Ophør print";
//        steps.documentShouldBePrintedForCustomer(documentName);
//        // and
//        steps.downloadDocument(documentName);
    }
    
    @Test
    @Ignore
    @Screenshots(onlyOnFailures = true)
    public void shouldBeAbleToCreateHousePolicyWith12Installments() {
        // given
        steps.userSignsInToTiaSystem(TestUsers.OALEXAV);
        // and
        steps.whenHeUsesCustomer(TestCustomers.MONA_STENSVOLD);
        // when
        steps.userCreatesPolicyWith12InstallmentsForCustomer(TestPolicies.WITH_12_INSTALLMENTS, 
                TestProducts.HOUSE_2010);
        // then
        String documentName = "Premievarsel";
//        steps.documentShouldBePrintedForCustomer(documentName);
        
//        // and
//        steps.downloadDocument(documentName);
    }
}
