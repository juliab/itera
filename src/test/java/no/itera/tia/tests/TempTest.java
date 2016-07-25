package no.itera.tia.tests;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import no.itera.tia.TestCustomers;
import no.itera.tia.TestUsers;
import no.itera.tia.beans.model.Document;
import no.itera.tia.steps.PolicyCreationSteps;
import no.itera.tia.ui.model.party.PartyPage;

@RunWith(SerenityRunner.class)
public class TempTest {
    
    PartyPage partyPage;

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
        
        Document document = new Document.Builder().description("Tilmelding til AvtaleGiro").build();
        
        System.out.println(partyPage.casePanel().getTable().contains(document));
        System.out.println();
    }
}
