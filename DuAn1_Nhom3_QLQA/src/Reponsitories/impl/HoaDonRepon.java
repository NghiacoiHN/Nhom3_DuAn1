/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories.impl;

import DomainModels.HoaDonDM;
import Reponsitories.HoaDonIRepon;
import Utilities.DBConnection;
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
public class HoaDonRepon implements HoaDonIRepon {

    @Override
    public List<HoaDonVM> findAll() {
        List<HoaDonVM> products = new ArrayList<>();
        String sql = "SELECT MaHD, NgayTao, TenKH, TrangThai\n"
                + "FROM     HoaDon";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonVM hoaDon1 = new HoaDonVM();
                hoaDon1.setMaHD(rs.getString("MaHD"));
                hoaDon1.setNgayTao(rs.getString("NgayTao"));
                hoaDon1.setTenKH(rs.getString("TenKH"));
                hoaDon1.setTrangThai(rs.getInt("TrangThai"));
                products.add(hoaDon1);
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
    public HoaDonVM getOne(Integer trangThai) {
        String query = "SELECT MaHD, NgayTao, TenKH, TrangThai\n"
                + "FROM     HoaDon\n"
                + "WHERE TrangThai = ?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HoaDonVM hoaDon1 = new HoaDonVM();
                hoaDon1.setMaHD(rs.getString("MaHD"));
                hoaDon1.setNgayTao(rs.getString("NgayTao"));
                hoaDon1.setTenKH(rs.getString("TenKH"));
                hoaDon1.setTrangThai(rs.getInt("TrangThai"));
                ps.executeUpdate();
                return hoaDon1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(HoaDonDM a) {
        String sql = "INSERT INTO HoaDon\n"
                + "                  (NgayTao, TenKH, SDTKH, TrangThai)\n"
                + "VALUES (?,?,?,2)";
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, a.getNgayTao());
            ps.setObject(2, a.getTenKH());
            ps.setObject(3, a.getSDTKH());
            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return check > 0;
    }

    @Override
    public boolean delete(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(HoaDonDM a, String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
