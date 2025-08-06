package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {

    private WebDriver driver;

    public String expectedTitle = "Dashboard";
    @FindBy(xpath = "//a[normalize-space()='Forgot Username/Password?']")
    public String expectedPageText = "My Profile";

    private By DocumentModule = By.xpath("//p[normalize-space()='Document Management']");
    private By MyProfileModule = By.xpath("//p[normalize-space()='My Profile']");
    private By TrainingModule = By.xpath("//p[normalize-space()='Training Management']");

    private By headerPageText = By.xpath("//p[normalize-space()='My Profile']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openDocumentManagement() {
        driver.findElement(DocumentModule).click();
        //Đợi cho đến khi trang load xong với hàm bên dưới
        waitForPageLoaded();
    }

    public boolean verifyDashboardTitle() {
        return driver.getTitle().equals(expectedTitle);
    }

    //Hàm đợi trang load xong rồi thao tác
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}