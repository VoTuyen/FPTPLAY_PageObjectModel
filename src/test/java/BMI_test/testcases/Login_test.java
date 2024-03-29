package BMI_test.testcases;

import BMI_test.pages.CalculatorPage;
import BMI_test.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login_test {
    WebDriver driver;

    HomePage homePage;

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
        }

    @DataProvider
        // là feature của testNG
    Object[][] testData(){
        return new Object[][]{
                {"0974303989","123456","Đang xem"}
        };
    }
    @Test(dataProvider = "testData")
    void verifyLoginSuccess(String username, String password, String expectedResult) throws InterruptedException {
        homePage.clickDangnhapBtn();
        homePage.fillAccountUser(username,password);
        homePage.clickDangnhapBtnInPopup();
        //homePage.clickTieptucDnBtn();
        //homePage.fillOTP();
        //homePage.clickConfirmLogin();
        homePage.clickContinueDnInNewBrowser();
        homePage.clickAccountBtn();
        String actualResult = homePage.getResult();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,expectedResult);
    }

//    @Test(dataProvider = "testData")
//    void validateResultLogoutSuccess(String username, String password){
//        homePage.logout(username,password);
//
//    }
//
//    @AfterClass
//    void closeBrowser(){
//        driver.quit();
//    }

}

