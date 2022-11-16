/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author TRONG NGHIA
 */
public class SanPhamVM {

    String maCTSP;
    String tenSP;
    String tenLoaiSP;
    String tenCL;
    String tenMS;
    String tenSize;
    Integer soLuongTon;
    BigDecimal giaBan;
    Integer trangThai;

    public SanPhamVM() {
    }

    public SanPhamVM(String maCTSP, String tenSP, String tenLoaiSP, String tenCL, String tenMS, String tenSize, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, Integer trangThai) {
        this.maCTSP = maCTSP;
        this.tenSP = tenSP;
        this.tenLoaiSP = tenLoaiSP;
        this.tenCL = tenCL;
        this.tenMS = tenMS;
        this.tenSize = tenSize;
        this.soLuongTon = soLuongTon;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getTenLoaiSP() {
        return tenLoaiSP;
    }

    public void setTenLoaiSP(String tenLoaiSP) {
        this.tenLoaiSP = tenLoaiSP;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
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
