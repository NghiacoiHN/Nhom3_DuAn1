/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories.impl;

import DomainModels.ChiTietSP;
import Reponsitories.ChiTietSPReponsitory;
import Utilities.DBConnection;
import ViewModels.ChiTietSPResponse;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 84362
 */
public class ChiTietSPReponsitoryImpl implements ChiTietSPReponsitory {

    public List<ChiTietSP> getAll() {
        List<ChiTietSP> listCTSP = new ArrayList<>();
        String sql = """
                     SELECT [IDCTSP]
                             ,[MaCTSP]
                             ,[IDCL]
                             ,[IDMS]
                             ,[IDSize]
                             ,[IDSP]
                             ,[IDLSP]
                             ,[IDXX]
                             ,[MoTa]
                             ,[SoLuongTon]
                             ,[GiaNhap]
                             ,[GiaBan]
                             ,[TrangThai]
                         FROM [dbo].[ChiTietSanPham]""";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listCTSP.add(new ChiTietSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getInt(10), rs.getBigDecimal(11), rs.getBigDecimal(12), rs.getInt(13)));
            }

            return listCTSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ChiTietSPResponse> getView() {
        List<ChiTietSPResponse> listCTSP = new ArrayList<>();
        String sql = """
                     select MaCTSP, TenCL, TenMS, TenSize, TenSp, TenLSP, TenNuoc, MoTa, SoLuongTon, GiaNhap, GiaBan, TrangThai 
                     from ChiTietSanPham join ChatLieu on ChiTietSanPham.IDCL = ChatLieu.IDCL
                                    join MauSac on ChiTietSanPham.IDMS = MauSac.IDMS
                                    join Size on ChiTietSanPham.IDSize = Size.IDSize
                                    join SanPham on ChiTietSanPham.IDSP = SanPham.IDSP
                                    join LoaiSP on ChiTietSanPham.IDLSP = LoaiSP.IDLSP
                                    join XuatXu on ChiTietSanPham.IDXX = XuatXu.IDXX""";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listCTSP.add(new ChiTietSPResponse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getInt(9), rs.getBigDecimal(10), rs.getBigDecimal(11), rs.getInt(12)));
            }

            return listCTSP;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer add(ChiTietSP ctsp) {
        String sql = """
                     INSERT INTO [dbo].[ChiTietSanPham]
                                           ([MaCTSP]
                                           ,[IDCL]
                                           ,[IDMS]
                                           ,[IDSize]
                                           ,[IDSP]
                                           ,[IDLSP]
                                           ,[IDXX]
                                           ,[MoTa]
                                           ,[SoLuongTon]
                                           ,[GiaNhap]
                                           ,[GiaBan]
                                           ,[TrangThai])
                                     VALUES
                                           (?,?,?,?,?,?,?,?,?,?,?,?) """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, ctsp.getMaChiTietSP());
            ps.setString(2, ctsp.getIdChatLieu());
            ps.setString(3, ctsp.getIdMauSac());
            ps.setString(4, ctsp.getIdSize());
            ps.setString(5, ctsp.getIdSP());
            ps.setString(6, ctsp.getIdLoaiSP());
            ps.setString(7, ctsp.getIdXuatXu());
            ps.setString(8, ctsp.getMoTa());
            ps.setInt(9, ctsp.getSoLuongTon());
            ps.setBigDecimal(10, ctsp.getGiaNhap());
            ps.setBigDecimal(11, ctsp.getGiaBan());
            ps.setInt(12, ctsp.getTrangThai());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer update(ChiTietSP ctsp) {
        String sql = """
                     UPDATE [dbo].[ChiTietSanPham]
                                    SET [IDCL] = ?
                                       ,[IDMS] = ?
                                       ,[IDSize] = ?
                                       ,[IDSP] = ?
                                       ,[IDLSP] = ?
                                       ,[IDXX] = ?
                                       ,[MoTa] = ?
                                       ,[SoLuongTon] = ?
                                       ,[GiaNhap] = ?
                                       ,[GiaBan] = ?
                                       ,[TrangThai] = ?
                                  WHERE MaCTSP = ? """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(12, ctsp.getMaChiTietSP());
            ps.setString(1, ctsp.getIdChatLieu());
            ps.setString(2, ctsp.getIdMauSac());
            ps.setString(3, ctsp.getIdSize());
            ps.setString(4, ctsp.getIdSP());
            ps.setString(5, ctsp.getIdLoaiSP());
            ps.setString(6, ctsp.getIdXuatXu());
            ps.setString(7, ctsp.getMoTa());
            ps.setInt(8, ctsp.getSoLuongTon());
            ps.setBigDecimal(9, ctsp.getGiaNhap());
            ps.setBigDecimal(10, ctsp.getGiaBan());
            ps.setInt(11, ctsp.getTrangThai());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer delete(String maCTSP) {
        String sql = """
                     DELETE FROM [dbo].[ChiTietSanPham]
                                      WHERE MaCTSP = ? """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, maCTSP);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public Integer xoaMem(String maCTSP) {
        String sql = """
                     UPDATE [dbo].[ChiTietSanPham]
                                         SET [TrangThai] = 10
                                       WHERE MaCTSP = ? """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, maCTSP);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
