import Data.LoadProperities;
import Pages.AddProductPage;
import Pages.AuctionShowPage;
import Pages.UserHome;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddProduct {

TestBase userAccount;
    String auctionName= LoadProperities.userData.getProperty("AuctionName");
    String mainCat= LoadProperities.userData.getProperty("MainCategory");
    String proAdress = LoadProperities.userData.getProperty("ProductAddress");
    String proDetails = LoadProperities.userData.getProperty("productDetails");
    String proPolicy = LoadProperities.userData.getProperty("ProductPolicy");
    String mainImage = LoadProperities.userData.getProperty("MainImage");
    String currency = LoadProperities.userData.getProperty("Currency");
    String bidValue = LoadProperities.userData.getProperty("BidValue");
    String nowValue = LoadProperities.userData.getProperty("NowValue");
    String succMess = LoadProperities.userData.getProperty("SuccessMessage");

@BeforeTest

public void OpenUserAccount() {
    userAccount = new TestBase();
    userAccount.LoginAccount();
   if(ExpectedConditions.alertIsPresent()!=null){
        UserHome.ClosePopUp(userAccount.driver).click();

    }
    WebDriverWait wait = new WebDriverWait(userAccount.driver, Duration.ofSeconds(20));
    WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='d-flex flex-row']//div[@class='dropdown action-dropdown user-actions']")));
    Actions action = new Actions(userAccount.driver);
    action.moveToElement(element1).perform();
    WebElement elementEdit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='dropdown-menu dropdown-menu-left']//a[normalize-space()='Add Product']")));
    action.moveToElement(element1).moveToElement(elementEdit).click().build().perform();



}

@Test
public void AddProductTest() {
     ///////------------------Step 1 tab------------------ /////////
    ///////Scroll to visible next Step button//////////////////////
    JavascriptExecutor je = (JavascriptExecutor) userAccount.driver;
    je.executeScript("arguments[0].scrollIntoView(true);", AddProductPage.NextStep1Button(userAccount.driver));
    //////////////////////////////////////////////////////////////
    AddProductPage.NextStep1Button(userAccount.driver).click();
    ///////////////////////--------------------------------------------------------/////////////////////////////////
    ///////------------------Step 2 tab------------------ /////////
    userAccount.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    je.executeScript("window.scrollBy(0,-200)");
    AddProductPage.AuctionName(userAccount.driver).sendKeys(auctionName);
    AddProductPage.MainCategory(userAccount.driver).sendKeys(mainCat);
    AddProductPage.MainCategory(userAccount.driver).sendKeys(Keys.ENTER);
    AddProductPage.SubCategory(userAccount.driver).click();
    AddProductPage.SubCategory(userAccount.driver).sendKeys(Keys.ARROW_DOWN);
    AddProductPage.SubCategory(userAccount.driver).sendKeys(Keys.ENTER);
    AddProductPage.Quantity(userAccount.driver).sendKeys("100");
    AddProductPage.ProductAddress(userAccount.driver).sendKeys(Keys.CONTROL+ "a");
    AddProductPage.ProductAddress(userAccount.driver).sendKeys(Keys.DELETE);
    AddProductPage.ProductAddress(userAccount.driver).sendKeys(proAdress);
    userAccount.driver.switchTo().frame(AddProductPage.iframeDetails);
    AddProductPage.AuctionDetails(userAccount.driver).sendKeys(proDetails);
    userAccount.driver.switchTo().defaultContent();
    userAccount.driver.switchTo().frame(AddProductPage.iframePolicy);
    AddProductPage.Policy(userAccount.driver).sendKeys(proPolicy);
    userAccount.driver.switchTo().defaultContent();
    AddProductPage.MainImage(userAccount.driver).sendKeys(System.getProperty("user.dir")+ mainImage);
    AddProductPage.NextStep2(userAccount.driver).click();
    ///////////////////////--------------------------------------------------------/////////////////////////////////
    ///////------------------Step 3 tab------------------ /////////
    userAccount.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    AddProductPage.Currency(userAccount.driver).sendKeys(currency);
    AddProductPage.Currency(userAccount.driver).sendKeys(Keys.ENTER);
    AddProductPage.BidValue(userAccount.driver).sendKeys(bidValue);
    AddProductPage.NowValue(userAccount.driver).sendKeys(nowValue);
    AddProductPage.NextStep3(userAccount.driver).click();
    ///////////////////////--------------------------------------------------------/////////////////////////////////
    ///////------------------Step 4 tab------------------ /////////
    AddProductPage.FinishAdd(userAccount.driver).click();
    SoftAssert soft= new SoftAssert();
    // 1- Get and verify the success message display
      String actualMessage = AddProductPage.SuccessMessage(userAccount.driver).getText();
      soft.assertTrue(actualMessage.contains(succMess));
    System.out.println("The product was added");
      AddProductPage.GoMyProductShow(userAccount.driver).click();
    ///////////////////////--------------------------------------------------------/////////////////////////////////
    ///////------------------Product Show page------------------ /////////
    AuctionShowPage.ActiveActions(userAccount.driver).click();
    // 2- Get and verify the product name
    AuctionShowPage.ActiveActions(userAccount.driver).click();
    je.executeScript("arguments[0].scrollIntoView(true);", AuctionShowPage.LastRecord(userAccount.driver));
    AuctionShowPage.NameToLastRecord(userAccount.driver).getText();
    String actual  = AuctionShowPage.NameToLastRecord(userAccount.driver).getText();
    System.out.println("The product name: "+ actual);
    String expected = auctionName;
    soft.assertEquals(actual,expected);
    soft.assertAll();
}

@AfterTest
public void CloseWeb() {
    userAccount.CloseWeb();
}

}
