package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;
import pages.HomePage;
import pages.NavigationBarPage;

import java.io.File;
import java.io.IOException;

import static fileReaderManager.ReadFromFiles.getPropertyByKey;


public class BaseTests_Parent_ٍSearch {

    public static String configPropertyFileName =  "configData.properties" ;
    WebDriver driver;

    @BeforeMethod
    public void setup_initiateDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get((String) getPropertyByKey(configPropertyFileName , "APP_URL"));
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        HomePage base=new HomePage(driver);
        Assert.assertEquals( base.VeryHome(),"Signup / Login","The Sigin Sign Out");
        navigationBarPage.clickProducat();

    }

    @AfterMethod
    public void a_takeScreenshotForFailedTests(ITestResult result) {
        String destination = "./screenshots/" + result.getName() + ".png" ;
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
        driver.quit();
    }

}
