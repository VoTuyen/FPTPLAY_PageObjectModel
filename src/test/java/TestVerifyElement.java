import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestVerifyElement {
    //By skipWelcomeScreenButton = By.xpath("//*[@id=\"adsplay-container\"]/div[2]/div/div");
    //By skipWelcomeScreenButton = By.xpath("//button[contains(text(), 'Bo qua')]");
    By loginButton = By.xpath("//*[@id=\"dang-nhap\"]");
    By banner = By.xpath("//*[@id=\"adsplay-container\"]/div[2]/img");
    By usernameField = By.xpath("//*[@id=\"phone-input\"]");
    By passwordField = By.xpath("//*[@id=\"password-input\"]");
    By loginInPopupButton = By.xpath("//*[@id=\"login-modal___BV_modal_body_\"]/div/form/button");
    By imageProfile = By.xpath("//*[@id=\"loading-page-fptplay\"]");
    //By imageProfile = By.xpath("//*[@id=\"multi-profiles-1710844015606__BV_toggle_\"]/div/div/img");
    By skipWelcomeScreenButton = By.xpath("//*[@id=\"adsplay-container\"]/div[2]/div/div");
    By accountButton = By.xpath("//div[@class='profilesdropdown__toggler']");
    By accountSettingButton = By.xpath("//*[@id=\"multi-profiles-1711012324375\"]/ul/div/div/a[2]/span");
    By logoutButton = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[9]/a");
    By continueLogin = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[2]");
    By OTPField = By.xpath("//*[@id=\"verify-modal___BV_modal_body_\"]/div/div[2]/div");
    By confirmOTPButton = By.xpath("//*[@id=\"verify-modal___BV_modal_footer_\"]/div/button");
    By continueLoginInNewDevice  = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[2]");
    By cancelLoginInNewDevice = By.xpath("//*[@id=\"notice-modal___BV_modal_body_\"]/div/div/button[1]");
    By taikhoanvacaidatBtn = By.xpath("//img[@alt='Tài khoản và cài đặt']");
    By titleBtn = By.xpath("//h4[@class='side-bar__title']");
    By continueLoginWithOTP = By.xpath("//button[@class='btn notice-btn btn-none btn-block']");
    By hoSoBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[2]/a");
    By thongTinCaNhan_HoSo_ThayDoiBtn = By.xpath("//*[@id=\"personal-area\"]/div[1]/div[1]/div/div/div[2]");
    By tenHienThiField = By.id("fullname");
    By thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn = By.xpath("//*[@id=\"__BVID__1288___BV_modal_footer_\"]");
    By thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn = By.xpath("//*[@id=\"result-modal___BV_modal_body_\"]/div/button");
    By thongTinCaNhan_HoSo_TenHienThiText = By.xpath("//*[@id=\"personal-area\"]/div[1]/div[1]/div/div/div[1]/p");
    By thongTinCaNhanBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[1]/a/span");


    public static WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String username = "web-v2";
        String password = "fptplay@2022";
        String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        String url = "https://" + encodedCredentials + "@fptplay.vn/";

        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(loginButton).click();

//        driver.switchTo().frame("iframe-11320103-11320203");
//        WebElement boQuaElement = driver.findElement(By.xpath("//*[@id=\"adsplay-container\"]/div[2]/div/div"));
//        boQuaElement.click();

        driver.findElement(usernameField).sendKeys("0974303989");
        driver.findElement(passwordField).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(loginInPopupButton).click();
        Thread.sleep(1000);

        // login with OTP
//        WebElement continueLoginWithOTPElement = wait.until(ExpectedConditions.visibilityOfElementLocated(continueLoginWithOTP));
//        continueLoginWithOTPElement.click();
//        driver.findElement(By.xpath("//*[@id=\"otp-input-focus\"]")).sendKeys("9");
//        driver.findElement(By.xpath("//*[@id=\"__BVID__1083\"]")).sendKeys("9");
//        driver.findElement(By.xpath("//*[@id=\"__BVID__1085\"]")).sendKeys("9");
//        driver.findElement(By.xpath("//*[@id=\"__BVID__1087\"]")).sendKeys("9");
//        driver.findElement(confirmOTPButton).click();

        //Login in new device
        driver.findElement(continueLoginInNewDevice).click();

//        driver.findElement(continueLoginInNewDevice).click();
//        Thread.sleep(1000);

//        driver.findElement(By.xpath("//*[@id=\"header\"]/div/nav[2]/div/div[4]/ul/li[3]")).click();
//        Thread.sleep(1000);

        WebElement accountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        accountElement.click();
        WebElement taikhoanvaCatdatElement = wait.until(ExpectedConditions.visibilityOfElementLocated(taikhoanvacaidatBtn));
        taikhoanvaCatdatElement.click();
        driver.findElement(thongTinCaNhanBtn).click();
        driver.findElement(thongTinCaNhan_HoSo_ThayDoiBtn).click();
        driver.findElement(tenHienThiField).clear();
        driver.findElement(tenHienThiField).sendKeys("Thay đổi 111");
        driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn).click();
        driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn).click();
        String text = driver.findElement(thongTinCaNhan_HoSo_TenHienThiText).getText();
        System.out.println(text);

    }
}
