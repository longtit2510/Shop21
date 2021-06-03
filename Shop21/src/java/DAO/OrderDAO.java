/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDb;
import Model.Order;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Snowyy
 */
public class OrderDAO {

    ConnectDb db = new ConnectDb();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Order> getAllOrder() {
        List<Order> lorder = new ArrayList<Order>();
        String query = "SELECT * FROM [ORDER]";
        try {
            conn = db.getConnection();//ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                lorder.add(new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
        }
        return lorder;
    }

    public String createOrder(String id_customer, String totalprice, String startDate, String status) {
        String query = "INSERT INTO [Order]\n"
                + " VALUES (?,?,?,?)";
        try {
            if (id_customer.trim() == "") {
                return ("Khong de trong id khach hang");
            }
            if (totalprice.trim() == "") {
                return ("Khong de trong tong gia tien");
            }
            if (startDate.trim() == "") {
                return ("Khong de trong ngay khoi tao don hang");
            }
            if (status.trim() == "") {
                return ("Khong de trong trang thai don hang");
            }
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id_customer);
            ps.setString(2, totalprice);
            ps.setString(3, startDate);
            ps.setString(4, status);
            int count = ps.executeUpdate();
            if (count > 0) {
                return ("them moi thanh cong");
            } else {
                return ("them moi that bai");
            }
        } catch (Exception e) {
            return "them moi that bai";
        }
    }

    public String updateorder(String id, String id_customer, String totalprice, String startDate, String status) {
        String query = "UPDATE [Order]\n"
                + "   SET id_customer = ?\n"
                + "      ,totalprice = ?\n"
                + "      ,startDate = ?\n"
                + "      ,status = ?\n"
                + " WHERE ID = ?";
        try {
            if (id.trim() == "") {
                return ("Khong de trong id don hang");
            }
            if (id_customer.trim() == "") {
                return ("Khong de trong id khach hang");
            }
            if (totalprice.trim() == "") {
                return ("Khong de trong tong gia tien");
            }
            if (startDate.trim() == "") {
                return ("Khong de trong ngay khoi tao don hang");
            }
            if (status.trim() == "") {
                return ("Khong de trong trang thai don hang");
            }
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id_customer);
            ps.setString(2, totalprice);
            ps.setString(3, startDate);
            ps.setString(4, status);
            ps.setString(5, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                return "cap nhat thanh cong";
            } else {
                return "cap nhat that bai";
            }
        } catch (Exception e) {
            return "cap nhat that bai";
        }
    }

    public String deleteOrder(String id) {
        String query = "delete from [Order]\n"
                + "where ID = ?";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            int count = ps.executeUpdate();
            if (count > 0) {
                return "Xoa thanh cong";
            } else {
                return "Xoa that bai";
            }
        } catch (Exception e) {
            return "Xoa that bai";
        }
    }

    public Order findOrderbyID(String id) {
        Order result = null;
        String query = "Select  * from [Order]\n"
                + "where ID = ?";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    public Order findOrderLast() {
        Order result = null;
        String query = "SELECT * FROM [Order] WHERE ID = (SELECT MAX(ID) FROM [Order])";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    public List<Order> findOrderDetailbyIDCustomer(String id_customer) {
        List<Order> lorder = new ArrayList<Order>();
        String query = "Select  * from [Order]\n"
                + "where id_customer = ?";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id_customer);
            rs = ps.executeQuery();
            while (rs.next()) {
                lorder.add(new Order(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
        }
        return lorder;
    }
}
