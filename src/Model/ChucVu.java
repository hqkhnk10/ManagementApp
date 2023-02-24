/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DHC
 */
public class ChucVu {
    private int MaCV;
    private String TenCV;
    
    public ChucVu(){
        
    }

    public ChucVu(int MaCV, String TenCV) {
        this.MaCV = MaCV;
        this.TenCV = TenCV;
    }

    public int getMaCV() {
        return MaCV;
    }

    public void setMaCV(int MaCV) {
        this.MaCV = MaCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }
    
}
