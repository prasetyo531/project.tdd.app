package mobileview;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Login {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RR8M90CMW9N");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        //appium --allow-insecure chromedriver_autodownload
        capabilities.setCapability("chromedriverExecutableDir","/Users/fdn-prasetyo/Documents/chromedriver");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        wait = new WebDriverWait(driver, 10);

        driver.get("https://femaledaily.com");
    }

    @Test
    public void basicTest () throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        System.out.println(size);

        wait.until(ExpectedConditions.elementToBeClickable((WebElement) driver.findElement(By.cssSelector("#id_notifhome"))));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
