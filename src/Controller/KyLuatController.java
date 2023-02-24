/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.KyLuat;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TruongNgo
 */
public class KyLuatController {
    
    private ArrayList<KyLuat> listKyLuat = null;

   
public ArrayList<KyLuat> getListKyLuat() {
        try {
            String sql = "SELECT  maKyLuat,KyLuat.maNhanVien,NhanVien.HoTen,KyLuat.NgayKyLuat,KyLuat.LyDo\n" +
"from KyLuat \n" +
"Inner join NhanVien on KyLuat.maNhanVien=NhanVien.maNhanVien;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<KyLuat> danhsach = new ArrayList<>();
            while (rs.next()) {
                KyLuat nhanvien = new KyLuat();
                 nhanvien.setMaKL(rs.getInt(1));
                nhanvien.setMaNV(rs.getInt(2));
                 nhanvien.setHoTen(rs.getString(3));
                nhanvien.setNgayKyLuat(rs.getDate(4));
                nhanvien.setLyDo(rs.getString(5));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }
public void themKyLuat(KyLuat kt){
     try {
        java.sql.Date NgayKyLuat = new java.sql.Date(kt.getNgayKyLuat().getTime());
            String sql = "insert into KyLuat(maNhanVien,NgayKyLuat,LyDo) values (?,?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, kt.getMaNV());
            pre.setDate(2, NgayKyLuat);
            pre.setString(3, kt.getLyDo());
            pre.executeUpdate();
            new Notification("Thêm thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        } 
}
public void suaKyLuat(KyLuat kt){
     java.sql.Date NgayKyLuat = new java.sql.Date(kt.getNgayKyLuat().getTime());
     try {
            String sql = "UPDATE `quanlynhansu`.`kyluat` SET `NgayKyLuat` = ?, `LyDo` = ? WHERE (`maKyLuat` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
           pre.setDate(1, NgayKyLuat);
            pre.setString(2, kt.getLyDo());            
            pre.setInt(3, kt.getMaNV());
            pre.executeUpdate();
new Notification("Sửa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
public void xoaKyLuat(int index){
     try {
            String sql = "DELETE FROM `quanlynhansu`.`kyluat` WHERE (`maKyLuat` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
new Notification("Xóa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
public ArrayList<KyLuat> TimKyLuatTheoTenNV(String TenNV) {
        try {
            String sql = "SELECT  maKyLuat,KyLuat.maNhanVien,NhanVien.HoTen,KyLuat.NgayKyLuat,KyLuat.LyDo\n" +
"from KyLuat\n" +
"Inner join NhanVien on KyLuat.maNhanVien=NhanVien.maNhanVien\n" +
"where NhanVien.HoTen=?;";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, TenNV);
            ResultSet rs = pre.executeQuery();
            ArrayList<KyLuat> danhsach = new ArrayList<>();
            while (rs.next()) {
               KyLuat nhanvien = new KyLuat();
                nhanvien.setMaKL(rs.getInt(1));
                nhanvien.setMaNV(rs.getInt(2));
                 nhanvien.setHoTen(rs.getString(3));
                nhanvien.setNgayKyLuat(rs.getDate(4));
                nhanvien.setLyDo(rs.getString(5));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }
public ArrayList<KyLuat> TimKyLuatTheoNgay(String tuNgay, String denNgay) {
        try {
            String sql = "SELECT  maKyLuat,KyLuat.maNhanVien,NhanVien.HoTen,KyLuat.NgayKyLuat,KyLuat.LyDo\n" +
"from KyLuat\n" +
"Inner join NhanVien on KyLuat.maNhanVien=NhanVien.maNhanVien\n" +
"where NgayKyLuat BETWEEN CAST(? AS DATE) AND CAST(? AS DATE);";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, tuNgay);
            pre.setString(2, denNgay);
            ResultSet rs = pre.executeQuery();
            ArrayList<KyLuat> danhsach = new ArrayList<>();
           while (rs.next()) {
               KyLuat nhanvien = new KyLuat();
                nhanvien.setMaKL(rs.getInt(1));
                nhanvien.setMaNV(rs.getInt(2));
                 nhanvien.setHoTen(rs.getString(3));
                nhanvien.setNgayKyLuat(rs.getDate(4));
                nhanvien.setLyDo(rs.getString(5));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }

}

