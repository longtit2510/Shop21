/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Order;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Snowyy
 */
public class OrderDAOTest {
    
    public OrderDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        Rollback rb = new Rollback();
        rb.RollbackOrder();
    }

    @After
    public void tearDown() {
        Rollback rb = new Rollback();
        rb.RollbackOrder();
    }

    @Test
    public void testGetAllOrder() {
        System.out.println("getAllOrder");
        OrderDAO instance = new OrderDAO();
        int expResult = 4;
        List<Order> result = instance.getAllOrder();
        assertEquals(expResult, result.size());
    }

    @Test
    public void testCreateOrderSuccess() {
        System.out.println("createOrder");
        String id_customer = "1";
        String totalprice = "3000000";
        String startDate = "2021-09-02";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        String expResult = "them moi thanh cong";
        int i = instance.getAllOrder().size();
        String result = instance.createOrder(id_customer, totalprice, startDate, status);
        int j = instance.getAllOrder().size();
        assertEquals(expResult, result);
        assertNotEquals(i,j);
    }
    @Test
    public void testCreateOrderNullIDCustomer() {
        System.out.println("createOrder");
        String id_customer = "";
        String totalprice = "3000000";
        String startDate = "2021-09-02";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        String expResult = "Khong de trong id khach hang";
        int i = instance.getAllOrder().size();
        String result = instance.createOrder(id_customer, totalprice, startDate, status);
        int j = instance.getAllOrder().size();
        assertEquals(expResult, result);
        assertEquals(i,j);
    }
    @Test
    public void testCreateOrderNullTotalprice() {
        System.out.println("createOrder");
        String id_customer = "1";
        String totalprice = "";
        String startDate = "2021-09-02";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        String expResult = "Khong de trong tong gia tien";
        int i = instance.getAllOrder().size();
        String result = instance.createOrder(id_customer, totalprice, startDate, status);
        int j = instance.getAllOrder().size();
        assertEquals(expResult, result);
        assertEquals(i,j);
    }
    @Test
    public void testCreateOrderNullStartDate() {
        System.out.println("createOrder");
        String id_customer = "1";
        String totalprice = "3000000";
        String startDate = "";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        String expResult = "Khong de trong ngay khoi tao don hang";
        int i = instance.getAllOrder().size();
        String result = instance.createOrder(id_customer, totalprice, startDate, status);
        int j = instance.getAllOrder().size();
        assertEquals(expResult, result);
        assertEquals(i,j);
    }
    @Test
    public void testCreateOrderNullStatus() {
        System.out.println("createOrder");
        String id_customer = "1";
        String totalprice = "3000000";
        String startDate = "2021-09-02";
        String status = "";
        OrderDAO instance = new OrderDAO();
        String expResult = "Khong de trong trang thai don hang";
        int i = instance.getAllOrder().size();
        String result = instance.createOrder(id_customer, totalprice, startDate, status);
        int j = instance.getAllOrder().size();
        assertEquals(expResult, result);
        assertEquals(i,j);
    }

    @Test
    public void testUpdateorderSuccess() {
        System.out.println("updateorder");
        String id = "1";
        String id_customer = "1";
        String totalprice = "2000000";
        String startDate = "2022-01-02";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        String expResult = "cap nhat thanh cong";
        String result = instance.updateorder(id, id_customer, totalprice, startDate, status);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateorderNullID() {
        OrderDAO instance = new OrderDAO();
        List<Order> ord = instance.findOrderDetailbyIDCustomer("1");
        System.out.println("updateorder");
        String id = "";
        String id_customer = "1";
        String totalprice = "2000000";
        String startDate = "2022-01-02";
        String status = "chua giao";
        String expResult = "Khong de trong id don hang";
        String result = instance.updateorder(id, id_customer, totalprice, startDate, status);
        List<Order> ord1 = instance.findOrderDetailbyIDCustomer("1");
        assertEquals(expResult, result);
        assertEquals(ord.size(),ord1.size());
    }
    @Test
    public void testUpdateorderNullIDCustomer() {
        System.out.println("updateorder");
        String id = "1";
        String id_customer = "";
        String totalprice = "2000000";
        String startDate = "2022-01-02";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        String expResult = "Khong de trong id khach hang";
        String result = instance.updateorder(id, id_customer, totalprice, startDate, status);
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateorderNullTotalprice() {
        System.out.println("updateorder");
        String id = "1";
        String id_customer = "1";
        String totalprice = "";
        String startDate = "2022-01-02";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        Order ord = instance.findOrderbyID("1");
        String expResult = "Khong de trong tong gia tien";
        String result = instance.updateorder(id, id_customer, totalprice, startDate, status);
        Order ord1 = instance.findOrderbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord,ord1);
    }
    @Test
    public void testUpdateorderNullStartDate() {
        System.out.println("updateorder");
        String id = "1";
        String id_customer = "1";
        String totalprice = "2000000";
        String startDate = "";
        String status = "chua giao";
        OrderDAO instance = new OrderDAO();
        Order ord = instance.findOrderbyID("1");
        String expResult = "Khong de trong ngay khoi tao don hang";
        String result = instance.updateorder(id, id_customer, totalprice, startDate, status);
        Order ord1 = instance.findOrderbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord,ord1);
    }
    @Test
    public void testUpdateorderNullStatus() {
        System.out.println("updateorder");
        String id = "1";
        String id_customer = "1";
        String totalprice = "2000000";
        String startDate = "2022-01-02";
        String status = "";
        OrderDAO instance = new OrderDAO();
        Order ord = instance.findOrderbyID("1");
        String expResult = "Khong de trong trang thai don hang";
        String result = instance.updateorder(id, id_customer, totalprice, startDate, status);
        Order ord1 = instance.findOrderbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord,ord1);
    }
    

    @Test
    public void testDeleteOrderSuccess() {
        System.out.println("deleteOrder");
        String id = "1";
        OrderDAO instance = new OrderDAO();
        String expResult = "Xoa thanh cong";
        int i = instance.getAllOrder().size();
        String result = instance.deleteOrder(id);
        int j = instance.getAllOrder().size();
        assertEquals(expResult, result);
        assertNotEquals(i,j);
    }
    @Test
    public void testDeleteOrderFailed() {
        System.out.println("deleteOrder");
        String id = "10";
        OrderDAO instance = new OrderDAO();
        String expResult = "Xoa that bai";
        int i = instance.getAllOrder().size();
        String result = instance.deleteOrder(id);
        int j = instance.getAllOrder().size();
        assertEquals(expResult, result);
        assertEquals(i,j);
    }

    @Test
    public void testFindOrderbyIDSuccess() {
        System.out.println("findOrderbyID");
        String id = "1";
        OrderDAO instance = new OrderDAO();
        Order expResult = new Order("1","1","8000000","2021-11-30","chua giao");
        Order result = instance.findOrderbyID(id);
        assertEquals(expResult, result);
    }
    @Test
    public void testFindOrderbyIDFailed() {
        System.out.println("findOrderbyID");
        String id = "7";
        OrderDAO instance = new OrderDAO();
        Order expResult = new Order();
        expResult = null;
        Order result = instance.findOrderbyID(id);
        assertEquals(expResult, result);
    }
    
}
