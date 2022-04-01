package testpackages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.Driver;

public class BaseClass {

    @BeforeSuite
    public void beforetest(){

    }


    @AfterSuite
    public void afterSuite(){
        Driver.quitDriver();
    }

}
