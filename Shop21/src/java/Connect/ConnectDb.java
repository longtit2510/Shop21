/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Snowyy
 */
public class ConnectDb {

    private final String serverName = "DESKTOP-NTTAICS";
    private final String dbName = "cuahang";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";

    public static void main(String[] args) throws Exception {
        ConnectDb db = new ConnectDb();
        System.out.println(db.getConnection());
    }

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
}
