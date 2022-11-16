/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.SanPhamDM;
import ViewModels.GioHangVM;
import java.util.List;

/**
 *
 * @author TRONG NGHIA
 */
public interface GioHangIRepon {
//    List<GioHangVM> findAll();

    GioHangVM getOne(String ma);

//    boolean add(SanPhamDM a);

//    boolean delete(String ma);
//
//    boolean update(SanPhamDM a, String ID);
}
