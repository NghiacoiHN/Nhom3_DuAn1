package Reponsitories.impl;

import DomainModels.XuatXu;
import Reponsitories.XuatXuRepository;
import Utilities.DBConnection;
import ViewModels.XuatXuResponse;
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
public class XuatXuRepositoryImpl implements XuatXuRepository {

    @Override
    public List<XuatXuResponse> getAll() {
        try {
            List<XuatXuResponse> dsXuatXu = new ArrayList();

            Connection connection = DBConnection.getConnection();

            String sql = "SELECT IDXX, MaXX, TenNuoc, TinhTrang FROM XuatXu";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                Integer trangThai = rs.getInt(4);

                XuatXuResponse xuatXu = new XuatXuResponse();
                xuatXu.setId(id);
                xuatXu.setMa(ma);
                xuatXu.setTen(ten);
                xuatXu.setTrangThai(trangThai);
                dsXuatXu.add(xuatXu);
            }
            rs.close();
            ps.close();
            connection.close();

            return dsXuatXu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(XuatXu xuatXu) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "INSERT INTO XuatXu(MaXX, TenNuoc, TinhTrang) VALUES (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, xuatXu.getMa());
            ps.setString(2, xuatXu.getTen());
            ps.setInt(3, xuatXu.getTrangThai());

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(String ma, XuatXu xuatXu) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE XuatXu SET TenNuoc = ?, TinhTrang = ? WHERE MaXX = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, xuatXu.getTen());
            ps.setInt(2, xuatXu.getTrangThai());
            ps.setString(3, ma);

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean delete(String ma) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE XuatXu SET TinhTrang = 10 WHERE MaXX = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ma);

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
