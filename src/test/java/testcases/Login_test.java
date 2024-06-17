package testcases;

import common.Browser;
import org.testng.ITestResult;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login_test {

    HomePage homePage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser){
        Browser.open(browser);
        homePage = new HomePage();
        homePage.openBrowser();
    }

    @DataProvider
        // là feature của testNG
    Object[][] testData(){
        return new Object[][]{
                {"0974303989","123321"}
        };
    }

    @Test(dataProvider = "testData")
    void verifyLoginSuccess(String username, String password) throws InterruptedException {
        Thread.sleep(6000);
        //homePage.clickHomeBtnInLandingPage();
        homePage.clickDangnhapBtn();
        homePage.fillAccountUser(username,password);
        homePage.clickDangnhapBtnInPopup();
        homePage.redirectToOTPField();
        homePage.fillOTP();
        Thread.sleep(20000);
        String actualResult = homePage.getResultLogin();
        Assert.assertEquals(actualResult,"Đang xem");
    }
    @Test
    void verifyLogoutSuccess() throws InterruptedException {
        homePage.clickAccountBtn();
        Thread.sleep(10000);
        homePage.clickTaikhoanvaCaidatBtn();
        homePage.logout();
        Thread.sleep(1000);
        String actualLogoutResult = homePage.getResultLogout();
        Assert.assertEquals(actualLogoutResult,"Đăng nhập");
    }

    //chup hinh result
    @AfterMethod
    void captureScreenWhenFail(ITestResult result){
        if(!result.isSuccess()){
            Browser.captureScreen(result.getName());
        }
    }

    @AfterClass
    void closeBrowser(){
        Browser.close();
    }
}

