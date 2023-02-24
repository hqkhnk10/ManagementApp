/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.NhanVien;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author TruongNgo
 */
public class NhanVienController {
    private ArrayList<NhanVien> listNhanVien = null;

   
public ArrayList<NhanVien> getListNhanVien() {
        try {
            String sql = "SELECT * FROM quanlynhansu.nhanvien;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<NhanVien> danhsach = new ArrayList<>();
            while (rs.next()) {
                NhanVien nhanvien = new NhanVien();
                nhanvien.setMaNV(rs.getInt(1));
                 nhanvien.setHoTen(rs.getString(2));
                nhanvien.setCMND(rs.getString(3));
                nhanvien.setNgaySinh(rs.getDate(4));
                nhanvien.setDiaChi(rs.getString(5));
                nhanvien.setGioiTinh(rs.getString(6));
                nhanvien.setChucVu(rs.getString(7));
                 nhanvien.setPhongBan(rs.getString(8));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }
public void themNhanVien(NhanVien nv){
     try {
        java.sql.Date NgaySinh = new java.sql.Date(nv.getNgaySinh().getTime());
        
            String sql = "insert into NhanVien(HoTen,CMND,ngaySinh,diaChi,GioiTinh,ChucVu,PhongBan) "
                    + "values(?,?,?,?,?,?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, nv.getHoTen());
             pre.setString(2, nv.getCMND());
            pre.setDate(3, NgaySinh);
            pre.setString(4, nv.getDiaChi());
            pre.setString(5, nv.getGioiTinh());
            pre.setString(6, nv.getChucVu());
            pre.setString(7, nv.getPhongBan());
            pre.executeUpdate();
            new Notification("Thêm thành công",2);

        } catch (SQLException ex) {
            new Notification(""+ex,1);
        } 
}
public void suaNhanVien(NhanVien nv){
      java.sql.Date NgaySinh = new java.sql.Date(nv.getNgaySinh().getTime());
     try {
            String sql = "UPDATE `quanlynhansu`.`nhanvien` SET "
                    + "`HoTen` = ?, `CMND` = ?, `NgaySinh` = ?, `DiaChi` = ?, `GioiTinh` = ?, `ChucVu` = ?, `PhongBan` = ? "
                    + "WHERE (`maNhanVien` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, nv.getHoTen());
             pre.setString(2, nv.getCMND());
            pre.setDate(3, NgaySinh);
            pre.setString(4, nv.getDiaChi());
            pre.setString(5, nv.getGioiTinh());
            pre.setString(6, nv.getChucVu());
             pre.setString(7, nv.getPhongBan());
             pre.setInt(8,nv.getMaNV());
            
            pre.executeUpdate();
            new Notification("Sửa thành công",2);

        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
public void xoaNhanVien(int index){
     try {
            String sql = "DELETE FROM nhanvien WHERE (`maNhanVien` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
             new Notification("Xóa thành công",2);

        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
public ArrayList<NhanVien> TimNhanVienTheoTen(String HoTen) {
        try {
            String sql = "SELECT * FROM nhanvien\n" +
"where HoTen=?;";

            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, HoTen);
            ResultSet rs = pre.executeQuery();
            ArrayList<NhanVien> danhsach = new ArrayList<>();
             while (rs.next()) {
                NhanVien nhanvien = new NhanVien();
                nhanvien.setMaNV(rs.getInt(1));
                 nhanvien.setHoTen(rs.getString(2));
                nhanvien.setCMND(rs.getString(3));
                nhanvien.setNgaySinh(rs.getDate(4));
                nhanvien.setDiaChi(rs.getString(5));
                nhanvien.setGioiTinh(rs.getString(6));
                nhanvien.setChucVu(rs.getString(7));
                 nhanvien.setPhongBan(rs.getString(8));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }


}
