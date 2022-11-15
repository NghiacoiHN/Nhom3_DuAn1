--Chất liệu
INSERT INTO ChatLieu
                  (MaCL, TenCL, TinhTrang)
VALUES ('CL01',N'Nỉ',1), ('CL02',N'Bông',1)
SELECT*FROM ChatLieu
--Size
INSERT INTO Size
                  (MaSize, TenSize, TinhTrang)
VALUES ('SZ01',N'L',1), ('SZ02',N'M',1)
SELECT*FROM Size
--Màu sắc
INSERT INTO MauSac
                  (MaMS, TenMS, TinhTrang)
VALUES ('MS01',N'Màu Hồng',1),('MS02',N'Màu Xanh',1)
SELECT*FROM MauSac
--Sản phẩm
INSERT INTO SanPham
                  (MaSP, TenSp, TinhTrang)
VALUES ('SP01',N'Quần',1),('SP02',N'Áo',1)
SELECT*FROM SanPham
--Loại sản phẩm
INSERT INTO LoaiSP
                  (MaLSP, TenLSP, TinhTrang)
VALUES ('LSP01',N'Áo Blaze',1), ('LSP02',N'Quần Blaze',1)
SELECT*FROM LoaiSP


--Cửa hàng
INSERT INTO CuaHang
                  (MaCH, TenCH, DiaChi, TrangThai)
VALUES ('CH01',N'Cửa Hàng Vui Vẻ',N'Hà Nội',1),('CH02',N'Cửa Hàng Vẻ Vui',N'Hà Nội',1)
SELECT*FROM CuaHang
--Nhân viên
INSERT INTO NhanVien
                  (MaNV, HoNV, TenNV, SDT, MatKhau, ChucVu, DiaChi, TrangThai, IDCH)
VALUES ('NV01',N'Nguyễn',N'Nghĩa','0337842655','123456',1,N'Hà Nội',1,'FDCB75A2-AC1D-4683-9321-84594E74812D'),
('NV02',N'Nguyễn',N'Hoàng','0987654321','123456',2,N'Hà Nội',1,'B23CBF2F-C5D7-425D-9B3C-FC4098F74F5F')
SELECT*FROM NhanVien WHERE SDT = 0987654321 and MatKhau = 123456 and ChucVu = 2
--Hóa đơn
INSERT INTO HoaDon
                  (MaHD, ThanhTien, TienDua, TienThua, HinhThucThanhToan)
VALUES ('HD001',15000,20000,5000,N'Bằng thẻ')
Select*from HoaDon

INSERT INTO ChiTietSanPham
                  (MaCTSP, IDCL, IDMS, IDSize, IDSP, MoTa, SoLuongTon, GiaNhap, GiaBan, TrangThai)
VALUES ('CTSP01','5A3913D2-637F-421B-AB17-8A334E97BB45','2E5061BD-59AA-49A4-B42C-F507DFCC6B12','5BD7DF12-F018-427B-8FFD-D3BD688D151A',
'8C7F2A96-CF65-4FDF-A5C0-897A68DE11C1',N'Đẹp',15,90000,100000,1),('CTSP02','5A3913D2-637F-421B-AB17-8A334E97BB45',
'2E5061BD-59AA-49A4-B42C-F507DFCC6B12','5BD7DF12-F018-427B-8FFD-D3BD688D151A',
'8C7F2A96-CF65-4FDF-A5C0-897A68DE11C1',N'Đẹp',20,90000,100000,1)

Select*from ChiTietSanPham