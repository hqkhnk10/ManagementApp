/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.TaiKhoan;
import Controller.MyConnnect;
import View.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TruongNgo
 */
public class DangNhap {
    public static TaiKhoan taiKhoanLogin = null;

    public TaiKhoan getTaiKhoanDangNhap(String user, String password) {
        TaiKhoan tk = new TaiKhoan();
        tk.setTenDangNhap(user);
        tk.setMatKhau(password);

        TaiKhoan account = dangNhap(tk);
        taiKhoanLogin = account;
       
        return account;
    }
    
     
     public TaiKhoan dangNhap(TaiKhoan tk) {
        try {
            String sql = "SELECT * FROM taikhoan WHERE TenDangNhap=? AND MatKhau=?";
            PreparedStatement pre = MyConnnect.conn.prepareStatement(sql);
             pre.setString(1, tk.getTenDangNhap());
            pre.setString(2, tk.getMatKhau());
            ResultSet rs = pre.executeQuery();
            TaiKhoan tkLogin = new TaiKhoan();
            if (rs.next()) {
                tkLogin.setTenDangNhap(rs.getString(1));
                tkLogin.setMatKhau(rs.getString(2));
                tkLogin.setMaNhanVien(rs.getInt(3));
                tkLogin.setQuyen(rs.getString(4));
                System.out.println("asdsa"+tkLogin.getTenDangNhap());
            }
            return tkLogin;
        } catch (SQLException e) {
            new Notification(""+e,1);
        }
        return null;
    }
}
