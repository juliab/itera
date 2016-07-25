package no.itera.tia.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import no.itera.tia.TestCustomers;
import no.itera.tia.TestDocuments;
import no.itera.tia.TestPolicies;
import no.itera.tia.TestProducts;
import no.itera.tia.TestUsers;
import no.itera.tia.steps.PolicyCreationSteps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BoligCreatePolicy12InstallmentsTest {

	@Managed
    private WebDriver driver;
	
    @Steps
    PolicyCreationSteps steps;

    @Test
    @Screenshots(onlyOnFailures = true)
    public void test() {
    	// given
        steps.userSignsInToTiaSystem(TestUsers.OALEXAV);
        // and
        steps.whenHeUsesCustomer(TestCustomers.JULIA_SIROSHTAN);
        // when
        steps.userCreatesPolicyWith12InstallmentsForCustomer(TestPolicies.WITH_12_INSTALLMENTS, 
                TestProducts.HOUSE_2010);
        // then
        steps.documentShouldBePrintedForCustomer(TestDocuments.PREMIEVARSEL);
        // and
        steps.downloadDocument();
    }
}
