package Reponsitories.impl;


import DomainModels.ChatLieu;
import Reponsitories.ChatLieuRepository;
import Utilities.DBConnection;
import ViewModels.ChatLieuResponse;
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
public class ChatLieuRepositoryImpl implements ChatLieuRepository{

    @Override
    public List<ChatLieuResponse> getAll() {
        try {
            List<ChatLieuResponse> dsChatLieu = new ArrayList();

            Connection connection = DBConnection.getConnection();

            String sql = "SELECT IDCL, MaCL, TenCL, TinhTrang FROM ChatLieu";

            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                Integer trangThai = rs.getInt(4);

                ChatLieuResponse chatLieu = new ChatLieuResponse();
                chatLieu.setId(id);
                chatLieu.setMa(ma);
                chatLieu.setTen(ten);
                chatLieu.setTrangThai(trangThai);
                dsChatLieu.add(chatLieu);
            }
            rs.close();
            ps.close();
            connection.close();

            return dsChatLieu;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(ChatLieu chatLieu) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "INSERT INTO ChatLieu(MaCL, TenCL, TinhTrang) VALUES (?, ?, ?)";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, chatLieu.getMa());
            ps.setString(2, chatLieu.getTen());
            ps.setInt(3, chatLieu.getTrangThai());

            check = ps.executeUpdate();

            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public boolean update(String ma, ChatLieu chatLieu) {
        int check = 0;
        try {
            Connection connection = DBConnection.getConnection();

            String sql = "UPDATE ChatLieu SET TenCL = ?, TinhTrang = ? WHERE MaCL = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, chatLieu.getTen());
            ps.setInt(2, chatLieu.getTrangThai());
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

            String sql = "UPDATE ChatLieu SET TinhTrang = 10 WHERE MaCL = ?";

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
