package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.NavigationBarPage;

import java.io.File;
import java.io.IOException;

import static fileReaderManager.ReadFromFiles.getPropertyByKey;


public class BaseTests_Parent_ٍSearch {

    public static String configPropertyFileName =  "configData.properties" ;
  protected ThreadLocal<WebDriver>   driver=new ThreadLocal<>();

    @BeforeMethod
    public void setup_initiateDriver() {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        driver.get().get((String) getPropertyByKey(configPropertyFileName , "APP_URL"));
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver.get());
        HomePage base=new HomePage(driver.get());
        Assert.assertEquals( base.VeryHome(),"Signup / Login","The Sigin Sign Out");
        navigationBarPage.clickProducat();

    }

    @AfterMethod
    public void a_takeScreenshotForFailedTests(ITestResult result) {
        String destination = "./screenshots/" + result.getName() + ".png" ;
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.FILE);
            try {
                //To add it in the extent report
                FileUtils.copyFile(screenshot, new File(destination));
            } catch (IOException e) {
                // handle
            }
        }
    }

    @AfterMethod
    public void z_quitDriver() {
        driver.get().quit();
    }

}
