package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static WebElement element = null;
    //------------------------------------------------------------------------------------------------
    public static WebElement loginEmail (WebDriver driver )
    {
        element = driver.findElement(By.id("email"));
        return element;
    }

    public static WebElement loginPassword (WebDriver driver )
    {
        element = driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement loginButton(WebDriver driver )
    {
        element = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        return element;
    }

}
