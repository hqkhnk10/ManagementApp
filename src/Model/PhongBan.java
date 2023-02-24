/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DHC
 */
public class PhongBan {
    private int MaPB;
    private String TenPB;
    
    public PhongBan(){
        
    }

    public PhongBan(int MaPB, String TenPB) {
        this.MaPB = MaPB;
        this.TenPB = TenPB;
    }

    public int getMaPB() {
        return MaPB;
    }

    public void setMaPB(int MaPB) {
        this.MaPB = MaPB;
    }

    public String getTenPB() {
        return TenPB;
    }

    public void setTenPB(String TenPB) {
        this.TenPB = TenPB;
    }
    
}
