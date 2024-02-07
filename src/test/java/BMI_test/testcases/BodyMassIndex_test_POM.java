package BMI_test.testcases;

import BMI_test.pages.CalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BodyMassIndex_test_POM {
    WebDriver driver;
    //private boolean formCleared = false;
    CalculatorPage calculatorPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser){
        //test chuyển đổi trên nhiều browser
        switch (browser) {
            case "chrome": {
                ChromeOptions chromeDriver = new ChromeOptions();
                chromeDriver.addArguments("--remote-allow-origins=+");
                driver = new ChromeDriver(chromeDriver);
                break;
            }
            case "firefox":{
                driver = new FirefoxDriver();
                break;
            }
            case "edge":{
                driver = new EdgeDriver();
                break;
            }
            case  "safari":{
                driver = new SafariDriver();
                break;
            }
        }
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.open();
        calculatorPage.selectMetricTab();
    }

    @DataProvider
        // là feature của testNG
    Object[][] testData(){
        return new Object[][]{
                {"37","male","172","64","BMI = 21.6 kg/m2   (Normal)"},
                {"37","male","172","64","BMI = 21.6 kg/m2   (Normal)"},
                {"37","female","172","64","BMI = 21.6 kg/m2   (Normal)"}
        };
    }

    @BeforeMethod
    void cleanUpForm() {
        calculatorPage.cleanUpForm();
    }

    @Test(dataProvider = "testData")
    void validateResult(String age, String gender, String height, String weight, String expectedResult)  {
        calculatorPage.fillForm(age, gender, height, weight);
        String result = calculatorPage.getResult();
        Assert.assertEquals(result, expectedResult);
    }

    @AfterClass
    void closeBrowser(){
        driver.quit();
    }
}
