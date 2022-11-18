/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.impl;

import DomainModels.LoaiSPCT;
import Reponsitories.LoaiSPCTReponsitory;
import Reponsitories.impl.LoaiSPCTReponsitoryImpl;
import Sevices.LoaiSPCTService;
import java.util.List;

/**
 *
 * @author 84362
 */
public class LoaiSPCTServiceImpl implements LoaiSPCTService{
    final LoaiSPCTReponsitory loaiSPCT = new LoaiSPCTReponsitoryImpl();

    @Override
    public List<LoaiSPCT> getAll() {
        return loaiSPCT.getAll();
    }

    @Override
    public String add(LoaiSPCT lspct) {
        if(loaiSPCT.add(lspct) < 0){
            return "Thêm thất bại";
        }else{
            return "Thêm thành công";
        }
    }

    @Override
    public String update(LoaiSPCT lspct) {
        if(loaiSPCT.update(lspct) < 0){
            return "Sửa thất bại";
        }else{
            return "Sửa thành công";
        }
    }
    
}
