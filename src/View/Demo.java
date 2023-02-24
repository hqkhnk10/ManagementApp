/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.ChamCongController;
import Controller.ChucVuController;
import Controller.HopDongController;
import Controller.KhenThuongController;
import Controller.KyLuatController;
import Controller.LuongController;
import Controller.NghiController;
import Controller.NhanVienController;
import Controller.PhongBanController;
import Controller.TaiKhoanController;
import Controller.XuLyFileExcel;
import Model.ChamCong;
import Model.ChucVu;
import Model.HopDong;
import Model.KhenThuong;
import Model.KyLuat;
import Model.Luong;
import Model.Nghi;
import Model.NhanVien;
import Model.PhongBan;
import Model.TaiKhoan;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

// tải ảnh
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

//
/**
 *
 * @author DHC
 */
public class Demo extends javax.swing.JFrame  {
TaiKhoan tk;
    private int i=0;
    /**
     * Creates new form Demo
     */
     public Demo() {

        
    }
     public Demo(TaiKhoan tk){
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DemoRun();
            }
        });
         this.tk=tk;
     }
     
    
    public void DemoRun() {
        initComponents();  
        MainTabbedPane.setSelectedIndex(2);
        setVisible(true);
    }
    public void getDataTaiKhoan(){
                 System.out.println(tk.getTenDangNhap()+" "+tk.getMatKhau()+" "+tk.getQuyen()+" "+tk.getMaNhanVien());

        TaiKhoanController controller = new TaiKhoanController();
        NhanVien nhanvien = new NhanVien();
        nhanvien=controller.getDataNhanVien(tk.getMaNhanVien());
        jLabel6.setText(nhanvien.getMaNV()+"");
        jLabel7.setText(nhanvien.getHoTen());
        jLabel47.setText(nhanvien.getCMND());
        jLabel52.setText(nhanvien.getNgaySinh()+"");
        jLabel53.setText(nhanvien.getDiaChi());
        jLabel71.setText(nhanvien.getGioiTinh());
        jLabel72.setText(nhanvien.getChucVu());
        jLabel73.setText(nhanvien.getPhongBan());
        
    }
  
public static void getDataDSHD(){
        HopDongController controller = new HopDongController();
        ArrayList<HopDong> dshd = new ArrayList<>();
        dshd = controller.getListHopDong();
        DefaultTableModel dtmHopDong = new DefaultTableModel();
        dtmHopDong.addColumn("Mã Hợp Đồng");
        dtmHopDong.addColumn("Tên Nhân Viên");
        dtmHopDong.addColumn("Loại Hợp Đồng");
        dtmHopDong.addColumn("Ngày Bắt Đầu");
        dtmHopDong.addColumn("Ngày Kết Thúc");
        dtmHopDong.addColumn("Ghi Chú");
        dtmHopDong.setRowCount(0);
        for (HopDong hd : dshd) {
            Vector<String> vec = new Vector<>();
            vec.add(hd.getMaHD() + "");
            vec.add(hd.getTenNV() + "");
            vec.add(hd.getLoaiHD() + "");
            vec.add(hd.getNgayBatDau() + "");
            vec.add(hd.getNgayKetThuc() + "");
            vec.add(hd.getGhichu() + "");
            dtmHopDong.addRow(vec);
        }
        jTable7.setModel(dtmHopDong);
    }
private void XoaHopDong(int index){
      HopDongController controller = new HopDongController();
      controller.xoaHopDong(index);
      getDataDSHD();
    }
private void TimHopDongTheoLoaiHD(String loaiHD){
    HopDongController controller = new HopDongController();
     ArrayList<HopDong> dshd = new ArrayList<>();
     dshd = controller.TimHopDongTheoLoaiHD(loaiHD);
        DefaultTableModel dtmHopDong = new DefaultTableModel();
        dtmHopDong.addColumn("Mã Hợp Đồng");
        dtmHopDong.addColumn("Tên Nhân Viên");
        dtmHopDong.addColumn("Loại Hợp Đồng");
        dtmHopDong.addColumn("Ngày Bắt Đầu");
        dtmHopDong.addColumn("Ngày Kết Thúc");
        dtmHopDong.addColumn("Ghi Chú");
        dtmHopDong.setRowCount(0);
        for (HopDong hd : dshd) {
            Vector<String> vec = new Vector<>();
            vec.add(hd.getMaHD() + "");
            vec.add(hd.getTenNV() + "");
            vec.add(hd.getLoaiHD() + "");
            vec.add(hd.getNgayBatDau() + "");
            vec.add(hd.getNgayKetThuc() + "");
            vec.add(hd.getGhichu() + "");
            dtmHopDong.addRow(vec);
        }
        jTable7.setModel(dtmHopDong);
    }
private void TimHopDongTheoNgay(String tuNgay,String denNgay){
    HopDongController controller = new HopDongController();
     ArrayList<HopDong> dshd = new ArrayList<>();
     dshd = controller.TimHopDongTheoNgay(tuNgay,denNgay);
        DefaultTableModel dtmHopDong = new DefaultTableModel();
        dtmHopDong.addColumn("Mã Hợp Đồng");
        dtmHopDong.addColumn("Tên Nhân Viên");
        dtmHopDong.addColumn("Loại Hợp Đồng");
        dtmHopDong.addColumn("Ngày Bắt Đầu");
        dtmHopDong.addColumn("Ngày Kết Thúc");
        dtmHopDong.addColumn("Ghi Chú");
        dtmHopDong.setRowCount(0);
        for (HopDong hd : dshd) {
            Vector<String> vec = new Vector<>();
            vec.add(hd.getMaHD() + "");
            vec.add(hd.getTenNV() + "");
            vec.add(hd.getLoaiHD() + "");
            vec.add(hd.getNgayBatDau() + "");
            vec.add(hd.getNgayKetThuc() + "");
            vec.add(hd.getGhichu() + "");
            dtmHopDong.addRow(vec);
        }
        jTable7.setModel(dtmHopDong);
    }

public static void getDataDSKT(){
       KhenThuongController controller = new KhenThuongController();
        ArrayList<KhenThuong> dskt = new ArrayList<>();
        dskt = controller.getListKhenThuong();
        DefaultTableModel dtmKhenThuong = new DefaultTableModel();
        dtmKhenThuong.addColumn("Mã Khen Thưởng");
        dtmKhenThuong.addColumn("Mã Nhân Viên");
        dtmKhenThuong.addColumn("Tên Nhân Viên");
        dtmKhenThuong.addColumn("Ngày Khen Thưởng");
        dtmKhenThuong.addColumn("Tiền Khen Thưởng");
        dtmKhenThuong.addColumn("Lý Do");
        dtmKhenThuong.setRowCount(0);
        for (KhenThuong kt : dskt) {
            Vector<String> vec = new Vector<>();
            vec.add(kt.getMaKT() + "");
            vec.add(kt.getMaNV() + "");
            vec.add(kt.getHoTen() + "");
            vec.add(kt.getNgayKhenThuong() + "");
            vec.add(kt.getTien() + "");
            vec.add(kt.getLyDo() + "");
            dtmKhenThuong.addRow(vec);
        }
        jTable8.setModel(dtmKhenThuong);
   }
private void XoaKhenThuong(int index){
      KhenThuongController controller = new KhenThuongController();
      controller.xoaKhenThuong(index);
      getDataDSKT();
    }
private void TimKTTheoTenNV(String TenNV){
    KhenThuongController controller = new KhenThuongController();
        ArrayList<KhenThuong> dskt = new ArrayList<>();
        dskt = controller.TimKTTheoTenNV(TenNV);
        DefaultTableModel dtmKhenThuong = new DefaultTableModel();
        dtmKhenThuong.addColumn("Mã Khen Thưởng");
        dtmKhenThuong.addColumn("Mã Nhân Viên");
        dtmKhenThuong.addColumn("Tên Nhân Viên");
        dtmKhenThuong.addColumn("Ngày Khen Thưởng");
        dtmKhenThuong.addColumn("Tiền Khen Thưởng");
        dtmKhenThuong.addColumn("Lý Do");
        dtmKhenThuong.setRowCount(0);
        for (KhenThuong kt : dskt) {
            Vector<String> vec = new Vector<>();
            vec.add(kt.getMaKT() + "");
            vec.add(kt.getMaNV() + "");
            vec.add(kt.getHoTen() + "");
            vec.add(kt.getNgayKhenThuong() + "");
            vec.add(kt.getTien() + "");
            vec.add(kt.getLyDo() + "");
            dtmKhenThuong.addRow(vec);
        }
        jTable8.setModel(dtmKhenThuong);
    }
private void TimKTTheoNgay(String tuNgay,String denNgay){
    KhenThuongController controller = new KhenThuongController();
        ArrayList<KhenThuong> dskt = new ArrayList<>();
        dskt = controller.TimKTTheoNgay(tuNgay,denNgay);
        DefaultTableModel dtmKhenThuong = new DefaultTableModel();
        dtmKhenThuong.addColumn("Mã Khen Thưởng");
        dtmKhenThuong.addColumn("Mã Nhân Viên");
        dtmKhenThuong.addColumn("Tên Nhân Viên");
        dtmKhenThuong.addColumn("Ngày Khen Thưởng");
        dtmKhenThuong.addColumn("Tiền Khen Thưởng");
        dtmKhenThuong.addColumn("Lý Do");
        dtmKhenThuong.setRowCount(0);
        for (KhenThuong kt : dskt) {
            Vector<String> vec = new Vector<>();
            vec.add(kt.getMaKT() + "");
            vec.add(kt.getMaNV() + "");
            vec.add(kt.getHoTen() + "");
            vec.add(kt.getNgayKhenThuong() + "");
            vec.add(kt.getTien() + "");
            vec.add(kt.getLyDo() + "");
            dtmKhenThuong.addRow(vec);
        }
        jTable8.setModel(dtmKhenThuong);
    }

