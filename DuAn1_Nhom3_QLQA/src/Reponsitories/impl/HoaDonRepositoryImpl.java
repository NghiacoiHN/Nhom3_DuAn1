/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories.impl;

import DomainModels.HoaDonDM;
import Utilities.DBConnection;
import ViewModels.HoaDonVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Reponsitories.HoaDonRepository;

/**
 *
 * @author TRONG NGHIA
 */
public class HoaDonRepositoryImpl implements HoaDonRepository {

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
    public HoaDonDM getOne(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(HoaDonDM a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
