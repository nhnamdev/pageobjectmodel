package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidateHelper {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }

    public void setText(By e, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        driver.findElement(e).clear();
        driver.findElement(e).sendKeys(text);
    }

    void clickElement(By e) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        driver.findElement(e).click();

    }

    void seclectOptionByText(By e, String text) {
        WebElement element = driver.findElement(e);
        Select select = new Select(element);
        select.selectByVisibleText(text);

    }

    void seclectOptionByValue(By e, String value) {
        WebElement element = driver.findElement(e);
        Select select = new Select(element);
        select.selectByVisibleText(value);

    }

    public void waitForPageLoaded(WebDriver driver) {

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.assertFalse(true, "Timeout waiting for Page Load Request to complete.");
        }
    }

}
