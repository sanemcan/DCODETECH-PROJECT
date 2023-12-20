package com.dcodetech.ATMMACHINE.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbutils {

    //ek private variable banvala
    private static Connection cn;


    //don metthod banva open and close
    public static  Connection openConnection() throws SQLException{ //he tr ikde method banvli tyat 
                                                            //try catch yenar
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");       //class load karto jdbc

      }catch(ClassNotFoundException e){
        e.printStackTrace();
      }
      String url ="jdbc:mysql://localhost/atm_machine";
      cn =DriverManager.getConnection(url,"root","Sagar@2001");

      return cn;
    }

    public static void closeconnection() throws SQLException{
        if (cn != null)
           cn.close();
    }
    
}
    

