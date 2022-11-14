﻿Create database DuAn_1
go
Use DuAn_1
go
--CuaHang
Create table CuaHang(
 IDCH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
 MaCH VARCHAR(20) UNIQUE,
 TenCH NVARCHAR(50) DEFAULT NULL,
 DiaChi NVARCHAR(150) DEFAULT NULL,
 TrangThai INT DEFAULT 0
)
--NhanVien
Create table NhanVien(
 IDNV UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
 IDCH UNIQUEIDENTIFIER,
 MaNV VARCHAR(20) UNIQUE,
 HoNV NVARCHAR(50) DEFAULT NULL,
 TenNV NVARCHAR(50) DEFAULT NULL,
 SDT VARCHAR(30) DEFAULT NULL,
 MatKhau VARCHAR(MAX) DEFAULT NULL,
 ChucVu INT DEFAULT 0,
 DiaChi NVARCHAR(150) DEFAULT NULL,
 TrangThai INT DEFAULT 0
)
--KhachHang
Create table KhachHang(
 IDKH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
 IDTichDiem UNIQUEIDENTIFIER,
 MaKH VARCHAR(20) UNIQUE,
 HoKH NVARCHAR(50) DEFAULT NULL,
 TenKH NVARCHAR(50) DEFAULT NULL,
 SDT VARCHAR(30) DEFAULT NULL,
 DiaChi NVARCHAR(150) DEFAULT NULL,
 TrangThai INT DEFAULT 0
)
--HoaDon
Create table HoaDon(
 IDHD UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
 IDKH UNIQUEIDENTIFIER,
 IDNV UNIQUEIDENTIFIER,
 IDVoucher UNIQUEIDENTIFIER,
 MaHD VARCHAR(20) UNIQUE,
 NgayTao DATE DEFAULT NULL,
 NgayThanhToan DATE DEFAULT NULL,
 TenKH NVARCHAR(50) DEFAULT NULL,
 SDT VARCHAR(30) DEFAULT NULL,
 DiaChi NVARCHAR(150) DEFAULT NULL,
 TrangThai INT DEFAULT 0
)
--ChatLieu
CREATE TABLE ChatLieu(
IDCL UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaCL VARCHAR(20) UNIQUE,
TenCL NVARCHAR(30),
TinhTrang INT DEFAULT 0
)
GO
--LoaiSP
CREATE TABLE LoaiSP(
IDLSP UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDLSP2 UNIQUEIDENTIFIER,
MaLSP VARCHAR(20) UNIQUE,
TenLSP NVARCHAR(30),
TinhTrang INT DEFAULT 0
)
GO

--LoaiSPChiTiet
CREATE TABLE LoaiSPCT(
IDLSPCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDLSP UNIQUEIDENTIFIER,
IDCTSP UNIQUEIDENTIFIER,
)
--MauSac
CREATE TABLE MauSac(
IDMS UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaMS VARCHAR(20) UNIQUE,
TenMS NVARCHAR(30),
TinhTrang INT DEFAULT 0
)
GO
--Size
CREATE TABLE Size(
IDSize UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaSize VARCHAR(20) UNIQUE,
TenSize VARCHAR(10) UNIQUE,
TinhTrang INT DEFAULT 0
)
GO
--SanPham
CREATE TABLE SanPham(
IDSP UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaSP VARCHAR(20) UNIQUE,
TenSp NVARCHAR(30),
TinhTrang INT DEFAULT 0
)
GO
--SanPham
CREATE TABLE SanPham(
IDSP UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaSP VARCHAR(20) UNIQUE,
TenSp NVARCHAR(30)
)
GO
--ChiTietSanPham
CREATE TABLE ChiTietSanPham(
IDCTSP UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
MaCTSP VARCHAR(20) UNIQUE,
IDCL UNIQUEIDENTIFIER,
IDMS UNIQUEIDENTIFIER,
IDSize UNIQUEIDENTIFIER,
IDSP UNIQUEIDENTIFIER,
MoTa NVARCHAR(50) DEFAULT NULL,
SoLuongTon INT,
GiaNhap DECIMAL(20,0) DEFAULT 0,
GiaBan DECIMAL(20,0) DEFAULT 0,
TrangThai INT DEFAULT 0,
)
GO
--GioHang
CREATE TABLE GioHang(
IDGH UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDKH UNIQUEIDENTIFIER,
IDNV UNIQUEIDENTIFIER,
Ma VARCHAR(20) UNIQUE,
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
TenNguoiNhan NVARCHAR(50) DEFAULT NULL,
DiaChi NVARCHAR(100) DEFAULT NULL,
Sdt VARCHAR(30) DEFAULT NULL,
TinhTrang INT DEFAULT 0
)
GO
--HoaDonChiTiet
CREATE TABLE HoaDonChiTiet(
IDHDCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDHD UNIQUEIDENTIFIER,
IDCTSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
TrangThai INT DEFAULT 0
)
GO
--GioHangChiTiet
CREATE TABLE GioHangChiTiet(
IDGHCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
IDGH UNIQUEIDENTIFIER,
IDCTSP UNIQUEIDENTIFIER,
SoLuong INT,
DonGia DECIMAL(20,0) DEFAULT 0,
DonGiaKhiGiam DECIMAL(20,0) DEFAULT 0,
)
GO
--TichDiem
--CREATE TABLE TichDiem(
-- IDTD UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
-- MaTD VARCHAR(20) UNIQUE,
 --SoDiem INT DEFAULT NULL,
 --TrangThai INT DEFAULT 0
--)
--TichDiemChiTiet
--CREATE TABLE TichDiemChiTiet(
 --IDTDCT UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
-- CONSTRAINT PK_TichDiemChiTiet PRIMARY KEY (IDHD,IDTDCT),
-- CONSTRAINT FK1 FOREIGN KEY(IDHD) REFERENCES HoaDon(IDHD),
-- CONSTRAINT FK2 FOREIGN KEY(IDTDCT) REFERENCES TichDiemChiTiet(IDTDCT),
--)

