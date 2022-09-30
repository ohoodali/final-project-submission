package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {


    WebDriver driver;
    WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public WebElement locateElement (By elementLocator)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElement(elementLocator);
    }
    public List<WebElement> locateListOfElement (By elementLocator)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElements(elementLocator);
    }
    public void hoverElement (By elementLocator)
    {
        Actions actions = new Actions(this.driver);
        WebElement element = locateElement(elementLocator);
        actions.moveToElement(element).perform();
        actions.perform();

    }

    public void clickElement (By elementLocator)
    {
        locateElement(elementLocator).click();
    }



    public void typeOnInputField (By elementLocator, String text)
    {
        locateElement(elementLocator).sendKeys(text);
    }

    public String getTextOfElement (By elementLocator)
    {
        return locateElement(elementLocator).getText();
    }



}
