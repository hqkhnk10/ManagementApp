/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author TruongNgo
 */
public class Nghi {
    private int MaNghi;
    private int MaNV;
    private String TenNV;
    private Date NgayNghi;
    private String LyDo;
    private boolean Phep;
    
    public Nghi(){
        
    }

    public Nghi(int MaNghi,int MaNV, String TenNV, Date NgayNghi, String LyDo,boolean Phep) {
        this.MaNghi = MaNghi;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.NgayNghi = NgayNghi;
        this.LyDo = LyDo;
         this.Phep = Phep;
    }

    public int getMaNghi() {
        return MaNghi;
    }

    public void setMaNghi(int MaNghi) {
        this.MaNghi = MaNghi;
    }
    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public Date getNgayNghi() {
        return NgayNghi;
    }

    public void setNgayNghi(Date NgayNghi) {
        this.NgayNghi = NgayNghi;
    }

    public String getLyDo() {
        return LyDo;
    }

    public void setLyDo(String LyDo) {
        this.LyDo = LyDo;
    }
    
    public boolean getPhep() {
        return Phep;
    }

    public void setPhep(boolean Phep) {
        this.Phep = Phep;
    }
}
