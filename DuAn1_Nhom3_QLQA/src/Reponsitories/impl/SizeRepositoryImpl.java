package Reponsitories.impl;


import DomainModels.Size;
import Reponsitories.SizeRepository;
import Utilities.DBConnection;
import ViewModels.SizeResponse;
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
public class SizeRepositoryImpl implements SizeRepository{

    @Override
    public List<SizeResponse> getAll() {
        try {
            List<SizeResponse> dsSize = new ArrayList();

            Connection connection = DBConnection.getConnection();

            String sql = "SELECT IDSize, MaSize, TenSize, TinhTrang FROM Size";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                Integer trangThai = rs.getInt(4);

                SizeResponse size = new SizeResponse();
                size.setId(id);
                size.setMa(ma);
                size.setSoSize(ten);
                size.setTrangThai(trangThai);
                dsSize.add(size);
            }
            rs.close();
            ps.close();
            connection.close();

            return dsSize;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Size size) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "INSERT INTO Size(MaSize, TenSize, TinhTrang) VALUES (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, size.getMa());
            ps.setString(2, size.getCoSize());
            ps.setInt(3, size.getTrangThai());

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(String id, Size size) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE Size SET MaSize = ?, TenSize = ?, TinhTrang = ? WHERE IDSize = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, size.getMa());
            ps.setString(2, size.getCoSize());
            ps.setInt(3, size.getTrangThai());
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

            String sql = "UPDATE Size SET TinhTrang = 10 WHERE IDSize = ?";

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
