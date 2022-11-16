/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author TRONG NGHIA
 */
public class SanPhamDM {
    String IDCTSP;
    String maCTSP;
    String IDSP;
    String IDCL;
    String IDMS;
    String IDSize;
    String moTa;
    Integer soLuongTon;
    BigDecimal giaNhap;
    BigDecimal giaBan;
    Integer trangThai;

    public SanPhamDM() {
    }

    public SanPhamDM(String IDCTSP, String maCTSP, String IDSP, String IDCL, String IDMS, String IDSize, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Integer trangThai) {
        this.IDCTSP = IDCTSP;
        this.maCTSP = maCTSP;
        this.IDSP = IDSP;
        this.IDCL = IDCL;
        this.IDMS = IDMS;
        this.IDSize = IDSize;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }

    public String getIDCTSP() {
        return IDCTSP;
    }

    public void setIDCTSP(String IDCTSP) {
        this.IDCTSP = IDCTSP;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getIDSP() {
        return IDSP;
    }

    public void setIDSP(String IDSP) {
        this.IDSP = IDSP;
    }

    public String getIDCL() {
        return IDCL;
    }

    public void setIDCL(String IDCL) {
        this.IDCL = IDCL;
    }

    public String getIDMS() {
        return IDMS;
    }

    public void setIDMS(String IDMS) {
        this.IDMS = IDMS;
    }

    public String getIDSize() {
        return IDSize;
    }

    public void setIDSize(String IDSize) {
        this.IDSize = IDSize;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
}
