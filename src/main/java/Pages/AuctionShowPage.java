package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuctionShowPage {
    private static WebElement element = null;
    //------------------------------------------------------------------------------------------------
    public static WebElement ActiveActions (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//a[normalize-space()='Active Auctions']"));
        return element;
    }
    public static WebElement LastRecord (WebDriver driver )
    {
        element = driver.findElement(By.xpath("(//div[@class='tab-pane pt-3 pb-3 active']//div[@class='container']//div[@class='row'])[last()]"));
        return element;
    }
    public static WebElement NameToLastRecord (WebDriver driver )
    {
        element = driver.findElement(By.xpath("(//div[@class='tab-pane pt-3 pb-3 active']//div[@class='container']//div[@class='row'])[last()]//div[@class='col-sm-3 col-6 more-product-desc']//h4[@class='total-price']"));
        return element;
    }
}
