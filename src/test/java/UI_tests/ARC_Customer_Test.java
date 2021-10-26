package UI_tests;

import BaseTest.BaseTest_UI; // carga la clase base de métodos comunes de UI
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ARC.ARC_DashboardPage;
import pages.ARC.ARC_LoginPage;
import pages.ARC.ARC_VerifyIdentityPage;

public class ARC_Customer_Test extends BaseTest_UI {

    @Test (description = "Let's verify if Supplier Login is working properly")
    public void supplierLoginOK() {
        ARC_LoginPage objLoginPage = new ARC_LoginPage(driver, testsConfig.getARC_Supplier_url("dev9"));
        objLoginPage.login(supplierUsername, supplierPassword);

        ARC_DashboardPage dashPage = new ARC_DashboardPage(driver);
        ARC_VerifyIdentityPage verifyIdentityPage = new ARC_VerifyIdentityPage(driver);

        if (verifyIdentityPage.getChallengeForm().isDisplayed()) {
            verifyIdentityPage.answerChallenge("answer");
        }

        Assert.assertTrue( dashPage.getDashboardMenuOption().isDisplayed());
    }

    @Test (description = "Let's validate all navigation options", dependsOnMethods = {"supplierLoginOK"})
    public void navigationTest() {
        ARC_DashboardPage dashboardPage = new ARC_DashboardPage(driver);
        Assert.assertTrue(dashboardPage.goToCustomers().getCustomerTable().isDisplayed());
        Assert.assertTrue(dashboardPage.goToInvoices().getInvoicesTable().isDisplayed());
        Assert.assertTrue(dashboardPage.goToPayments().getPaymentsTable().isDisplayed());
        Assert.assertTrue(dashboardPage.goToActivities().getEventsTable().isDisplayed());
        Assert.assertTrue(dashboardPage.goToDocuments().getDocumentsTable().isDisplayed());
        Assert.assertTrue(dashboardPage.goToDashboard().getReceivablesDashboard().isDisplayed());
    }


}
