import Data.LoadProperities;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

    WebDriver driver;
    String url= LoadProperities.userData.getProperty("URL");
     String email= LoadProperities.userData.getProperty("Email");
    String password= LoadProperities.userData.getProperty("Password");
    public void LoginAccount(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        LoginPage.loginEmail(driver).sendKeys(email);
        LoginPage.loginPassword(driver).sendKeys(password);
        LoginPage.loginButton(driver).click();

    }

    public void CloseWeb(){
        driver.quit();
    }
}
