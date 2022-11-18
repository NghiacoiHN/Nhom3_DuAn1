/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Sevices;

import DomainModels.LoaiSPCT;
import java.util.List;

/**
 *
 * @author 84362
 */
public interface LoaiSPCTService {
    List<LoaiSPCT> getAll();
    String add(LoaiSPCT lspct);
    String update(LoaiSPCT lspct);
}
