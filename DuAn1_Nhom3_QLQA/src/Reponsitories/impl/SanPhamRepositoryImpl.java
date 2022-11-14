package Reponsitories.impl;


import DomainModels.SanPham;
import Reponsitories.SanPhamRepository;
import Utilities.DBConnection;
import ViewModels.SanPhamResponse;
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
public class SanPhamRepositoryImpl implements SanPhamRepository{

    @Override
    public List<SanPhamResponse> getAll() {
        try {
            List<SanPhamResponse> dsSanPham = new ArrayList();

            Connection connection = DBConnection.getConnection();

            String sql = "SELECT IDSP, MaSP, TenSp, TinhTrang FROM SanPham";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                Integer trangThai = rs.getInt(4);

                SanPhamResponse sanPham = new SanPhamResponse();
                sanPham.setId(id);
                sanPham.setMa(ma);
                sanPham.setTen(ten);
                sanPham.setTrangThai(trangThai);
                dsSanPham.add(sanPham);
            }
            rs.close();
            ps.close();
            connection.close();

            return dsSanPham;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(SanPham sanPham) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "INSERT INTO SanPham(MaSP, TenSp, TinhTrang) VALUES (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setInt(3, sanPham.getTrangThai());

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, SanPham sanPham) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE SanPham SET MaSP = ?, TenSp = ?, TinhTrang = ? WHERE IDSP = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setInt(3, sanPham.getTrangThai());
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

            String sql = "UPDATE SanPham SET TinhTrang = 10 WHERE IDSP = ?";

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
