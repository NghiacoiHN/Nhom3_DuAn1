/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.impl;

import DomainModels.ChiTietSP;
import Reponsitories.ChiTietSPReponsitory;
import Reponsitories.impl.ChiTietSPReponsitoryImpl;
import Sevices.ChiTietSPService;
import ViewModels.ChiTietSPReponse;
import java.util.List;

/**
 *
 * @author 84362
 */
public class ChiTietSPServiceImpl implements ChiTietSPService{
    final ChiTietSPReponsitory ctspRepo = new ChiTietSPReponsitoryImpl();

    @Override
    public List<ChiTietSP> getAll() {
        return ctspRepo.getAll();
    }

    @Override
    public List<ChiTietSPReponse> getView() {
        return ctspRepo.getView();
    }

    @Override
    public boolean checkMa(String maCTSP) {
        List<ChiTietSPReponse> listCTSP = ctspRepo.getView();
        for (ChiTietSPReponse ctsp : listCTSP) {
            if(ctsp.getMaChiTietSP().equalsIgnoreCase(maCTSP)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String add(ChiTietSP ctsp) {
        if(ctspRepo.add(ctsp) < 0){
            return "Thêm thất bại";
        }else{
            return "Thêm thành công";
        }
    }

    @Override
    public String update(ChiTietSP ctsp) {
        if(ctspRepo.update(ctsp) < 0){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }

    @Override
    public String delete(String maCTSP) {
        if(ctspRepo.delete(maCTSP) < 0){
            return "Xóa thất bại";
        }else{
            return "Xóa thành công";
        }
    }
    
}
