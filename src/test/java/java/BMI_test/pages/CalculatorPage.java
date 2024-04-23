package BMI_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage {

    WebDriver driver;

    //Tạo contructor cho driver
    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    By metricTab = By.xpath("//a[.='Metric Units']");
    By ageTextBox = By.id("cage");
    By maleRadioButton = By.id("csex1");
    By femaleRadioButton = By.cssSelector("label[for=csex2");
    By heightTextBox = By.id("cheightmeter");
    By weightTextBox = By.id("ckg");
    By calculateButton = By.cssSelector("input[value=Calculate]");
    By resultLabel = By.cssSelector(".rightresult .bigtext");
    By clearButton = By.cssSelector("input[value=Clear]");

    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }
    public void selectMetricTab(){
        driver.findElement(metricTab).click();
    }

    public void fillForm(String age, String gender, String height, String weight){
        driver.findElement(ageTextBox).sendKeys(age);
        if(gender.equals("male")) {
            if (!driver.findElement(maleRadioButton).isSelected()) {
                driver.findElement(maleRadioButton).click();
            }
        }else {
            if (!driver.findElement(femaleRadioButton).isSelected()) {
                driver.findElement(femaleRadioButton).click();
            }
        }

        driver.findElement(heightTextBox).sendKeys(height);
        driver.findElement(weightTextBox).sendKeys(weight);
        driver.findElement(calculateButton).click();
    }

    public String getResult(){
        return driver.findElement(resultLabel).getText();
    }

    public void cleanUpForm(){
        driver.findElement(clearButton).click();
    }
}