--GiamGia
CREATE TABLE GiamGia(
 IDGG UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
 MaGG VARCHAR(20) UNIQUE,
 TenChuongTrinh VARCHAR(50) UNIQUE,
 NgayBatDau DATE DEFAULT NULL,
 NgayThanhToan DATE DEFAULT NULL,
 KieuGiamGia MONEY DEFAULT NULL,
 SoTienGiamGia MONEY DEFAULT NULL,
 TrangThai INT DEFAULT 0
)
--GiamGiaChiTiet
CREATE TABLE GiamGiaChiTiet(
 IDGG UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
 CONSTRAINT PK_GiamGiaChiTiet PRIMARY KEY (IDNV,IDGG),
 CONSTRAINT FK1 FOREIGN KEY(IDNV) REFERENCES NhanVien(IDNV),
 CONSTRAINT FK2 FOREIGN KEY(IDGG) REFERENCES GiamGia(IDGG),
)



--LIÊN KÊT MỐI QUAN HỆ--
--NhanVien_CuaHang
ALTER TABLE NhanVien ADD FOREIGN KEY (IDCH) REFERENCES CuaHang(IDCH)
--NhanVien_HoaDon
ALTER TABLE HoaDon ADD FOREIGN KEY (IDNV) REFERENCES NhanVien(IDNV)
--KhachHang_HoaDon
ALTER TABLE HoaDon ADD FOREIGN KEY (IDKH) REFERENCES KhachHang(IDKH)
--Voucher_HoaDon
--ALTER TABLE HoaDon ADD FOREIGN KEY (IDVoucher) REFERENCES Voucher(IDVoucher)
--ChatLieu_ChiTietSanPham
ALTER TABLE ChiTietSanPham ADD FOREIGN KEY (IDCL) REFERENCES ChatLieu(IDCL)
--ChiTietSanPham-SanPham
ALTER TABLE ChiTietSanPham ADD FOREIGN KEY (IDSP) REFERENCES SanPham(IDSP)
--MauSac_ChiTietSanPham
ALTER TABLE ChiTietSanPham ADD FOREIGN KEY (IDMS) REFERENCES MauSac(IDMS)
--Size_ChiTietSanPham
ALTER TABLE ChiTietSanPham ADD FOREIGN KEY (IDSize) REFERENCES Size(IDSize)
--GioHang-KhachHang
ALTER TABLE GioHang ADD FOREIGN KEY (IDKH) REFERENCES KhachHang(IDKH)
--GioHang-NhanVien
ALTER TABLE GioHang ADD FOREIGN KEY (IDNV) REFERENCES NhanVien(IDNV)
--KhachHang-TichDiem
--ALTER TABLE KhachHang ADD FOREIGN KEY (IDTD) REFERENCES TichDiem(IDTD)
--LoaiSP-LoaiSPChiTiet
ALTER TABLE LoaiSPCT ADD FOREIGN KEY (IDLSP) REFERENCES LoaiSP(IDLSP)
--LoaiSP - Level2
ALTER TABLE LoaiSP ADD FOREIGN KEY (IDLSP2) REFERENCES LoaiSP(IDLSP)
--LoaiSPChiTiet-ChiTietSanPham
ALTER TABLE LoaiSPCT ADD FOREIGN KEY (IDCTSP) REFERENCES ChiTietSanPham(IDCTSP)
--HoaDonChiTiet-ChiTietSanPham
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IDCTSP) REFERENCES ChiTietSanPham(IDCTSP)
--HoaDonChiTiet-HoaDon
ALTER TABLE HoaDonChiTiet ADD FOREIGN KEY (IDHD) REFERENCES HoaDon(IDHD)
--GioHangChiTiet - GioHang
ALTER TABLE GioHangChiTiet ADD FOREIGN KEY (IDGH) REFERENCES GioHang(IDGH)
--GioHangChiTiet - GioHang
ALTER TABLE GioHangChiTiet ADD FOREIGN KEY (IDGH) REFERENCES GioHang(IDGH)
--GioHangChiTiet - ChiTietSanPham
ALTER TABLE GioHangChiTiet ADD FOREIGN KEY (IDCTSP) REFERENCES ChiTietSanPham(IDCTSP)
