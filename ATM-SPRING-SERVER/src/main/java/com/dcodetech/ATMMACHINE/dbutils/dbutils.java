package com.dcodetech.ATMMACHINE.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static Connection cn;

    public static Connection openConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://127.0.0.1:3306/atm_machine";
        cn = DriverManager.getConnection(url, "root", "5277");
        return cn;
    }

    public static void closeConnection() throws SQLException {
        if (cn != null)
            cn.close();
    }

    public static void connectwhenpageopen() throws SQLException{

    }

}