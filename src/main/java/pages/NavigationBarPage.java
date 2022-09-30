package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBarPage extends BasePage{
    private By Producat = By.cssSelector("li>a[href=\"/products\"]");







    public NavigationBarPage(WebDriver driver) {
        super(driver);
    }
    public NavigationBarPage clickProducat ()

    {
        clickElement(Producat);
        return new NavigationBarPage(driver);
    }








}
