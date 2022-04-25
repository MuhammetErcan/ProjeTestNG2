package testpackages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.Browser;
import utils.Driver;

public class TestClass2_Yetkili extends BaseClass {

    Criteria1 criteria1=new Criteria1();
    Criteria2 criteria2=new Criteria2();


    @Test(dataProvider = "data" )
    public void test1_login(String username, String password, int status){
        criteria1.login(username,password,status);
    }



    @DataProvider(name = "data")
    public Object [][]getData(){
        Object [][] data=new Object[][]{
                {"bdorkena@github.com", "8AjXlD6", 0},
                //{"hbendb@imdb.com", "mCdonxCK2Ix", 0},
                //{"cburnhillc@stumbleupon.com", "s9KIhZYWF57", 0},
                //{"dcastelaind@timesonline.co.uk", "zEWuz4URBkP", 0},
                {"ali@gmail.com","123456",1}
        };
        return data;
    }

    @Test( priority = 1, enabled = false)
    public void test2_logout(){
        criteria1.logout();
    }

    @Test(priority = 2)
    public void test3_choseProduct(){
        criteria2.choseProductAndAddCart();
    }

    @Test(priority = 3)
    public void test4_choseProductAgain(){
        criteria2.choseProductAndAddCartAgain();
    }

    @Test(priority = 4)
    public void test5_changeQuantity(){
        criteria2.changeQuantity();
    }

    @Test(priority = 5)
    public void test6_deleteProductfromCart(){
        criteria2.deleteProductFromCart();
    }

    @Test(priority = 6)
    public void test7_assertProductsAndTotalPrice(){
        criteria1.assertProductsTotalPrice();
    }

    @Test(priority = 7)
    public void test8_selectSort(){
        criteria2.searchProductAndSelect();
    }

    @Test(priority = 8)
    public void test9_addToWishList(){
        criteria1.addToWish();
    }

    @Test(priority = 9)
    public void test10_sendMessage(){
        criteria2.sendMessage();
    }

    @Test(priority = 10)
    @Parameters({"firstName","lastName","telephone"})
    public void test11_updateAccountInfo(String firstName, String lastName, String telephone){
        criteria1.updateAccountInfo(firstName,lastName,telephone);
    }

    @Test(priority = 11)
    @Parameters({"firstName","lastName","address1","city","postCode"})
    public void test12_addNewAdress(String firstName, String lastName, String address1, String city, String postCode){
        criteria1.addNewAddress(firstName,lastName,address1,city,postCode);
    }

    @Test(priority = 12)
    public void test13_updateAddress(){
        criteria1.updateAddress("ankara");
    }

    @Test(priority = 13)
    public void test14_buyProduct(){
        criteria1.buyProduct();
    }

    @Test(priority = 14)
    public void test15_orderHistory(){
        criteria1.orderHistory();
    }

    @Test(priority = 15)
    public void test16_orderHistorySecondProduct(){
        criteria1.orderHistorySecondProduct();
    }

    @Test(priority = 16)
    public void test17_logout(){
        criteria1.logout();
    }

}