public static void getDataDSKyLuat(){
       KyLuatController controller = new KyLuatController();
        ArrayList<KyLuat> danhsach = new ArrayList<>();
        danhsach = controller.getListKyLuat();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Kỷ Luật");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Kỷ Luật");
        dtm.addColumn("Lý Do");
        dtm.setRowCount(0);
        for (KyLuat nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaKL() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getHoTen() + "");
            vec.add(nhanvien.getNgayKyLuat() + "");
            vec.add(nhanvien.getLyDo() + "");
            dtm.addRow(vec);
        }
        jTable9.setModel(dtm);
   }
private void XoaKyLuat(int index){
      KyLuatController controller = new KyLuatController();
      controller.xoaKyLuat(index);
      getDataDSKyLuat();
    }
public  void TimKyLuatTheoTenNV(String tenNV){
       KyLuatController controller = new KyLuatController();
        ArrayList<KyLuat> danhsach = new ArrayList<>();
        danhsach = controller.TimKyLuatTheoTenNV(tenNV);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Kỷ Luật");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Kỷ Luật");
        dtm.addColumn("Lý Do");
        dtm.setRowCount(0);
        for (KyLuat nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaKL() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getHoTen() + "");
            vec.add(nhanvien.getNgayKyLuat() + "");
            vec.add(nhanvien.getLyDo() + "");
            dtm.addRow(vec);
        }
        jTable9.setModel(dtm);
   }
public  void TimKyLuatTheoNgay(String tuNgay,String denNgay){
       KyLuatController controller = new KyLuatController();
        ArrayList<KyLuat> danhsach = new ArrayList<>();
        danhsach = controller.TimKyLuatTheoNgay(tuNgay,denNgay);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Kỷ Luật");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Kỷ Luật");
        dtm.addColumn("Lý Do");
        dtm.setRowCount(0);
        for (KyLuat nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaKL() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getHoTen() + "");
            vec.add(nhanvien.getNgayKyLuat() + "");
            vec.add(nhanvien.getLyDo() + "");
            dtm.addRow(vec);
        }
        jTable9.setModel(dtm);
   }

public static void getDataDSChamCong(int MaNV){
        ChamCongController controller = new ChamCongController();
        ArrayList<ChamCong> danhsach = new ArrayList<>();
        danhsach = controller.getListChamCong(MaNV);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Chấm Công");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Chấm Công");
        dtm.addColumn("Giờ Vào");
        dtm.addColumn("Giờ Ra");
        dtm.setRowCount(0);
        for (ChamCong nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaCC() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getTenNV() + "");
            vec.add(nhanvien.getNgayChamCong() + "");
            vec.add(nhanvien.getGioVao() + "");
            vec.add(nhanvien.getGioRa() + "");
            dtm.addRow(vec);
        }
        jTable4.setModel(dtm);
        jTable10.setModel(dtm);
        
   }
public void TimChamCongTheoNgay(String tuNgay,String denNgay,int MaNV){
     ChamCongController controller = new ChamCongController();
        ArrayList<ChamCong> danhsach = new ArrayList<>();
        danhsach = controller.TimChamCongTheoNgay(tuNgay,denNgay,MaNV);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Chấm Công");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Chấm Công");
        dtm.addColumn("Giờ Vào");
        dtm.addColumn("Giờ Ra");
        dtm.setRowCount(0);
        for (ChamCong nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaCC() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getTenNV() + "");
            vec.add(nhanvien.getNgayChamCong() + "");
            vec.add(nhanvien.getGioVao() + "");
            vec.add(nhanvien.getGioRa() + "");
            dtm.addRow(vec);
        }
        jTable10.setModel(dtm);
}
private void XoaChamCong(int index){
      ChamCongController controller = new ChamCongController();
      controller.xoaChamCong(index);
        getDataDSChamCong(Integer.valueOf(jTextField25.getText()));
    }

public static void getDataDSNghi(){
       NghiController controller = new NghiController();
        ArrayList<Nghi> danhsach = new ArrayList<>();
        danhsach = controller.getListNghi();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nghỉ");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Nghỉ");
        dtm.addColumn("Lý Do");
        dtm.addColumn("Phép");
        dtm.setRowCount(0);
        for (Nghi nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNghi() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getTenNV() + "");
            vec.add(nhanvien.getNgayNghi() + "");
            vec.add(nhanvien.getLyDo() + "");
            if(nhanvien.getPhep()){
                vec.add("Có Phép");
            }
            else{
                vec.add("Không Phép");
            }
            dtm.addRow(vec);
        }
        jTable11.setModel(dtm);
   }
private void TimNghiTheoPhep(boolean Phep){
       NghiController controller = new NghiController();
        ArrayList<Nghi> danhsach = new ArrayList<>();
        danhsach = controller.TimNghiTheoPhep(Phep);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nghỉ");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Nghỉ");
        dtm.addColumn("Lý Do");
        dtm.addColumn("Phép");
        dtm.setRowCount(0);
        for (Nghi nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNghi() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getTenNV() + "");
            vec.add(nhanvien.getNgayNghi() + "");
            vec.add(nhanvien.getLyDo() + "");
            if(nhanvien.getPhep()){
                vec.add("Có Phép");
            }
            else{
                vec.add("Không Phép");
            }
            dtm.addRow(vec);
        }
        jTable11.setModel(dtm);
   }
private void TimNghiTheoNgayTatCa(String tuNgay,String denNgay){
       NghiController controller = new NghiController();
        ArrayList<Nghi> danhsach = new ArrayList<>();
        danhsach = controller.TimNghiTheoNgayTatCa(tuNgay,denNgay);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nghỉ");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Nghỉ");
        dtm.addColumn("Lý Do");
        dtm.addColumn("Phép");
        dtm.setRowCount(0);
        for (Nghi nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNghi() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getTenNV() + "");
            vec.add(nhanvien.getNgayNghi() + "");
            vec.add(nhanvien.getLyDo() + "");
            if(nhanvien.getPhep()){
                vec.add("Có Phép");
            }
            else{
                vec.add("Không Phép");
            }
            dtm.addRow(vec);
        }
        jTable11.setModel(dtm);
   }
private void TimNghiTheoNgay(String tuNgay,String denNgay,boolean phep){
       NghiController controller = new NghiController();
        ArrayList<Nghi> danhsach = new ArrayList<>();
        danhsach = controller.TimNghiTheoNgayPhep(tuNgay,denNgay,phep);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nghỉ");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Ngày Nghỉ");
        dtm.addColumn("Lý Do");
        dtm.addColumn("Phép");
        dtm.setRowCount(0);
        for (Nghi nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNghi() + "");
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getTenNV() + "");
            vec.add(nhanvien.getNgayNghi() + "");
            vec.add(nhanvien.getLyDo() + "");
            if(nhanvien.getPhep()){
                vec.add("Có Phép");
            }
            else{
                vec.add("Không Phép");
            }
            dtm.addRow(vec);
        }
        jTable11.setModel(dtm);
   }
private void XoaNghi(int index){
     NghiController controller = new NghiController();
     controller.xoaNghi(index);
     getDataDSNghi();
}

public static void getDataDSNhanVien(){
       NhanVienController controller = new NhanVienController();
        ArrayList<NhanVien> danhsach = new ArrayList<>();
        danhsach = controller.getListNhanVien();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("CMND");
        dtm.addColumn("NgaySinh");
        dtm.addColumn("Giới Tính");
        dtm.addColumn("Địa Chỉ");
        dtm.addColumn("Chức Vụ");
        dtm.addColumn("Phòng Ban");
        dtm.setRowCount(0);
        for (NhanVien nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getHoTen() + "");
            vec.add(nhanvien.getCMND()+"");
            vec.add(nhanvien.getNgaySinh()+"");
             vec.add(nhanvien.getGioiTinh()+"");
            vec.add(nhanvien.getDiaChi() + "");
            vec.add(nhanvien.getChucVu() + "");
             vec.add(nhanvien.getPhongBan() + "");
           
            dtm.addRow(vec);
        }
        jTable12.setModel(dtm);
           
   }
public static void TimNhanVienTheoTen(String tenNV){
       NhanVienController controller = new NhanVienController();
        ArrayList<NhanVien> danhsach = new ArrayList<>();
        danhsach = controller.TimNhanVienTheoTen(tenNV);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("CMND");
        dtm.addColumn("NgaySinh");
        dtm.addColumn("Giới Tính");
        dtm.addColumn("Địa Chỉ");
        dtm.addColumn("Chức Vụ");
        dtm.addColumn("Phòng Ban");
        dtm.setRowCount(0);
        for (NhanVien nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getHoTen() + "");
            vec.add(nhanvien.getCMND()+"");
            vec.add(nhanvien.getNgaySinh()+"");
             vec.add(nhanvien.getGioiTinh()+"");
            vec.add(nhanvien.getDiaChi() + "");
            vec.add(nhanvien.getChucVu() + "");
             vec.add(nhanvien.getPhongBan() + "");
           
            dtm.addRow(vec);
        }
        jTable12.setModel(dtm);
   }
private void XoaNhanVien(int index){
      NhanVienController controller = new NhanVienController();
      controller.xoaNhanVien(index);
      getDataDSHD();
    }

