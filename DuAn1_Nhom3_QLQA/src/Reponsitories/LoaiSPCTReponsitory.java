/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reponsitories;

import DomainModels.LoaiSPCT;
import java.util.List;

/**
 *
 * @author 84362
 */
public interface LoaiSPCTReponsitory {
    List<LoaiSPCT> getAll();
    Integer add(LoaiSPCT lspct);
    Integer update(LoaiSPCT lspct);
}
