package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPageFactory {
    private WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Forgot Username/Password?']")
    private WebElement headerPageText;

    @FindBy(id = "EmailInputEmail")
    private WebElement emailInput;

    @FindBy(id = "PasswordInputPassword")
    private WebElement passwordInput;

    @FindBy(id = "SignInButton")
    private WebElement signinBtn;

    @FindBy(id = "signInError")
    private WebElement errorMsgText;

    @FindBy(id = "Pin")
    private WebElement pinInput;
    @FindBy(id = "RequestPinForm_SubmitButton")
    private WebElement submitBtn;
    @FindBy(id = "RequestPinForm_Back")
    private WebElement backBtn;
    @FindBy(id = "RequestPinForm_ResetPin")
    private WebElement resetPintBtn;

    // Khởi tạo class khi được gọi và truyền driver vào để các thành phần trong
    // Và khởi tạo initElements
    public SignInPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Chúng ta viết hàm signin không cần dùng các hàm bổ trợ enter hay click nữa
    public void signin(String username, String password, String Pin) throws Exception {
        setText(emailInput, username);
        passwordInput.sendKeys(password);
        signinBtn.click();
        Thread.sleep(1000);
        pinInput.sendKeys(Pin);
        submitBtn.click();
    }

    public void setText(WebElement e, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.sendKeys(value);
    }

    public void clickElement(WebElement e) {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }
}
