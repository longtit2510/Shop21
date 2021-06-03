/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.OrderDetail;
import java.util.ArrayList;
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
public class OrderDetailDAOTest {

    public OrderDetailDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Rollback rb = new Rollback();
        rb.RollbackOrderDetail();
    }

    @After
    public void tearDown() {
        Rollback rb = new Rollback();
        rb.RollbackOrderDetail();
    }

    @Test
    public void testGetAllOrderDetailSuccess() {
        System.out.println("getAllOrderDetail");
        OrderDetailDAO instance = new OrderDetailDAO();
        int expResult = 7;
        List<OrderDetail> result = instance.getAllOrderDetail();
        assertEquals(expResult, result.size());
    }

    @Test
    public void testCreateOrderDetailSuccess() {
        System.out.println("createOrderDetail");
        int oid = 8;
        int pid = 8;
        String pname = "Vans";
        String dongia = "5000000.0";
        int quantity = 2;
        OrderDetailDAO instance = new OrderDetailDAO();
        String expResult = "them moi thanh cong";
        String result = instance.createOrderDetail(oid, pid, pname, dongia, quantity);
        OrderDetail ord = instance.findOrderDetailLast();
        OrderDetail ord1 = new OrderDetail(ord.getId(), oid, pid, pname, dongia, quantity);
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testCreateOrderDetailNullOID() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailLast();
        System.out.println("createOrderDetail");
        int oid = 0;
        int pid = 8;
        String pname = "Vans";
        String dongia = "5000000";
        int quantity = 2;
        String expResult = "Khong de trong id don hang";
        String result = instance.createOrderDetail(oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailLast();
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testCreateOrderDetailNullPID() {
        System.out.println("createOrderDetail");
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailLast();
        int oid = 8;
        int pid = 0;
        String pname = "Vans";
        String dongia = "5000000";
        int quantity = 2;
        String expResult = "Khong de trong id san pham";
        String result = instance.createOrderDetail(oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailLast();
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testCreateOrderDetailNullPName() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailLast();
        System.out.println("createOrderDetail");
        int oid = 8;
        int pid = 8;
        String pname = "";
        String dongia = "5000000";
        int quantity = 2;
        String expResult = "Khong de trong ten san pham";
        String result = instance.createOrderDetail(oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailLast();
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testCreateOrderDetailNullDongia() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailLast();
        System.out.println("createOrderDetail");
        int oid = 8;
        int pid = 8;
        String pname = "Vans";
        String dongia = "";
        int quantity = 2;
        String expResult = "Khong de trong don gia";
        String result = instance.createOrderDetail(oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailLast();
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testCreateOrderDetailNullQuantity() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailLast();
        System.out.println("createOrderDetail");
        int oid = 8;
        int pid = 8;
        String pname = "Vans";
        String dongia = "5000000";
        int quantity = 0;
        String expResult = "Khong de trong so luong";
        String result = instance.createOrderDetail(oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailLast();
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testUpdateOrderDetailSuccess() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailbyID("1");
        System.out.println("updateorderDetail");
        int id = 1;
        int oid = 1;
        int pid = 3;
        String pname = "Converse";
        String dongia = "500000.0";
        int quantity = 1;
        String expResult = "cap nhat thanh cong";
        String result = instance.updateOrderDetail(id, oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = new OrderDetail(ord.getId(), oid, pid, pname, dongia, quantity);
        OrderDetail ord2 = instance.findOrderDetailbyID("1");
        assertEquals(expResult, result);
        assertNotEquals(ord, ord1);
        assertEquals(ord2, ord1);
    }

    @Test
    public void testUpdateOrderDetailNullID() {
        OrderDetailDAO instance = new OrderDetailDAO();
        System.out.println("updateorderDetail");
        int id = 0;
        int oid = 1;
        int pid = 3;
        String pname = "Converse";
        String dongia = "500000";
        int quantity = 1;
        List<OrderDetail> lord = instance.findOrderDetailbyOID("1");
        String expResult = "Khong de trong id chi tiet don hang";
        String result = instance.updateOrderDetail(id, oid, pid, pname, dongia, quantity);
        List<OrderDetail> lord1 = instance.findOrderDetailbyOID("1");
        assertEquals(expResult, result);
        assertEquals(lord, lord1);
    }

    @Test
    public void testUpdateOrderDetailNullOID() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailbyID("1");
        System.out.println("updateorderDetail");
        int id = 1;
        int oid = 0;
        int pid = 3;
        String pname = "Converse";
        String dongia = "500000";
        int quantity = 1;
        String expResult = "Khong de trong id don hang";
        String result = instance.updateOrderDetail(id, oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testUpdateOrderDetailNullPID() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailbyID("1");
        System.out.println("updateorderDetail");
        int id = 1;
        int oid = 1;
        int pid = 0;
        String pname = "Converse";
        String dongia = "500000";
        int quantity = 1;
        String expResult = "Khong de trong id san pham";
        String result = instance.updateOrderDetail(id, oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testUpdateOrderDetailNullPName() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailbyID("1");
        System.out.println("updateorderDetail");
        int id = 1;
        int oid = 1;
        int pid = 3;
        String pname = "";
        String dongia = "500000";
        int quantity = 1;
        String expResult = "Khong de trong ten san pham";
        String result = instance.updateOrderDetail(id, oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testUpdateOrderDetailNullDongia() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailbyID("1");
        System.out.println("updateorderDetail");
        int id = 1;
        int oid = 1;
        int pid = 3;
        String pname = "Converse";
        String dongia = "";
        int quantity = 1;
        String expResult = "Khong de trong don gia";
        String result = instance.updateOrderDetail(id, oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testUpdateOrderDetailNullQuantity() {
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail ord = instance.findOrderDetailbyID("1");
        System.out.println("updateorderDetail");
        int id = 1;
        int oid = 1;
        int pid = 3;
        String pname = "Converse";
        String dongia = "500000";
        int quantity = 0;
        String expResult = "Khong de trong so luong san pham";
        String result = instance.updateOrderDetail(id, oid, pid, pname, dongia, quantity);
        OrderDetail ord1 = instance.findOrderDetailbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
    }

    @Test
    public void testDeleteOrderDetailSuccess() {
        OrderDetailDAO instance = new OrderDetailDAO();
        System.out.println("deleteOrderDetail");
        int i = instance.getAllOrderDetail().size();
        OrderDetail ord = null;
        String id = "1";
        String expResult = "Xoa thanh cong";
        String result = instance.deleteOrderDetail(id);
        int j = instance.getAllOrderDetail().size();
        OrderDetail ord1 = instance.findOrderDetailbyID("1");
        assertEquals(expResult, result);
        assertEquals(ord, ord1);
        assertNotEquals(i, j);
    }

    @Test
    public void testDeleteOrderDetailFailed() {
        System.out.println("deleteOrderDetail");
        String id = "11";
        OrderDetailDAO instance = new OrderDetailDAO();
        int i = instance.getAllOrderDetail().size();
        String expResult = "Xoa that bai";
        String result = instance.deleteOrderDetail(id);
        int j = instance.getAllOrderDetail().size();
        assertEquals(expResult, result);
        assertEquals(i, j);
    }

    @Test
    public void testFindOrderDetailbyIDSuccess() {
        System.out.println("findOrderDetailbyID");
        String id = "1";
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail expResult = new OrderDetail(1, 1, 2, "Air Jordan ", "3000000.0", 2);
        OrderDetail result = instance.findOrderDetailbyID(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOrderDetailbyIDFailed() {
        System.out.println("findOrderDetailbyID");
        String id = "11";
        OrderDetailDAO instance = new OrderDetailDAO();
        OrderDetail expResult = new OrderDetail();
        expResult = null;
        OrderDetail result = instance.findOrderDetailbyID(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOrderDetailbyOIDSuccess() {
        System.out.println("findOrderDetailbyOID");
        String id = "1";
        OrderDetailDAO instance = new OrderDetailDAO();
        int expResult = 2;
        List<OrderDetail> result = instance.findOrderDetailbyOID(id);
        assertEquals(expResult, result.size());
    }

    @Test
    public void testFindOrderDetailbyOIDFailed() {
        System.out.println("findOrderDetailbyOID");
        String id = "11";
        OrderDetailDAO instance = new OrderDetailDAO();
        List<OrderDetail> expResult = new ArrayList<OrderDetail>();
        List<OrderDetail> result = instance.findOrderDetailbyOID(id);
        assertEquals(expResult, result);
    }
}
