/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.impl;

import DomainModels.SanPhamDM;
import Reponsitories.SanPhamIRepon;
import Reponsitories.impl.SanPhamRepon;
import Sevices.SanPhamISevice;
import ViewModels.SanPhamVM;
import java.util.List;

/**
 *
 * @author TRONG NGHIA
 */
public class SanPhamSevice implements SanPhamISevice {

    SanPhamIRepon spRepon = new SanPhamRepon();

    @Override
    public List<SanPhamVM> findAll() {
        try {
            return spRepon.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public SanPhamVM getOne(Integer trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(SanPhamDM a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(SanPhamDM a, String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
