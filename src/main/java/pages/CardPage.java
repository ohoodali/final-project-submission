package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardPage extends BasePage {


    private By columnnumber = By.xpath("//table[@class=\"table table-condensed\"]/thead/tr/td");
    By allCartRows = By.className("cart_product");
    private By firstproduct = By.xpath("//a[@href=\"/product_details/2\"]");
    private By secondproduct = By.xpath("//a[@href=\"/product_details/6\"]");
    private By firstprice = By.xpath("(//td[@class=\"cart_price\"]/p)[1]");

    private By secondprice = By.xpath("(//td[@class=\"cart_price\"]/p)[2]");

    private By firsttotal = By.xpath("(//p[@class=\"cart_total_price\"])[1]");
    private By secondtotal = By.xpath("(//p[@class=\"cart_total_price\"])[2]");
    private By firstquantity = By.xpath("(//button[@class=\"disabled\"])[1]");
    private By secondquantity = By.xpath("(//button[@class=\"disabled\"])[2]");
    public CardPage(WebDriver driver) {
        super(driver);
    }

   public int getSizeColumnNumber()

   {
       List<WebElement>headers=locateListOfElement(columnnumber);
       return locateListOfElement(columnnumber).size();
   }
   public boolean getHeardersText(List<String> expectedheaderstest){
       List<WebElement>headers= locateListOfElement(columnnumber);
       for(int i=0; i< headers.size();i++)
       {

           if(headers.get(i).getText()!=expectedheaderstest.get(i)){
               return false;
           }
       }
return true;
   }
    public int getSizeOfAddedProducts ()
    {
        return locateListOfElement(allCartRows).size();
    }

    public String getFirstProduct()
    {

        String firstproducat= getTextOfElement(firstproduct);
        return firstproducat;
    }

    public String getSeconProduct()
    {

        String secondproducat= getTextOfElement(secondproduct);
        return secondproducat;
    }
    public String getFirstPrice ()
    {

        String firsprice= getTextOfElement(firstprice);
        return firsprice;
    }
    public String getsecondPrice ()
    {

        String serpr= getTextOfElement(secondprice);
        return serpr;
    }
    public String getFirsttotal()
    {

        String firsttoal= getTextOfElement(firsttotal);
        return firsttoal;
    }
    public String getSecontotal()
    {

        String secondto= getTextOfElement(secondtotal);
        return secondto;
    }
    public String getFirstquantity()
    {

        String firstquintiy= getTextOfElement(firstquantity);
        return firstquintiy;
    }

    public String getSecondQuantity()
    {
        String  secondquintiy= getTextOfElement(secondquantity);
        return secondquintiy;
    }
}
