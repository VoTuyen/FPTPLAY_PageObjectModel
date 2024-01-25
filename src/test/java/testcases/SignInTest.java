package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages.SignIn;

import java.sql.SQLException;

import static java.sql.DriverManager.getDriver;

public class SignInTest {
    private WebDriver driver;
    public SignIn signIn;

    @BeforeClass
    public void setUp() throws SQLException {
        driver = getDriver("bbb");
    }
}
