/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.impl;

import Reponsitories.GioHangIRepon;
import Reponsitories.impl.GioHangRepon;
import Sevices.GioHangISevice;
import ViewModels.GioHangVM;
import java.util.List;


/**
 *
 * @author TRONG NGHIA
 */
public class GioHangSevice implements GioHangISevice {

    GioHangIRepon ghRepon = new GioHangRepon();

    @Override
    public List<GioHangVM> findAll() {
        try {
            return ghRepon.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<GioHangVM> getOne(String ma) {
        try {
            return ghRepon.getOne(ma);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public boolean add(HoaDonDM a) {
//        try {
//            return hdRepon.add(a);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public boolean delete(String ma) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public boolean update(HoaDonDM a, String ID) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
