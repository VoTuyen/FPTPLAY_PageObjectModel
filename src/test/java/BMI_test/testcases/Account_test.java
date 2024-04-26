package BMI_test.testcases;

import BMI_test.pages.AccountPage;
import BMI_test.pages.HomePage;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.swing.plaf.TableHeaderUI;

public class Account_test {
    WebDriver driver;

    HomePage homePage;
    AccountPage accountPage;
    @DataProvider
        // là feature của testNG
    Object[][] testData(){
        return new Object[][]{
                {"0974303989","123456"}
        };
    }

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) throws InterruptedException {
        switch (browser) {
            case "chrome": {
                ChromeOptions chromeDriver = new ChromeOptions();
                chromeDriver.addArguments("--remote-allow-origins=+");
                driver = new ChromeDriver(chromeDriver);
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "edge": {
                driver = new EdgeDriver();
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                break;
            }
        }
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        homePage.openBrowser();
        Thread.sleep(2000);
        homePage.clickDangnhapBtn();
        homePage.fillAccountUser("0974303989","123321");
        homePage.clickDangnhapBtnInPopup();
        homePage.loginwithOTP();
        homePage.clickAccountBtn();
        Thread.sleep(1000);
        homePage.clickTaikhoanvaCaidatBtn();

    }

    @Test(dataProvider = "testData")
    void verifyRedirectToThongTinCaNhanSuccess(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        String actualResult = accountPage.getTitleText();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,"Tài khoản và dịch vụ");
    }

    @Test(priority = 1)
    void verifyUpdateUsernameSuccess() throws InterruptedException {
        accountPage.clickThongTinCaNhanBtn();
        String tenHienThi = accountPage.getTenHienThiBeforeUpdate();
        accountPage.clickThayDoiHoSoBtn();
        accountPage.fillTenHienThi("t");
        Thread.sleep(2000);
        accountPage.clickCapNhatHoSoBtn();
        Thread.sleep(2000);
        accountPage.clickQuayLaiBtn();
        Thread.sleep(2000);
        String actual_tenHienThi = accountPage.getTenHienThiAfterUpdate();
        System.out.println(actual_tenHienThi);
        Assert.assertEquals(actual_tenHienThi, tenHienThi+"t");
    }

    @Test(priority = 2)
    void verifyCannotUpdateHoSoWithEmtyUsername() throws InterruptedException {
        accountPage.clickThayDoiHoSoBtn();
        Thread.sleep(5000);
        accountPage.clearFieldUsername();
        accountPage.fillTenHienThi(" ");
        Thread.sleep(2000);
        accountPage.clickCapNhatHoSoBtn();
        String actual_messageWhenUpdateWithEmtyUsername = "Tên hiển thị bao gồm từ 6-20 ký tự, không được chứa ký tự đặc biệt.";
        Assert.assertEquals(accountPage.getMessageWhenUpdateWithEmtyUsername(),actual_messageWhenUpdateWithEmtyUsername);
        accountPage.clickDongYBtn();
    }

    @Test(priority = 3)
    void verifyCannotUpdateHoSoWithUsernameLessThan6Letter() throws InterruptedException {
        Thread.sleep(2000);
        accountPage.clickThayDoiHoSoBtn();
        accountPage.clearFieldUsername();
        accountPage.fillTenHienThi("12345");
        accountPage.clickCapNhatHoSoBtn();
        String actual_messageWhenUpdateWithEmtyUsername = "Tên hiển thị bao gồm từ 6-20 ký tự, không được chứa ký tự đặc biệt.";
        Assert.assertEquals(accountPage.getMessageWhenUpdateWithEmtyUsername(),actual_messageWhenUpdateWithEmtyUsername);
        accountPage.clickDongYBtn();
    }

//    @Test(priority = 4)
//    void verifyCannotUpdateHoSoWith
}
