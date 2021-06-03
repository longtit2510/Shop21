/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDb;
import Model.Customer;
import static java.lang.System.in;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Snowyy
 */
public class CustomerDAO {

    ConnectDb db = new ConnectDb();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Customer> getAllCustomer() {
        List<Customer> lcus = new ArrayList<Customer>();
        String query = "SELECT * FROM CUSTOMER";
        try {
            conn = db.getConnection();//ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                lcus.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {

        }
        return lcus;
    }

    public String createCustomer(String name, String phone, String address, String certificate) {
        String query = "INSERT INTO Customer\n"
                + " VALUES (?,?,?,?)";
        try {
            if (name.trim() == "") {
                return ("Khong de trong ten");
            }
            if (phone.trim() == "") {
                return ("Khong de trong sdt");
            }
            if (address.trim() == "") {
                return ("Khong de trong dia chi");
            }
            if (certificate.trim() == "") {
                return ("Khong de trong cmnd");
            }
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, certificate);
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

    public String updateCustomer(String id, String name, String phone, String address, String certificate) {
        String query = "UPDATE Customer\n"
                + "   SET name = ?\n"
                + "      ,phone = ?\n"
                + "      ,address = ?\n"
                + "      ,certificate = ?\n"
                + " WHERE ID = ?";
        try {

            if (id.trim() == "") {
                return ("Khong de trong id");
            }
            if (name.trim() == "") {
                return ("Khong de trong ten");
            }
            if (phone.trim() == "") {
                return ("Khong de trong sdt");
            }
            if (address.trim() == "") {
                return ("Khong de trong dia chi");
            }
            if (certificate.trim() == "") {
                return ("Khong de trong cmnd");
            }
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, certificate);
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

    public String deleteCustomer(String id) {
        String query = "delete from Customer\n"
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

    public Customer findCustomerById(String id) {
        Customer result = null;
        String query = "Select  * from Customer\n"
                + "where ID = ?";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new Customer(rs.getInt(1),
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
    public Customer findCustomerLast() {
        Customer result = null;
        String query = "SELECT * FROM Customer WHERE ID = (SELECT MAX(ID) FROM Customer)";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new Customer(rs.getInt(1),
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
//    public static void main(String[] args) {
//        CustomerDAO dao = new CustomerDAO();
//    }
}
