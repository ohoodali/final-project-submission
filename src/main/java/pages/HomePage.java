package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By myhome = By.xpath("//a[@href='/login']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String VeryHome()
    {
        String home= getTextOfElement(myhome);

        return home;
    }
}
