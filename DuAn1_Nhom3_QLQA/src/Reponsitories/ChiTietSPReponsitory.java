/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.ChiTietSP;
import ViewModels.ChiTietSPResponse;
import java.util.List;

/**
 *
 * @author 84362
 */
public interface ChiTietSPReponsitory {
    List<ChiTietSP> getAll();
    List<ChiTietSPResponse> getView();
    Integer add(ChiTietSP ctsp);
    Integer update(ChiTietSP ctsp);
    Integer delete(String maCTSP);
    
}
