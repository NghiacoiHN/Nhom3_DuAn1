/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
<<<<<<< HEAD
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sevices.impl;

import Reponsitories.*;
import DomainModels.HoaDonDM;
<<<<<<<< HEAD:DuAn1_Nhom3_QLQA/src/Sevices/impl/HoaDonSevice.java
import Reponsitories.HoaDonIRepon;
import Reponsitories.impl.HoaDonRepon;
import Sevices.HoaDonISevice;
========
>>>>>>>> origin/Tu4n:DuAn1_Nhom3_QLQA/src/Sevices/HoaDonSevice.java
=======
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.impl;

import DomainModels.HoaDonDM;
import Reponsitories.HoaDonIRepon;
import Reponsitories.impl.HoaDonRepon;
import Sevices.HoaDonISevice;
>>>>>>> origin/Tu4n
import ViewModels.HoaDonVM;
import java.util.List;

/**
 *
 * @author TRONG NGHIA
 */
<<<<<<< HEAD
public interface HoaDonSevice {

    List<HoaDonVM> findAll();

    HoaDonDM getOne(String ID);

<<<<<<<< HEAD:DuAn1_Nhom3_QLQA/src/Sevices/impl/HoaDonSevice.java
    @Override
    public HoaDonVM getOne(Integer trangThai) {
        try {
            return hdRepon.getOne(trangThai);
=======
public class HoaDonSevice implements HoaDonISevice {

    HoaDonIRepon hdRepon = new HoaDonRepon();

    @Override
    public List<HoaDonVM> findAll() {
        try {
            return hdRepon.findAll();
>>>>>>> origin/Tu4n
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
<<<<<<< HEAD
    public boolean add(HoaDonDM a) {
        try {
            return hdRepon.add(a);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
=======
    public HoaDonDM getOne(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(HoaDonDM a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
>>>>>>> origin/Tu4n
    }

    @Override
    public boolean delete(String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(HoaDonDM a, String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
<<<<<<< HEAD
========
    boolean add(HoaDonDM a);

    boolean delete(String ma);
>>>>>>>> origin/Tu4n:DuAn1_Nhom3_QLQA/src/Sevices/HoaDonSevice.java

    boolean update(HoaDonDM a, String ID);
=======

>>>>>>> origin/Tu4n
}
