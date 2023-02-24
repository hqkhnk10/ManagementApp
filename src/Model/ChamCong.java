/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.sql.Time;
import javax.swing.JTextField;
/**
 *
 * @author TruongNgo
 */
public class ChamCong {
     private int MaCC;
    private int MaNV;
    private String TenNV;
    private Time GioVao;
     private Time GioRa;
    private Date NgayChamCong;
    
    public ChamCong(){
         
    }

    public ChamCong(int MaCC,int MaNV,String TenNV, Time GioVao,Time GioRa, Date NgayChamCong) {
        this.MaCC = MaCC;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.GioVao = GioVao;
        this.GioRa = GioRa;
        this.NgayChamCong = NgayChamCong;
    }

    public int getMaCC() {
        return MaCC;
    }

    public void setMaCC(int MaCC) {
        this.MaCC = MaCC;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }
    
    public Time getGioVao() {
        return GioVao;
    }

    public void setGioVao(Time GioVao) {
        this.GioVao = GioVao;
    }
    public Time getGioRa() {
        return GioRa;
    }

    public void setGioRa(Time GioRa) {
        this.GioRa = GioRa;
    }
    public Date getNgayChamCong() {
        return NgayChamCong;
    }

    public void setNgayChamCong(Date NgayChamCong) {
        this.NgayChamCong = NgayChamCong;
    }  
    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }    

    public void setMaNV(String MaNV) {
        this.MaNV = Integer.valueOf(MaNV);
    }
}
