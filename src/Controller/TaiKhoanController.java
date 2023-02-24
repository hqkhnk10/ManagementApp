/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.NhanVien;
import Model.TaiKhoan;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author TruongNgo
 */
public class TaiKhoanController {
    public NhanVien getDataNhanVien(int maNhanVien){
         try {
            String sql = "SELECT * FROM quanlynhansu.nhanvien where maNhanVien=?;";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setInt(1, maNhanVien);
            ResultSet rs = pre.executeQuery();
                            NhanVien nhanvien = new NhanVien();
            while (rs.next()) {
                nhanvien.setMaNV(rs.getInt(1));
                 nhanvien.setHoTen(rs.getString(2));
                nhanvien.setCMND(rs.getString(3));
                nhanvien.setNgaySinh(rs.getDate(4));
                nhanvien.setDiaChi(rs.getString(5));
                nhanvien.setGioiTinh(rs.getString(6));
                nhanvien.setChucVu(rs.getString(7));
                 nhanvien.setPhongBan(rs.getString(8));
            }
            return nhanvien;
        } catch (SQLException ex) {new Notification(""+ex,1);
        }
        return null;
    }

    public void ThemTaiKhoan(TaiKhoan tk) {
         try{
            String sql = "insert into TaiKhoan(tenDangNhap,matKhau,maNhanVien,quyen) values (?,?,?,?);";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
            pre.setString(1, tk.getTenDangNhap());
            pre.setString(2, tk.getMatKhau());
            pre.setInt(3, tk.getMaNhanVien());
            pre.setString(4, "guest");
            pre.executeUpdate();
             new Notification("Thêm thành công",2);
        } catch (SQLException ex){
            new Notification(""+ex,1);
        }
    }
    
}
