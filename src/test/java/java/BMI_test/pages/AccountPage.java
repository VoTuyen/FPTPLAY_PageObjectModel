package BMI_test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By titleBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/h4");
    By thongTinCaNhanBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[1]/a/span");
    By hoSoBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[2]/a");
    By fPTPlayRewardBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[3]/a");
    By quanLyThietBiBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[4]/a");
    By quanLyTheThanhToan = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[5]/a");
    By lichSuGiaoDichBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[6]/a");
    By dichVuDaMuaBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[7]/a");
    By nhapMaKichHoatBtn = By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/ul/li[8]/a");
    By thongTinCaNhan_HoSo_ThayDoiBtn = By.xpath("//*[@id=\"personal-area\"]/div[1]/div[1]/div/div/div[2]");
    By tenHienThiField = By.id("fullname");
    By thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn = By.xpath("//*[@id=\"__BVID__1288___BV_modal_footer_\"]");
    By thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn = By.xpath("//*[@id=\"result-modal___BV_modal_body_\"]/div/button");
    By thongTinCaNhan_HoSo_TenHienThiText = By.xpath("//*[@id=\"personal-area\"]/div[1]/div[1]/div/div/div[1]/p");

    public String getTitleText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titleElement = driver.findElement(titleBtn);
        return titleElement.getText();
    }

    public void clickThongTinCaNhanBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSoElement = driver.findElement(thongTinCaNhanBtn);
        hoSoElement.click();
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
    public void clickThayDoiHoSoBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSo_ThaydoiElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoiBtn);
        hoSo_ThaydoiElement.click();
    }

    public void clearFieldUsername(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSo_ThayDoiTenHienThiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tenHienThiField));
        hoSo_ThayDoiTenHienThiElement.clear();
    }
    public void fillTenHienThi(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSo_ThayDoiTenHienThiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tenHienThiField));
        //hoSo_ThayDoiTenHienThiElement.clear();
        hoSo_ThayDoiTenHienThiElement.sendKeys("t");
    }
    public void clickCapNhatHoSoBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSo_CapNhatElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn));
        //WebElement hoSo_CapNhatElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn);
        hoSo_CapNhatElement.click();
    }
    public void clickFullFlowCapNhatHoSoBtn() throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSo_CapNhatElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn);
        //WebElement hoSo_CapNhatElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn));
        hoSo_CapNhatElement.click();
        WebElement hoSo_QuayLaiElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn);
        //WebElement hoSo_QuayLaiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn));
        hoSo_QuayLaiElement.click();
    }
    public void clickQuayLaiBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoSo_QuayLaiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn));
        //WebElement hoSo_QuayLaiElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn);
        hoSo_QuayLaiElement.click();
    }

    public String getTenHienThiBeforeUpdate(){
        String tenHienThiBeforeUpdate = driver.findElement(thongTinCaNhan_HoSo_TenHienThiText).getText();
        return tenHienThiBeforeUpdate;
    }

    public String getTenHienThiAfterUpdate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tenHienThiElement = driver.findElement(thongTinCaNhan_HoSo_TenHienThiText);
        //WebElement tenHienThiElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tenHienThiField));
        return tenHienThiElement.getText();
    }

}
