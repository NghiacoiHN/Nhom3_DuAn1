/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories.impl;

import Reponsitories.GioHangIRepon;
import Utilities.DBConnection;
import ViewModels.GioHangVM;
import ViewModels.HoaDonVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TRONG NGHIA
 */
public class GioHangRepon implements GioHangIRepon {

    @Override
    public List<GioHangVM> findAll() {
        List<GioHangVM> products = new ArrayList<>();
        String sql = "SELECT HoaDon.MaHD, SanPham.TenSp, LoaiSP.TenLSP, ChatLieu.TenCL, MauSac.TenMS, Size.TenSize, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia\n"
                + "FROM     ChiTietSanPham INNER JOIN\n"
                + "                  SanPham ON ChiTietSanPham.IDSP = SanPham.IDSP INNER JOIN\n"
                + "                  LoaiSPCT ON ChiTietSanPham.IDCTSP = LoaiSPCT.IDCTSP INNER JOIN\n"
                + "                  LoaiSP ON LoaiSPCT.IDLSP = LoaiSP.IDLSP INNER JOIN\n"
                + "                  ChatLieu ON ChiTietSanPham.IDCL = ChatLieu.IDCL INNER JOIN\n"
                + "                  MauSac ON ChiTietSanPham.IDMS = MauSac.IDMS INNER JOIN\n"
                + "                  HoaDonChiTiet ON ChiTietSanPham.IDCTSP = HoaDonChiTiet.IDCTSP INNER JOIN\n"
                + "                  HoaDon ON HoaDonChiTiet.IDHD = HoaDon.IDHD INNER JOIN\n"
                + "                  Size ON ChiTietSanPham.IDSize = Size.IDSize";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHangVM gioHang1 = new GioHangVM();
                gioHang1.setMaHD(rs.getString("MaHD"));
                gioHang1.setTenSP(rs.getString("TenSp"));
                gioHang1.setTenLoaiSP(rs.getString("TenLSP"));
                gioHang1.setTenCL(rs.getString("TenCL"));
                gioHang1.setTenMS(rs.getString("TenMS"));
                gioHang1.setTenSize(rs.getString("TenSize"));
                gioHang1.setSoLuong(rs.getInt("SoLuong"));
                gioHang1.setDonGia(rs.getBigDecimal("DonGia"));
                products.add(gioHang1);
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return products;
    }

    @Override
    public List<GioHangVM> getOne(String ma) {
        List<GioHangVM> products = new ArrayList<>();
        String sql = "SELECT HoaDon.MaHD, SanPham.TenSp, LoaiSP.TenLSP, ChatLieu.TenCL, MauSac.TenMS, Size.TenSize, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia\n"
                + "FROM     ChiTietSanPham INNER JOIN\n"
                + "                  SanPham ON ChiTietSanPham.IDSP = SanPham.IDSP INNER JOIN\n"
                + "                  LoaiSPCT ON ChiTietSanPham.IDCTSP = LoaiSPCT.IDCTSP INNER JOIN\n"
                + "                  LoaiSP ON LoaiSPCT.IDLSP = LoaiSP.IDLSP INNER JOIN\n"
                + "                  ChatLieu ON ChiTietSanPham.IDCL = ChatLieu.IDCL INNER JOIN\n"
                + "                  MauSac ON ChiTietSanPham.IDMS = MauSac.IDMS INNER JOIN\n"
                + "                  HoaDonChiTiet ON ChiTietSanPham.IDCTSP = HoaDonChiTiet.IDCTSP INNER JOIN\n"
                + "                  HoaDon ON HoaDonChiTiet.IDHD = HoaDon.IDHD INNER JOIN\n"
                + "                  Size ON ChiTietSanPham.IDSize = Size.IDSize\n"
                + "WHERE HoaDon.MaHD = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHangVM gioHang1 = new GioHangVM();
                gioHang1.setMaHD(rs.getString("MaHD"));
                gioHang1.setTenSP(rs.getString("TenSp"));
                gioHang1.setTenLoaiSP(rs.getString("TenLSP"));
                gioHang1.setTenCL(rs.getString("TenCL"));
                gioHang1.setTenMS(rs.getString("TenMS"));
                gioHang1.setTenSize(rs.getString("TenSize"));
                gioHang1.setSoLuong(rs.getInt("SoLuong"));
                gioHang1.setDonGia(rs.getBigDecimal("DonGia"));
                products.add(gioHang1);
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return products;
    }
//
//    @Override
//    public boolean add(HoaDonDM a) {
//        String sql = "INSERT INTO HoaDon\n"
//                + "                  (NgayTao, TenKH, SDTKH, TrangThai)\n"
//                + "VALUES (?,?,?,2)";
//        int check = 0;
//        try {
//            Connection connection = DBConnection.getConnection();
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setObject(1, a.getNgayTao());
//            ps.setObject(2, a.getTenKH());
//            ps.setObject(3, a.getSDTKH());
//            check = ps.executeUpdate();
//
//            ps.close();
//            connection.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return check > 0;
//    }

}
