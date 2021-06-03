/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDb;
import Model.Customer;
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
public class OrderDetailDAO {

    ConnectDb db = new ConnectDb();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<OrderDetail> getAllOrderDetail() {
        List<OrderDetail> lorder = new ArrayList<OrderDetail>();
        String query = "SELECT * FROM [ORDERDETAIL]";
        try {
            conn = db.getConnection();//ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                lorder.add(new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)));
            }
        } catch (Exception e) {

        }
        return lorder;
    }

    public String createOrderDetail(int oid, int pid, String pname, String dongia, int quantity) {
        String query = "INSERT INTO OrderDetail\n"
                + " VALUES (?,?,?,?,?)";
        try {

            if (oid == 0) {
                return ("Khong de trong id don hang");
            }
            if (pid == 0) {
                return ("Khong de trong id san pham");
            }
            if (pname.trim() == "") {
                return ("Khong de trong ten san pham");
            }
            if (quantity == 0) {
                return ("Khong de trong so luong");
            }
            if (dongia.trim() == "") {
                return ("Khong de trong don gia");
            }

            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, oid);
            ps.setInt(2, pid);
            ps.setString(3, pname);
            ps.setString(4, dongia);
            ps.setInt(5, quantity);
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

    public String updateOrderDetail(int id, int oid, int pid, String pname, String dongia, int quantity) {
        String query = "UPDATE OrderDetail\n"
                + "   SET oid = ?\n"
                + "      ,pid = ?\n"
                + "      ,pname = ?\n"
                + "      ,dongia = ?\n"
                + "      ,quantity = ?\n"
                + " WHERE ID = ?";
        try {
            if (id == 0) {
                return ("Khong de trong id chi tiet don hang");
            }
            if (oid == 0) {
                return ("Khong de trong id don hang");
            }
            if (pid == 0) {
                return ("Khong de trong id san pham");
            }
            if (pname.trim() == "") {
                return ("Khong de trong ten san pham");
            }
            if (dongia.trim() == "") {
                return ("Khong de trong don gia");
            }
            if (quantity == 0) {
                return ("Khong de trong so luong san pham");
            }
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, oid);
            ps.setInt(2, pid);
            ps.setString(3, pname);
            ps.setString(4, dongia);
            ps.setInt(5, quantity);
            ps.setInt(6, id);
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

    public String deleteOrderDetail(String id) {
        String query = "delete from OrderDetail\n"
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

    public OrderDetail findOrderDetailbyID(String id) {
        OrderDetail result = null;
        String query = "Select  * from OrderDetail\n"
                + "where ID = ?";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

    public List<OrderDetail> findOrderDetailbyOID(String id) {
        List<OrderDetail> lorder = new ArrayList<OrderDetail>();
        String query = "Select  * from OrderDetail\n"
                + "where OID = ?";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                lorder.add(new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                ));
            }
        } catch (Exception e) {
        }
        return lorder;
    }

    public OrderDetail findOrderDetailLast() {
        OrderDetail result = null;
        String query = "SELECT * FROM OrderDetail WHERE ID = (SELECT MAX(ID) FROM OrderDetail)";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }

}
