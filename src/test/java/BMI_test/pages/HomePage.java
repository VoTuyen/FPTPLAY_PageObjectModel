package BMI_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginButton = By.xpath("//*[@id=\"dang-nhap\"]");
    By usernameField = By.xpath("//*[@id=\"phone-input\"]");
    By passwordField = By.xpath("//*[@id=\"password-input\"]");
    By loginInPopupButton = By.xpath("//*[@id=\"login-modal___BV_modal_body_\"]/div/form/button");
    By imageProfile = By.xpath("//*[@id=\"loading-page-fptplay\"]");
    //By imageProfile = By.xpath("//*[@id=\"multi-profiles-1710844015606__BV_toggle_\"]/div/div/img");
    By skipWelcomeScreenButton = By.xpath("//*[@id=\"adsplay-container\"]/div[2]/div/div");
    By accountButton = By.xpath("//*[@id=\"header\"]/div/nav[2]/div/div[4]/ul/li[3]");
    By dangxemBlock = By.xpath("//*[@id=\"horizontal-slider\"]/div[1]/h2");
    By continueLoginBtn = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/button");
    By confirmLoginButton = By.xpath("//*[@id=\"verify-modal___BV_modal_footer_\"]/div/button");
    By logoutButton = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[9]/a");

    By continueLoginInNewDevice  = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[2]");
    By cancelLoginInNewDevice = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[1]");



    By accountButtonAfterLogin = By.xpath("//*[@id=\"multi-profiles-1711534893085__BV_toggle_\"]/div/img");

    public void openBrowser(){
        driver.manage().window().maximize();
        driver.get("https://fptplay.vn/");
    }

//    public void clickSkipWelcomeScreen(){
//        driver.findElement(skipWelcomeScreenButton).click();
//    }
    public void clickDangnhapBtn(){
        driver.findElement(loginButton).click();
    }

    public void fillAccountUser(String username, String password) throws InterruptedException {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);


    }
    public void clickDangnhapBtnInPopup() throws InterruptedException {
        driver.findElement(loginInPopupButton).click();
        Thread.sleep(500);
    }
    public void clickTieptucDnBtn() throws InterruptedException {
        driver.findElement(continueLoginBtn).click();
        Thread.sleep(500);
    }

    public void fillOTP(){
        driver.findElement(By.xpath("//*[@id=\"otp-input-focus\"]")).sendKeys("9");
        driver.findElement(By.xpath("//*[@id=\"__BVID__1083\"]")).sendKeys("9");
        driver.findElement(By.xpath("//*[@id=\"__BVID__1085\"]")).sendKeys("9");
        driver.findElement(By.xpath("//*[@id=\"__BVID__1087\"]")).sendKeys("9");
    }

    public void clickConfirmLogin() throws InterruptedException {
        driver.findElement(confirmLoginButton).click();
        Thread.sleep(2000);
    }

    public void clickContinueDnInNewBrowser() throws InterruptedException {
        driver.findElement(continueLoginInNewDevice).click();
        Thread.sleep(1000);
    }

    public void clickAccountBtn() throws InterruptedException {
        driver.findElement(accountButton).click();
        Thread.sleep(1000);

    }
    public String getResult(){
        return driver.findElement(dangxemBlock).getText();
    }

    public void logout(String username, String password) throws InterruptedException {

        driver.findElement(accountButton).click();
       // driver.findElement(accountSettingButton).click();
        driver.findElement(logoutButton).click();

    }


}
