/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author DHC
 */
public class KhenThuong {
    private int MaKT;
    private int MaNV;
    private String HoTen;
    private Date NgayKhenThuong;
    private double Tien;
    private String LyDo;
    
    
    public KhenThuong(){
        
    }

    public KhenThuong(int MaKT,int MaNV, String HoTen, Date NgayKhenThuong, double Tien, String LyDo) {
        this.MaKT = MaKT;
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgayKhenThuong = NgayKhenThuong;
        this.Tien = Tien;
        this.LyDo = LyDo;
    }

    
    public int getMaKT() {
        return MaKT;
    }

    public void setMaKT(int MaKT) {
        this.MaKT = MaKT;
    }
    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public Date getNgayKhenThuong() {
        return NgayKhenThuong;
    }

    public void setNgayKhenThuong(Date NgayKhenThuong) {
        this.NgayKhenThuong = NgayKhenThuong;
    }

    public double getTien() {
        return Tien;
    }

    public void setTien(double Tien) {
        this.Tien = Tien;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }
    
    
}
