package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigationBarPage;
import pages.SearchPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class LoginTest extends BaseTests_Parent_ٍSearch{

    String signupLogin;
    String logintoyouraccount;
    String validemail;
    String vaildpassword;
    String invalidemail;
    String invalidpassword;
    @BeforeClass
    public void LoginTestData() {
        String testDataJsonFile = "searchitemTestData.json" ;
        signupLogin=(String) getJsonValueByKey(testDataJsonFile, "SignupLogin");
        logintoyouraccount=(String) getJsonValueByKey(testDataJsonFile, "logintoyouraccount");
        validemail=(String) getJsonValueByKey(testDataJsonFile, "validemail");
        vaildpassword=(String) getJsonValueByKey(testDataJsonFile, "vaildpassword");
        invalidemail=(String) getJsonValueByKey(testDataJsonFile, "invalidemail");
        invalidpassword=(String) getJsonValueByKey(testDataJsonFile, "invalidpassword");

    }
    @Test
    public void tesLogin ()
    {
        HomePage base=new HomePage(driver);
        Assert.assertEquals( base.VeryHome(),signupLogin,"The Sigin Sign Out");
        LoginPage loginpage=new LoginPage(driver);
        loginpage.clickLogin();
        Assert.assertEquals(loginpage.logintoyouraccountVisible(),logintoyouraccount,"Login to your account Shown");
        //log with valid email and password
        //loginpage.loginToAppWithValidCredentials(validemail,vaildpassword);
        // log with Invalid email and password you must run one by one you can't run two together
        loginpage.loginToAppWithInvalidCredentials(invalidemail,invalidpassword);
        Assert.assertEquals(loginpage.incorrectEmailorpassword(invalidemail,invalidpassword),"Your email or password is incorrect!","Your email or password is incorrect! Shown");



    }

}
