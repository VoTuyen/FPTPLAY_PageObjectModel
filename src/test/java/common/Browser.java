package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
    public static WebDriver open(String browser) {
        switch (browser) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=+");
                return new ChromeDriver(chromeOptions);
            }
            case "firefox": {
                return new FirefoxDriver();
            }
            case "edge": {
                return new EdgeDriver();
            }
            case "safari": {
                return new SafariDriver();
            }
        }
        return null;
    }
}
