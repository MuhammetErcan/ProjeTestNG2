package testpackages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;
import utils.WaitConditions;
import static testpackages.Criteria2.*;

import java.util.List;

public class Criteria1 extends ParentClass {

    String url = "https://opencart.abstracta.us/index.php?route=account/login";
    By lUsername = By.id("input-email");
     By lPassword = By.id("input-password");
     By lLoginSubmit = By.cssSelector("input[value='Login']");
     By lLogout = By.xpath("//a[text()='Logout']");
    By lWarning = By.cssSelector("div.alert.alert-danger");
    By lMyAccount=By.cssSelector("i.fa.fa-user");
    By lLogin=By.xpath("//a[text()='Login']");

    By lIpodClassicAddToWish=By.xpath("(//button[@data-original-title='Add to Wish List'])[1]");
    By lIpodClassicName1=By.xpath("(//a[text()='iPod Classic'])[1]");
    String ipodClassicNameString;
    By lGotoWishListButton=By.xpath("(//i[@class='fa fa-heart'])[1]");


    By lproduct1=By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
    By lContinue=By.xpath("//a[text()='Continue']");
    By lProduct1Name=By.xpath("(//a[text()='MacBook'])[1]");
    By lProduct1Price=By.xpath("(//div[@class='caption']/p[@class='price'])[1]");
    By lProduct2=By.xpath("(//button[contains(@onclick,'cart.add')])[2]");
    By lProduct2Name=By.xpath("(//a[text()='iPhone'])[1]");
    By lProduct2Price=By.xpath("(//div[@class='caption']/p[@class='price'])[2]");
    String product1NameString;
    String product1PriceString;
    String product2NameString;
    String product2PriceString;
    By lTotalPriceInCartPanelUnauthorized=By.xpath("(((//table[@class='table table-bordered']//tr)[4])//td)[2]");
    By lTotalPriceInCartPanelforAuthorized=By.xpath("((//table[@class='table table-bordered']//tr)[2]//td)[2]");
    String totalPriceInCartPanelString;
    By lCartPanel = By.cssSelector("ul.dropdown-menu.pull-right");
    By lCart = By.cssSelector("#cart button");
    By lIpodClassicNameInWishList = By.xpath("//a[text()='iPod Classic']");
    String ipodClassicNameInWishList;

    By lMyAccountEndPage=By.xpath("//ul[@class='list-unstyled']//a[text()='My Account']");
    By lEditAccount=By.xpath("//ul[@class='list-unstyled']//a[text()='Edit Account']");
    By lFirstName=By.cssSelector("input[name='firstname']");
    By lLastName= By.cssSelector("input[name='lastname']");
    By lPhoneNumber=By.cssSelector("input[name='telephone']");
    By lContinueSubmitInEditAccount=By.cssSelector("input[type='submit']");
    By lNotificate=By.cssSelector("div[class='alert alert-success alert-dismissible']");

    By lAdressBook=By.xpath("//ul[@class='list-unstyled']//a[text()='Address Book']");
    By lNewAdressButton=By.xpath("//a[text()='New Address']");

    By lFirstNameInNewAddress=By.cssSelector("input[name='firstname']");
    By lLastNameInNewAddress=By.cssSelector("input[name='lastname']");
    By lAddress1InNewAddress=By.cssSelector("input[name='address_1']");
    By lCityInNewAddress=By.cssSelector("input[name='city']");
    By lPostCodeInNewAddress=By.cssSelector("input[name='postcode']");
    By lCountrySelectInNewAddress=By.cssSelector("select[name='country_id']");
    By lRegionSelectInNewAddress=By.cssSelector("select[name='zone_id']");
    By lContinueButtonInNewAddress=By.cssSelector("input[type='submit']");
    By lSelectTurkey=By.xpath("//option[text()='Turkey']");
    By lSelectIstanbul=By.xpath("//option[text()='İstanbul']");
    By lNotificatioForNewAddress=By.cssSelector("div[class='alert alert-success alert-dismissible']");