public static void getDataDSLuong(String Thang,String Nam,int loaiTimKiem,String ThongTinTimKiem){
       LuongController controller = new LuongController();
        ArrayList<Luong> danhsach = new ArrayList<>();
        if(loaiTimKiem == 0){
        danhsach = controller.getListLuongMaNV(Integer.parseInt(Thang),Integer.parseInt(Nam),Integer.parseInt(ThongTinTimKiem));}
        if(loaiTimKiem == 1){
        danhsach = controller.getListLuongTenNV(Integer.parseInt(Thang),Integer.parseInt(Nam),ThongTinTimKiem);}
         if(loaiTimKiem == 2){
        danhsach = controller.getListLuongTatCa(Integer.parseInt(Thang),Integer.parseInt(Nam));}
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Chức Vụ");
        dtm.addColumn("Ngày Công Thực Tế");
        dtm.addColumn("Lương Thỏa Thuận");
        dtm.addColumn("Phụ Cấp");
        dtm.addColumn("Lương Thực Tế");
        dtm.addColumn("Trừ Thuế");
        dtm.addColumn("Thực Tế Nhận");
        dtm.setRowCount(0);
        Double TongLuong=0.0,TongThucTe=0.0;
        for (Luong nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getHoTen() + "");
            vec.add(nhanvien.getChucVu() + "");
            vec.add(nhanvien.getNgayCongThucTe() + "");
            vec.add(nhanvien.getLuongThoaThuan() + "");
            vec.add(nhanvien.getPhuCap() + "");
            vec.add(nhanvien.getLuongThucTe() + "");
            TongLuong += Double.parseDouble(nhanvien.getLuongThucTe());
            vec.add(nhanvien.getThue() + "");
            vec.add(nhanvien.getThucTeNhan() + "");
             TongThucTe += Double.parseDouble(nhanvien.getThucTeNhan());
            dtm.addRow(vec);
        }
        String luongthucte="",thuctenhan="";
                 DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(0);
        luongthucte=df.format(TongLuong);
        thuctenhan=df.format(TongThucTe);
        dtm.addRow(new Object[]{null});
        dtm.addRow(new Object[]{"Tổng Cộng", null, null,null,null, null,luongthucte,null,thuctenhan});
      DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jTable3.setModel(dtm);
        for(int i=0;i<9;i++){
        jTable3.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }
   }

public static void getDataDSPB(){
        PhongBanController pbc = new PhongBanController();
        ArrayList<PhongBan> dspb = new ArrayList<>();
        dspb = pbc.getListPhongBan();
        DefaultTableModel dtmPhongBan = new DefaultTableModel();
        dtmPhongBan.addColumn(" Mã phòng ban");
        dtmPhongBan.addColumn("Tên phòng ban");
        dtmPhongBan.setRowCount(0);
        
        for (PhongBan pb : dspb){
            Vector<String> vec = new Vector<>();
            vec.add(pb.getMaPB() + "");
            vec.add(pb.getTenPB() + "");
            dtmPhongBan.addRow(vec);
            
        }
        tblPB.setModel(dtmPhongBan);
    }
    private void XoaPhongBan(int index){
        PhongBanController pbc = new PhongBanController();
        pbc.xoaPhongBan(index);
        getDataDSPB();
   
   }
    private void TimPBTheoTen(String TenPB){
        PhongBanController pbc = new PhongBanController();
        ArrayList<PhongBan> dspb = new ArrayList<>();
        dspb = pbc.TimPBTheoTen(TenPB);
        DefaultTableModel dtmPhongBan = new DefaultTableModel();
       dtmPhongBan.addColumn("Mã phòng ban");
       dtmPhongBan.addColumn("Tên phòng ban");
       dtmPhongBan.setRowCount(0);
       for (PhongBan pb : dspb){
           Vector<String> vec = new Vector<>();
           vec.add(pb.getMaPB() + "");
           vec.add(pb.getTenPB() + "");
           dtmPhongBan.addRow(vec);
           }
       tblPB.setModel(dtmPhongBan);
    }
// danh sách chức vụ
public static void getDataDSCV() {  
    ChucVuController CV = new ChucVuController();
    ArrayList<ChucVu> dscv = new ArrayList<>();
    dscv = CV.getListChucVu();
    DefaultTableModel dtmChucVu = new DefaultTableModel();
    dtmChucVu.addColumn("Mã chức vụ ");
    dtmChucVu.addColumn("Tên chức vụ ");
    dtmChucVu.setRowCount(0);
    for (ChucVu cv : dscv ){
        Vector<String> vec = new Vector<>();
        vec.add(cv.getMaCV() + "");
        vec.add(cv.getTenCV() + "");
        dtmChucVu.addRow(vec);
        }
    tblCV.setModel(dtmChucVu);
    
}
public static void TimChucVuTheoTen(String tenCV){ 
        ChucVuController CV = new ChucVuController();
        ArrayList<ChucVu> dscv = new ArrayList<>();
        dscv = CV.TimChucVuTheoTen(tenCV);
        DefaultTableModel dtmChucVu = new DefaultTableModel();
        dtmChucVu.addColumn("Mã phòng ban");
        dtmChucVu.addColumn("Tên phòng ban");
        dtmChucVu.setRowCount(0);
        for (ChucVu cv : dscv){
           Vector<String> vec = new Vector<>();
           vec.add(cv.getMaCV() + "");
           vec.add(cv.getTenCV() + "");
           dtmChucVu.addRow(vec);
           }
        tblPB.setModel(dtmChucVu);
    }
private void XoaChucVu(int index){
      ChucVuController CV = new ChucVuController();
      CV.xoaChucVu(index);
      getDataDSCV();
    }    

public static void getDataDSLuongNV(String Thang,String Nam,int loaiTimKiem,String ThongTinTimKiem){
       LuongController controller = new LuongController();
        ArrayList<Luong> danhsach = new ArrayList<>();
        if(loaiTimKiem == 0){
        danhsach = controller.getListLuongMaNV(Integer.parseInt(Thang),Integer.parseInt(Nam),Integer.parseInt(ThongTinTimKiem));}
        if(loaiTimKiem == 1){
        danhsach = controller.getListLuongTenNV(Integer.parseInt(Thang),Integer.parseInt(Nam),ThongTinTimKiem);}
         if(loaiTimKiem == 2){
        danhsach = controller.getListLuongTatCa(Integer.parseInt(Thang),Integer.parseInt(Nam));}
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Tên Nhân Viên");
        dtm.addColumn("Lương Thỏa Thuận");
        dtm.addColumn("Phụ Cấp");
        dtm.setRowCount(0);
        for (Luong nhanvien : danhsach) {
            Vector<String> vec = new Vector<>();
            vec.add(nhanvien.getMaNV() + "");
            vec.add(nhanvien.getHoTen() + "");
            vec.add(nhanvien.getLuongThoaThuan() + "");
            vec.add(nhanvien.getPhuCap() + "");
            dtm.addRow(vec);
        }
       jTable1.setModel(dtm);
   }
private void XoaLuong(int index){
      LuongController controller = new LuongController();
      controller.xoaLuong(index);
      jButton14.doClick();
    }

