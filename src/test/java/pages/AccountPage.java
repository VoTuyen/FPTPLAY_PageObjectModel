package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    WebDriver driver;

    public  AccountPage() {
        this.driver = Browser.getDriver();
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
    By thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn = By.xpath("//*[@id=\"__BVID__1248___BV_modal_footer_\"]/button | //*[@id=\"__BVID__1265___BV_modal_footer_\"]/button | //*[@id=\"__BVID__52___BV_modal_footer_\"]/button");
    By thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn = By.xpath("//*[@id=\"result-modal___BV_modal_body_\"]/div/button");
    By thongTinCaNhan_HoSo_TenHienThiText = By.xpath("//*[@id=\"personal-area\"]/div[1]/div[1]/div/div/div[1]/p");
    By thongTinCaNhan_HoSo_MessageWhenUpdateWithEmtyUsername = By.xpath("//*[@id=\"result-modal___BV_modal_body_\"]/div/h5");
    By thongTinCaNhan_HoSo_DongYBtn = By.xpath("//*[@id=\"result-modal___BV_modal_body_\"]/div/button");
    By thongTinCaNhan_HoSo_BirthdayCheckbox = By.xpath("//*[@id=\"__BVID__1034__outer_\"] | //*[@id=\"__BVID__870__outer_\"]");
    By thongTinCaNhan_HoSo_Birthday = By.xpath("//*[@id=\"__BVID__1036__cell-2024-05-31_\"] | /html/body/div[4]/div[1]/div/div/div/div[2]/div[4]/div/div/div/div/div[2]/div[3]/div[2]/div[3]");

    public String getTitleText(){
        WebElement titleElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(titleBtn));
        return titleElement.getText();
    }

    public void clickThongTinCaNhanBtn(){
        WebElement hoSoElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhanBtn));
        hoSoElement.click();
    }
    public void clickHoSoBtn(){
        WebElement hoSoElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(hoSoBtn));
        hoSoElement.click();
    }

    public void clickFPTPlayRewardsBtn(){
        WebElement fPTPlayRewardElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(fPTPlayRewardBtn));
        fPTPlayRewardElement.click();
    }

    public void clickQuanLyThietBiBtn(){
        WebElement quanLyThietBiElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(quanLyThietBiBtn));
        quanLyThietBiElement.click();
    }
    public void clickQuanLyTheThanhToanBtn(){
        WebElement quanLyTheThanhToanElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(quanLyTheThanhToan));
        quanLyTheThanhToanElement.click();
    }

    public void clickLichSuGiaoDichBtn(){
        WebElement lichSuGiaoDichElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(lichSuGiaoDichBtn));
        lichSuGiaoDichElement.click();
    }

    public void clickDichVuDaMuaBtn(){
        WebElement dichVuDaMuaElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(dichVuDaMuaBtn));
        dichVuDaMuaElement.click();
    }

    public void clickNhapMaKichHoatBtn(){
        WebElement nhapMaKichHoatElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(nhapMaKichHoatBtn));
        nhapMaKichHoatElement.click();
    }
    public void clickThayDoiHoSoBtn(){
        WebElement hoSo_ThaydoiElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoiBtn));
        hoSo_ThaydoiElement.click();
    }

    public void clearFieldUsername(){
        WebElement hoSo_ThayDoiTenHienThiElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(tenHienThiField));
        //hoSo_ThayDoiTenHienThiElement.click();
        hoSo_ThayDoiTenHienThiElement.clear();
        hoSo_ThayDoiTenHienThiElement.sendKeys(Keys.SPACE);

    }
    public void fillTenHienThi(String profileName){
        WebElement hoSo_ThayDoiTenHienThiElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(tenHienThiField));
        //hoSo_ThayDoiTenHienThiElement.clear();
        hoSo_ThayDoiTenHienThiElement.sendKeys(profileName);
    }
    public void clickCapNhatHoSoBtn(){
        WebElement hoSo_CapNhatElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn));
        //WebElement hoSo_CapNhatElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn);
        hoSo_CapNhatElement.click();
    }
    public void clickFullFlowCapNhatHoSoBtn() {
        //WebElement hoSo_CapNhatElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn);
        WebElement hoSo_CapNhatElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhatBtn));
        hoSo_CapNhatElement.click();
        //WebElement hoSo_QuayLaiElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn);
        WebElement hoSo_QuayLaiElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn));
        hoSo_QuayLaiElement.click();
    }
    public void clickQuayLaiBtn(){
        WebElement hoSo_QuayLaiElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn));
        //WebElement hoSo_QuayLaiElement = driver.findElement(thongTinCaNhan_HoSo_ThayDoi_CapNhat_QuayLaiBtn);
        hoSo_QuayLaiElement.click();
    }

    public String getTenHienThiBeforeUpdate(){
        WebElement tenHienThiBeforeUpdateElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_TenHienThiText));
        return tenHienThiBeforeUpdateElement.getText();
    }

    public String getTenHienThiAfterUpdate(){
        //WebElement tenHienThiElement = driver.findElement(thongTinCaNhan_HoSo_TenHienThiText);
        WebElement tenHienThiElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_TenHienThiText));
        return tenHienThiElement.getText();
    }

    public String getMessageWhenUpdateUsernameWrong(){
        WebElement messageElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_MessageWhenUpdateWithEmtyUsername));
        return messageElement.getText();
    }
    public void clickDongYBtn(){
        WebElement dongYElement = Browser.wait.until(ExpectedConditions.visibilityOfElementLocated(thongTinCaNhan_HoSo_DongYBtn));
        dongYElement.click();
    }
    public void clickBirthdayCheckbox(){
        WebElement birthdayCheckboxElement = driver.findElement(thongTinCaNhan_HoSo_BirthdayCheckbox);
        birthdayCheckboxElement.click();
    }
    public void selectBirthday(){
        WebElement birthdaylement = driver.findElement(thongTinCaNhan_HoSo_Birthday);
        birthdaylement.click();
    }
}