    By lEditInAddressBook=By.xpath("(//a[text()='Edit'])[1]");
    By lGoToShoppingCart=By.xpath("//a[@title='Shopping Cart']");
    By lCheckoutForBuyProduct=By.xpath("//a[text()='Checkout']");
    By lContinueButton1ForBuyProduct=By.cssSelector("input[value='Continue']");
    By lContinueButton2ForBuyProduct=By.xpath("(//input[@value='Continue'])[2]");
    By lContinueButton3ForBuyProduct=By.xpath("(//input[@value='Continue'])[3]");
    By lChechBoxButtonForBuyProduct=By.xpath("//input[@type='checkbox']");
    By lContinueButton4ForBuyProduct=By.xpath("(//input[@value='Continue'])[4]");
    By lConfirmOrderButtonForBuyProduct=By.xpath("//input[@value='Confirm Order']");

    By lNotificateforBuyProduct=By.xpath("//h1[text()='Your order has been placed!']");
    By lLastContinueForBuyProduct=By.xpath("//a[text()='Continue']");

    By lOrderHistoryEndPage=By.xpath("//ul[@class='list-unstyled']//a[text()='Order History']");
    By lViewIOrderHistory=By.xpath("(//a[@data-original-title='View'])[1]");

    By lIphoneNameInHistory=By.xpath("//td[contains(text(),'iPhone')]");
    String iphoneNameInHistoryString;
    By lMacBookNameInHistory=By.xpath("//td[contains(text(),'MacBook')]");
    String macBookNameInHistoryString;
    By lLogoutInOrderHistory=By.xpath("//div[@class='list-group']//a[text()='Logout']");

    By lDeletePtoductFromCart=By.cssSelector("button[title='Remove']");




    Criteria2 criteria2=new Criteria2();

     public void login(String username, String password, int status){
         openSite("https://opencart.abstracta.us/index.php?route=account/login");
         sendKeysTo(lUsername,username);
         sendKeysTo(lPassword,password);
         clickTo(lLoginSubmit);

         if (status==0)
             verifyTextIn(lWarning,"Warning");
         else {
             waitFor(lLogout, WaitConditions.exist);
         }
     }

     public void logout(){
         waitFor(lMyAccount,WaitConditions.clickable);
         clickTo(lMyAccount);
         waitFor(lLogout,WaitConditions.clickable);
         clickTo(lLogout);
         waitFor(lLogin,WaitConditions.exist);
     }

     public void addToWish(){
         clickTo(lIpodClassicAddToWish);
         ipodClassicNameString=driver.findElement(lIpodClassicName1).getText();
         clickTo(lGotoWishListButton);
         ipodClassicNameInWishList=driver.findElement(lIpodClassicNameInWishList).getText();

         Assert.assertEquals(ipodClassicNameString,ipodClassicNameInWishList);

     }

    public void assertProductsTotalPrice(){
        clickTo(lContinue);
        //waitFor(lproduct1,WaitConditions.visible);
        scrollLocator(lproduct1);
        product1NameString=driver.findElement(lProduct1Name).getText();
        product2NameString=driver.findElement(lProduct2Name).getText();

        product1PriceString=driver.findElement(lProduct1Price).getText();
        product2PriceString=driver.findElement(lProduct2Price).getText();

        double product1PriceDouble=criteria2.getPriceAsNumber(product1PriceString);
        double product2PriceDouble=criteria2.getPriceAsNumber(product2PriceString);
        double expectedTotalPrice=product1PriceDouble+product2PriceDouble;


        clickTo(lproduct1);
        clickTo(lProduct2);
        scrollLocator(lCart);
        clickTo(lMyAccount);

        clickTo(lCart);

        totalPriceInCartPanelString=driver.findElement(lTotalPriceInCartPanelforAuthorized).getText();


        double totalPriceInCartPanelDouble=criteria2.getPriceAsNumber(totalPriceInCartPanelString);

        verifyTextIn(lCartPanel,product1NameString);
        verifyTextIn(lCartPanel,product2NameString);

        Assert.assertEquals(expectedTotalPrice,totalPriceInCartPanelDouble);
    }

