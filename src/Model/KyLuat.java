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
public class KyLuat {
    private int MaKL;
    private int MaNV;
    private String HoTen;
    private Date NgayKyLuat;
    private String LyDo;
    
    public KyLuat(){
        
    }

    public KyLuat(int MaKL,int MaNV, String HoTen, Date NgayKyLuat, String LyDo) {
        this.MaKL = MaKL;
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.NgayKyLuat = NgayKyLuat;
        this.LyDo = LyDo;
    }

    public int getMaKL() {
        return MaKL;
    }

    public void setMaKL(int MaKL) {
        this.MaKL = MaKL;
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

    public Date getNgayKyLuat() {
        return NgayKyLuat;
    }

    public void setNgayKyLuat(Date NgayKyLuat) {
        this.NgayKyLuat = NgayKyLuat;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }
    
}
