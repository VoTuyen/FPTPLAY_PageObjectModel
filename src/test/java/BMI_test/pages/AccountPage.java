package BMI_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By titleBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1/div/]h4");
    By thongTinCaNhanBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[1]/a/span");
    By hoSoBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[2]/a");
    By fPTPlayRewardBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[3]/a");
    By quanLyThietBiBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[4]/a");
    By quanLyTheThanhToan = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[5]/a");
    By lichSuGiaoDichBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[6]/a");
    By dichVuDaMuaBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[7]/a");
    By nhapMaKichHoatBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[8]/a");

    public String getTitleText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleElement = driver.findElement(titleBtn);
        return titleElement.getText();
    }

    public void clickHoSoBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSoElement = driver.findElement(hoSoBtn);
        hoSoElement.click();
    }

    public void clickFPTPlayRewardsBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fPTPlayRewardElement = driver.findElement(fPTPlayRewardBtn);
        fPTPlayRewardElement.click();
    }

    public void clickQuanLyThietBiBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quanLyThietBiElement = driver.findElement(quanLyThietBiBtn);
        quanLyThietBiElement.click();
    }
    public void clickQuanLyTheThanhToanBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quanLyTheThanhToanElement = driver.findElement(quanLyTheThanhToan);
        quanLyTheThanhToanElement.click();
    }

    public void clickLichSuGiaoDichBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lichSuGiaoDichElement = driver.findElement(lichSuGiaoDichBtn);
        lichSuGiaoDichElement.click();
    }

    public void clickDichVuDaMuaBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dichVuDaMuaElement = driver.findElement(dichVuDaMuaBtn);
        dichVuDaMuaElement.click();
    }

    public void clickNhapMaKichHoatBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nhapMaKichHoatElement = driver.findElement(nhapMaKichHoatBtn);
        nhapMaKichHoatElement.click();
    }





}
