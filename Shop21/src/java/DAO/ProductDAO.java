/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDb;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Snowyy
 */
public class ProductDAO {

    ConnectDb db = new ConnectDb();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> lpro = new ArrayList<Product>();
        String query = "SELECT * FROM PRODUCT";
        try {
            conn = db.getConnection();//ket noi
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                lpro.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {

        }
        return lpro;
    }

    public String createProduct(String name, String price, String description, String supplier) {
        String query = "INSERT INTO Product\n"
                + " VALUES (?,?,?,?)";
        try {
            if (name.trim() == "") {
                return ("Khong de trong ten");
            }
            if (price.trim() == "") {
                return ("Khong de trong gia");
            }
            if (description.trim() == "") {
                return ("Khong de trong mo ta");
            }
            if (supplier.trim() == "") {
                return ("Khong de trong nha cung cap");
            }
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, description);
            ps.setString(4, supplier);
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

    public String updateProduct(String id, String name, String price, String description, String supplier) {
        String query = "UPDATE Product\n"
                + "   SET name = ?\n"
                + "      ,price = ?\n"
                + "      ,description = ?\n"
                + "      ,supplier = ?\n"
                + " WHERE ID = ?";
        try {

            if (id.trim() == "") {
                return ("Khong de trong id");
            }
            if (name.trim() == "") {
                return ("Khong de trong ten");
            }
            if (price.trim() == "") {
                return ("Khong de trong gia");
            }
            if (description.trim() == "") {
                return ("Khong de trong mo ta");
            }
            if (supplier.trim() == "") {
                return ("Khong de trong nha cung cap");
            }
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, description);
            ps.setString(4, supplier);
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

    public String deleteProduct(String id) {
        String query = "delete from Product\n"
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

    public Product findProductById(String id) {
        Product result = null;
        String query = "Select  * from Product\n"
                + "where ID = ?";
        try {
            conn = db.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            result = null;
        }
        return result;
    }
//    public static void main(String[] args) {
//            ProductDAO dao = new ProductDAO();
//            System.out.println(dao.findById("1"));
//    }
}
