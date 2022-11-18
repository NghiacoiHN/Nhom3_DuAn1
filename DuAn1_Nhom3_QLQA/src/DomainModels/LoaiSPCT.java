/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author 84362
 */
public class LoaiSPCT {
    private String idLoaiSPCT;
    private String idLoaiSP;
    private String idChiTietSP;

    public LoaiSPCT() {
    }

    public LoaiSPCT(String idLoaiSPCT, String idLoaiSP, String idChiTietSP) {
        this.idLoaiSPCT = idLoaiSPCT;
        this.idLoaiSP = idLoaiSP;
        this.idChiTietSP = idChiTietSP;
    }

    public String getIdLoaiSPCT() {
        return idLoaiSPCT;
    }

    public void setIdLoaiSPCT(String idLoaiSPCT) {
        this.idLoaiSPCT = idLoaiSPCT;
    }

    public String getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(String idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    
}
