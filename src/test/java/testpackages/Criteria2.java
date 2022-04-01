package testpackages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ParentClass;
import utils.WaitConditions;

public class Criteria2 extends ParentClass {

    By lCartPanel = By.cssSelector("ul.dropdown-menu.pull-right");
    By lchosenProductNameInCart = By.xpath("//table[@class='table table-striped']//td[2]");
    By lproduct1=By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
    By lCart = By.cssSelector("#cart button");
    By lcountProduct=By.xpath("//table[@class='table table-striped']//td[3]");
    WebElement cartPanel;
    WebElement chosenProductName;
    WebElement eProduct1;
    WebElement chosenProductSize;
    By lDeleteProduct=By.cssSelector("button[title='Remove']");
    By lViewCart=By.cssSelector("strong i[class='fa fa-shopping-cart']");
    By lInputQuantity=By.xpath("//input[contains(@name,'quantity')]");
    By lRefresh=By.cssSelector("i.fa.fa-refresh");
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
    By lCheckOut=By.xpath("//*[text()=' Checkout']");
    By lNewCustomer=By.cssSelector("div.col-sm-6 h2");
    By lSearchInput =By.cssSelector("input[name='search']");
    By lSearchButton=By.cssSelector("button[class='btn btn-default btn-lg']");
    By lSortBy=By.cssSelector("#input-sort");
    By lContact=By.cssSelector("i[class='fa fa-phone']");
    By lname=By.cssSelector("input[name='name']");
    By lEmail=By.cssSelector("input[name='email']");
    By lSubmitMessageButton=By.cssSelector("input[type='submit']");
    By lTextArea=By.cssSelector("textarea[name='enquiry']");
    By lContinueButtonforMessage=By.xpath("//a[text()='Continue']");
    By lCurrency=By.cssSelector("button[class='btn btn-link dropdown-toggle']");
    By lMyAccount=By.cssSelector("a[title='My Account']");





    public void choseProductAndAddCart(){
        openSite("https://opencart.abstracta.us/index");
        clickTo(lproduct1);
        clickTo(lCart);
        chosenProductName=driver.findElement(lchosenProductNameInCart);
        cartPanel=driver.findElement(lCartPanel);
        Assert.assertTrue(cartPanel.getText().contains(chosenProductName.getText()));
    }

    public void choseProductAndAddCartAgain(){
        eProduct1=driver.findElement(lproduct1);
        scrollElement(eProduct1);
        waitFor(lproduct1,WaitConditions.clickable);
        clickTo(lproduct1);
        clickTo(lCart);
        chosenProductSize=driver.findElement(lcountProduct);
        Assert.assertTrue(chosenProductSize.getText().contains("2"));
    }

    public void changeQuantity(){
        clickTo(lViewCart);
        clickTo(lInputQuantity);
        sendKeysTo(lInputQuantity,"3");
        clickTo(lRefresh);
        clickTo(lCart);
        WebElement chosenProductSize=driver.findElement(lcountProduct);
        Assert.assertTrue(chosenProductSize.getText().contains("3"));

    }

    public void deleteProductFromCart(){
        clickTo(lDeleteProduct);
        wait.until(ExpectedConditions.invisibilityOf(chosenProductName));
    }

    public void assertProductsTotalPrice(){
        clickTo(lContinue);
        //waitFor(lproduct1,WaitConditions.visible);
        scrollLocator(lproduct1);
        product1NameString=driver.findElement(lProduct1Name).getText();
        product2NameString=driver.findElement(lProduct2Name).getText();

        product1PriceString=driver.findElement(lProduct1Price).getText();
        product2PriceString=driver.findElement(lProduct2Price).getText();

        double product1PriceDouble=getPriceAsNumber(product1PriceString);
        double product2PriceDouble=getPriceAsNumber(product2PriceString);
        double expectedTotalPrice=product1PriceDouble+product2PriceDouble;


        clickTo(lproduct1);
        clickTo(lProduct2);
        scrollLocator(lCart);
        clickTo(lMyAccount);

        clickTo(lCart);

        totalPriceInCartPanelString=driver.findElement(lTotalPriceInCartPanelUnauthorized).getText();


        double totalPriceInCartPanelDouble=getPriceAsNumber(totalPriceInCartPanelString);

        verifyTextIn(lCartPanel,product1NameString);
        verifyTextIn(lCartPanel,product2NameString);

        Assert.assertEquals(expectedTotalPrice,totalPriceInCartPanelDouble);
    }

    public double getPriceAsNumber(String text){
        String str = text.split("\n")[0]
                .replaceAll("[^0-9]","");

        return Double.parseDouble(str)/100;
    }

    public void unauthorized(){
        clickTo(lCheckOut);
        String expected="New Customer";
        verifyTextIn(lNewCustomer,expected);
    }

    public void searchProductAndSelect(){
        openSite("https://opencart.abstracta.us/index");
        sendKeysTo(lSearchInput,"ipod");
        clickTo(lSearchButton);
        clickTextInSelect(lSortBy,"Name (A - Z)");
        waitFor(lSortBy,WaitConditions.visible);
        clickTextInSelect(lSortBy,"Price (Low > High)");

    }

    public void sendMessage(){
        openSite("https://opencart.abstracta.us/index");
        clickTo(lContact);
        scrollLocator(lSubmitMessageButton);
        sendKeysTo(lname, "Muhammet");
        sendKeysTo(lEmail,"ali@gmail.com");
        sendKeysTo(lTextArea, "merhaba merhaba merhaba");
        clickTo(lSubmitMessageButton);
        waitFor(lContinueButtonforMessage,WaitConditions.clickable);
        clickTo(lContinueButtonforMessage);
        waitFor(lCurrency,WaitConditions.exist);
    }








}
