/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Nghi;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NghiController {
    private ArrayList<Nghi> listNghi = null;

   
public ArrayList<Nghi> getListNghi() {
        try {
            String sql = "SELECT  maNghi,Nghi.maNhanVien,NhanVien.HoTen,Nghi.NgayNghi,Nghi.LyDo,Phep\n" +
"from Nghi \n" +
"Inner join NhanVien on Nghi.maNhanVien=NhanVien.maNhanVien;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<Nghi> danhsach = new ArrayList<>();
            while (rs.next()) {
                Nghi nhanvien = new Nghi();
                 nhanvien.setMaNghi(rs.getInt(1));
                nhanvien.setMaNV(rs.getInt(2));
                 nhanvien.setTenNV(rs.getString(3));
                nhanvien.setNgayNghi(rs.getDate(4));
                nhanvien.setLyDo(rs.getString(5));
                nhanvien.setPhep(rs.getBoolean(6));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
        return null;
    }
public void suaNghi(Nghi kt){
     java.sql.Date NgayNghi = new java.sql.Date(kt.getNgayNghi().getTime());
     try {
            String sql = "UPDATE `quanlynhansu`.`Nghi` SET `NgayNghi` = ?, `LyDo` = ?, `Phep` = ? WHERE (`maNghi` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
           pre.setDate(1, NgayNghi);
            pre.setString(2, kt.getLyDo()); 
            pre.setBoolean(3, kt.getPhep());
            pre.setInt(4, kt.getMaNV());
            pre.executeUpdate();
new Notification("Sửa thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        }
}
public void xoaNghi(int index){
     try {
            String sql = "DELETE FROM Nghi WHERE (`maNghi` = ?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, index);
            pre.executeUpdate();
new Notification("Xóa thành công",2);
        } catch (SQLException ex) {
           new Notification(""+ex,1);
        }
}
public ArrayList<Nghi> TimNghiTheoPhep(boolean phep) {
        try {
            String sql = "SELECT  maNghi,Nghi.maNhanVien,NhanVien.HoTen,Nghi.NgayNghi,Nghi.LyDo,Phep\n" +
"from Nghi\n" +
"Inner join NhanVien on Nghi.maNhanVien=NhanVien.maNhanVien\n" +
"where Phep=?;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setBoolean(1, phep);
            ResultSet rs = pre.executeQuery();
            ArrayList<Nghi> danhsach = new ArrayList<>();
            while (rs.next()) {
                Nghi nhanvien = new Nghi();
                 nhanvien.setMaNghi(rs.getInt(1));
                nhanvien.setMaNV(rs.getInt(2));
                 nhanvien.setTenNV(rs.getString(3));
                nhanvien.setNgayNghi(rs.getDate(4));
                nhanvien.setLyDo(rs.getString(5));
                nhanvien.setPhep(rs.getBoolean(6));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }
public ArrayList<Nghi> TimNghiTheoNgayTatCa(String tuNgay,String denNgay) {
        try {
            String sql = "SELECT  maNghi,Nghi.maNhanVien,NhanVien.HoTen,Nghi.NgayNghi,Nghi.LyDo,Phep\n" +
"from Nghi\n" +
"Inner join NhanVien on Nghi.maNhanVien=NhanVien.maNhanVien\n" +
"where NgayNghi BETWEEN CAST(? AS DATE) AND CAST(? AS DATE);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, tuNgay);
            pre.setString(2, denNgay);
            ResultSet rs = pre.executeQuery();
            ArrayList<Nghi> danhsach = new ArrayList<>();
            while (rs.next()) {
                Nghi nhanvien = new Nghi();
                 nhanvien.setMaNghi(rs.getInt(1));
                nhanvien.setMaNV(rs.getInt(2));
                 nhanvien.setTenNV(rs.getString(3));
                nhanvien.setNgayNghi(rs.getDate(4));
                nhanvien.setLyDo(rs.getString(5));
                nhanvien.setPhep(rs.getBoolean(6));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }
public ArrayList<Nghi> TimNghiTheoNgayPhep(String tuNgay,String denNgay,boolean phep) {
        try {
            String sql = "SELECT  maNghi,Nghi.maNhanVien,NhanVien.HoTen,Nghi.NgayNghi,Nghi.LyDo,Phep\n" +
"from Nghi\n" +
"Inner join NhanVien on Nghi.maNhanVien=NhanVien.maNhanVien\n" +
"where NgayNghi BETWEEN CAST(? AS DATE) AND CAST(? AS DATE) and phep=?;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, tuNgay);
            pre.setString(2, denNgay);
            pre.setBoolean(3, phep);
            ResultSet rs = pre.executeQuery();
            ArrayList<Nghi> danhsach = new ArrayList<>();
            while (rs.next()) {
                Nghi nhanvien = new Nghi();
                 nhanvien.setMaNghi(rs.getInt(1));
                nhanvien.setMaNV(rs.getInt(2));
                 nhanvien.setTenNV(rs.getString(3));
                nhanvien.setNgayNghi(rs.getDate(4));
                nhanvien.setLyDo(rs.getString(5));
                nhanvien.setPhep(rs.getBoolean(6));
                danhsach.add(nhanvien);
            }
            return danhsach;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }

    public void themNghi(Nghi kt) {
         try {
        java.sql.Date NgayNghi = new java.sql.Date(kt.getNgayNghi().getTime());
            String sql = "insert into Nghi(maNhanVien,NgayNghi,LyDo,Phep) values (?,?,?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, kt.getMaNV());
            pre.setDate(2, NgayNghi);
            pre.setString(3, kt.getLyDo());
             pre.setBoolean(4, kt.getPhep());
            pre.executeUpdate();
            new Notification("Thêm thành công",2);
        } catch (SQLException ex) {
            new Notification(""+ex,1);
        } 
    }
}
