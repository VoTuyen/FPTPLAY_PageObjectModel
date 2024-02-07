package BMI_test.studiesNotPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BodyMassIndexTest {

    WebDriver driver;
    //private boolean formCleared = false;

    @BeforeClass
    void openBrowser(){
        ChromeOptions chromeDriver = new ChromeOptions();
        chromeDriver.addArguments("--remote-allow-origins=+");
        driver = new ChromeDriver(chromeDriver);
        driver.get("https://www.calculator.net/bmi-calculator.html");
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/table/tbody/tr/td/form/table[4]/tbody/tr/td/input[4]")).click();
        driver.findElement(By.xpath("//a[.='Metric Units']")).click();
    }

    @DataProvider // là feature của testNG
    Object[][] testData(){
        return new Object[][]{
                {"37","male","172","64","BMI = 21.6 kg/m2   (Normal)"},
                {"37","male","172","64","BMI = 21.6 kg/m2   (Normal)"},
                {"37","female","172","64","BMI = 21.6 kg/m2   (Normal)"}
        };
    }

    @BeforeMethod
    void cleanUpForm() {
        //clear text
        driver.findElement(By.cssSelector("input[value=Clear]")).click();
        //driver.findElement(By.className("clearbtn")).click();

//        if (method.getName().equals("validateResult") && formCleared) {
//            driver.findElement(By.cssSelector("#menuon a")).click();
//        }

    }

    @Test(dataProvider = "testData")
    void validateResult(String age, String gender, String height, String weight, String expectedResult) throws InterruptedException {
        //driver.findElement(By.xpath("//*[@id=\"cage\"]")).sendKeys(age);
        driver.findElement(By.id("cage")).sendKeys(age);
        if(gender.equals("male")) {
            if (!driver.findElement(By.id("csex1")).isSelected()) {
                driver.findElement(By.id("csex1")).click();
            }
        }else {
            if (!driver.findElement(By.cssSelector("label[for=csex2")).isSelected()) {
                driver.findElement(By.cssSelector("label[for=csex2")).click();
                //driver.findElement(By.cssSelector("label[for=csex2")).click();
            }
        }

        //driver.findElement(By.xpath("//*[@id=\"cheightmeter\"]")).sendKeys(height);
        driver.findElement(By.id("cheightmeter")).sendKeys(height);
        //driver.findElement(By.xpath("//*[@id=\"ckg\"]")).sendKeys(weight);
        driver.findElement(By.id("ckg")).sendKeys(weight);
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/table/tbody/tr/td/form/table[4]/tbody/tr/td/input[3]")).click();
        driver.findElement(By.cssSelector("input[value=Calculate]")).click();
        //String result = driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[1]")).getText();
        String result = driver.findElement(By.cssSelector(".rightresult .bigtext")).getText();
        Assert.assertEquals(result, expectedResult);
        Thread.sleep(5000);

//        if (!formCleared) {
//            formCleared = true;
//        }
    }

    @AfterClass
    void closeBrowser(){
        driver.quit();
    }
}
