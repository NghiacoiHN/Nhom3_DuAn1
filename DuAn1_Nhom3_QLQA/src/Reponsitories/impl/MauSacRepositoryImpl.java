package Reponsitories.impl;

import DomainModels.MauSac;
import Reponsitories.MauSacRepository;
import Utilities.DBConnection;
import ViewModels.MauSacResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chutu
 */
public class MauSacRepositoryImpl implements MauSacRepository{
    @Override
    public List<MauSacResponse> getAll() {
        try {
            List<MauSacResponse> dsMauSac = new ArrayList();

            Connection connection = DBConnection.getConnection();

            String sql = "SELECT IDMS, MaMS, TenMS, TinhTrang FROM MauSac";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                Integer trangThai = rs.getInt(4);

                MauSacResponse mauSac = new MauSacResponse();
                mauSac.setId(id);
                mauSac.setMa(ma);
                mauSac.setTen(ten);
                mauSac.setTrangThai(trangThai);
                dsMauSac.add(mauSac);
            }
            rs.close();
            ps.close();
            connection.close();

            return dsMauSac;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(MauSac mauSac) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "INSERT INTO MauSac(MaMS, TenMS, TinhTrang) VALUES (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.setInt(3, mauSac.getTrangThai());

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, MauSac mauSac) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();
            
            String sql = "UPDATE MauSac SET MaMS = ?, TenMS = ?, TinhTrang = ? WHERE IDMS = ?";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.setInt(3, mauSac.getTrangThai());
            ps.setString(4, id);
            
            check = ps.executeUpdate();
            
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String id) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();
            
            String sql = "UPDATE SanPham SET TinhTrang = 10 WHERE IDMS = ?";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            
            check = ps.executeUpdate();
            
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }  
}

