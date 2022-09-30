package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    // Locators
    By emailField = By.xpath("//input[@data-qa=\"login-email\"]");
    By passwordField = By.xpath("//input[@data-qa=\"login-password\"]");
    By login= By.xpath("//a[@href=\"/login\"]");
    By loginBtn = By.xpath("//button[@data-qa=\"login-button\"]");
    By logintoaccount = By.xpath("//div[@class=\"login-form\"]/h2");
    By incorrect = By.xpath("//p[ contains (text(), \"Your email or password \" )]");

    public LoginPage clickLogin()
    {
        clickElement(login);

        return new LoginPage(driver);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage loginToAppWithValidCredentials (String email,String pass)
    {
        typeOnInputField(emailField, email);
        typeOnInputField(passwordField, pass);
        clickElement(loginBtn);
        return new LoginPage(driver);
    }
    public String logintoyouraccountVisible ()
    {
        String loginaccount= getTextOfElement(logintoaccount);
        return loginaccount;
    }
    public LoginPage loginToAppWithInvalidCredentials (String invalidEmail,String pass)
    {
        typeOnInputField(emailField, invalidEmail);
        typeOnInputField(passwordField, pass);
        clickElement(loginBtn);
        return new LoginPage(driver);
    }

    public String incorrectEmailorpassword (String invalidEmail,String pass)
    {
       /* typeOnInputField(emailField, invalidEmail);
        typeOnInputField(passwordField, pass);
        clickElement(loginBtn);*/
        String loginaccount= getTextOfElement(incorrect);
        return loginaccount;
    }
}
