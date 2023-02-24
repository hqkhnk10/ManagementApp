/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Luong;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 *
 * @author TruongNgo
 */
public class LuongController {
     private ArrayList<Luong> listLuong = null;

   
public ArrayList<Luong> getListLuongMaNV(int Thang,int Nam,int MaNV) {
        try {
            String sql = "SELECT luong.maNhanVien,nhanvien.HoTen,nhanvien.ChucVu, count(*) as ngaycongthute,luong.LuongThoaThuan,luong.PhuCap\n" +
"FROM luong\n" +
"inner join nhanvien on ?=luong.maNhanVien\n" +
"inner join chamcong on chamcong.maNhanVien=nhanvien.maNhanVien\n" +
"where month(ngayChamCong)=? and year(NgayChamCong)=?";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1,MaNV);
            pre.setInt(2,Thang);
            pre.setInt(3,Nam);
            ResultSet rs = pre.executeQuery();
            ArrayList<Luong> danhsach = new ArrayList<>();
            while (rs.next()) {
                double luongThucTe=0,Thue=0,thucTeNhan=0;
                luongThucTe=Double.valueOf(rs.getInt(4))*rs.getDouble(5)+rs.getDouble(6);
                Thue=tinhThue(luongThucTe);
                thucTeNhan=luongThucTe-Thue;
                String luongthucte="",thuctenhan="";
                 DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(0);
        luongthucte=df.format(luongThucTe);
        thuctenhan=df.format(thucTeNhan);
                Luong nhanvien = new Luong();
                nhanvien.setMaNV(rs.getInt(1));
                 nhanvien.setHoTen(rs.getString(2));
                nhanvien.setChucVu(rs.getString(3));
                nhanvien.setNgayCongThucTe(rs.getInt(4));
                nhanvien.setLuongThoaThuan(rs.getDouble(5));
                nhanvien.setPhuCap(rs.getDouble(6));
                nhanvien.setLuongThucTe(luongthucte);
                nhanvien.setThue(Thue);
                nhanvien.setThucTeNhan(thuctenhan);
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }
public double tinhThue(double LuongThucTe){
    double Thue=0;
    if(LuongThucTe>5000000 && LuongThucTe<10000000 ){
        Thue = LuongThucTe/10;
    }
    if(LuongThucTe>10000000 && LuongThucTe<18000000 ){
        Thue = (LuongThucTe*15)/100;
    }
    if(LuongThucTe>18000000 ){
        Thue = (LuongThucTe*17)/100;
    }
    return Thue;
}

    public ArrayList<Luong> getListLuongTenNV(int Thang, int Nam, String TenNV) {
         try {
            String sql = "SELECT luong.maNhanVien,nhanvien.HoTen,nhanvien.ChucVu, count(*) as ngaycongthute,luong.LuongThoaThuan,luong.PhuCap\n" +
"FROM luong\n" +
"inner join nhanvien on ?=nhanvien.HoTen\n" +
"inner join chamcong on chamcong.maNhanVien=nhanvien.maNhanVien\n" +
"where month(ngayChamCong)=? and year(NgayChamCong)=?";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1,TenNV);
            pre.setInt(2,Thang);
            pre.setInt(3,Nam);
            ResultSet rs = pre.executeQuery();
            ArrayList<Luong> danhsach = new ArrayList<>();
             while (rs.next()) {
                double luongThucTe=0,Thue=0,thucTeNhan=0;
                luongThucTe=Double.valueOf(rs.getInt(4))*rs.getDouble(5)+rs.getDouble(6);
                Thue=tinhThue(luongThucTe);
                thucTeNhan=luongThucTe-Thue;
                String luongthucte="",thuctenhan="";
                 DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(0);
        luongthucte=df.format(luongThucTe);
        thuctenhan=df.format(thucTeNhan);
                Luong nhanvien = new Luong();
                nhanvien.setMaNV(rs.getInt(1));
                 nhanvien.setHoTen(rs.getString(2));
                nhanvien.setChucVu(rs.getString(3));
                nhanvien.setNgayCongThucTe(rs.getInt(4));
                nhanvien.setLuongThoaThuan(rs.getDouble(5));
                nhanvien.setPhuCap(rs.getDouble(6));
                nhanvien.setLuongThucTe(luongthucte);
                nhanvien.setThue(Thue);
                nhanvien.setThucTeNhan(thuctenhan);
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }
    
   public ArrayList<Luong> getListLuongTatCa(int Thang, int Nam) {
         try {
            String sql = "SELECT luong.maNhanVien,nhanvien.HoTen,nhanvien.ChucVu,count(*) as ngaycongthucte,luong.LuongThoaThuan,luong.PhuCap\n" +
"FROM luong\n" +
"inner join nhanvien on luong.maNhanVien=nhanvien.maNhanVien\n" +
"inner join chamcong on chamcong.maNhanVien=nhanvien.maNhanVien\n" +
"where month(ngayChamCong)=? and year(NgayChamCong)=?\n" +
"group by nhanvien.maNhanVien";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1,Thang);
            pre.setInt(2,Nam);
            ResultSet rs = pre.executeQuery();
            ArrayList<Luong> danhsach = new ArrayList<>();
             while (rs.next()) {
                double luongThucTe=0,Thue=0,thucTeNhan=0;
                luongThucTe=Double.valueOf(rs.getInt(4))*rs.getDouble(5)+rs.getDouble(6);
                Thue=tinhThue(luongThucTe);
                thucTeNhan=luongThucTe-Thue;
                String luongthucte="",thuctenhan="";
                 DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(0);
        luongthucte=df.format(luongThucTe);
        thuctenhan=df.format(thucTeNhan);
                Luong nhanvien = new Luong();
                nhanvien.setMaNV(rs.getInt(1));
                 nhanvien.setHoTen(rs.getString(2));
                nhanvien.setChucVu(rs.getString(3));
                nhanvien.setNgayCongThucTe(rs.getInt(4));
                nhanvien.setLuongThoaThuan(rs.getDouble(5));
                nhanvien.setPhuCap(rs.getDouble(6));
                nhanvien.setLuongThucTe(luongthucte);
                nhanvien.setThue(Thue);
                nhanvien.setThucTeNhan(thuctenhan);
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }   

    public void suaLuong(Luong kt) {
     try {
            String sql = "UPDATE `quanlynhansu`.`luong` SET `LuongThoaThuan` = ?, `PhuCap` = ? WHERE (`maNhanVien` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setDouble(1, kt.getLuongThoaThuan());
            pre.setDouble(2, kt.getPhuCap());
            pre.setInt(3, kt.getMaNV());
            pre.executeUpdate();
new Notification("Sửa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
    }

    public void xoaLuong(int index) {
     try {
            String sql = "DELETE FROM `quanlynhansu`.`luong` WHERE (`maNhanVien` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
new Notification("Xóa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
    }
}
