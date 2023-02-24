/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ChucVu;
import java.util.ArrayList;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ChucVuController {
    private ArrayList<ChucVu> listChucVu = null;


    public ArrayList<ChucVu> getListChucVu(){
        try {
           String sql = "SELECT * FROM quanlynhansu.chucvu;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<ChucVu> dscv = new ArrayList<>();
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setMaCV(rs.getInt(1));
                cv.setTenCV(rs.getString(2));
                dscv.add(cv);
            }
            return dscv;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        
        return null;
        
   }

   public void themChucVu(ChucVu cv){
     try {
            String sql = "insert into chucvu(maChucVu , tenChucVu) "
                    + "values(?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, cv.getMaCV());
            pre.setString(2, cv.getTenCV());
            
            pre.executeUpdate();
                            new Notification("Thêm thành công",2);

            
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        } 
    }
    public void suaChucVu(ChucVu cv){
      
     try {
            String sql = "UPDATE `quanlynhansu`.`chucvu` SET "
                    + "`maChucVu` = ?, `tenChucVu` = ? "
                    + "WHERE (`maChucVu` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, cv.getMaCV());
            pre.setString(2, cv.getTenCV());
            
            pre.executeUpdate();
                            new Notification("Sửa thành công",2);


        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
public void xoaChucVu(int index){
     try {
            String sql = "DELETE FROM chucvu WHERE (`maChucVu` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
             new Notification("Xóa thành công",2);

        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
public ArrayList<ChucVu> TimChucVuTheoTen(String TenCV) {
        try {
            String sql = "SELECT * FROM chucvu\n" +
"where tenChucVu = ?;";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, TenCV);
            ResultSet rs = pre.executeQuery();
            ArrayList<ChucVu> dscv = new ArrayList<>();
             while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setMaCV(rs.getInt(1));
                cv.setTenCV(rs.getString(2));
                
                dscv.add(cv);
            }
            return dscv;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }
}