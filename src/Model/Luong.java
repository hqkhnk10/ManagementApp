/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DHC
 */
public class Luong {
    private int MaNV;
    private String HoTen;
    private String ChucVu;
    private int NgayCongThucTe;
    private double LuongThoaThuan;
    private double PhuCap;
     private String LuongThucTe;
     private double Thue;
     private String ThucTeNhan;
    public Luong(){
        
    }

    public Luong(int MaNV, String HoTen, String ChucVu, int NgayCongThucTe, double LuongThoaThuan, double PhuCap,String LuongThucTe,double Thue,String ThucTeNhan) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.ChucVu = ChucVu;
        this.NgayCongThucTe = NgayCongThucTe;
        this.LuongThoaThuan = LuongThoaThuan;
        this.PhuCap = PhuCap;
        this.LuongThucTe = LuongThucTe;
        this.Thue = Thue;
        this.ThucTeNhan = ThucTeNhan;
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

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public int getNgayCongThucTe() {
        return NgayCongThucTe;
    }

    public void setNgayCongThucTe(int NgayCongThucTe) {
        this.NgayCongThucTe = NgayCongThucTe;
    }

    public double getLuongThoaThuan() {
        return LuongThoaThuan;
    }

    public void setLuongThoaThuan(double LuongThoaThuan) {
        this.LuongThoaThuan = LuongThoaThuan;
    }

    public double getPhuCap() {
        return PhuCap;
    }

    public void setPhuCap(double PhuCap) {
        this.PhuCap = PhuCap;
    }
    
     public String getLuongThucTe() {
        return LuongThucTe;
    }

    public void setLuongThucTe(String LuongThucTe) {
        this.LuongThucTe = LuongThucTe;
    }

    public double getThue() {
        return Thue;
    }
    public void setThue(double Thue) {
        this.Thue=Thue;
    }

    public String getThucTeNhan() {
        return ThucTeNhan;
    }
    public void setThucTeNhan(String thucTeNhan) {
        this.ThucTeNhan= thucTeNhan;
    }
}
