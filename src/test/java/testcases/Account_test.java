package testcases;

import common.Browser;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AccountPage;
import pages.HomePage;

import org.testng.Assert;

public class Account_test {
    HomePage homePage;
    AccountPage accountPage;
    @DataProvider
        // là feature của testNG
    Object[][] testData(){
        return new Object[][]{
                {"0974303989","123456"}
        };
    }

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) throws InterruptedException {
        Browser.open(browser);
        homePage = new HomePage();
        accountPage = new AccountPage();
        homePage.openBrowser();
        Thread.sleep(6000);
        homePage.clickHomeBtnInLandingPage();
        homePage.clickDangnhapBtn();
        homePage.fillAccountUser("0974303989","123321");
        homePage.clickDangnhapBtnInPopup();
        homePage.redirectToOTPField();
        homePage.fillOTP();
        homePage.clickAccountBtn();
        Thread.sleep(10000);
        homePage.clickTaikhoanvaCaidatBtn();

    }

    @Test(dataProvider = "testData")
    void verifyRedirectToThongTinCaNhanSuccess(String username, String password) throws InterruptedException {
        Thread.sleep(5000);
        String actualResult = accountPage.getTitleText();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,"Tài khoản và dịch vụ");
    }

//    @Test(priority = 1)
//    void verifyUpdateUsernameSuccess() throws InterruptedException {
//        accountPage.clickThongTinCaNhanBtn();
//        String tenHienThi = accountPage.getTenHienThiBeforeUpdate();
//        accountPage.clickThayDoiHoSoBtn();
//        accountPage.fillTenHienThi("t");
//        Thread.sleep(2000);
//        accountPage.clickCapNhatHoSoBtn();
//        Thread.sleep(3000);
//        accountPage.clickQuayLaiBtn();
//        Thread.sleep(2000);
//        String actual_tenHienThi = accountPage.getTenHienThiAfterUpdate();
//        System.out.println(actual_tenHienThi);
//        Assert.assertEquals(actual_tenHienThi, tenHienThi+"t");
//    }
//
//    @Test(priority = 2)
//    void verifyCannotUpdateHoSoWithEmptyUsername() throws InterruptedException {
//        accountPage.clickThayDoiHoSoBtn();
//        Thread.sleep(5000);
//        accountPage.clearFieldUsername();
//        accountPage.fillTenHienThi(" ");
//        Thread.sleep(2000);
//        accountPage.clickCapNhatHoSoBtn();
//        String actual_messageWhenUpdateWithEmtyUsername = "Tên hiển thị bao gồm từ 6-20 ký tự, không được chứa ký tự đặc biệt.";
//        Assert.assertEquals(accountPage.getMessageWhenUpdateUsernameWrong(),actual_messageWhenUpdateWithEmtyUsername);
//        accountPage.clickDongYBtn();
//    }
//
//    @Test(priority = 3)
//    void verifyCannotUpdateHoSoWithUsernameLessThan6Letters() throws InterruptedException {
//        Thread.sleep(2000);
//        accountPage.clickThayDoiHoSoBtn();
//        accountPage.clearFieldUsername();
//        accountPage.fillTenHienThi("12345");
//        accountPage.clickCapNhatHoSoBtn();
//        String actual_messageWhenUpdateWithEmtyUsername = "Tên hiển thị bao gồm từ 6-20 ký tự, không được chứa ký tự đặc biệt.";
//        Assert.assertEquals(accountPage.getMessageWhenUpdateUsernameWrong(),actual_messageWhenUpdateWithEmtyUsername);
//        accountPage.clickDongYBtn();
//    }
//
//    @Test(priority = 4)
//    void verifyCannotUpdateHoSoWithUsernameMoreThan20Leters() throws InterruptedException {
//        Thread.sleep(2000);
//        accountPage.clickThayDoiHoSoBtn();
//        accountPage.clearFieldUsername();
//        accountPage.fillTenHienThi("12345abcddfgredfgredfge");
//        accountPage.clickCapNhatHoSoBtn();
//        String actual_messageWhenUpdateWithEmtyUsername = "Tên hiển thị bao gồm từ 6-20 ký tự, không được chứa ký tự đặc biệt.";
//        Assert.assertEquals(accountPage.getMessageWhenUpdateUsernameWrong(),actual_messageWhenUpdateWithEmtyUsername);
//        accountPage.clickDongYBtn();
//    }
//
//    @Test(priority = 5)
//    void verifyCannotUpdateHoSoWithUsernameHaveSpecialLetter() throws InterruptedException {
//        Thread.sleep(2000);
//        accountPage.clickThayDoiHoSoBtn();
//        accountPage.clearFieldUsername();
//        accountPage.fillTenHienThi("12345@#%");
//        accountPage.clickCapNhatHoSoBtn();
//        String actual_messageWhenUpdateWithEmtyUsername = "Tên hiển thị bao gồm từ 6-20 ký tự, không được chứa ký tự đặc biệt.";
//        Assert.assertEquals(accountPage.getMessageWhenUpdateUsernameWrong(),actual_messageWhenUpdateWithEmtyUsername);
//        accountPage.clickDongYBtn();
//    }
//
//    @Test(priority = 6)
//    void verifyUpdateHoSoWithUsernameHaveAccentAndSpaceSuccess(){
//        accountPage.clickThayDoiHoSoBtn();
//        accountPage.clearFieldUsername();
//        accountPage.fillTenHienThi("Quỳnh Chá Na");
//        accountPage.clickCapNhatHoSoBtn();
//        accountPage.clickQuayLaiBtn();
//        String userNameHaveAccent = accountPage.getTenHienThiAfterUpdate();
//        Assert.assertEquals(userNameHaveAccent, "Quỳnh Chá Na");
//    }

    @Test(priority = 7)
    void verifyUpdateHoSoAfterChangeBirthdaySuccess(){
        accountPage.clickThayDoiHoSoBtn();
        accountPage.clickBirthdayCheckbox();
        accountPage.selectBirthday();
        accountPage.clickCapNhatHoSoBtn();
        accountPage.clickQuayLaiBtn();
    }

//    @AfterMethod
//    void captureScreenWhenFail(ITestResult result){
//        if(!result.isSuccess()){
//            Browser.captureScreen(result.getName());
//        }
//    }

//    @AfterClass
//    void closeBrowser(){
//        Browser.close();
//    }

}
