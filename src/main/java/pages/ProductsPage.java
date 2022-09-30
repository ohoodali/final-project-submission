package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    private By allprodcate = By.xpath("//a[@data-product-id=\"2\"][1]");
    private By allprodcate2 = By.xpath("//a[@data-product-id=\"6\"][1]");
    private By firstproduct = By.xpath("//a[@href=\"/product_details/2\"]");
    private By secondproduct = By.xpath("//a[@href=\"/product_details/6\"]");
    private By shopping = By.xpath(" (//button[ @class=\"btn btn-success close-modal btn-block\"])");
    private By viewcart = By.cssSelector("p>a[href=\"/view_cart\"]");



    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    public ProductsPage hoverOverFirstProduct()

    {
        hoverElement(firstproduct);
        return new ProductsPage(driver);
    }
    public ProductsPage hoverOverSecondProduct()

    {

        hoverElement(secondproduct);
        return new ProductsPage(driver);
    }


    public ProductsPage clickLAddTocardFirstProduct()
    {
        clickElement(allprodcate);
        return new ProductsPage(driver);
    }
    public ProductsPage clickLAddTocardSecondProduct()
    {
        clickElement(allprodcate2);
        return new ProductsPage(driver);
    }

    public ProductsPage clickLShopping()
    {

        clickElement(shopping);
        return new ProductsPage(driver);
    }
    public ProductsPage clickLView()
    {
        clickElement(viewcart);
        return new ProductsPage(driver);
    }
}
