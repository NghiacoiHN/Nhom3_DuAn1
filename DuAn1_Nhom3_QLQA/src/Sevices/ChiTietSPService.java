/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sevices;

import DomainModels.ChiTietSP;
import ViewModels.ChiTietSPReponse;
import java.util.List;

/**
 *
 * @author 84362
 */
public interface ChiTietSPService {
    List<ChiTietSP> getAll();
    List<ChiTietSPReponse> getView();
    boolean checkMa(String maCTSP);
    
    String add(ChiTietSP ctsp);
    String update(ChiTietSP ctsp);
    String delete(String maCTSP);
    
}
