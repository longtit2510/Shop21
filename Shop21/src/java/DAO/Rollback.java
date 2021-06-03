/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connect.ConnectDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Snowyy
 */
public class Rollback {

    ConnectDb db = new ConnectDb();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public void RollbackCustomer() {
        String query = "Truncate Table [cuahang].[dbo].[Customer]\n"
                + "  INSERT [dbo].[Customer] ( [name], [phone], [address], [certificate]) VALUES (N'minh',N'0954829198',N'dan ',N'23041201')\n"
                + "  INSERT [dbo].[Customer] ( [name], [phone], [address], [certificate]) VALUES (N'long',N'0291832991',N'duong noi',N'2415221')\n"
                + "  INSERT [dbo].[Customer] ( [name], [phone], [address], [certificate]) VALUES (N'ha',N'034219222',N'ha noi',N'32341421')";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    public void RollbackOrderDetail() {
        String query = "TRUNCATE table [cuahang].[dbo].[OrderDetail]\n"
                + "INSERT [dbo].[OrderDetail] ( [oid], [pid], [pname], [dongia], [quantity]) VALUES (N'1',N'2',N'Air Jordan ',N'3000000',N'2')\n"
                + "INSERT [dbo].[OrderDetail] ( [oid], [pid], [pname], [dongia], [quantity]) VALUES (N'1',N'1',N'Nike Air Force',N'2000000',N'1')\n"
                + "INSERT [dbo].[OrderDetail] ( [oid], [pid], [pname], [dongia], [quantity]) VALUES (N'2',N'1',N'Nike Air Force',N'2000000',N'5')\n"
                + "INSERT [dbo].[OrderDetail] ( [oid], [pid], [pname], [dongia], [quantity]) VALUES (N'3',N'3',N'Converse',N'1000000',N'1')\n"
                + "INSERT [dbo].[OrderDetail] ( [oid], [pid], [pname], [dongia], [quantity]) VALUES (N'3',N'2',N'Air Jordan',N'3000000',N'1')\n"
                + "INSERT [dbo].[OrderDetail] ( [oid], [pid], [pname], [dongia], [quantity]) VALUES (N'4',N'4',N'Puma',N'500000',N'2')\n"
                + "INSERT [dbo].[OrderDetail] ( [oid], [pid], [pname], [dongia], [quantity]) VALUES (N'4',N'2',N'Nike Air Force',N'2000000',N'1')";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }

    public void RollbackOrder() {
        String query = "TRUNCATE table [cuahang].[dbo].[Order]\n"
                + "INSERT [dbo].[Order] ( [id_customer], [totalprice], [startDate], [status]) VALUES (N'1',N'8000000',N'2021-11-30 ',N'chua giao')\n"
                + "INSERT [dbo].[Order] ( [id_customer], [totalprice], [startDate], [status]) VALUES (N'3',N'10000000',N'2020-02-01',N'chua giao')\n"
                + "INSERT [dbo].[Order] ( [id_customer], [totalprice], [startDate], [status]) VALUES (N'2',N'4000000',N'2021-04-03',N'da giao')\n"
                + "INSERT [dbo].[Order] ( [id_customer], [totalprice], [startDate], [status]) VALUES (N'2',N'3000000',N'2021-05-29',N'da giao')";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {

        }
    }
}
