package testpackages;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass1_Yetkisiz extends BaseClass {

    Criteria1 criteria1=new Criteria1();
    Criteria2 criteria2=new Criteria2();


    @Test()
    public void test3_choseProduct(){
        criteria2.choseProductAndAddCart();
    }

    @Test(priority = 1)
    public void test4_choseProductAgain(){
        criteria2.choseProductAndAddCartAgain();
    }

    @Test(priority = 2)
    public void test5_changeQuantity(){
        criteria2.changeQuantity();
    }

    @Test(priority = 3)
    public void test6_deleteProductfromCart(){
        criteria2.deleteProductFromCart();
    }

    @Test(priority = 4)
    public void test7_assertProductsAndTotalPrice(){
        criteria2.assertProductsTotalPrice();
    }

    @Test(priority = 5)
    public void test8_unauthorized(){
        criteria2.unauthorized();
    }

    @Test(priority = 6)
    public void test9_selectSort(){
        criteria2.searchProductAndSelect();
    }

    @Test(priority = 7)
    public void test10_sendMessage(){
        criteria2.sendMessage();
    }
}