/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblQLNV = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblQLPB = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblCC = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        lblQLL = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lblTTCN = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        MainTabbedPane = new javax.swing.JTabbedPane();
        pnlQLNV = new javax.swing.JPanel();
        QLNVTabbedPane = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        btnThemMoiHopDong = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        btnThemMoiKhenThuong = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jButton30 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton48 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        btnThemMoiKyLuat = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jButton34 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jButton59 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jButton37 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jTextField28 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel24 = new javax.swing.JPanel();
        btnThemMoiNhanVien = new javax.swing.JButton();
        jTextField30 = new javax.swing.JTextField();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jRadioButton19 = new javax.swing.JRadioButton();
        jRadioButton20 = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        jRadioButton22 = new javax.swing.JRadioButton();
        jLabel48 = new javax.swing.JLabel();
        jButton44 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField11 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pnlCC = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        QLPBTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnThemMoiPhongBan = new javax.swing.JButton();
        txtNhapTenPB = new javax.swing.JTextField();
        btnTimKiemPB = new javax.swing.JButton();
        btnXoaPB = new javax.swing.JButton();
        btnSuaPB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPB = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThemMoiChucVu = new javax.swing.JButton();
        txtTenCV = new javax.swing.JTextField();
        btnTimKiemCV = new javax.swing.JButton();
        btnXoaCV = new javax.swing.JButton();
        btnSuaCV = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCV = new javax.swing.JTable();
        pnlTTCN = new javax.swing.JPanel();
        btnClock = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jButton40 = new javax.swing.JButton();
        jTextField9 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        pnlQLPB = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jTextField33 = new javax.swing.JTextField();
        jButton56 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel58 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        pnlQLPB1 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lblAnh = new javax.swing.JLabel();
        btnTaiAnh = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("THÔNG TIN CÁ NHÂN");

        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Mã nhân viên :");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Họ và tên :");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("CMND :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Ảnh ");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Ngày Sinh :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("Địa chỉ :");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_upload_25px_1.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel9.setText("Ảnh đại diện");

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Giới tính :");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Chức vụ :");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setText("Số điện thoại :");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Quê quán :");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_data_sheet_32px.png"))); // NOI18N
        jButton2.setText("Xem bảng lương");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Female_User_Update_32px.png"))); // NOI18N
        jButton1.setText("Cập nhật ");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên hành chính", "Nhân viên nhân sự" }));

        jRadioButton1.setText("Nam");

        jRadioButton2.setText("Nữ");

        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ NHÂN SỰ VÀ TIỀN LƯƠNG");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(23, 35, 51));

        jPanel11.setBackground(new java.awt.Color(23, 35, 51));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_myspace_3_30px.png"))); // NOI18N

        lblQLNV.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblQLNV.setForeground(new java.awt.Color(255, 255, 255));
        lblQLNV.setText("Quản lý nhân viên");
        lblQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLNVMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(lblQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(23, 35, 51));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_room_30px_1.png"))); // NOI18N

        lblQLPB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblQLPB.setForeground(new java.awt.Color(255, 255, 255));
        lblQLPB.setText("Quản lý phòng ban");
        lblQLPB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLPBMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblQLPB)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblQLPB)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(23, 35, 51));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_property_30px.png"))); // NOI18N

        lblCC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCC.setForeground(new java.awt.Color(255, 255, 255));
        lblCC.setText("Chấm công");
        lblCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCCMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(lblCC, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Apartment_100px.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(23, 35, 51));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_paycheque_30px.png"))); // NOI18N

        lblQLL.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblQLL.setForeground(new java.awt.Color(255, 255, 255));
        lblQLL.setText("Quản lý lương nhân viên");
        lblQLL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQLLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblQLL)
                .addGap(142, 142, 142)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQLL)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(23, 35, 51));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_male_user_30px.png"))); // NOI18N

        lblTTCN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTTCN.setForeground(new java.awt.Color(255, 255, 255));
        lblTTCN.setText("Thông tin cá nhân");
        lblTTCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTTCNMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTTCN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTTCN)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator6)
                            .addGroup(pnlMenuLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlMenuLayout.createSequentialGroup()
                                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jSeparator5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)))))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(888, 888, 888))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator2)))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(540, 540, 540)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)))
                .addGap(569, 569, 569)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 300, 650));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        MainTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        MainTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MainTabbedPaneStateChanged(evt);
            }
        });

        pnlQLNV.setBackground(new java.awt.Color(255, 255, 255));

        QLNVTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                QLNVTabbedPaneStateChanged(evt);
            }
        });

        btnThemMoiHopDong.setBackground(new java.awt.Color(0, 102, 102));
        btnThemMoiHopDong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemMoiHopDong.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoiHopDong.setText("Thêm mới hợp đồng");
        btnThemMoiHopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiHopDongActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Tìm kiếm theo ngày (yyyy-mm-dd):");

        jTextField16.setForeground(new java.awt.Color(153, 153, 153));
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jTable7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jLabel33.setText("Từ :");

        jLabel34.setText("Đến :");

        jTextField17.setForeground(new java.awt.Color(153, 153, 153));
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jTextField18.setForeground(new java.awt.Color(153, 153, 153));

        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        jButton27.setText("Delete");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton28.setText("Edit ");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        jButton29.setBorder(null);
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel65.setText("Tìm kiếm theo loại hợp đồng:");

        jButton33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        jButton33.setBorder(null);
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemMoiHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addGap(33, 33, 33))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton29))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel34)))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton33))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2285, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnThemMoiHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32)
                                .addComponent(jLabel33)
                                .addComponent(jLabel34)
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton33))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton28)
                                .addComponent(jButton27))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel65)))
                            .addComponent(jButton29))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        QLNVTabbedPane.addTab("Danh sách hợp đồng", jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        btnThemMoiKhenThuong.setBackground(new java.awt.Color(0, 102, 102));
        btnThemMoiKhenThuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemMoiKhenThuong.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoiKhenThuong.setText("Thêm mới khen thưởng");
        btnThemMoiKhenThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiKhenThuongActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Từ:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Tìm kiếm theo thời gian:");

        jTextField19.setForeground(new java.awt.Color(153, 153, 153));

        jTextField20.setForeground(new java.awt.Color(153, 153, 153));

        jTextField21.setForeground(new java.awt.Color(153, 153, 153));
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_32px_2.png"))); // NOI18N
        jButton30.setBorder(null);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ Tên ", "Ngày khen thưởng", "Tiền khen thưởng", "Lý do"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable8);

        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton31.setText("Edit ");

        jButton32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        jButton32.setText("Delete");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_32px_2.png"))); // NOI18N
        jButton43.setBorder(null);
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jButton48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton48.setBorder(null);

        jButton55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_1.png"))); // NOI18N
        jButton55.setText("Delete");
        jButton55.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });

        jButton57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton57.setText("Edit");
        jButton57.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel66.setText("Đến:");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setText("Tìm kiếm theo tên nhân viên:");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel67)
                        .addGap(95, 95, 95)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton32)
                .addGap(98, 98, 98)
                .addComponent(jButton31)
                .addGap(278, 278, 278))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnThemMoiKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 2285, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnThemMoiKhenThuong, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField19, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton31)
                            .addComponent(jButton32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(407, 407, 407))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton55, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton57, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        QLNVTabbedPane.addTab("Danh sách khen thưởng", jPanel20);

        btnThemMoiKyLuat.setBackground(new java.awt.Color(0, 102, 102));
        btnThemMoiKyLuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemMoiKyLuat.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoiKyLuat.setText("Thêm mới kỷ luật");
        btnThemMoiKyLuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiKyLuatActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Tìm kiếm theo thời gian:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel38.setText("Đến:");

        jTextField22.setForeground(new java.awt.Color(153, 153, 153));

        jTextField23.setForeground(new java.awt.Color(153, 153, 153));

        jTextField24.setForeground(new java.awt.Color(153, 153, 153));
        jTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_32px_2.png"))); // NOI18N
        jButton34.setBorder(null);
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Tên", "Ngày Kỷ Luật", "Lý do"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable9);

        jButton35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        jButton35.setText("Delete");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton36.setText("Edit ");

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setText("Từ:");

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setText("Tìm kiếm theo tên nhân viên:");

        jButton47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_32px_2.png"))); // NOI18N
        jButton47.setBorder(null);
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });

        jButton58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_1.png"))); // NOI18N
        jButton58.setText("Delete");
        jButton58.setBorder(null);
        jButton58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton58ActionPerformed(evt);
            }
        });

        jButton59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton59.setText("Edit");
        jButton59.setBorder(null);
        jButton59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton59ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThemMoiKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton35)
                        .addGap(18, 18, 18)
                        .addComponent(jButton36))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(69, 69, 69)
                                .addComponent(jLabel68))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel69)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel38))
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2069, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(btnThemMoiKyLuat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton47, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton59, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 39, Short.MAX_VALUE))))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        QLNVTabbedPane.addTab("Danh sách kỷ luật", jPanel21);

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel39.setText("Tìm kiếm theo mã nhân viên:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setText("Tìm kiếm theo ngày :");

        jTextField25.setForeground(new java.awt.Color(204, 204, 255));
        jTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField25ActionPerformed(evt);
            }
        });

        jButton37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        jButton37.setBorder(null);
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Chấm Công", "Mã nhân viên", "Họ Tên", "Ngày", "Giờ vào", "Giờ ra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable10);

        jLabel41.setText("Từ : ");

        jTextField26.setForeground(new java.awt.Color(153, 153, 153));

        jLabel42.setText("Đến :");

        jTextField27.setForeground(new java.awt.Color(153, 153, 153));
        jTextField27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField27ActionPerformed(evt);
            }
        });

        jButton38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton38.setText("Edit ");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        jButton39.setText("Delete");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        jButton60.setBorder(null);
        jButton60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton60ActionPerformed(evt);
            }
        });

        jButton62.setBackground(new java.awt.Color(0, 102, 102));
        jButton62.setForeground(new java.awt.Color(255, 255, 255));
        jButton62.setText("Thêm Mới Chấm Công");
        jButton62.setBorder(null);
        jButton62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton62ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2287, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel41)
                                .addGap(46, 46, 46)
                                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel42)
                                .addGap(67, 67, 67)
                                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton60))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(22, 22, 22)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton37)
                                .addGap(50, 50, 50)
                                .addComponent(jButton39)
                                .addGap(38, 38, 38)
                                .addComponent(jButton38))))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jButton62, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(jLabel41)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton60))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton39)
                        .addComponent(jButton38))
                    .addComponent(jButton37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        QLNVTabbedPane.addTab("Danh sách chấm công", jPanel22);

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setText("Tìm kiếm theo ngày :");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setText("Tìm kiếm theo trạng thái :");

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ Tên", "Ngày nghỉ", "Lí do"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable11.setSelectionBackground(new java.awt.Color(39, 89, 200));
        jScrollPane11.setViewportView(jTable11);

        jTextField28.setForeground(new java.awt.Color(153, 153, 153));

        jTextField29.setForeground(new java.awt.Color(153, 153, 153));

        jLabel45.setText("Từ :");

        jLabel46.setText("Đến :");

        jButton41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        jButton41.setText("Delete");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton42.setText("Edit ");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        jButton61.setBorder(null);
        jButton61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton61ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Có Phép", "Không Phép" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel43)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel45))
                            .addComponent(jLabel44))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(jButton41)
                                .addGap(64, 64, 64)
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton61)))))
                .addContainerGap(2287, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton61, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton41)
                        .addComponent(jButton42))
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        QLNVTabbedPane.addTab("Danh sách ngày nghỉ", jPanel23);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        btnThemMoiNhanVien.setBackground(new java.awt.Color(0, 102, 102));
        btnThemMoiNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemMoiNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoiNhanVien.setText("Thêm mới nhân viên");
        btnThemMoiNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiNhanVienActionPerformed(evt);
            }
        });

        jTextField30.setForeground(new java.awt.Color(204, 204, 255));
        jTextField30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jRadioButton17.setText("Tất cả");

        jRadioButton18.setText("Nghỉ việc");

        jRadioButton19.setText("Đang làm việc");

        jRadioButton20.setText("Tên nhân viên");

        jRadioButton21.setText("Mã nhân viên");

        jRadioButton22.setText("Phòng ban");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setText("Tìm kiếm theo tên nhân viên:");

        jButton44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_32px_2.png"))); // NOI18N
        jButton44.setBorder(null);
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "CMND", "Tài khoản", "Giới tính", "Địa chỉ", "Chức vụ", "Phòng ban"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTable12);

        jButton45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        jButton45.setText("Delete");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });

        jButton46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        jButton46.setText("Edit ");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });

        jButton50.setText("Xuất Excel");
        jButton50.setBorder(null);
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1031, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(581, 581, 581)
                        .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(2285, Short.MAX_VALUE))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(btnThemMoiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jLabel48)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton17)
                            .addComponent(jRadioButton21))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton19)
                            .addComponent(jRadioButton20))
                        .addGap(109, 109, 109)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton18)
                            .addComponent(jRadioButton22)))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton17)
                            .addComponent(jRadioButton18)
                            .addComponent(jRadioButton19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton20)
                            .addComponent(jRadioButton21)
                            .addComponent(jRadioButton22)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemMoiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton45)
                            .addComponent(jButton46)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        QLNVTabbedPane.addTab("Danh sách nhân viên", jPanel24);

        jButton10.setBackground(new java.awt.Color(0, 102, 102));
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Thêm Mới Lương");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_edit_35px.png"))); // NOI18N
        jButton11.setText("Sửa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Delete_Trash_35px_1.png"))); // NOI18N
        jButton12.setText("Xóa");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Google_Web_Search_32px_1.png"))); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        jLabel13.setText("Tìm kiếm theo ngày:");

        jLabel74.setText("Tìm kiếm theo:");

        jLabel75.setText("Tháng:");

        jLabel76.setText("Năm:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Nhân Viên", "Tên Nhân Viên", "Tất Cả" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton11)
                                .addGap(71, 71, 71)
                                .addComponent(jButton12)
                                .addGap(80, 80, 80))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(15, 15, 15)
                                .addComponent(jLabel75)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel76)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButton14))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addGap(30, 30, 30)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(2546, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2380, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(jLabel76)
                    .addComponent(jLabel74)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton11)
                            .addComponent(jButton12)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton14)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(364, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(189, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );

        QLNVTabbedPane.addTab("Danh sách Lương", jPanel10);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout pnlQLNVLayout = new javax.swing.GroupLayout(pnlQLNV);
        pnlQLNV.setLayout(pnlQLNVLayout);
        pnlQLNVLayout.setHorizontalGroup(
            pnlQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLNVLayout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(QLNVTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlQLNVLayout.setVerticalGroup(
            pnlQLNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QLNVTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        MainTabbedPane.addTab("1", pnlQLNV);

        pnlCC.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("QUẢN LÝ PHÒNG BAN");

        QLPBTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        QLPBTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                QLPBTabbedPaneStateChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThemMoiPhongBan.setBackground(new java.awt.Color(0, 102, 102));
        btnThemMoiPhongBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemMoiPhongBan.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoiPhongBan.setText("Thêm mới phòng ban");
        btnThemMoiPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiPhongBanActionPerformed(evt);
            }
        });

        txtNhapTenPB.setForeground(new java.awt.Color(153, 153, 153));
        txtNhapTenPB.setText("Nhập tên phòng ban cần tìm");
        txtNhapTenPB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnTimKiemPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        btnTimKiemPB.setBorder(null);
        btnTimKiemPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemPBActionPerformed(evt);
            }
        });

        btnXoaPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        btnXoaPB.setText("Delete");
        btnXoaPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPBActionPerformed(evt);
            }
        });

        btnSuaPB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        btnSuaPB.setText("Edit ");
        btnSuaPB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPBActionPerformed(evt);
            }
        });

        tblPB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã phòng ban", "Tên phòng ban"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPB);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNhapTenPB, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnTimKiemPB)
                        .addGap(40, 40, 40)
                        .addComponent(btnXoaPB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaPB))
                    .addComponent(btnThemMoiPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2286, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTimKiemPB)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThemMoiPhongBan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtNhapTenPB, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoaPB)
                            .addComponent(btnSuaPB))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        QLPBTabbedPane.addTab("Danh sách phòng ban", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnThemMoiChucVu.setBackground(new java.awt.Color(0, 102, 102));
        btnThemMoiChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThemMoiChucVu.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMoiChucVu.setText("Thêm mới chức vụ");
        btnThemMoiChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiChucVuActionPerformed(evt);
            }
        });

        txtTenCV.setForeground(new java.awt.Color(153, 153, 153));
        txtTenCV.setText("Chức vụ cần tìm");
        txtTenCV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btnTimKiemCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        btnTimKiemCV.setBorder(null);
        btnTimKiemCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemCVActionPerformed(evt);
            }
        });

        btnXoaCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_35px_6.png"))); // NOI18N
        btnXoaCV.setText("Delete");
        btnXoaCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaCVActionPerformed(evt);
            }
        });

        btnSuaCV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_35px_2.png"))); // NOI18N
        btnSuaCV.setText("Edit ");
        btnSuaCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCVActionPerformed(evt);
            }
        });

        tblCV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã chức vụ", "Tên Chức vụ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblCV);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThemMoiChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnTimKiemCV)
                        .addGap(52, 52, 52)
                        .addComponent(btnXoaCV)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaCV)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2288, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoaCV)
                        .addComponent(btnSuaCV))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnThemMoiChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenCV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiemCV))))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        QLPBTabbedPane.addTab("Danh sách chức vụ", jPanel5);

        javax.swing.GroupLayout pnlCCLayout = new javax.swing.GroupLayout(pnlCC);
        pnlCC.setLayout(pnlCCLayout);
        pnlCCLayout.setHorizontalGroup(
            pnlCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCCLayout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(QLPBTabbedPane)
        );
        pnlCCLayout.setVerticalGroup(
            pnlCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCCLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QLPBTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainTabbedPane.addTab("2", pnlCC);

        pnlTTCN.setBackground(new java.awt.Color(255, 255, 255));

        btnClock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClock.setText("Clock");
        btnClock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClockActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setText("Giờ :");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setText("Tìm kiếm theo ngày :");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setText("Tìm kiếm theo mã nhân viên :");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setText("Từ :");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setText("Đến :");

        jTextField36.setText("dd/mm/yyyy");

        jTextField37.setText("dd/mm/yyyy");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Chấm Công", "Mã nhân viên", "Họ tên", "Ngày", "Giờ vào", "Giờ ra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jButton7.setText("Chấm Công");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Tan Ca");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setText("Tìm kiếm theo mã nhân viên:");

        jTextField31.setForeground(new java.awt.Color(204, 204, 255));
        jTextField31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        jButton40.setBorder(null);
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jButton9.setText("OK");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTTCNLayout = new javax.swing.GroupLayout(pnlTTCN);
        pnlTTCN.setLayout(pnlTTCNLayout);
        pnlTTCNLayout.setHorizontalGroup(
            pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTCNLayout.createSequentialGroup()
                .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTTCNLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlTTCNLayout.createSequentialGroup()
                                .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel62)
                                    .addComponent(jButton7))
                                .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlTTCNLayout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlTTCNLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton9))))
                            .addGroup(pnlTTCNLayout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel63)
                                .addGap(19, 19, 19)
                                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlTTCNLayout.createSequentialGroup()
                                .addComponent(jLabel60)
                                .addGap(18, 18, 18)
                                .addComponent(btnClock, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(jLabel64)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(2288, Short.MAX_VALUE))
            .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTTCNLayout.createSequentialGroup()
                    .addGap(1390, 1390, 1390)
                    .addComponent(jLabel55)
                    .addGap(22, 22, 22)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton40)
                    .addContainerGap(1435, Short.MAX_VALUE)))
        );
        pnlTTCNLayout.setVerticalGroup(
            pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTCNLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(18, 18, 18)
                .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClock)
                    .addComponent(jLabel60))
                .addGap(27, 27, 27)
                .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
            .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTTCNLayout.createSequentialGroup()
                    .addGap(312, 312, 312)
                    .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlTTCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addComponent(jButton40))
                    .addContainerGap(312, Short.MAX_VALUE)))
        );

        MainTabbedPane.addTab("3", pnlTTCN);

        pnlQLPB.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel57.setText("QUẢN LÝ LƯƠNG NHÂN VIÊN");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jTextField33.setForeground(new java.awt.Color(153, 153, 153));
        jTextField33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jButton56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Google_Web_Search_35px.png"))); // NOI18N
        jButton56.setBorder(null);
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Chức vụ", "Ngày công thực tế", "Lương thoả thuận", "Phụ cấp", "Lương thực tế"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.setShowGrid(true);
        jScrollPane3.setViewportView(jTable3);

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel58.setText("Năm :");

        jTextField35.setForeground(new java.awt.Color(153, 153, 153));
        jTextField35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jTextField34.setForeground(new java.awt.Color(153, 153, 153));
        jTextField34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setText("Tháng :");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setText("Tìm kiếm theo :");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Nhân Viên", "Tên Nhân Viên", "Tất Cả" }));

        jButton6.setText("Xuất Excel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel56)
                                .addGap(30, 30, 30)
                                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel58)
                                .addGap(37, 37, 37)
                                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jButton56)
                        .addGap(129, 129, 129)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlQLPBLayout = new javax.swing.GroupLayout(pnlQLPB);
        pnlQLPB.setLayout(pnlQLPBLayout);
        pnlQLPBLayout.setHorizontalGroup(
            pnlQLPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLPBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlQLPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlQLPBLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1209, Short.MAX_VALUE))
        );
        pnlQLPBLayout.setVerticalGroup(
            pnlQLPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLPBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addGroup(pnlQLPBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQLPBLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlQLPBLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))))
        );

        MainTabbedPane.addTab("4", pnlQLPB);

        pnlQLPB1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("THÔNG TIN CÁ NHÂN");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel27.setText("Ảnh đại diện");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setText("Mã nhân viên :");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("CMND :");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Địa chỉ :");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setText("Ngày Sinh :");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setText("Chức vụ :");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setText("Giới tính :");

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Female_User_Update_32px.png"))); // NOI18N
        jButton4.setText("Cập nhật ");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_data_sheet_32px.png"))); // NOI18N
        jButton5.setText("Xem bảng lương");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setText("Họ và tên :");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        lblAnh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAnh.setText("Ảnh ");
        lblAnh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnTaiAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_upload_25px_1.png"))); // NOI18N
        btnTaiAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnTaiAnh)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnTaiAnh))
        );

        jLabel70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel70.setText("Phòng ban:");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel6");

        jLabel47.setText("jLabel6");

        jLabel52.setText("jLabel6");

        jLabel53.setText("jLabel6");

        jLabel71.setText("jLabel6");

        jLabel72.setText("jLabel6");

        jLabel73.setText("jLabel6");

        javax.swing.GroupLayout pnlQLPB1Layout = new javax.swing.GroupLayout(pnlQLPB1);
        pnlQLPB1.setLayout(pnlQLPB1Layout);
        pnlQLPB1Layout.setHorizontalGroup(
            pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLPB1Layout.createSequentialGroup()
                .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQLPB1Layout.createSequentialGroup()
                        .addGap(421, 421, 421)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jButton5))
                    .addGroup(pnlQLPB1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlQLPB1Layout.createSequentialGroup()
                                .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel30))
                                .addGap(77, 77, 77)
                                .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(119, 119, 119)
                                .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel70))
                                .addGap(18, 18, 18)
                                .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlQLPB1Layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlQLPB1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel27)))
                .addContainerGap(488, Short.MAX_VALUE))
        );
        pnlQLPB1Layout.setVerticalGroup(
            pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlQLPB1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlQLPB1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlQLPB1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(68, 68, 68)
                        .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(jLabel51)
                                .addComponent(jLabel71))
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jLabel50)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                            .addComponent(jLabel72, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(jLabel70)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                            .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addGroup(pnlQLPB1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(252, 252, 252))))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3316, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(pnlQLPB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2001, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlQLPB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        MainTabbedPane.addTab("5", jPanel6);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(MainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(MainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 1130, 650));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("QUẢN LÝ NHÂN SỰ VÀ TIỀN LƯƠNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(563, 563, 563)
                .addComponent(jLabel2)
                .addContainerGap(554, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá ngày nghỉ không?") == JOptionPane.NO_OPTION ){
            return;
        }
        XoaNghi( Integer.valueOf((String)jTable11.getValueAt(jTable11.getSelectedRow(),0)));
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnClockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClockActionPerformed
       
        ClockThread th = new ClockThread(btnClock);
        th.start();
        btnClock.setEnabled(true);
        
    }//GEN-LAST:event_btnClockActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lblCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCCMouseClicked
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(2);

    }//GEN-LAST:event_lblCCMouseClicked

    private void lblQLPBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLPBMouseClicked
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(1);

    }//GEN-LAST:event_lblQLPBMouseClicked

    private void lblQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLNVMouseClicked
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_lblQLNVMouseClicked

    private void lblQLLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQLLMouseClicked
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(3);
    }//GEN-LAST:event_lblQLLMouseClicked

    private void lblTTCNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTTCNMouseClicked
        // TODO add your handling code here:
        MainTabbedPane.setSelectedIndex(4);
        getDataTaiKhoan();
    }//GEN-LAST:event_lblTTCNMouseClicked

    private void btnThemMoiHopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiHopDongActionPerformed
        ThemMoiHopDong inputHĐ = new ThemMoiHopDong(this,rootPaneCheckingEnabled);
        inputHĐ.setVisible(true);
        
    }//GEN-LAST:event_btnThemMoiHopDongActionPerformed

    private void btnThemMoiKyLuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiKyLuatActionPerformed
       ThemMoiKyLuat inputKL = new ThemMoiKyLuat(this,rootPaneCheckingEnabled);
        inputKL.setVisible(true);
    }//GEN-LAST:event_btnThemMoiKyLuatActionPerformed

    private void btnThemMoiPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiPhongBanActionPerformed
        ThemMoiPhongBan inputPB = new ThemMoiPhongBan(this,rootPaneCheckingEnabled);
        inputPB.setVisible(true);
    }//GEN-LAST:event_btnThemMoiPhongBanActionPerformed

    private void btnThemMoiChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiChucVuActionPerformed
      ThemMoiChucVu inputCV = new ThemMoiChucVu(this,rootPaneCheckingEnabled);
        inputCV.setVisible(true);
    }//GEN-LAST:event_btnThemMoiChucVuActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       XemBangLuong xembl = new XemBangLuong(this,rootPaneCheckingEnabled,tk.getMaNhanVien());
        xembl.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void QLNVTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_QLNVTabbedPaneStateChanged
        switch(QLNVTabbedPane.getSelectedIndex()){
            case 0:
                getDataDSHD();
                break;
            case 1:
                getDataDSKT();
                break;
            case 2:
                getDataDSKyLuat();
                break;
            case 3:
                jTextField25.setText("1");
                getDataDSChamCong(1);
                break;
            case 4:
                getDataDSNghi();
                break;
            case 5:
                getDataDSNhanVien();
                break;
        }
    }//GEN-LAST:event_QLNVTabbedPaneStateChanged

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá hợp đồng không?") == JOptionPane.NO_OPTION ){
            return;
        }
            XoaHopDong( Integer.valueOf((String)jTable7.getValueAt(jTable7.getSelectedRow(),0)));       
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
         HopDong hd = new HopDong();
         DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
         Date startDate = null;
        try {
            startDate = df.parse((String)jTable7.getValueAt(jTable7.getSelectedRow(),3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date endDate = null;
        try {
            endDate = df.parse((String)jTable7.getValueAt(jTable7.getSelectedRow(),4));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        hd.setMaHD(Integer.valueOf((String)jTable7.getValueAt(jTable7.getSelectedRow(),0)));
        hd.setTenNV((String)jTable7.getValueAt(jTable7.getSelectedRow(),1));
        hd.setLoaiHD((String)jTable7.getValueAt(jTable7.getSelectedRow(),2));
        hd.setNgayBatDau(startDate);
        hd.setNgayKetThuc(endDate);
        hd.setGhichu((String)jTable7.getValueAt(jTable7.getSelectedRow(),5));
     
        SuaHopDong suahopdong = new SuaHopDong(this,rootPaneCheckingEnabled,hd); 
          suahopdong.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        String loaihd="";
        System.out.println(jTextField16.getText());
        if(jTextField16.getText().equals(loaihd)){
            getDataDSHD();
        }
        else{
            TimHopDongTheoLoaiHD(jTextField16.getText());
        }
        
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        String ngay="";
            System.out.println(jTextField17.getText());
                System.out.println(jTextField18.getText());
        if(jTextField17.getText().equals(ngay)||jTextField18.getText().equals(ngay)){
            getDataDSHD();
        }
        else{
            TimHopDongTheoNgay(jTextField18.getText(),jTextField17.getText());
        }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void btnThemMoiKhenThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiKhenThuongActionPerformed
        ThemMoiKhenThuong inputKT = new ThemMoiKhenThuong(this,rootPaneCheckingEnabled);
        inputKT.setVisible(true);
    }//GEN-LAST:event_btnThemMoiKhenThuongActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá chấm công không?") == JOptionPane.NO_OPTION ){
            return;
        }
        XoaChamCong( Integer.valueOf((String)jTable10.getValueAt(jTable10.getSelectedRow(),0)));
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jTextField27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField27ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá nhân viên không?") == JOptionPane.NO_OPTION ){
            return;
        }
        XoaNhanVien( Integer.valueOf((String)jTable12.getValueAt(jTable12.getSelectedRow(),0)));
    }//GEN-LAST:event_jButton45ActionPerformed

    private void btnThemMoiNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiNhanVienActionPerformed
        ThemMoiNhanVien inputMoiNhanVien = new ThemMoiNhanVien(this,rootPaneCheckingEnabled);
        inputMoiNhanVien.setVisible(true);
    }//GEN-LAST:event_btnThemMoiNhanVienActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá khen thưởng không?") == JOptionPane.NO_OPTION ){
            return;
        }
        XoaKhenThuong( Integer.valueOf((String)jTable8.getValueAt(jTable8.getSelectedRow(),0)));
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
         KhenThuong kt = new KhenThuong();
         DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
         Date startDate = null;
        try {
            startDate = df.parse((String)jTable8.getValueAt(jTable8.getSelectedRow(),3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
       kt.setMaKT(Integer.valueOf((String)jTable8.getValueAt(jTable8.getSelectedRow(),0)));
        kt.setMaNV(Integer.valueOf((String)jTable8.getValueAt(jTable8.getSelectedRow(),1)));
                 kt.setHoTen((String)jTable8.getValueAt(jTable8.getSelectedRow(),2));
                kt.setNgayKhenThuong(startDate);
                kt.setTien(Double.parseDouble((String)jTable8.getValueAt(jTable8.getSelectedRow(),4)));
                kt.setLyDo((String)jTable8.getValueAt(jTable8.getSelectedRow(),5));
        SuaKhenThuong suakhenthuong = new SuaKhenThuong(this,rootPaneCheckingEnabled,kt); 
          suakhenthuong.setVisible(true);
    }//GEN-LAST:event_jButton57ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        String plain="";
        System.out.println(jTextField21.getText());
        if(jTextField21.getText().equals(plain)){
            getDataDSKT();
        }
        else{
            TimKTTheoTenNV(jTextField21.getText());
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
         String ngay="";
            System.out.println(jTextField19.getText());
                System.out.println(jTextField20.getText());
        if(jTextField20.getText().equals(ngay)||jTextField19.getText().equals(ngay)){
        }
        else{
            TimKTTheoNgay(jTextField19.getText(),jTextField20.getText());
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton58ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá kỷ luật không?") == JOptionPane.NO_OPTION ){
            return;
        }
         XoaKyLuat( Integer.valueOf((String)jTable9.getValueAt(jTable9.getSelectedRow(),0)));
    }//GEN-LAST:event_jButton58ActionPerformed

    private void jButton59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton59ActionPerformed
        // TODO add your handling code here:
        KyLuat nhanvien = new KyLuat();
         DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
         Date startDate = null;
        try {
            startDate = df.parse((String)jTable9.getValueAt(jTable9.getSelectedRow(),3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        nhanvien.setMaNV(Integer.valueOf((String)jTable9.getValueAt(jTable9.getSelectedRow(),0)));
                 nhanvien.setHoTen((String)jTable9.getValueAt(jTable9.getSelectedRow(),2));
                nhanvien.setNgayKyLuat(startDate);
                nhanvien.setLyDo((String)jTable9.getValueAt(jTable9.getSelectedRow(),4));
        SuaKyLuat suaKyLuat = new SuaKyLuat(this,rootPaneCheckingEnabled,nhanvien); 
          suaKyLuat.setVisible(true);
    }//GEN-LAST:event_jButton59ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
           String plain="";
        System.out.println(jTextField24.getText());
        if(jTextField24.getText().equals(plain)){
        }
        else{
            TimKyLuatTheoTenNV(jTextField24.getText());
        }
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
         String ngay="";
                System.out.println(jTextField22.getText());
        if(jTextField22.getText().equals(ngay)||jTextField23.getText().equals(ngay)){
            getDataDSKyLuat();
        }
        else{
            TimKyLuatTheoNgay(jTextField22.getText(),jTextField23.getText());
        }
    }//GEN-LAST:event_jButton47ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        // TODO add your handling code here:
         String plain="";
        if(jTextField25.getText().equals(plain)){
            jTable10.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null}
    },
    new String [] {
        "Mã nhân viên", "Họ Tên", "Ngày", "Giờ vào", "Giờ ra"
    }
) {
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
    };

    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
});
        }
        else{
        getDataDSChamCong(Integer.valueOf(jTextField25.getText()));}
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton60ActionPerformed
        // TODO add your handling code here:
          String ngay="";
        if(jTextField26.getText().equals(ngay)||jTextField27.getText().equals(ngay)||jTextField25.getText().equals(ngay)){
            jButton37.doClick();
        }
        else{
            TimChamCongTheoNgay(jTextField26.getText(),jTextField27.getText(),Integer.valueOf(jTextField25.getText()));
        }
    }//GEN-LAST:event_jButton60ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
         ChamCong nhanvien = new ChamCong();
         DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
          DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
         Date startDate = null;
      
        java.sql.Time GioVao = null;
        java.sql.Time GioRa = null;
         try {
              GioVao = new java.sql.Time(formatter.parse((String)jTable10.getValueAt(jTable10.getSelectedRow(),4)).getTime());
         } catch (ParseException ex) {
             Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
              GioRa = new java.sql.Time(formatter.parse((String)jTable10.getValueAt(jTable10.getSelectedRow(),5)).getTime());
         } catch (ParseException ex) {
             Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        try {
            startDate = df.parse((String)jTable10.getValueAt(jTable10.getSelectedRow(),3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
       nhanvien.setMaCC(Integer.valueOf((String)jTable10.getValueAt(jTable10.getSelectedRow(),0)));
        nhanvien.setMaNV(Integer.valueOf((String)jTable10.getValueAt(jTable10.getSelectedRow(),1)));
                 nhanvien.setTenNV((String)jTable10.getValueAt(jTable10.getSelectedRow(),2));
                nhanvien.setNgayChamCong(startDate);
                nhanvien.setGioVao(GioVao);
                 nhanvien.setGioRa(GioRa);
        SuaChamCong suaChamCong = new SuaChamCong(this,rootPaneCheckingEnabled,nhanvien); 
          suaChamCong.setVisible(true);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        if(jComboBox3.getSelectedItem().toString().equals("Tất Cả")){
            getDataDSNghi();
        }
        else{
                boolean phep=false;
                if(jComboBox3.getSelectedItem().toString().equals("Có Phép")){
                phep=true;
                }
                else{}
                System.out.println(phep);
                        TimNghiTheoPhep(phep);

                }
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton61ActionPerformed
        // TODO add your handling code here:
        String ngay="";
                if(jTextField29.getText().equals(ngay)||jTextField28.getText().equals(ngay)){
        }
        else{
                    if(jComboBox3.getSelectedItem().toString().equals("Tất Cả")){
            TimNghiTheoNgayTatCa(jTextField29.getText(),jTextField28.getText());
        }
        else{
                boolean phep=false;
                if(jComboBox3.getSelectedItem().toString().equals("Có Phép")){
                phep=true;
                TimNghiTheoPhep(phep);
                }
                else{}
                System.out.println(phep);
                        
  TimNghiTheoNgay(jTextField29.getText(),jTextField28.getText(),phep);
                }
              
        }
    }//GEN-LAST:event_jButton61ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        Nghi kt = new Nghi();
         DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
         Date startDate = null;
        try {
            startDate = df.parse((String)jTable11.getValueAt(jTable11.getSelectedRow(),3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
       kt.setMaNghi(Integer.valueOf((String)jTable11.getValueAt(jTable11.getSelectedRow(),0)));
        kt.setMaNV(Integer.valueOf((String)jTable11.getValueAt(jTable11.getSelectedRow(),1)));
                 kt.setTenNV((String)jTable11.getValueAt(jTable11.getSelectedRow(),2));
                kt.setNgayNghi(startDate);
                kt.setLyDo((String)jTable11.getValueAt(jTable11.getSelectedRow(),4));
                String phep =(String)jTable11.getValueAt(jTable11.getSelectedRow(),5);
                if(phep.equals("Có Phép")){
                    kt.setPhep(true);
                }
                else{kt.setPhep(false);}
        SuaNghi suakhenthuong = new SuaNghi(this,rootPaneCheckingEnabled,kt); 
          suakhenthuong.setVisible(true);
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
         String loaihd="";
        System.out.println(jTextField30.getText());
        if(jTextField30.getText().equals(loaihd)){
            getDataDSNhanVien();
        }
        else{
            TimNhanVienTheoTen(jTextField30.getText());
        }
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
        NhanVien nv = new NhanVien();
         DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
         Date startDate = null;
        try {
            startDate = df.parse((String)jTable12.getValueAt(jTable12.getSelectedRow(),3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
       nv.setMaNV(Integer.valueOf((String)jTable12.getValueAt(jTable12.getSelectedRow(),0)));
                 nv.setHoTen((String)jTable12.getValueAt(jTable12.getSelectedRow(),1));
                 nv.setCMND((String)jTable12.getValueAt(jTable12.getSelectedRow(),2));
                nv.setNgaySinh(startDate);
                
                 nv.setGioiTinh((String)jTable12.getValueAt(jTable12.getSelectedRow(),4));
                nv.setDiaChi((String)jTable12.getValueAt(jTable12.getSelectedRow(),5));
                nv.setChucVu((String)jTable12.getValueAt(jTable12.getSelectedRow(),6));
                nv.setPhongBan((String)jTable12.getValueAt(jTable12.getSelectedRow(),7));
        SuaNhanVien suakhenthuong = new SuaNhanVien(this,rootPaneCheckingEnabled,nv); 
          suakhenthuong.setVisible(true);
    }//GEN-LAST:event_jButton46ActionPerformed

    private void QLPBTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_QLPBTabbedPaneStateChanged
        // TODO add your handling code here:
        
        System.out.println(QLPBTabbedPane.getSelectedIndex());
        switch(QLPBTabbedPane.getSelectedIndex()){
           case 0:
               getDataDSPB();
               break;
           case 1:
               getDataDSCV();
               break;
             
       }
    }//GEN-LAST:event_QLPBTabbedPaneStateChanged

    private void btnXoaCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaCVActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá chức vụ không?") == JOptionPane.NO_OPTION ){
            return;
        }
         XoaPhongBan( Integer.valueOf((String)tblPB.getValueAt(tblPB.getSelectedRow(),0)));
    }//GEN-LAST:event_btnXoaCVActionPerformed

    private void btnSuaPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPBActionPerformed
        // TODO add your handling code here:
        PhongBan pb = new PhongBan();
        pb.setMaPB(Integer.valueOf((String)tblPB.getValueAt(tblPB.getSelectedRow(), 0)));
        pb.setTenPB((String)tblPB.getValueAt(tblPB.getSelectedRow(),1));
        
        SuaPhongBan suaPB = new SuaPhongBan(this,rootPaneCheckingEnabled,pb);
        suaPB.setVisible(true);
        
    }//GEN-LAST:event_btnSuaPBActionPerformed

    private void btnTimKiemPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemPBActionPerformed
        // TODO add your handling code here:
         String TenPB="";
        System.out.println(txtNhapTenPB.getText());
        if(txtNhapTenPB.getText().equals(TenPB)){
            getDataDSPB();
        }
        else{
            TimPBTheoTen(txtNhapTenPB.getText());
    }                
    }//GEN-LAST:event_btnTimKiemPBActionPerformed

    private void btnXoaPBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPBActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá phòng ban không?") == JOptionPane.NO_OPTION ){
            return;
        }
        XoaChucVu( Integer.valueOf((String)tblCV.getValueAt(tblCV.getSelectedRow(),0)));
    }//GEN-LAST:event_btnXoaPBActionPerformed

    private void btnSuaCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCVActionPerformed
        // TODO add your handling code here:
        ChucVu cv = new ChucVu();
        cv.setMaCV(Integer.valueOf((String)tblCV.getValueAt(tblCV.getSelectedRow(),0)));
        cv.setTenCV((String)tblCV.getValueAt(tblCV.getSelectedRow(),1));
                 
        SuaChucVu suacv = new SuaChucVu(this,rootPaneCheckingEnabled,cv); 
        suacv.setVisible(true);
        

        
    }//GEN-LAST:event_btnSuaCVActionPerformed

    private void btnTimKiemCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemCVActionPerformed
        // TODO add your handling code here:
         String TenCV="";
        System.out.println(txtTenCV.getText());
        if(txtTenCV.getText().equals(TenCV)){
            getDataDSCV();
            }
        else{
            TimChucVuTheoTen(txtTenCV.getText());
        }
    }//GEN-LAST:event_btnTimKiemCVActionPerformed

    private void btnTaiAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiAnhActionPerformed
        // TODO add your handling code here:
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // chỉ hiển thị file
        int returnValue = chooser.showOpenDialog(this);
        if(returnValue == JFileChooser.APPROVE_OPTION)
            {
                File file = chooser.getSelectedFile();
                //lay duong dan file de lưu vao 1 truong trong csdl
                String pathFile = file.getAbsolutePath();
                //String pathFile = file.getAbsolutePath().replace(".", "//");
                BufferedImage b;
                try{
                    b=ImageIO.read(file);
                    lblAnh.setIcon(new ImageIcon(b));
                }catch(Exception e){
                    }
            }
        
    }//GEN-LAST:event_btnTaiAnhActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        // TODO add your handling code here:
        XuLyFileExcel fileExcel = new XuLyFileExcel();
        fileExcel.xuatExcel(jTable12);
        
    }//GEN-LAST:event_jButton50ActionPerformed

    private void MainTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MainTabbedPaneStateChanged
        // TODO add your handling code here:
           switch(MainTabbedPane.getSelectedIndex()){
            case 0 -> {
                if(!tk.getQuyen().equals("admin")){
                    if(i>0){
                        MainTabbedPane.setSelectedIndex(2);
                     new Notification("Bạn chưa được cấp quyền vào mục này",3);
                }
                                                                            i++;
                }
        }
            case 1 -> {
                if(!tk.getQuyen().equals("admin")){
                                                                             MainTabbedPane.setSelectedIndex(2);
                     new Notification("Bạn chưa được cấp quyền vào mục này",3);

                }
        }
            case 2 -> {
        }
            case 3 -> {
                jComboBox2.setSelectedIndex(2);
                MainTabbedPane.setSelectedIndex(2);
                 new Notification("Bạn chưa được cấp quyền vào mục này",3);

        }
            case 4 -> {
 getDataTaiKhoan();
        }
       
        }
    }//GEN-LAST:event_MainTabbedPaneStateChanged

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        if(  jTextField34.getText().equals("")){
            new Notification("Chưa điền tháng",4);
            return;
        }
        if(  jTextField35.getText().equals("")){
            new Notification("Chưa điền năm",4);
            return;
        }
        if(  jTextField33.getText().equals("") && jComboBox2.getSelectedIndex()!=2){
            new Notification("Chưa điền thông tin nhân viên",4);
            return;
        }
        getDataDSLuong(jTextField34.getText(),jTextField35.getText(),jComboBox2.getSelectedIndex(),jTextField33.getText());
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        XuLyFileExcel fileExcel = new XuLyFileExcel();
        fileExcel.xuatExcel(jTable3);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ThemChamCong add = new ThemChamCong();
        add.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ChamCong nhanvien = new ChamCong();
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        Date startDate = null;
      
        java.sql.Time GioVao = null;
        java.sql.Time GioRa = null;
         try {
              GioVao = new java.sql.Time(formatter.parse((String)jTable4.getValueAt(jTable4.getSelectedRow(),4)).getTime());
         } catch (ParseException ex) {
             Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
              GioRa = new java.sql.Time(formatter.parse((String)jTable4.getValueAt(jTable4.getSelectedRow(),5)).getTime());
         } catch (ParseException ex) {
             Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        try {
            startDate = df.parse((String)jTable4.getValueAt(jTable4.getSelectedRow(),3));
        } catch (ParseException ex) {
            Logger.getLogger(SuaHopDong.class.getName()).log(Level.SEVERE, null, ex);
        }
        nhanvien.setMaCC(Integer.valueOf((String)jTable4.getValueAt(jTable4.getSelectedRow(),0)));
        nhanvien.setMaNV(Integer.valueOf((String)jTable4.getValueAt(jTable4.getSelectedRow(),1)));
                nhanvien.setTenNV((String)jTable4.getValueAt(jTable4.getSelectedRow(),2));
                nhanvien.setNgayChamCong(startDate);
                nhanvien.setGioVao(GioVao);
                nhanvien.setGioRa(GioRa);
        SuaChamCong suaChamCong = new SuaChamCong(this,rootPaneCheckingEnabled,nhanvien); 
        suaChamCong.setVisible(true);        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         String plain="";
        if(jTextField9.getText().equals(plain)){
            jTable4.setModel(new javax.swing.table.DefaultTableModel(
    new Object [][] {
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null},
        {null, null, null, null, null, null, null}
    },
    new String [] {
        "Mã nhân viên", "Họ Tên", "Ngày", "Giờ vào", "Giờ ra"
    }
) {
    Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
    };

    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }
});
        }
        else{
        getDataDSChamCong(Integer.valueOf(jTextField9.getText()));}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTextField25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField25ActionPerformed

    private void jButton62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton62ActionPerformed
        // TODO add your handling code here:
         ThemMoiChamCong cc = new ThemMoiChamCong(this,rootPaneCheckingEnabled);
        cc.setVisible(true);
    }//GEN-LAST:event_jButton62ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if(  jTextField10.getText().equals("")){
            new Notification("Chưa điền tháng",4);
            return;
        }
        if(  jTextField12.getText().equals("")){
            new Notification("Chưa điền năm",4);
            return;
        }
        if(  jTextField11.getText().equals("") && jComboBox4.getSelectedIndex()!=2){
            new Notification("Chưa điền thông tin nhân viên",4);
            return;
        }
        getDataDSLuongNV(jTextField10.getText(),jTextField12.getText(),jComboBox4.getSelectedIndex(),jTextField11.getText());
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         Luong nv = new Luong();
         
       nv.setMaNV(Integer.valueOf((String)jTable1.getValueAt(jTable1.getSelectedRow(),0)));
                 nv.setHoTen((String)jTable1.getValueAt(jTable1.getSelectedRow(),1));
                 nv.setLuongThoaThuan(Double.parseDouble((String)jTable1.getValueAt(jTable1.getSelectedRow(),2)));
                nv.setPhuCap(Double.parseDouble((String)jTable1.getValueAt(jTable1.getSelectedRow(),3)));
                
        SuaLuong suaLuong = new SuaLuong(this,rootPaneCheckingEnabled,nv); 
          suaLuong.setVisible(true);
        
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá lương không?") == JOptionPane.NO_OPTION ){
            return;
        }
         XoaLuong( Integer.valueOf((String)jTable1.getValueAt(jTable1.getSelectedRow(),0)));
    }//GEN-LAST:event_jButton12ActionPerformed
    
    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane MainTabbedPane;
    private javax.swing.JTabbedPane QLNVTabbedPane;
    private javax.swing.JTabbedPane QLPBTabbedPane;
    private javax.swing.JButton btnClock;
    private javax.swing.JButton btnSuaCV;
    private javax.swing.JButton btnSuaPB;
    private javax.swing.JButton btnTaiAnh;
    private javax.swing.JButton btnThemMoiChucVu;
    private javax.swing.JButton btnThemMoiHopDong;
    private javax.swing.JButton btnThemMoiKhenThuong;
    private javax.swing.JButton btnThemMoiKyLuat;
    private javax.swing.JButton btnThemMoiNhanVien;
    private javax.swing.JButton btnThemMoiPhongBan;
    private javax.swing.JButton btnTimKiemCV;
    private javax.swing.JButton btnTimKiemPB;
    private javax.swing.JButton btnXoaCV;
    private javax.swing.JButton btnXoaPB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    public static javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton20;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable10;
    private static javax.swing.JTable jTable11;
    private static javax.swing.JTable jTable12;
    private static javax.swing.JTable jTable3;
    private static javax.swing.JTable jTable4;
    private static javax.swing.JTable jTable7;
    private static javax.swing.JTable jTable8;
    private static javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField10;
    public static javax.swing.JTextField jTextField11;
    public static javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    public static javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    public static javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblAnh;
    private javax.swing.JLabel lblCC;
    private javax.swing.JLabel lblQLL;
    private javax.swing.JLabel lblQLNV;
    private javax.swing.JLabel lblQLPB;
    private javax.swing.JLabel lblTTCN;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pnlCC;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlQLNV;
    private javax.swing.JPanel pnlQLPB;
    private javax.swing.JPanel pnlQLPB1;
    private javax.swing.JPanel pnlTTCN;
    private static javax.swing.JTable tblCV;
    private static javax.swing.JTable tblPB;
    private javax.swing.JTextField txtNhapTenPB;
    private javax.swing.JTextField txtTenCV;
    // End of variables declaration//GEN-END:variables
}
