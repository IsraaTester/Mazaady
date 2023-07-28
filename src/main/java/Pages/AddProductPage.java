package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProductPage {

    public static String iframeDetails = "tinymce_description_ifr";
    public static String iframePolicy = "tinymce_policy_ifr";
    private static WebElement element = null;
    //------------------------------------------------------------------------------------------------

    ///////// Step 1 tab ///////////
    public static WebElement NextStep1Button (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//button[@class='btn btn-buy continue']"));
        return element;
    }

    ///////// Step 2 tab ///////////
    public static WebElement AuctionName (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@placeholder='Auction Name']"));
        return element;
    }
    public static WebElement MainCategory (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@placeholder='select category']"));
        return element;
    }
    public static WebElement SubCategory (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@placeholder='select subcategory']"));
        return element;
    }
    public static WebElement Quantity (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@placeholder='Quantity']"));
        return element;
    }
    public static WebElement Country (WebDriver driver )
    {
        element = driver.findElement(By.xpath("(//input[@class='vs__search'])[5]"));
        return element;
    }
    public static WebElement Region (WebDriver driver )
    {
        element = driver.findElement(By.xpath("(//input[@type='search'])[10]"));
        return element;
    }
    public static WebElement City (WebDriver driver )
    {
        element = driver.findElement(By.xpath("(//input[@type='search'])[11]"));
        return element;
    }
    public static WebElement ProductAddress (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@name='address']"));
        return element;
    }
    public static WebElement AuctionDetails (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//body[@id='tinymce']"));
        return element;
    }
    public static WebElement Policy (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//body[@id='tinymce']"));
        return element;
    }
    public static WebElement MainImage (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@id='main_image']"));
        return element;
    }
    public static WebElement NextStep2 (WebDriver driver )
    {
        element = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Next Step'])[2]"));
        return element;
    }
    ////////////////////////////----------------------------------------/////////////////////

     ///////// Step 3 tab ///////////
     public static WebElement Currency (WebDriver driver )
     {
         element = driver.findElement(By.xpath("//div[@class='col-sm-6 col-12']//input[@type='search']"));
         return element;
     }
    public static WebElement BidValue (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@name='starting_bid']"));
        return element;
    }
    public static WebElement NowValue (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//input[@placeholder='Buy Now Value']"));
        return element;
    }
    public static WebElement NextStep3 (WebDriver driver )
    {
        element = driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Next Step'])[3]"));
        return element;
    }
    ////////////////////////////----------------------------------------/////////////////////

    ///////// Step 4 tab ///////////
    public static WebElement SuccessMessage (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//div[@class='swal-text']"));
        return element;
    }
    public static WebElement FinishAdd (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//button[normalize-space()='Add']"));
        return element;
    }
    public static WebElement GoMyProductShow (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//button[normalize-space()='Go to my product']"));
        return element;
    }
    ///////////////----------------------------////////////////////


}
