package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CardPage;
import pages.ProductsPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class AddProductToCardTests extends BaseTests_Parent_ٍSearch{
    int columnumber;
    int sizeOfAddedProducts;
    String firstproduct;
    String secondproduct;
    String firstprice;
    String firstquantity;
    String firsttotal;
    String secondprice;
    String secondtotal;
    String  secondquantity;

    @BeforeClass
    public void loadTestData() {
        String testDataJsonFile = "searchitemTestData.json" ;
        sizeOfAddedProducts = Integer.parseInt((String) getJsonValueByKey(testDataJsonFile, "sizeOfAddedProducts"));
        firstproduct = (String) getJsonValueByKey(testDataJsonFile, "firstproduct");
        secondproduct = (String) getJsonValueByKey(testDataJsonFile, "secondproduct");
        firstprice = (String) getJsonValueByKey(testDataJsonFile, "firstprice");
        firsttotal = (String) getJsonValueByKey(testDataJsonFile, "firsttotal");
        secondprice = (String) getJsonValueByKey(testDataJsonFile, "secondprice");
        secondtotal = (String) getJsonValueByKey(testDataJsonFile, "secondtotal");
        firstquantity = (String) getJsonValueByKey(testDataJsonFile,"firstquantity");
        secondquantity = (String) getJsonValueByKey(testDataJsonFile,"secondquantity");
        columnumber = Integer.parseInt((String) getJsonValueByKey(testDataJsonFile, "columnumber"));



    }
    @Test
    public void testAddOneProductsToCart ()
    {
        ProductsPage productpage = new ProductsPage(driver);
        CardPage cardpage= new CardPage(driver);
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.clickLAddTocardSecondProduct();
        productpage.clickLView();
        Assert.assertEquals(cardpage.getSizeOfAddedProducts(), sizeOfAddedProducts, "The added products should be 2");
        Assert.assertEquals( cardpage.getFirstProduct(),firstproduct,"The First Product should be Men Tshirt");
        Assert.assertEquals( cardpage.getSeconProduct(),secondproduct,"The Second Product should be Summer White Top");

    }
    @Test
    public void testProductsPrices ()
    {
        ProductsPage productpage = new ProductsPage(driver);
        CardPage cardpage= new CardPage(driver);
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.clickLAddTocardSecondProduct();
        productpage.clickLView();
        Assert.assertEquals( cardpage.getFirstPrice(),firstprice,"The First Product Price should be Rs. 400");
        Assert.assertEquals( cardpage.getsecondPrice(),secondprice,"The Second Product Price should be Rs. 400");
    }
    @Test
    public void testProductsQuantity ()
    {
        ProductsPage productpage = new ProductsPage(driver);
        CardPage cardpage= new CardPage(driver);
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.hoverOverSecondProduct();
        productpage.clickLAddTocardSecondProduct();
        productpage.clickLView();
        Assert.assertEquals(cardpage.getFirstquantity(),firstquantity,"The First Product Quintty should be 2");
        Assert.assertEquals(cardpage.getSecondQuantity(),secondquantity,"The Second Product Quintty should be 1");
    }


    @Test
    public void testProductsTotalPrices ()
    {
        ProductsPage productpage = new ProductsPage(driver);
        CardPage cardpage= new CardPage(driver);
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.hoverOverSecondProduct();
        productpage.clickLAddTocardSecondProduct();
        productpage.clickLView();
        Assert.assertEquals(cardpage.getFirsttotal(),firsttotal,"The First Product prices should be 800");
        Assert.assertEquals(cardpage.getSecontotal(),secondtotal,"The Second Product Quintty should be 400");
    }

    @Test
    public void testColumnNumber ()
    {
        ProductsPage productpage = new ProductsPage(driver);
        CardPage cardpage= new CardPage(driver);
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.hoverOverFirstProduct();
        productpage.clickLAddTocardFirstProduct();
        productpage.clickLShopping();
        productpage.hoverOverSecondProduct();
        productpage.clickLAddTocardSecondProduct();
        productpage.clickLView();
        Assert.assertEquals(cardpage.getSizeColumnNumber(), columnumber, "The Column Number should be 6");

    }





}
