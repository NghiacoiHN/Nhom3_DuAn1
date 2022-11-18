/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reponsitories.impl;

import DomainModels.LoaiSPCT;
import Reponsitories.LoaiSPCTReponsitory;
import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84362
 */
public class LoaiSPCTReponsitoryImpl implements LoaiSPCTReponsitory{

    @Override
    public List<LoaiSPCT> getAll() {
        List<LoaiSPCT> listLSPCT = new ArrayList<>();
        String sql = """
                     SELECT [IDLSPCT]
                           ,[IDLSP]
                           ,[IDCTSP]
                       FROM [dbo].[LoaiSPCT]""";
        
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ){
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                listLSPCT.add(new LoaiSPCT(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
            
            return listLSPCT;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer add(LoaiSPCT lspct) {
        String sql = """
                     INSERT INTO [dbo].[LoaiSPCT]
                                  ([IDLSP]
                                  ,[IDCTSP])
                            VALUES
                                  (?,?)""";
        
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ){
            ps.setString(1, lspct.getIdLoaiSP());
            ps.setString(2, lspct.getIdChiTietSP());
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Integer update(LoaiSPCT lspct) {
        String sql = """
                     UPDATE [dbo].[LoaiSPCT]
                                     SET [IDLSP] = ?
                                        ,[IDCTSP] = ?
                                   WHERE IDLSP = ?""";
        
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ){
            ps.setString(1, lspct.getIdLoaiSP());
            ps.setString(2, lspct.getIdChiTietSP());
            ps.setString(3, lspct.getIdLoaiSPCT());
            return ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
}
