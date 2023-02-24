/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.ChamCong;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TruongNgo
 */
public class ChamCongController {
    public ArrayList<ChamCong> getListChamCong(int MaNV) {
        try {
            String sql = "SELECT maChamCong,chamcong.maNhanVien,nhanvien.HoTen,NgayChamCong,GioVao,GioRa\n" +
"FROM chamcong\n" +
"inner join NhanVien on chamcong.maNhanVien=nhanvien.maNhanVien\n" +
"where chamcong.maNhanVien=?;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, MaNV);
            ResultSet rs = pre.executeQuery();
            ArrayList<ChamCong> danhsach = new ArrayList<>();
            while (rs.next()) {
                ChamCong nhanvien = new ChamCong();
                 nhanvien.setMaCC(rs.getInt(1));
                 nhanvien.setMaNV(rs.getInt(2));
                nhanvien.setTenNV(rs.getString(3));
                nhanvien.setNgayChamCong(rs.getDate(4));
                nhanvien.setGioVao(rs.getTime(5));
                nhanvien.setGioRa(rs.getTime(6));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }
    public void themChamCong(ChamCong kt){
        java.sql.Date NgayChamCong = new java.sql.Date(kt.getNgayChamCong().getTime());
        java.sql.Time getGioVao = new java.sql.Time(kt.getGioVao().getTime());
        java.sql.Time getGioRa = new java.sql.Time(kt.getGioVao().getTime());
        try{
            String sql = "insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa)" + "values (?,?,?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, kt.getMaNV());
            pre.setDate(2, NgayChamCong);
            pre.setTime(3, getGioVao);
            pre.setTime(4, getGioVao);
            pre.executeUpdate();
             new Notification("Thêm thành công",2);
        } catch (SQLException ex){
            new Notification(""+ex,1);
        }
    }
    public void suaChamCong(ChamCong kt){
     java.sql.Date NgayChamCong = new java.sql.Date(kt.getNgayChamCong().getTime());
     try {
            String sql = "UPDATE `quanlynhansu`.`chamcong` SET "
                    + "`NgayChamCong` = ?, `GioVao` = ?, `GioRa` = ? WHERE (`maChamCong` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
           pre.setDate(1, NgayChamCong);
            pre.setTime(2, kt.getGioVao());
            pre.setTime(3, kt.getGioRa());
            pre.setInt(4, kt.getMaNV());
            pre.executeUpdate();
new Notification("Sửa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
    public void xoaChamCong(int index){
     try {
            String sql = "DELETE FROM ChamCong WHERE (`maChamCong` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
new Notification("Xóa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
    public ArrayList<ChamCong> TimChamCongTheoNgay(String tuNgay, String denNgay,int MaNV) {
        try {
            String sql = "SELECT maChamCong,chamcong.maNhanVien,nhanvien.HoTen,NgayChamCong,GioVao,GioRa\n" +
"FROM chamcong\n" +
"inner join NhanVien on chamcong.maNhanVien=nhanvien.maNhanVien\n" +
"where NgayChamCong BETWEEN CAST(? AS DATE) AND CAST(? AS DATE) and nhanvien.maNhanVien=?;";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, tuNgay);
            pre.setString(2, denNgay);
             pre.setInt(3, MaNV);
            ResultSet rs = pre.executeQuery();
            ArrayList<ChamCong> danhsach = new ArrayList<>();
          while (rs.next()) {
                ChamCong nhanvien = new ChamCong();
                 nhanvien.setMaCC(rs.getInt(1));
                 nhanvien.setMaNV(rs.getInt(2));
                nhanvien.setTenNV(rs.getString(3));
                nhanvien.setNgayChamCong(rs.getDate(4));
                nhanvien.setGioVao(rs.getTime(5));
                nhanvien.setGioRa(rs.getTime(6));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }
}
