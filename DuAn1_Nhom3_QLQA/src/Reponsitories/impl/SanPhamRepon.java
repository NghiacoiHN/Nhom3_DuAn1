/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories.impl;

import DomainModels.SanPhamDM;
import Reponsitories.SanPhamIRepon;
import Utilities.DBConnection;
import ViewModels.HoaDonVM;
import ViewModels.SanPhamVM;
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
public class SanPhamRepon implements SanPhamIRepon {

    @Override
    public List<SanPhamVM> findAll() {
        List<SanPhamVM> products = new ArrayList<>();
        String sql = "Select MaCTSP, TenCL, TenMS, TenSize, TenSp, MoTa, SoLuongTon, GiaNhap, GiaBan, TrangThai\n"
                + "                       from ChiTietSanPham join ChatLieu on ChiTietSanPham.IDCL = ChatLieu.IDCL\n"
                + "                       					join MauSac on ChiTietSanPham.IDMS = MauSac.IDMS\n"
                + "                       					join Size on ChiTietSanPham.IDSize = size.IDSize\n"
                + "                       					join SanPham on ChiTietSanPham.IDSP = SanPham.IDSP";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamVM sanPham1 = new SanPhamVM();
                sanPham1.setMaCTSP(rs.getString("MaCTSP"));
                sanPham1.setTenSP(rs.getString("TenSp"));
                sanPham1.setTenLoaiSP(rs.getString("TenLSP"));
                sanPham1.setTenCL(rs.getString("TenCL"));
                sanPham1.setTenMS(rs.getString("TenMS"));
                sanPham1.setTenSize(rs.getString("TenSize"));
                sanPham1.setSoLuongTon(rs.getInt("SoLuongTon"));
                sanPham1.setGiaBan(rs.getBigDecimal("GiaBan"));
                sanPham1.setTrangThai(rs.getInt("TrangThai"));
                products.add(sanPham1);
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
    public SanPhamVM getOne(Integer trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(SanPhamDM a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(SanPhamDM a, String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
