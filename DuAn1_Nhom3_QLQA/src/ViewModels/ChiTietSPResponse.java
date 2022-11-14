/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author 84362
 */
public class ChiTietSPResponse {
    private String maChiTietSP;
    private String chatLieu;
    private String mauSac;
    private String size;
    private String sanPham;
    private String moTa;
    private int soLuongTon;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private int trangThai;

    public ChiTietSPResponse() {
    }

    public ChiTietSPResponse(String maChiTietSP, String chatLieu, String mauSac, String size, String sanPham, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan, int trangThai) {
        this.maChiTietSP = maChiTietSP;
        this.chatLieu = chatLieu;
        this.mauSac = mauSac;
        this.size = size;
        this.sanPham = sanPham;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
    }

    public String getMaChiTietSP() {
        return maChiTietSP;
    }

    public void setMaChiTietSP(String maChiTietSP) {
        this.maChiTietSP = maChiTietSP;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String trangThai(){
        if(trangThai == 1){
            return "Còn bán";
        }
        else if(trangThai == 2){
            return "Ngừng kinh doanh";
        }else{
            return "Chưa xác định";
        }
    }
}
