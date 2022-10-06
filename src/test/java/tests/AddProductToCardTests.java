package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CardPage;
import pages.ProductsPage;

import static fileReaderManager.ReadFromFiles.getJsonValueByKey;

public class AddProductToCardTests extends BaseTests_Parent_ٍSearch{

    String sizeOfAddedProducts;
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
        sizeOfAddedProducts = (String) getJsonValueByKey(testDataJsonFile,  "sizeOfAddedProducts");
        firstproduct = (String) getJsonValueByKey(testDataJsonFile, "firstproduct");
        secondproduct = (String) getJsonValueByKey(testDataJsonFile, "secondproduct");
        firstprice = (String) getJsonValueByKey(testDataJsonFile, "firstprice");
        firstquantity = (String) getJsonValueByKey(testDataJsonFile,  "firstquantity");
        firsttotal = (String) getJsonValueByKey(testDataJsonFile, "firsttotal");
        secondprice = (String) getJsonValueByKey(testDataJsonFile, "secondprice");
        secondtotal = (String) getJsonValueByKey(testDataJsonFile, "second total");
       secondquantity = (String) getJsonValueByKey(testDataJsonFile,"secondquantity");



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
        Assert.assertEquals(cardpage.getSizeOfAddedProducts(), 2, "The added products should be 2");
        Assert.assertEquals( cardpage.getFirstProduct(),"Men Tshirt","The First Product should be Men Tshirt");
        Assert.assertEquals( cardpage.getSeconProduct(),"Summer White Top","The Second Product should be Summer White Top");
        Assert.assertEquals( cardpage.getFirstPrice(),"Rs. 400","The First Product Price should be Rs. 400");
        Assert.assertEquals( cardpage.getsecondPrice(),"Rs. 400","The Second Product Price should be Rs. 400");
        Assert.assertEquals( cardpage.getFirstquantity(),1,"The First Product Quintty should be 1");
        Assert.assertEquals( cardpage.getSecondQuantity(),1,"The Second Product Quintty should be 1");
        Assert.assertEquals( cardpage.getFirsttotal(),"Rs. 400","The Frist Product Totol should be Rs. 400");
        Assert.assertEquals( cardpage.getSecontotal(),"Rs. 400","The Second Product Price should be Rs. 400");

    }
    @Test
    public void testAddTwoProductsQuantityToCart ()
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
        Assert.assertEquals(cardpage.getSizeOfAddedProducts(), 2, "The added products should be 2");
        Assert.assertEquals(cardpage.getFirstquantity(),2,"The First Product Quintty should be 2");
        Assert.assertEquals(cardpage.getSecondQuantity(),1,"The Second Product Quintty should be 1");
    }


    @Test
    public void testAddTwoProductsPricesToCart ()
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
        Assert.assertEquals(cardpage.getSizeOfAddedProducts(), 2, "The added products should be 2");
        Assert.assertEquals(cardpage.getFirsttotal(),"Rs. 800","The First Product prices should be 800");
        Assert.assertEquals(cardpage.getSecontotal(),"Rs. 400","The Second Product Quintty should be 400");
    }





}