    public void updateAccountInfo(String firstName, String lastName, String telephon){
         scrollLocator(lMyAccountEndPage);
         clickTo(lMyAccountEndPage);
         clickTo(lEditAccount);
         sendKeysTo(lFirstName,firstName);
         sendKeysTo(lLastName,lastName);
         sendKeysTo(lPhoneNumber,telephon);
         clickTo(lContinueSubmitInEditAccount);
         Assert.assertTrue(driver.findElement(lNotificate).getText().contains("Success"));
    }


    public void addNewAddress(String firstName, String lastName, String address1, String city, String postCode){
         clickTo(lAdressBook);
         clickTo(lNewAdressButton);
         sendKeysTo(lFirstNameInNewAddress,firstName);
         sendKeysTo(lLastNameInNewAddress,lastName);
         sendKeysTo(lAddress1InNewAddress,address1);
         sendKeysTo(lCityInNewAddress,city);
         sendKeysTo(lPostCodeInNewAddress,postCode);
         scrollLocator(lContinueButtonInNewAddress);
         clickTo(lCountrySelectInNewAddress);
         clickTo(lSelectTurkey);
         clickTo(lRegionSelectInNewAddress);
         clickTo(lSelectIstanbul);
         clickTo(lContinueButtonInNewAddress);

         Assert.assertTrue(driver.findElement(lNotificatioForNewAddress).getText().contains("successfully"));
    }

    public void updateAddress(String newAddress){
         clickTo(lEditInAddressBook);
         sendKeysTo(lAddress1InNewAddress,newAddress);
         scrollLocator(lContinueButtonInNewAddress);
        clickTo(lCountrySelectInNewAddress);
        clickTo(lSelectTurkey);
        clickTo(lRegionSelectInNewAddress);
        clickTo(lSelectIstanbul);
        clickTo(lContinueButtonInNewAddress);
        Assert.assertTrue(driver.findElement(lNotificatioForNewAddress).getText().contains("successfully"));
    }

    public void buyProduct(){
         clickTo(lGoToShoppingCart);
         scrollLocator(lCheckoutForBuyProduct);
         clickTo(lCheckoutForBuyProduct);
         clickTo(lContinueButton1ForBuyProduct);
         clickTo(lContinueButton2ForBuyProduct);
         clickTo(lContinueButton3ForBuyProduct);
        waitFor(lCheckoutForBuyProduct,WaitConditions.clickable);
         clickTo(lChechBoxButtonForBuyProduct);
         clickTo(lContinueButton4ForBuyProduct);
        waitFor(lConfirmOrderButtonForBuyProduct,WaitConditions.clickable);
         //scrollLocator(lConfirmOrderButtonForBuyProduct);
         clickTo(lConfirmOrderButtonForBuyProduct);
        waitFor(lNotificateforBuyProduct,WaitConditions.exist);
         Assert.assertTrue(driver.findElement(lNotificateforBuyProduct).getText().contains("Your order has been placed"));
         waitFor(lLastContinueForBuyProduct,WaitConditions.clickable);
         clickTo(lLastContinueForBuyProduct);
    }

    public void orderHistory(){
         scrollLocator(lOrderHistoryEndPage);
         clickTo(lOrderHistoryEndPage);
         waitFor(lViewIOrderHistory,WaitConditions.clickable);
         clickTo(lViewIOrderHistory);
         scrollLocator(lIphoneNameInHistory);
         iphoneNameInHistoryString=driver.findElement(lIphoneNameInHistory).getText();
         macBookNameInHistoryString=driver.findElement(lMacBookNameInHistory).getText();

         Assert.assertEquals(product1NameString,macBookNameInHistoryString);
    }

    public void orderHistorySecondProduct(){
        Assert.assertEquals(product2NameString,iphoneNameInHistoryString);
    }

    public void removeProductFromCart(){
         clickTo(lCart);
         while (driver.findElements(lDeletePtoductFromCart).size()>0){
             clickTo(driver.findElements(lDeletePtoductFromCart).get(0));
             clickTo(lCart);
         }
    }



}
