package BMI_test.testcases;

import BMI_test.pages.AccountPage;
import BMI_test.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Account_test {
    WebDriver driver;

    HomePage homePage;
    AccountPage accountPage;
    @DataProvider
        // là feature của testNG
    Object[][] testData(){
        return new Object[][]{
                {"0974303989","123456","Đang xem"}
        };
    }

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser){
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
        homePage.openBrowser();
        homePage.clickDangnhapBtn();
        homePage.login();
        homePage.clickAccountBtn();
        homePage.clickTaikhoanvaCaidatBtn();
    }



    @Test(dataProvider = "testData")
    void verifyRedirectToThongTinCaNhanSuccess(){
        String actualResult = accountPage.getTitleText();
        Assert.assertEquals(actualResult,"Thông tin cá nhân");
    }



}
