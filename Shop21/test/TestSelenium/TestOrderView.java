/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSelenium;

import DAO.Rollback;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Snowyy
 */
public class TestOrderView {

    public void TestOrderView() {
    }
    private static WebDriver wd = null;

    @BeforeClass
    public static void setUpClass() {
        Rollback rb = new Rollback();
        rb.RollbackOrder();
        rb.RollbackOrderDetail();
        System.setProperty("webdriver.chrome.driver", "D:\\logo\\nam 4 ky 2\\SQA\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("http://localhost:8080/Shop21/Order");
    }

    @After
    public void tearDown() {
        Rollback rb = new Rollback();
        rb.RollbackOrder();
        rb.RollbackOrderDetail();
    }

    @Test
    public void TestXemChiTiet() throws InterruptedException {
        WebElement btnxemct = wd.findElement(By.id("btnxemct"));
        Thread.sleep(2000);
        btnxemct.click();
    }
}
