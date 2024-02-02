package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SignIn;

import java.sql.SQLException;

import static java.sql.DriverManager.getDriver;

public class SignInTest {
    private WebDriver driver;
    public SignIn signIn;

    @BeforeClass
    public void setUp(){
        driver = getDriver();
    }

    private WebDriver getDriver() {
        return null;
    }

    @Test
    public void signIn(){
        System.out.println(driver);
        signIn = new SignIn(driver);

        Assert.assertTrue(signIn.clickSubmitSignIn(), "1");
    }

}
