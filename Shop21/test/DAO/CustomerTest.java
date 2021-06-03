/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.CustomerDAO;
import Model.Customer;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
//11 test
public class CustomerTest {
    
    @Test
    public void testGetAllCustomer() {
        System.out.println("getAllCustomer");
        CustomerDAO instance = new CustomerDAO();
        int expResult = 11;
        List<Customer> result = instance.getAllCustomer();
        assertEquals(expResult, result.size());
    }

    @Test
    public void testCreateCustomerSuccess() {
        System.out.println("createCustomer");
        String name = "long";
        String phone = "234102031";
        String address = "duong noi";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "them moi thanh cong";
        String result = instance.createCustomer(name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateCustomerFailed() {
        System.out.println("createCustomer");
        String name = "long";
        String phone = "234102031";
        String address = "duong noi";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "them moi that bai";
        String result = instance.createCustomer(name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateCustomerNullName() {
        System.out.println("createCustomer");
        String name = "";
        String phone = "234102031";
        String address = "duong noi";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong ten";
        String result = instance.createCustomer(name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateCustomerNullPhone() {
        System.out.println("createCustomer");
        String name = "long";
        String phone = "";
        String address = "duong noi";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong sdt";
        String result = instance.createCustomer(name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateCustomerNullAddress() {
        System.out.println("createCustomer");
        String name = "long";
        String phone = "234102031";
        String address = "";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong dia chi";
        String result = instance.createCustomer(name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    @Test
    public void testCreateCustomerNullCertificate() {
        System.out.println("createCustomer");
        String name = "long";
        String phone = "234102031";
        String address = "duong noi";
        String certificate = "";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong cmnd";
        String result = instance.createCustomer(name, phone, address, certificate);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        String id = "8";
        String name = "chiu1";
        String phone = "234102031";
        String address = "duong noi1";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "cap nhat thanh cong";
        String result = instance.updateCustomer(id, name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    public void testUpdateCustomerByNameFailed() {
        System.out.println("updateCustomer");
        String id = "8";
        String name = "";
        String phone = "234102031";
        String address = "duong noi1";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong ten";
        String result = instance.updateCustomer(id, name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    public void testUpdateCustomerByPhoneFailed() {
        System.out.println("updateCustomer");
        String id = "8";
        String name = "linh";
        String phone = "";
        String address = "duong noi1";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong sdt";
        String result = instance.updateCustomer(id, name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    public void testUpdateCustomerByAddressFailed() {
        System.out.println("updateCustomer");
        String id = "8";
        String name = "linh";
        String phone = "0375424";
        String address = "";
        String certificate = "3912048901";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong dia chi";
        String result = instance.updateCustomer(id, name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    public void testUpdateCustomerByCertificateFailed() {
        System.out.println("updateCustomer");
        String id = "8";
        String name = "linh";
        String phone = "03547857";
        String address = "duong noi1";
        String certificate = "";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Khong de trong cmnd";
        String result = instance.updateCustomer(id, name, phone, address, certificate);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        String id = "3";
        CustomerDAO instance = new CustomerDAO();
        String expResult = "Xoa thanh cong";
        String result = instance.deleteCustomer(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindCustomerByIdSuccess() {
        System.out.println("findCustomerById");
        String id = "3";
        CustomerDAO instance = new CustomerDAO();
        Customer expResult = new Customer(3,"minh","0432569421","dan phuong","32140292");
        Customer result = instance.findCustomerById(id);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindCustomerByIdFailed() {
        System.out.println("findCustomerById");
        String id = "4";
        CustomerDAO instance = new CustomerDAO();
        Customer expResult = new Customer(3,"minh","0432569421","dan phuong","32140292");
        Customer result = instance.findCustomerById(id);
        assertEquals(expResult, result);
    }
    
}
