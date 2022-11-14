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