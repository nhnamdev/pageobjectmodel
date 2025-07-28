package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseSetup {

    private WebDriver driver;

    static String driverPath = "resources\\drivers\\";

    public WebDriver getDriver() {
        return driver;
    }

    //Hàm này để tùy chọn Browser. Cho chạy trước khi gọi class này (BeforeClass)
    private void setDriver(String browserType, String appURL) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver(appURL);
        }
    }

    //Khởi tạo cấu hình của các Browser để đưa vào Switch Case
    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching Chrome browser...");
        //Cho nay dang fix cung vi loi
        System.setProperty("webdriver.chrome.driver", "D:\\ytb\\Tester\\PageObjectModel_POM\\src\\main\\resources\\drivers\\" + "chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        System.out.println(">> WebDriver created: " + driver); // Kiểm tra driver có null không

        driver.manage().window().maximize();
        driver.navigate().to(appURL);

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    // Chạy hàm initializeTestBaseSetup trước hết khi class này được gọi
    @Parameters({"browserType", "appURL"})
    @BeforeClass
    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            // Khởi tạo driver và browser
            setDriver(browserType, appURL);
        } catch (Exception e) {
            System.out.println("Error..." + e.getStackTrace());
            System.out.println("Error..." + e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }


}

