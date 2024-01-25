package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
    private WebDriver driver;

    private By signinBtn = By.xpath("//*[@id=\"dang-nhap\"]");
    private By number_phoneInput = By.xpath("//*[@id=\"phone-input\"]");
    private By passwordInput = By.xpath("//*[@id=\"password-input\"]");
    private By submitSigninBtn = By.xpath("//*[@id=\"login-modal___BV_modal_body_\"]/div/form/button");

    // Khởi tạo class khi được gọi và truyền driver vào để các thành phần trong
    // class này đọc
    public SignIn(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn(String numberphone, String password) throws Exception {
        enterNumber_phone(numberphone);
        enterPassword(password);
        clickSubmitSignIn();
    }

    public void clickSignIn() {
        WebElement signin = driver.findElement(signinBtn);
        if (signin.isDisplayed()) {
            signin.click();
        }
    }
    public void enterNumber_phone(String number_phone) {
        WebElement number_phoneTxtBox = driver.findElement(number_phoneInput);
        if (number_phoneTxtBox.isDisplayed())
            number_phoneTxtBox.sendKeys(number_phone);
    }
    public void enterPassword(String password) {
        WebElement passwordTxtBox = driver.findElement(passwordInput);
        if (passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys(password);
    }
    public void clickSubmitSignIn() {
        WebElement submitsignin = driver.findElement(submitSigninBtn);
        if (submitsignin.isDisplayed()) {
            submitsignin.click();
        }
    }



}
