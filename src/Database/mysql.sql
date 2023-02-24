create database QuanLyNhanSu;
use QuanLyNhanSu;

CREATE TABLE `ChucVu` (
  `maChucVu` int NOT NULL,
  `tenChucVu` varchar(50) NOT NULL,
  PRIMARY KEY (`tenChucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `PhongBan` (
  `maPhongBan` int NOT NULL,
  `tenPhongBan` varchar(50) NOT NULL,
  PRIMARY KEY (`tenPhongBan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `NhanVien` (
  `maNhanVien` int NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(50) NOT NULL,
  `CMND` varchar(50),
  `NgaySinh` date DEFAULT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  `GioiTinh` varchar(50) DEFAULT NULL,
  `ChucVu` varchar(50) NOT NULL,
  `PhongBan` varchar(50) NOT NULL,
  PRIMARY KEY (`maNhanVien`),
  FOREIGN KEY (ChucVu) REFERENCES ChucVu(tenChucVu),
  FOREIGN KEY (PhongBan) REFERENCES PhongBan(tenPhongBan)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Luong` (
  `maBangLuong` int NOT NULL AUTO_INCREMENT,
  `maNhanVien` int not null,
  `LuongThoaThuan` double NOT NULL,
  `PhuCap` int,
  PRIMARY KEY (`maBangLuong`),
    FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `ChamCong` (
  `maChamCong` int NOT NULL AUTO_INCREMENT,
  `maNhanVien` int NOT NULL,
  `NgayChamCong` date unique DEFAULT NULL,
  `GioVao` time NOT NULL,
  `GioRa` time NOT NULL,
  PRIMARY KEY (`maChamCong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `KhenThuong` (
`maKhenThuong` int not null AUTO_INCREMENT,
  `maNhanVien` int NOT NULL,
 `NgayKhenThuong` varchar(50) NOT NULL,
 `Tien` int,
  `LyDo` varchar(50) NOT NULL,
  PRIMARY KEY (`maKhenThuong`),
  FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `KyLuat` (
`maKyLuat` int NOT NULL AUTO_INCREMENT,
  `maNhanVien` int NOT NULL,
 `NgayKyLuat` varchar(50) NOT NULL,
  `LyDo` varchar(50) NOT NULL,
   PRIMARY KEY (`maKyLuat`),
   FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `HopDong` (
`maHopDong` int NOT NULL,
  `maNhanVien` int NOT NULL,
 `LoaiHopDong` varchar(50) NOT NULL,
   `NgayBatDau` date DEFAULT NULL,
     `NgayKetThuc` date DEFAULT NULL,
  `ghichu` varchar(50) NOT NULL,
  primary key(maHopDong),
   FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `Nghi` (
`maNghi` int NOT NULL AUTO_INCREMENT,
  `maNhanVien` int NOT NULL,
   `NgayNghi` date DEFAULT NULL,
  `LyDo` varchar(50) NOT NULL,
  `Phep` boolean NOT NULL,
  primary key(maNghi),
   FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `TaiKhoan` (
  `tenDangNhap` varchar(50) NOT NULL,
  `matKhau` varchar(50) NOT NULL,
  `maNhanVien` int NOT NULL,
  `quyen` varchar(50),
  CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into ChucVu(maChucVu,tenChucVu) values(1,'Quan Ly');
insert into ChucVu(maChucVu,tenChucVu) values(2,'Nhan Vien');

insert into PhongBan(maPhongBan,tenPhongBan) values(1,'IT');
insert into PhongBan(maPhongBan,tenPhongBan) values(2,'Nhan Su');

insert into NhanVien(maNhanVien,HoTen,CMND,ngaySinh,diaChi,GioiTinh,ChucVu,PhongBan) values(1,'Ngo Quang Truong','20198265',STR_TO_DATE('16-01-2001', '%d-%m-%Y'),'DHBK','Nam','Quan Ly','IT');
insert into NhanVien(maNhanVien,HoTen,CMND,ngaySinh,diaChi,GioiTinh,ChucVu,PhongBan) values(2,'Ngo 2 Truong','20198265',STR_TO_DATE('16-01-2001', '%d-%m-%Y'),'DHBK','Nu','Quan Ly','IT');

insert into HopDong(maHopDong,maNhanVien,LoaiHopDong,NgayBatDau,NgayKetThuc,ghichu) values (1,1,'PartTime','2020-01-10','2022-01-25','Gioi');
insert into HopDong(maHopDong,maNhanVien,LoaiHopDong,NgayBatDau,NgayKetThuc,ghichu) values (3,1,'PartTime','2020-01-10','2022-01-25','Gioi');
insert into HopDong(maHopDong,maNhanVien,LoaiHopDong,NgayBatDau,NgayKetThuc,ghichu) values (2,2,'FullTime','2020-01-20','2024-04-20','KhaGioi');

insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (1,'2022-07-20','08:16:00','16:46:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (1,'2022-07-21','08:20:00','17:42:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (1,'2022-07-22','08:25:00','16:27:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (1,'2022-07-23','08:30:00','18:19:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (2,'2022-07-20','07:16:00','17:13:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (2,'2022-07-21','07:16:00','16:54:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (2,'2022-07-22','07:16:00','17:49:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (2,'2022-07-23','07:16:00','16:26:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (1,'2022-08-22','08:25:00','16:27:00');
insert into ChamCong(maNhanVien,NgayChamCong,GioVao,GioRa) values (1,'2022-08-23','08:30:00','18:19:00');

insert into kyluat(maNhanVien,NgayKyLuat,LyDo) values(1,'2022-07-23','Đi Muộn');
insert into kyluat(maNhanVien,NgayKyLuat,LyDo) values(2,'2022-07-24','Đi Sớm');


insert into KhenThuong(maNhanVien,NgayKhenThuong,Tien,LyDo) values (1,'2022-07-23',1000000,'Nghèo');
insert into KhenThuong(maNhanVien,NgayKhenThuong,Tien,LyDo) values (1,'2022-07-24',20000,'Giàu');
insert into KhenThuong(maNhanVien,NgayKhenThuong,Tien,LyDo) values (2,'2022-07-23',5000,'Nghèo');
insert into KhenThuong(maNhanVien,NgayKhenThuong,Tien,LyDo) values (2,'2022-07-24',99999,'Giàu');

insert into Nghi(maNhanVien,NgayNghi,LyDo,Phep) values(1,'2022-07-27','Ốm',true);
insert into Nghi(maNhanVien,NgayNghi,LyDo,Phep) values(1,'2022-07-28','Đau',false);
insert into Nghi(maNhanVien,NgayNghi,LyDo,Phep) values(2,'2022-07-27','Bệnh',true);
insert into Nghi(maNhanVien,NgayNghi,LyDo,Phep) values(2,'2022-07-27','Tật',false);

insert into Luong(maNhanVien,luongthoathuan,phucap) values(1,5000000,100000);
insert into Luong(maNhanVien,luongthoathuan,phucap) values(2,2000000,500000);

insert into TaiKhoan(tenDangNhap,matKhau,maNhanVien,quyen) values ('admin','admin',1,'admin');
insert into TaiKhoan(tenDangNhap,matKhau,maNhanVien,quyen) values ('123','123',2,'guest');