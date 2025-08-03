package testcases;

import base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInTest extends BaseSetup {

    private WebDriver driver;
    public SignInPage signInPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Test(priority = 1)
    public void signIn() throws Exception {
        System.out.println(driver);
        signInPage = new SignInPage(driver);

        Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
        Assert.assertTrue(signInPage.verifySignInPageText(), "Header page text not matching");

        signInPage.signin("thaian@mailinator.com", "Demo@123", "123456");

    }

}
