package BMI_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By loginButton = By.xpath("//*[@id=\"dang-nhap\"]");
    By usernameField = By.xpath("//*[@id=\"phone-input\"]");
    By passwordField = By.xpath("//*[@id=\"password-input\"]");
    By loginInPopupButton = By.xpath("//*[@id=\"login-modal___BV_modal_body_\"]/div/form/button");
    By dangxemBlock = By.xpath("//*[@id=\"horizontal-slider\"]/div[1]/h2");
    By continueLoginWithOTP = By.xpath("//button[@class='btn notice-btn btn-none btn-block']");
    By otpLocator1 = By.xpath("//*[@id=\"otp-input-focus\"]");
    By otpLocator2 = By.xpath("//*[@id=\"__BVID__1084\"]");
    By otpLocator3 = By.xpath("//*[@id=\"__BVID__1086\"]");
    By otpLocator4 = By.xpath("//*[@id=\"__BVID__1082\"]");
    By confirmLoginButton = By.xpath("//*[@id=\"verify-modal___BV_modal_footer_\"]/div/button");
    By continueLoginInNewDevice  = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[2]");
    By accountButton = By.xpath("//div[@class='profilesdropdown__toggler']");
    By cancelLoginInNewDevice = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[1]");
    By taikhoanvacaidatBtn = By.xpath("//img[@alt='Tài khoản và cài đặt']");
    By dangxuattaikhoanBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[9]/a");
    By dongyLogoutBtn = By.xpath("//button[@class='btn mx-1 px-5 button-active btn-none btn-block']");
    By thoatLogoutBtn = By.xpath("//button[@class='btn mx-1 px-5 button-disable btn-none btn-block]");
    By boQuaAdsBtn = By.xpath("//*[@id=\"adsplay-banner-11320103-11320203\"]");

    public void openBrowser(){
        driver.manage().window().maximize();
        driver.get("https://fptplay.vn/");
    }
//    public void clickBoQuaAds(){
//        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));
//        driver.findElement(By.xpath("//*[@id=\"adsplay-banner-11320103-11320203\"]")).click();
//    }

    public void clickDangnhapBtn(){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginElement.click();
    }

    public void fillAccountUser(String username, String password) throws InterruptedException {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);


    }
    public void clickDangnhapBtnInPopup() throws InterruptedException {
        driver.findElement(loginInPopupButton).click();
        Thread.sleep(500);
    }

    public void login(){
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement continueLoginWithOTPElement = wait.until(ExpectedConditions.visibilityOfElementLocated(continueLoginWithOTP));
        continueLoginWithOTPElement.click();
        WebElement otpField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator1));
        otpField1.sendKeys("9");
        WebElement otpField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator2));
        otpField2.sendKeys("9");
        WebElement otpField3 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator3));
        otpField3.sendKeys("9");
        WebElement otpField4 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator4));
        otpField4.sendKeys("9");
        driver.findElement(confirmLoginButton).click();
    }


//    public void login(){
//        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
//        boolean continueBtnisDisplayed = driver.findElement(continueLoginInNewDevice).isDisplayed();
//        if(continueBtnisDisplayed == FALSE){
//        WebElement continueLoginWithOTPElement = wait.until(ExpectedConditions.visibilityOfElementLocated(continueLoginWithOTP));
//        continueLoginWithOTPElement.click();
//            //driver.findElement(continueLoginWithOTP).click();
//            WebElement otpField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator1));
//            otpField1.sendKeys("9");
//            WebElement otpField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator2));
//            otpField2.sendKeys("9");
//            WebElement otpField3 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator3));
//            otpField3.sendKeys("9");
//            WebElement otpField4 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator4));
//            otpField4.sendKeys("9");
//            driver.findElement(confirmLoginButton).click();
//        } else {
//            driver.findElement(continueLoginInNewDevice).click();
//        }
//
//    }

    public void clickAccountBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        accountElement.click();
    }

    public void clickTaikhoanvaCaidatBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement taikhoanvaCatdatElement = wait.until(ExpectedConditions.visibilityOfElementLocated(taikhoanvacaidatBtn));
        taikhoanvaCatdatElement.click();
    }
    public String getResultLogin(){
        return driver.findElement(dangxemBlock).getText();
    }

    public void logout() throws InterruptedException {
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        accountElement.click();
        Thread.sleep(500);
        WebElement taikhoanvaCatdatElement = wait.until(ExpectedConditions.visibilityOfElementLocated(taikhoanvacaidatBtn));
        taikhoanvaCatdatElement.click();
        Thread.sleep(1000);
        WebElement dangxuattaikhoanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dangxuattaikhoanBtn));
        dangxuattaikhoanElement.click();
        Thread.sleep(500);
        WebElement dongyLogoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dongyLogoutBtn));
        dongyLogoutElement.click();
    }

    public String getResultLogout(){
        return driver.findElement(loginButton).getText();
    }



}
