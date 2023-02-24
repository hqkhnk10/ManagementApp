/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.HopDong;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TruongNgo
 */
public class HopDongController {

    private ArrayList<HopDong> listHopDong = null;

   
public ArrayList<HopDong> getListHopDong() {
        try {
            String sql = "SELECT  maHopDong,NhanVien.HoTen,LoaiHopDong,NgayBatDau,NgayKetThuc,ghichu\n" +
"from HopDong\n" +
"Inner join NhanVien on HopDong.maNhanVien=NhanVien.maNhanVien;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<HopDong> dshd = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHD(rs.getInt(1));
                 hd.setTenNV(rs.getString(2));
                hd.setLoaiHD(rs.getString(3));
                hd.setNgayBatDau(rs.getDate(4));
                hd.setNgayKetThuc(rs.getDate(5));
                hd.setGhichu(rs.getString(6));
                dshd.add(hd);
            }
            return dshd;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }
public ArrayList<HopDong> TimHopDongTheoLoaiHD(String loaiHD) {
        try {
            String sql = "SELECT  maHopDong,NhanVien.HoTen,LoaiHopDong,NgayBatDau,NgayKetThuc,ghichu\n" +
"from HopDong\n" +
"Inner join NhanVien on HopDong.maNhanVien=NhanVien.maNhanVien\n" +
"where LoaiHopDong=?;";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, loaiHD);
            ResultSet rs = pre.executeQuery();
            ArrayList<HopDong> dshd = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHD(rs.getInt(1));
                 hd.setTenNV(rs.getString(2));
                hd.setLoaiHD(rs.getString(3));
                hd.setNgayBatDau(rs.getDate(4));
                hd.setNgayKetThuc(rs.getDate(5));
                hd.setGhichu(rs.getString(6));
                dshd.add(hd);
            }
            return dshd;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }

public ArrayList<HopDong> TimHopDongTheoNgay(String tuNgay, String denNgay) {
        try {
            String sql = "SELECT  maHopDong,NhanVien.HoTen,LoaiHopDong,NgayBatDau,NgayKetThuc,ghichu\n" +
"from HopDong\n" +
"Inner join NhanVien on HopDong.maNhanVien=NhanVien.maNhanVien\n" +
"where NgayBatDau BETWEEN CAST(? AS DATE) AND CAST(? AS DATE)";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, tuNgay);
            pre.setString(2, denNgay);
            ResultSet rs = pre.executeQuery();
            ArrayList<HopDong> dshd = new ArrayList<>();
            while (rs.next()) {
                HopDong hd = new HopDong();
                hd.setMaHD(rs.getInt(1));
                 hd.setTenNV(rs.getString(2));
                hd.setLoaiHD(rs.getString(3));
                hd.setNgayBatDau(rs.getDate(4));
                hd.setNgayKetThuc(rs.getDate(5));
                hd.setGhichu(rs.getString(6));
                dshd.add(hd);
            }
            return dshd;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }

public void themHopDong(HopDong hd){
     try {
        java.sql.Date NgayBatDau = new java.sql.Date(hd.getNgayBatDau().getTime());
        java.sql.Date NgayKetThuc = new java.sql.Date(hd.getNgayKetThuc().getTime());   
        
            String sql = "insert into HopDong(maHopDong,maNhanVien,LoaiHopDong,NgayBatDau,NgayKetThuc,ghichu) values (?,?,?,?,?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, hd.getMaHD());
             pre.setInt(2, hd.getmaNV());
            pre.setString(3, hd.getLoaiHD());
            pre.setDate(4, NgayBatDau);
            pre.setDate(5, NgayKetThuc);
            pre.setString(6, hd.getGhichu());
            pre.executeUpdate();
                         new Notification("Thêm thành công",2);


        } catch (SQLException ex) {
            new Notification(""+ex,1);
        } 
}
public void xoaHopDong(int index){
     try {
            String sql = "DELETE FROM hopdong WHERE (maHopDong = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
                                     new Notification("Xóa thành công",2);


        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}

public void suaHopDong(HopDong hd){
     java.sql.Date NgayBatDau = new java.sql.Date(hd.getNgayBatDau().getTime());
        java.sql.Date NgayKetThuc = new java.sql.Date(hd.getNgayKetThuc().getTime()); 
     try {
            String sql = "UPDATE `quanlynhansu`.`hopdong` SET "
                    + "`LoaiHopDong` = ?, `NgayBatDau` = ?, `NgayKetThuc` = ?, `ghichu` = ? "
                    + "WHERE (`maHopDong` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, hd.getLoaiHD());
            pre.setDate(2, NgayBatDau);
            pre.setDate(3, NgayKetThuc);
            pre.setString(4, hd.getGhichu());
            pre.setInt(5,hd.getMaHD());
            
            pre.executeUpdate();
            new Notification("Sửa thành công",2);

        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}

}


