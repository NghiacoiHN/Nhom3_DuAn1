/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.impl;

import DomainModels.HoaDonDM;
import Reponsitories.HoaDonIRepon;
import Reponsitories.impl.HoaDonRepon;
import Sevices.HoaDonISevice;
import ViewModels.HoaDonVM;
import java.util.List;

/**
 *
 * @author TRONG NGHIA
 */
public class HoaDonSevice implements HoaDonISevice {

    HoaDonIRepon hdRepon = new HoaDonRepon();

    @Override
    public List<HoaDonVM> findAll() {
        try {
            return hdRepon.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<HoaDonVM> findByTT(Integer trangThai) {
        try {
            return hdRepon.findByTT(trangThai);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean add(HoaDonDM a) {
        try {
            return hdRepon.add(a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
