package testcases;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.SignInPageFactory;

public class SignInTest extends BaseSetup {

    private WebDriver driver;
    public SignInPageFactory signInPage;
    public DashboardPage dashboardPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void signIn() throws Exception {
        System.out.println(driver);
        signInPage = new SignInPageFactory(driver);

//        Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
//        Assert.assertTrue(signInPage.verifySignInPageText(), "Header page text not matching");
        dashboardPage = signInPage.signin("thaian@mailinator.com", "Demo@123", "123456");


    }

    @Test(priority = 2)
    public void openDashboard() throws Exception {

        Assert.assertTrue(dashboardPage.verifyDashboardTitle());
    }
}
