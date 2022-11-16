package Reponsitories.impl;


import DomainModels.LoaiSp;
import Reponsitories.LoaiSpRepository;
import Utilities.DBConnection;
import ViewModels.LoaiSpResponse;
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
public class LoaiSpRepositoryImpl implements LoaiSpRepository{

    @Override
    public List<LoaiSpResponse> getAll() {
        try {
            List<LoaiSpResponse> dsLoaiSp = new ArrayList();

            Connection connection = DBConnection.getConnection();

            String sql = "SELECT IDLSP, MaLSP, TenLSP, TinhTrang FROM LoaiSP";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                Integer trangThai = rs.getInt(4);

                LoaiSpResponse loaiSp = new LoaiSpResponse();
                loaiSp.setId(id);
                loaiSp.setMa(ma);
                loaiSp.setTen(ten);
                loaiSp.setTrangThai(trangThai);
                dsLoaiSp.add(loaiSp);
            }
            rs.close();
            ps.close();
            connection.close();

            return dsLoaiSp;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(LoaiSp loaiSp) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "INSERT INTO LoaiSP(MaLSP, TenLSP, TinhTrang) VALUES (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, loaiSp.getMa());
            ps.setString(2, loaiSp.getTen());
            ps.setInt(3, loaiSp.getTrangThai());

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, LoaiSp loaiSP) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE LoaiSP SET TenLSP = ?, TinhTrang = ? WHERE MaLSP = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, loaiSP.getTen());
            ps.setInt(2, loaiSP.getTrangThai());
            ps.setString(3, id);

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

            String sql = "UPDATE LoaiSP SET TinhTrang = 10 WHERE MaLSP = ?";

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
