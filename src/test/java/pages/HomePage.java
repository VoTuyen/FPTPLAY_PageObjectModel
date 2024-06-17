package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage() {
        this.driver = Browser.getDriver();
    }

    By loginButton = By.xpath("//*[@id=\"dang-nhap\"]");
    By usernameField = By.xpath("//*[@id=\"phone-input\"]");
    By passwordField = By.xpath("//*[@id=\"password-input\"]");
    By loginInPopupButton = By.xpath("//*[@id=\"login-modal___BV_modal_body_\"]/div/form/button");
    By dangxemBlock = By.xpath("//*[@id=\"horizontal-slider\"]/div[1]/h2");
    By continueLoginWithOTP = By.xpath("//button[@class='btn notice-btn btn-none btn-block'] |  //*[@id=\"notice-modal___BV_modal_body_\"]/div/button | //*[@id=\"notice-modal___BV_modal_body_\"]/div/button");
    By otpLocator1 = By.xpath("//*[@id=\"otp-input-focus\"]");
    By otpLocator2 = By.xpath("//*[@id=\"__BVID__1003\"] | //*[@id=\"__BVID__1020\"] | //*[@id=\"__BVID__1011\"] | //*[@id=\"__BVID__1027\"] | //*[@id=\"__BVID__1008\"] | //*[@id=\"__BVID__1026\"] | //*[@id=\"__BVID__1088\"] | //*[@id=\"__BVID__1087\"] | //*[@id=\"__BVID__590\"]");
    By otpLocator3 = By.xpath("//*[@id=\"__BVID__1005\"] | //*[@id=\"__BVID__1022\"] | //*[@id=\"__BVID__1013\"] | //*[@id=\"__BVID__1029\"] | //*[@id=\"__BVID__1010\"] | //*[@id=\"__BVID__1028\"] | //*[@id=\"__BVID__1090\"] | //*[@id=\"__BVID__1089\"] | //*[@id=\"__BVID__592\"]");
    By otpLocator4 = By.xpath("//*[@id=\"__BVID__1007\"] | //*[@id=\"__BVID__1024\"] | //*[@id=\"__BVID__1015\"] | //*[@id=\"__BVID__1031\"] | //*[@id=\"__BVID__1012\"] | //*[@id=\"__BVID__1030\"] | //*[@id=\"__BVID__1092\"] | //*[@id=\"__BVID__1091\"] | //*[@id=\"__BVID__594\"]");
    By confirmLoginButton = By.xpath("//*[@id=\"verify-modal___BV_modal_footer_\"]/div/button");
    By continueLoginInNewDevice  = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[2]");
    By accountButton = By.xpath("//div[@class='profilesdropdown__toggler']");
    By cancelLoginInNewDevice = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[1]");
    By taikhoanvacaidatBtn = By.xpath("//img[@alt='Tài khoản và cài đặt'] | //*[@id=\"multi-profiles-1718536390695\"]/ul/div/div/a[2]");
    //
    By dangxuattaikhoanBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[9]/a");
    By dongyLogoutBtn = By.xpath("//button[@class='btn mx-1 px-5 button-active btn-none btn-block']");
    By thoatLogoutBtn = By.xpath("//button[@class='btn mx-1 px-5 button-disable btn-none btn-block]");
    By boQuaAdsBtn = By.xpath("//*[@id=\"adsplay-banner-11320103-11320203\"]");
    By waitBtn = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/button");
    By homeBtnInLandingPage = By.xpath("//*[@id=\"button1\"]");

    //id="iframe-11320103-11320203" -> id iframe wellcome screen Bỏ qua

    public void openBrowser(){
        driver.manage().window().maximize();
        driver.get("https://fptplay.vn/");
    }
//    public void clickBoQuaAds(){
//        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[2]")));
//        driver.findElement(By.xpath("//*[@id=\"adsplay-banner-11320103-11320203\"]")).click();
//    }

    public void clickBoQuaWelcome(){
        driver.switchTo().frame("iframe-11320103-11320203");
        WebElement boQuaElement = driver.findElement(By.xpath("//*[@id=\"adsplay-container\"]/div[2]/div/div"));
        boQuaElement.click();
    }

    public void clickHomeBtnInLandingPage(){
        driver.findElement(homeBtnInLandingPage).click();
    }

    public void clickDangnhapBtn() throws InterruptedException {
        Thread.sleep(2000);
            driver.findElement(loginButton).click();
    }

    public void fillAccountUser(String username, String password) throws InterruptedException {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickDangnhapBtnInPopup() throws InterruptedException {
        driver.findElement(loginInPopupButton).click();
    }

    //hàm bắt trạng thái NosuchElement khi không tìm được element
    public void redirectToOTPField(){
        try {
            if (driver.findElement(waitBtn).isDisplayed()) {
                driver.findElement(waitBtn).click();
            }
        }catch (NoSuchElementException e){

        }
        WebElement test = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(continueLoginWithOTP));
            //driver.findElement(loginInPopupButton).click();
            //driver.findElement(continueLoginWithOTP).click();
        test.click();
    }

//    public void clickThulaiLogin(){
//        Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(waitBtn)).click();
//    }

    public void fillOTP() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));
        WebElement otpField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator1));
        otpField1.sendKeys("9");
        WebElement otpField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator2));
        otpField2.sendKeys("9");
        WebElement otpField3 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator3));
        otpField3.sendKeys("9");
        WebElement otpField4 = wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator4));
        otpField4.sendKeys("9");
//        WebElement otpField1 = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator1));
//        otpField1.sendKeys("9");
//        WebElement otpField2 = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator2));
//        otpField2.sendKeys("9");
//        WebElement otpField3 = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator3));
//        otpField3.sendKeys("9");
//        WebElement otpField4 = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(otpLocator4));
//        otpField4.sendKeys("9");
//        Thread.sleep(2000);
//        driver.findElement(otpLocator1).sendKeys("9");
//        driver.findElement(otpLocator2).sendKeys("9");
//        driver.findElement(otpLocator3).sendKeys("9");
//        driver.findElement(otpLocator4).sendKeys("9");
        driver.findElement(confirmLoginButton).click();
    }


    public void login(){
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
        driver.findElement(continueLoginInNewDevice).click();
        //}
    }

    public void clickAccountBtn(){
        WebElement accountElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        accountElement.click();
    }

    public void clickTaikhoanvaCaidatBtn(){
        WebElement taikhoanvaCatdatElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(taikhoanvacaidatBtn));
        taikhoanvaCatdatElement.click();
    }
    public String getResultLogin(){
        return Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(dangxemBlock)).getText();
        //driver.findElement(dangxemBlock).getText();
    }

    public void logout() throws InterruptedException {
//        WebElement accountElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
//        accountElement.click();
//        WebElement taikhoanvaCatdatElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(taikhoanvacaidatBtn));
//        taikhoanvaCatdatElement.click();
        WebElement dangxuattaikhoanElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(dangxuattaikhoanBtn));
        dangxuattaikhoanElement.click();
        WebElement dongyLogoutElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(dongyLogoutBtn));
        dongyLogoutElement.click();
    }

    public String getResultLogout(){
        return Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).getText();
                //driver.findElement(loginButton).getText();
    }
}
