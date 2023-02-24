/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Notification;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class MyConnnect {
    public static Connection conn = null;
    private String severName;
    private String dbName;
    private String userName;
    private String password;
    public MyConnnect() {
        severName="localhost";
        dbName="QuanLyNhanSu";
        userName="root";
        password="Concho123";
        String strConnect = "jdbc:mysql://" + severName + "/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        Properties pro = new Properties();
        pro.put("user", userName);
        pro.put("password", password);
        try {
            com.mysql.cj.jdbc.Driver driver = new Driver();
            conn = driver.connect(strConnect, pro);
            System.out.println("work");
        } catch (SQLException ex) {
            new Notification(""+ex,1);
            System.exit(0);
        }

    }
}
