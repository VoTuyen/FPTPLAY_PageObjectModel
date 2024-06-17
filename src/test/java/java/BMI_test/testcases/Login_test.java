package BMI_test.testcases;

import BMI_test.pages.AccountPage;
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

import javax.swing.plaf.TableHeaderUI;

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
                {"0974303989","123321"}
        };
    }

    @Test(dataProvider = "testData")
    void verifyLoginSuccess(String username, String password) throws InterruptedException {
        Thread.sleep(6000);
        homePage.clickDangnhapBtn();
        homePage.fillAccountUser(username,password);
        homePage.clickDangnhapBtnInPopup();
        homePage.loginwithOTP();
        Thread.sleep(5000);
        String actualResult = homePage.getResultLogin();
        Assert.assertEquals(actualResult,"Đang xem");
    }
    @Test
    void verifyLogoutSuccess() throws InterruptedException {
        homePage.logout();
        Thread.sleep(1000);
        String actualLogoutResult = homePage.getResultLogout();
        Assert.assertEquals(actualLogoutResult,"Đăng nhập");
    }


//    @AfterClass
//    void closeBrowser(){
//        driver.quit();
//    }

}

