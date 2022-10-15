package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NavigationBarPage;
import pages.SearchPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class SearchTests extends BaseTests_Parent_ٍSearch{
    String searchitem;
    String allproducts;
    String searchedprodut;
    String searchProduct;
    String signupLogin;
    String logintoyouraccount;
    String validemail;
    String vaildpassword;
    String invalidemail;
    String invalidpassword;


    @BeforeClass
    public void loadTestData() {
        String testDataJsonFile = "searchitemTestData.json" ;
        searchitem = (String) getJsonValueByKey(testDataJsonFile, "searchitem");
        allproducts = (String) getJsonValueByKey(testDataJsonFile, "allproducts");
        searchedprodut = (String) getJsonValueByKey(testDataJsonFile, "searchedprodut");
        searchProduct = (String) getJsonValueByKey(testDataJsonFile, "searchedprodut");
        signupLogin=(String) getJsonValueByKey(testDataJsonFile, "SignupLogin");
        logintoyouraccount=(String) getJsonValueByKey(testDataJsonFile, "logintoyouraccount");
        validemail=(String) getJsonValueByKey(testDataJsonFile, "validemail");
        vaildpassword=(String) getJsonValueByKey(testDataJsonFile, "vaildpassword");
        invalidemail=(String) getJsonValueByKey(testDataJsonFile, "invalidemail");
        invalidpassword=(String) getJsonValueByKey(testDataJsonFile, "invalidpassword");
    }

    @Test
    public void testSearceProducatWithBlueKeyword ()
    {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver.get());
        navigationBarPage.clickProducat();
        SearchPage search = new SearchPage(driver.get());
        Assert.assertEquals(search.allProducatShown(), allproducts,"ALL PRODUCTS should be shown");
        search.searchProductbyname(searchProduct);
        Assert.assertEquals( search.AllSharedDisplayed(), searchedprodut,"SEARCHED PRODUCTS should be shown");


    }
    @Test
    public void testAllRealtedShown ()
    {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver.get());
        navigationBarPage.clickProducat();
        SearchPage search = new SearchPage(driver.get());
        search.searchProductbyname(searchitem);
        search.isKeyWordInProducatTitles(searchitem);

    }
    @Test
    public void testForSeachtopblueByEnter ()
    {
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver.get());
        navigationBarPage.clickProducat();
        SearchPage search = new SearchPage(driver.get());
       Assert.assertEquals(search.searchProductbynameThenclickenter(searchProduct),"Blue Top should be shown");

    }



}
