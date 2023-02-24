/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PhongBan;
import View.Notification;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhongBanController {
    
    private ArrayList<PhongBan> listPhongBan = null;
    
    public ArrayList<PhongBan> getListPhongBan(){
        try{
            String sql = "SELECT * from quanlynhansu.phongban;" ;
             
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<PhongBan> dspb = new ArrayList<>();
            while (rs.next()){
                    PhongBan pb = new PhongBan();
                    pb.setMaPB(rs.getInt(1));
                    pb.setTenPB(rs.getString(2));
                    dspb.add(pb);
            }
            return dspb;
            
        }catch (SQLException ex){
            new Notification(""+ex,1);
        }
        return null;
        
    }
    public ArrayList<PhongBan> TimPBTheoTen(String TenPB){
      try{
          String sql = "SELECT * FROM phongban where tenPhongBan=?;" ;
          
          PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
          pre.setString(1, TenPB);
          ResultSet rs = pre.executeQuery();
          ArrayList<PhongBan> dspb = new ArrayList<>();
          while (rs.next()){
              PhongBan pb = new PhongBan();
              pb.setMaPB(rs.getInt(1));
              pb.setTenPB(rs.getString(2));
              dspb.add(pb);
          
      }
          return dspb;
          }catch (SQLException ex) {
          Notification notification = new Notification(""+ex,1);
        }
        return null;
      
    }
    
    public void themPhongBan(PhongBan pb){
        try{
            String sql = "insert into phongban(maPhongBan,tenPhongBan) values (?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, pb.getMaPB());
            pre.setString(2, pb.getTenPB());
            pre.executeUpdate();
              new Notification("Thêm thành công",2);
        
        }catch (SQLException ex){
            Notification notification = new Notification(""+ex,1);
        }
    }
    
    public void xoaPhongBan(int index){
        try{
            String sql = "DELETE FROM phongban WHERE (maPhongBan = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
             new Notification("Xóa thành công",2);
            
        }catch (SQLException ex){
            new Notification(""+ex,1);
            }
    }
    
    public void suaPhongBan(PhongBan pb){
        try{
            String sql = "UPDATE `quanlynhansu`.`phongban` SET " + "`tenPhongBan` = ?" + "WHERE (`maPhongBan` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, pb.getMaPB());
            pre.setString(2, pb.getTenPB());
            
            pre.executeUpdate();
            new Notification("Sửa thành công",2);
            
        }catch(SQLException ex){
           new Notification(""+ex,1);
            
                }
            
    }
    
}
