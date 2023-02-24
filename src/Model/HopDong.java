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
public class HopDong {
    private int MaHD;
    private int maNV;
    private String LoaiHD;
    private String TenNV;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private String ghichu;
    
    public HopDong(){
         
    }

    public HopDong(int MaHD,int maNV, String LoaiHD,String TenNV, Date NgayBatDau, Date NgayKetThuc, String ghichu) {
        this.MaHD = MaHD;
        this.maNV = maNV;
        this.LoaiHD = LoaiHD;
        this.TenNV = TenNV;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.ghichu = ghichu;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getmaNV() {
        return maNV;
    }

    public void setmaNV(int maNV) {
        this.maNV = maNV;
    }
    
    public String getLoaiHD() {
        return LoaiHD;
    }

    public void setLoaiHD(String LoaiHD) {
        this.LoaiHD = LoaiHD;
    }
 public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }
    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
    
}
