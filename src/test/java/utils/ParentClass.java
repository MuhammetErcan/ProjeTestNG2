package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class ParentClass {

    protected    WebDriver driver;
    protected    WebDriverWait wait;

    public ParentClass(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openSite(String url){
        driver.get(url);
    }

    public void clickTo(By locater){
        wait.until(ExpectedConditions.elementToBeClickable(locater)).click();
    }

    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendKeysTo(By locater, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locater)).sendKeys(text);
    }


    public void waitFor(By locater, WaitConditions waitConditions){
        switch (waitConditions){
            case exist:
                wait.until(ExpectedConditions.presenceOfElementLocated(locater));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locater));
                break;
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
                break;
        }
    }

    public boolean isExist(By locator){
        return driver.findElements(locator).size()>0;
    }

    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void scrollLocator(By locator){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }

    public void verifyTextIn(By locator, String str){
        WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(warning.getText().toLowerCase().contains(str.toLowerCase()));
    }

    public void clickTextInSelect(By locator, String text){
        WebElement selectButton=driver.findElement(locator);
        Select select =new Select(selectButton);
        List<WebElement> list=select.getOptions();
        for (WebElement element:list) {
            if (element.getText().contains(text)){
                element.click();
                break;
            }
        }
    }


}