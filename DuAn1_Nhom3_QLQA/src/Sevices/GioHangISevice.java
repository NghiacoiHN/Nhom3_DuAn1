/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sevices;

import Reponsitories.*;
import DomainModels.SanPhamDM;
import ViewModels.GioHangVM;
import java.util.List;

/**
 *
 * @author TRONG NGHIA
 */
public interface GioHangISevice {
    List<GioHangVM> findAll();

    List<GioHangVM> getOne(String ma);

//    boolean add(SanPhamDM a);

//    boolean delete(String ma);
//
//    boolean update(SanPhamDM a, String ID);
}
