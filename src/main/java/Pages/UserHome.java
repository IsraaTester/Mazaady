package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHome {

    private static WebElement element = null;
    //------------------------------------------------------------------------------------------------
    public static WebElement AddProduct (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//div[@class='dropdown-menu dropdown-menu-left']//a[normalize-space()='Add Product']"));
        return element;
    }
    public static WebElement ClosePopUp (WebDriver driver )
    {
        element = driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
        return element;
    }
}
