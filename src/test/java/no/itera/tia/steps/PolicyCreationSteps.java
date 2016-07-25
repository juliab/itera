package no.itera.tia.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import no.itera.tia.TestCustomers;
import no.itera.tia.TestDocuments;
import no.itera.tia.TestPolicies;
import no.itera.tia.TestProducts;
import no.itera.tia.TestUsers;
import no.itera.tia.beans.model.Document;
import no.itera.tia.beans.model.Party;
import no.itera.tia.beans.model.Policy;
import no.itera.tia.enumeration.Properties;
import no.itera.tia.enumeration.Language;
import no.itera.tia.enumeration.PolicyStatusCode;
import no.itera.tia.ui.controls.TableRow;
import no.itera.tia.ui.model.document.CasePage;
import no.itera.tia.ui.model.line.PolicyLinePage;
import no.itera.tia.ui.model.object.PolicyObjectPage;
import no.itera.tia.ui.model.party.PartyPage;
import no.itera.tia.ui.model.party.PartySearchPage;
import no.itera.tia.ui.model.policy.PolicyPage;
import no.itera.tia.ui.pages.*;
import no.itera.tia.utility.PdfReader;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class PolicyCreationSteps {

    private LoginPage loginPage;
    private HomePage homePage;
    private PartySearchPage searchPage;
    private PartyPage partyPage;
    private PolicyPage policyPage;
    private PolicyLinePage policyLinePage;
    private PolicyObjectPage policyObjectPage;
    private CasePage casePage;

    private Policy policy;
    private String pdfFileName;
    private Party customer;
    private Document document;

    @Step("User {0} signs in to TIA system")
    public void userSignsInToTiaSystem(TestUsers user) {
        loginPage.open();
        loginPage.login(user.get());
        homePage.switchLanguage(Language.NORWEGIAN);
    }

    @Step
    public void whenHeUsesCustomer(TestCustomers customer) {
        this.customer = customer.get();
        TableRow<Party> recentCustomer = homePage.recentCustomersSidePanel()
                .getTable()
                .findRowContaining(customer.get());
        if (recentCustomer != null) {
            recentCustomer.open();
            return;
        }
        homePage.userWorkflowsSidePanel().openSearch();
        searchPage.searchAndOpen(this.customer);
    }

    @Step("User creates policy {0} for customer with product: {1}")
    public void userCreatesPolicyWithPreviousInsuranceInfoForCustomer(TestPolicies policy, TestProducts product) {
        this.policy = policy.get();
        this.policy.getLine().setObject(product.getInsuranceObject());
        
        addsNewPolicyLine();
        fillsPreviousAndNextInsuranceInformation();
        completesPolicy();
        assertThatPolicyStatusIs(PolicyStatusCode.SUCCESS);
    }
    
    @Step("User creates policy {0} for customer with product: {1}")
    public void userCreatesPolicyWith12InstallmentsForCustomer(TestPolicies policy, TestProducts product) {
        this.policy = policy.get();
        this.policy.getLine().setObject(product.getInsuranceObject());
        
        addsNewPolicyLine();
        assertThatCustomerAddressWasPrepopulatedOnObjectForm();
        fillsInsuranceObjectData();
        completesPolicy();
        assertThatPolicyStatusIs(PolicyStatusCode.SUCCESS);
        assertThatCorrectPaymentFrequencyIsDisplayed();
    }

    @Step("Adds new policy line")
    public void addsNewPolicyLine() {
        partyPage.startPolicyCreation();
        policyPage.paymentInfoPanel().fillForm(this.policy.getPaymentInfo());
        policyPage.addNewLine(this.policy.getLine());
    }
    
    @Step
    public void fillsInsuranceObjectData() {
        policyObjectPage.fillData(this.policy.getLine().getObject());
    }
    
    @Step
    public void completesPolicy() {
        policyObjectPage.complete();
    }
    
    @Step
    public void assertThatCustomerAddressWasPrepopulatedOnObjectForm() {
        assertThat(policyObjectPage.objectPanel().getStreet()).isEqualTo(customer.getAddress().getStreet());
        assertThat(policyObjectPage.objectPanel().getNumber()).isEqualTo(customer.getAddress().getStreetNo());
        assertThat(policyObjectPage.objectPanel().getLetter()).isEqualTo(customer.getAddress().getStreetCode());
        assertThat(policyObjectPage.objectPanel().getHouseNo()).isEqualTo(customer.getAddress().getDoor());
        assertThat(policyObjectPage.objectPanel().getPostCode()).contains(customer.getAddress().getPostCode());
        Serenity.takeScreenshot();
    }

    @Step
    public void fillsPreviousAndNextInsuranceInformation() {
        policyObjectPage.policiesSidePanel().openLastPolicyLine();
        policyLinePage.previousAndNextInsurancePanel().fillForm(policy.getLine().getPastInsuranceInfo());
        Serenity.takeScreenshot();
    }

    @Step
    public void assertThatPolicyStatusIs(PolicyStatusCode statusCode) {
        partyPage.policiesSidePanel().openLastPolicy();
        assertThatPolicyStatusIs(statusCode.getPolicyStatus());
        assertThatPolicyTransactionTypeIs(statusCode.getPolicyTransactionType());
        
        policyPage.policiesSidePanel().openLastPolicyLine();
        assertThatPolicyLineStatusIs(statusCode.getPolicyLineStatus());
        assertThatTransactionCodeIs(statusCode.getTransactionCode(Language.ENGLISH), 
                statusCode.getTransactionCode());
    }
    
    @Step
    public void assertThatCorrectPaymentFrequencyIsDisplayed() {
        policyLinePage.policiesSidePanel().openLastPolicy();
        assertThat(policyPage.paymentInfoPanel().getPaymentFrequency())
            .isEqualTo(this.policy.getPaymentInfo().getFrequency());
    }
    
    @Step
    public void assertThatPolicyStatusIs(String status) {
        assertThat(policyPage.getStatus()).isEqualTo(status);
    }
    
    @Step
    public void assertThatPolicyTransactionTypeIs(String type) {
        assertThat(policyPage.getTransactionType()).isEqualTo(type);
        Serenity.takeScreenshot();
    }
    
    @Step
    public void assertThatPolicyLineStatusIs(String status) {
        assertThat(policyLinePage.getStatus()).isEqualTo(status);
    }
    
    @Step("Assert that transaction code is {0} or {1}")
    public void assertThatTransactionCodeIs(String codeEn, String codeNo) {
        assertThat(policyLinePage.getTransactionCode()).isIn(codeEn, codeNo);
        Serenity.takeScreenshot();
    }

    @Step("{0} document should be printed for customer")
    public void documentShouldBePrintedForCustomer(TestDocuments doc) {
        document = doc.get();
        
        wait3MinutesForDocument();
        assertThatDocumentIsPresent();
    }
    
    @Step
    public void wait3MinutesForDocument() {
        policyLinePage.relationsSidePanel().openRelation();
        partyPage.casePanel().waitForDocument(document);
    }
    
    @Step
    public void assertThatDocumentIsPresent() {
        assertTrue("No document " + document.getDescription() + " after 3 minutes of waiting",
                partyPage.casePanel().getTable().getRow(1).contains(document));
        Serenity.takeScreenshot();
    }

    @Step
    public void downloadDocument() {
        downloadFile();
        documentShouldHaveCorrectStructure();
    }

    @Step
    public void downloadFile() {
        partyPage.casePanel().openDocument(document);
        casePage.archiveDetailsPanel().downloadFile();
        pdfFileName = casePage.archiveDetailsPanel().getFileName();
    }
    
    @Step
    public void documentShouldHaveCorrectStructure() {
        String pdfContent = PdfReader.read(Properties.DOWNLOADS_PATH + pdfFileName);
        document.getText().stream().forEach(t -> assertThatPdfContainsText(pdfContent, t));
    }
    
    @Step("Assert that pdf contains text: {1}")
    public void assertThatPdfContainsText(String pdfContent, String text) {
        assertThat(pdfContent).contains(text);
    }
}
