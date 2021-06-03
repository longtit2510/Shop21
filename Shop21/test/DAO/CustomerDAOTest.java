/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Snowyy
 */
public class CustomerDAOTest {

    public CustomerDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Rollback rb = new Rollback();
        rb.RollbackCustomer();
    }

    @After
    public void tearDown() {
        Rollback rb = new Rollback();
        rb.RollbackCustomer();
    }

    @Test
    public void testGetAllCustomer() {
        System.out.println("getAllCustomer");
        CustomerDAO instance = new CustomerDAO();
        int expResult = 3;
        List<Customer> result = instance.getAllCustomer();
        assertEquals(expResult, result.size());
    }

    @Test
    public void testCreateCustomer() {
        System.out.println("createCustomer");
        String name = "long";
        String phone = "234102031";
        String address = "duong noi";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "them moi thanh cong";
        String result = instance.createCustomer(name, phone, address, certificate);
        Customer cus1 = instance.findCustomerLast();
        Customer cus = new Customer(cus1.getId(), name, phone, address, certificate);
        assertEquals(expResult, result);
        assertEquals(cus1, cus);
    }


    @Test
    public void testCreateCustomerNullName() {
        CustomerDAO instance = new CustomerDAO();
        Customer cus = instance.findCustomerLast();
        System.out.println("createCustomer");
        String name = "";
        String phone = "234102031";
        String address = "duong noi";
        String certificate = "3912048901";
        String expResult = "Khong de trong ten";
        String result = instance.createCustomer(name, phone, address, certificate);
        Customer cus1 = instance.findCustomerLast();
        assertEquals(expResult, result);
        assertEquals(cus1,cus);
    }

    @Test
    public void testCreateCustomerNullPhone() {
        CustomerDAO instance = new CustomerDAO();
        Customer cus = instance.findCustomerLast();
        System.out.println("createCustomer");
        String name = "long";
        String phone = "";
        String address = "duong noi";
        String certificate = "3912048901";
        String expResult = "Khong de trong sdt";
        String result = instance.createCustomer(name, phone, address, certificate);
        Customer cus1 = instance.findCustomerLast();
        assertEquals(expResult, result);
        assertEquals(cus1,cus);
    }

    @Test
    public void testCreateCustomerNullAddress() {
        CustomerDAO instance = new CustomerDAO();
        Customer cus = instance.findCustomerLast();
        System.out.println("createCustomer");
        String name = "long";
        String phone = "234102031";
        String address = "";
        String certificate = "3912048901";
        String expResult = "Khong de trong dia chi";
        String result = instance.createCustomer(name, phone, address, certificate);
        Customer cus1 = instance.findCustomerLast();
        assertEquals(expResult, result);
        assertEquals(cus1,cus);
    }

    @Test
    public void testCreateCustomerNullCertificate() {
        CustomerDAO instance = new CustomerDAO();
        Customer cus = instance.findCustomerLast();
        System.out.println("createCustomer");
        String name = "long";
        String phone = "234102031";
        String address = "duong noi";
        String certificate = "";
        String expResult = "Khong de trong cmnd";
        String result = instance.createCustomer(name, phone, address, certificate);
        Customer cus1 = instance.findCustomerLast();
        assertEquals(expResult, result);
        assertEquals(cus1,cus);
    }

    @Test
    public void testUpdateCustomerSuccess() {
        CustomerDAO instance = new CustomerDAO();
        Customer cus1 = instance.findCustomerById("1");
        System.out.println("updateCustomer");
        String id = "1";
        String name = "chiu1";
        String phone = "234102031";
        String address = "duong noi1";
        String certificate = "3912048901";
        String expResult = "cap nhat thanh cong";
        String result = instance.updateCustomer(id, name, phone, address, certificate);
        Customer cus = new Customer(cus1.getId(), name, phone, address, certificate);
        Customer cus2 = instance.findCustomerById(id);
        assertEquals(expResult, result);
        assertNotEquals(cus1, cus);
        assertEquals(cus2,cus);
    }


    @Test
    public void testDeleteCustomerSuccess() {
        CustomerDAO instance = new CustomerDAO();
        System.out.println("deleteCustomer");
        String id = "3";
        Customer cus = null;
        int i = instance.getAllCustomer().size();
        String expResult = "Xoa thanh cong";
        String result = instance.deleteCustomer(id);
        Customer cus1 = instance.findCustomerById(id);
        int j = instance.getAllCustomer().size();
        assertEquals(expResult, result);
        assertEquals(cus1,cus);
        assertNotEquals(j,i);
    }

    @Test
    public void testDeleteCustomerFailed() {
        CustomerDAO instance = new CustomerDAO();
        int i = instance.getAllCustomer().size();
        System.out.println("deleteCustomer");
        String id = "5";
        String expResult = "Xoa that bai";
        String result = instance.deleteCustomer(id);
        int j = instance.getAllCustomer().size();
        assertEquals(expResult, result);
        assertEquals(i,j);
    }

    @Test
    public void testFindCustomerByIdSuccess() {
        System.out.println("findCustomerById");
        String id = "3";
        CustomerDAO instance = new CustomerDAO();
        Customer expResult = new Customer(3, "ha", "034219222", "ha noi", "32341421");
        Customer result = instance.findCustomerById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindCustomerByIdFailed() {
        System.out.println("findCustomerById");
        String id = "5";
        CustomerDAO instance = new CustomerDAO();
        Customer expResult = new Customer();
        expResult = null;
        Customer result = instance.findCustomerById(id);
        assertEquals(expResult, result);
    }

    private void assertnotEquals(int j, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
