/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.KhenThuong;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TruongNgo
 */
public class KhenThuongController {

    private ArrayList<KhenThuong> listKhenThuong = null;

   
public ArrayList<KhenThuong> getListKhenThuong() {
        try {
            String sql = "SELECT  maKhenThuong,KhenThuong.maNhanVien,NhanVien.HoTen,NgayKhenThuong,Tien,LyDo\n" +
"from KhenThuong\n" +
"Inner join NhanVien on KhenThuong.maNhanVien=NhanVien.maNhanVien;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhenThuong> dskt = new ArrayList<>();
            while (rs.next()) {
                KhenThuong kt = new KhenThuong();
                kt.setMaKT(rs.getInt(1));
                kt.setMaNV(rs.getInt(2));
                 kt.setHoTen(rs.getString(3));
                kt.setNgayKhenThuong(rs.getDate(4));
                kt.setTien(rs.getDouble(5));
                kt.setLyDo(rs.getString(6));
                dskt.add(kt);
            }
            return dskt;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }

public void themKhenThuong(KhenThuong kt){
     try {
        java.sql.Date NgayKhenThuong = new java.sql.Date(kt.getNgayKhenThuong().getTime());
        
            String sql = "insert into KhenThuong(maNhanVien,NgayKhenThuong,Tien,LyDo) values (?,?,?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, kt.getMaNV());
            pre.setDate(2, NgayKhenThuong);
            pre.setDouble(3, kt.getTien());
            pre.setString(4, kt.getLyDo());
            pre.executeUpdate();
                        new Notification("Thêm thành công",2);


        } catch (SQLException ex) {
            new Notification(""+ex,1);
        } 
}

public void suaKhenThuong(KhenThuong kt){
     java.sql.Date NgayKhenThuong = new java.sql.Date(kt.getNgayKhenThuong().getTime());
     try {
            String sql = "UPDATE `KhenThuong` "
                    + "SET `NgayKhenThuong` = ?, `Tien` = ?, `LyDo` = ? WHERE (`maKhenThuong` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
           pre.setDate(1, NgayKhenThuong);
           pre.setDouble(2, kt.getTien());
            pre.setString(3, kt.getLyDo());            
            pre.setInt(4, kt.getMaKT());
            pre.executeUpdate();
            new Notification("Sửa thành công",2);

        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}

public void xoaKhenThuong(int index){
     try {
            String sql = "DELETE FROM KhenThuong WHERE (maKhenThuong = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
            new Notification("Xóa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}

public ArrayList<KhenThuong> TimKTTheoTenNV(String TenNV) {
        try {
            String sql = "SELECT  maKhenThuong,KhenThuong.maNhanVien,NhanVien.HoTen,NgayKhenThuong,Tien,LyDo\n" +
"from KhenThuong\n" +
"Inner join NhanVien on KhenThuong.maNhanVien=NhanVien.maNhanVien\n" +
"where NhanVien.HoTen=?;";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, TenNV);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhenThuong> dskt = new ArrayList<>();
             while (rs.next()) {
                KhenThuong kt = new KhenThuong();
                kt.setMaKT(rs.getInt(1));
                kt.setMaNV(rs.getInt(2));
                 kt.setHoTen(rs.getString(3));
                kt.setNgayKhenThuong(rs.getDate(4));
                kt.setTien(rs.getDouble(5));
                kt.setLyDo(rs.getString(6));
                dskt.add(kt);
            }
            return dskt;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }

public ArrayList<KhenThuong> TimKTTheoNgay(String tuNgay, String denNgay) {
        try {
            String sql = "SELECT  maKhenThuong,KhenThuong.maNhanVien,NhanVien.HoTen,NgayKhenThuong,Tien,LyDo\n" +
"from KhenThuong\n" +
"Inner join NhanVien on KhenThuong.maNhanVien=NhanVien.maNhanVien\n" +
"where NgayKhenThuong BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, tuNgay);
            pre.setString(2, denNgay);
            ResultSet rs = pre.executeQuery();
            ArrayList<KhenThuong> dskt = new ArrayList<>();
            while (rs.next()) {
                KhenThuong kt = new KhenThuong();
                kt.setMaKT(rs.getInt(1));
                kt.setMaNV(rs.getInt(2));
                 kt.setHoTen(rs.getString(3));
                kt.setNgayKhenThuong(rs.getDate(4));
                kt.setTien(rs.getDouble(5));
                kt.setLyDo(rs.getString(6));
                dskt.add(kt);
            }
            return dskt;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }

}


