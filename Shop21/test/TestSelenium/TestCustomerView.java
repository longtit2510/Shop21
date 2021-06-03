/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSelenium;

/**
 *
 * @author Snowyy
 */
import DAO.Rollback;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCustomerView {

    public TestCustomerView() {
    }
    private static WebDriver wd = null;
    @BeforeClass
    public static void setUpClass() {
        Rollback rb = new Rollback();
        rb.RollbackCustomer();
        System.setProperty("webdriver.chrome.driver", "D:\\logo\\nam 4 ky 2\\SQA\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("http://localhost:8080/Shop21/Customer");
    }
    @After
    public void tearDown() {
        Rollback rb = new Rollback();
        rb.RollbackCustomer();
    }
    //TEST THEM KHACH HANG MOI      
    @Test
    public void TestCreateCus() throws InterruptedException {
        WebElement btnadd = wd.findElement(By.id("btnaddcus"));
        btnadd.click();
        WebElement btnadd2 = wd.findElement(By.id("addbtn2"));
        WebElement addname = wd.findElement(By.id("name"));
        WebElement addphone = wd.findElement(By.id("phone"));
        WebElement addaddress = wd.findElement(By.id("address"));
        WebElement addcertificate = wd.findElement(By.id("certificate"));
        Thread.sleep(4000);
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnadd2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestCreateCusNullName() throws InterruptedException {
        WebElement btnadd = wd.findElement(By.id("btnaddcus"));
        btnadd.click();
        WebElement btnadd2 = wd.findElement(By.id("addbtn2"));
        WebElement addname = wd.findElement(By.id("name"));
        WebElement addphone = wd.findElement(By.id("phone"));
        WebElement addaddress = wd.findElement(By.id("address"));
        WebElement addcertificate = wd.findElement(By.id("certificate"));
        Thread.sleep(4000);
        addname.sendKeys("");
        Thread.sleep(1000);
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnadd2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestCreateCusNullPhone() throws InterruptedException {
        WebElement btnadd = wd.findElement(By.id("btnaddcus"));
        btnadd.click();
        WebElement btnadd2 = wd.findElement(By.id("addbtn2"));
        WebElement addname = wd.findElement(By.id("name"));
        WebElement addphone = wd.findElement(By.id("phone"));
        WebElement addaddress = wd.findElement(By.id("address"));
        WebElement addcertificate = wd.findElement(By.id("certificate"));
        Thread.sleep(4000);
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.sendKeys("");
        Thread.sleep(1000);
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnadd2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestCreateCusNullAddress() throws InterruptedException {
        WebElement btnadd = wd.findElement(By.id("btnaddcus"));
        btnadd.click();
        WebElement btnadd2 = wd.findElement(By.id("addbtn2"));
        WebElement addname = wd.findElement(By.id("name"));
        WebElement addphone = wd.findElement(By.id("phone"));
        WebElement addaddress = wd.findElement(By.id("address"));
        WebElement addcertificate = wd.findElement(By.id("certificate"));
        Thread.sleep(4000);
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.sendKeys("");
        Thread.sleep(1000);
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnadd2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestCreateCusNullCertificate() throws InterruptedException {
        WebElement btnadd = wd.findElement(By.id("btnaddcus"));
        btnadd.click();
        WebElement btnadd2 = wd.findElement(By.id("addbtn2"));
        WebElement addname = wd.findElement(By.id("name"));
        WebElement addphone = wd.findElement(By.id("phone"));
        WebElement addaddress = wd.findElement(By.id("address"));
        WebElement addcertificate = wd.findElement(By.id("certificate"));
        Thread.sleep(4000);
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.sendKeys("");
        Thread.sleep(1000);
        btnadd2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    //TEST SUA KHACH HANG
    @Test
    public void TestUpdateCustomer() throws InterruptedException {
        WebElement btnsua = wd.findElement(By.id("btnsua"));
        btnsua.click();
        WebElement btnsua2 = wd.findElement(By.id("btnsua2"));
        WebElement addname = wd.findElement(By.id("nameedit"));
        WebElement addphone = wd.findElement(By.id("phoneedit"));
        WebElement addaddress = wd.findElement(By.id("addressedit"));
        WebElement addcertificate = wd.findElement(By.id("certificateedit"));
        Thread.sleep(4000);
        addname.clear();
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.clear();
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.clear();
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.clear();
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnsua2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestUpdateCustomerNullName() throws InterruptedException {
        WebElement btnsua = wd.findElement(By.id("btnsua"));
        btnsua.click();
        WebElement btnsua2 = wd.findElement(By.id("btnsua2"));
        WebElement addname = wd.findElement(By.id("nameedit"));
        WebElement addphone = wd.findElement(By.id("phoneedit"));
        WebElement addaddress = wd.findElement(By.id("addressedit"));
        WebElement addcertificate = wd.findElement(By.id("certificateedit"));
        Thread.sleep(4000);
        addname.clear();
        addname.sendKeys("");
        Thread.sleep(1000);
        addphone.clear();
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.clear();
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.clear();
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnsua2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestUpdateCustomerNullPhone() throws InterruptedException {
        WebElement btnsua = wd.findElement(By.id("btnsua"));
        btnsua.click();
        WebElement btnsua2 = wd.findElement(By.id("btnsua2"));
        WebElement addname = wd.findElement(By.id("nameedit"));
        WebElement addphone = wd.findElement(By.id("phoneedit"));
        WebElement addaddress = wd.findElement(By.id("addressedit"));
        WebElement addcertificate = wd.findElement(By.id("certificateedit"));
        Thread.sleep(4000);
        addname.clear();
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.clear();
        addphone.sendKeys("");
        Thread.sleep(1000);
        addaddress.clear();
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.clear();
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnsua2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestUpdateCustomerNullAddress() throws InterruptedException {
        WebElement btnsua = wd.findElement(By.id("btnsua"));
        btnsua.click();
        WebElement btnsua2 = wd.findElement(By.id("btnsua2"));
        WebElement addname = wd.findElement(By.id("nameedit"));
        WebElement addphone = wd.findElement(By.id("phoneedit"));
        WebElement addaddress = wd.findElement(By.id("addressedit"));
        WebElement addcertificate = wd.findElement(By.id("certificateedit"));
        Thread.sleep(4000);
        addname.clear();
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.clear();
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.clear();
        addaddress.sendKeys("");
        Thread.sleep(1000);
        addcertificate.clear();
        addcertificate.sendKeys("123456");
        Thread.sleep(1000);
        btnsua2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    @Test
    public void TestUpdateCustomerNullCertificate() throws InterruptedException {
        WebElement btnsua = wd.findElement(By.id("btnsua"));
        btnsua.click();
        WebElement btnsua2 = wd.findElement(By.id("btnsua2"));
        WebElement addname = wd.findElement(By.id("nameedit"));
        WebElement addphone = wd.findElement(By.id("phoneedit"));
        WebElement addaddress = wd.findElement(By.id("addressedit"));
        WebElement addcertificate = wd.findElement(By.id("certificateedit"));
        Thread.sleep(4000);
        addname.clear();
        addname.sendKeys("tu gay");
        Thread.sleep(1000);
        addphone.clear();
        addphone.sendKeys("0869575849");
        Thread.sleep(1000);
        addaddress.clear();
        addaddress.sendKeys("la ca");
        Thread.sleep(1000);
        addcertificate.clear();
        addcertificate.sendKeys("");
        Thread.sleep(1000);
        btnsua2.click();
        Thread.sleep(2000);
        wd.navigate().refresh();
    }

    //TEST XOA KHACH HANG
    @Test
    public void TestDeleteCustomer() throws InterruptedException {
        WebElement btnxoa = wd.findElement(By.id("btnxoa"));
        btnxoa.click();
        Thread.sleep(4000);
        WebElement btnconfirm = wd.findElement(By.id("btnconfirmxoa"));
        btnconfirm.click();
    }
}
