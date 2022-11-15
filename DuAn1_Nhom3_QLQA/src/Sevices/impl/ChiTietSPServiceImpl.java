/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sevices.impl;

import DomainModels.ChiTietSP;
import Reponsitories.ChiTietSPReponsitory;
import Reponsitories.impl.ChiTietSPReponsitoryImpl;
import Sevices.ChiTietSPService;
import ViewModels.ChiTietSPResponse;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author 84362
 */
public class ChiTietSPServiceImpl implements ChiTietSPService {

    final ChiTietSPReponsitory ctspRepo = new ChiTietSPReponsitoryImpl();

    @Override
    public List<ChiTietSP> getAll() {
        return ctspRepo.getAll();

    }

    @Override
    public boolean checkMa(String maCTSP) {
        List<ChiTietSPResponse> listCTSP = ctspRepo.getView();
        for (ChiTietSPResponse ctsp : listCTSP) {
            if (ctsp.getMaChiTietSP().equalsIgnoreCase(maCTSP)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String add(ChiTietSP ctsp) {
        if (checkMa(ctsp.getMaChiTietSP())) {
            return "Mã chi tiết sản phẩm đã tồn tại";
        } else {
            if (ctspRepo.add(ctsp) < 0) {
                return "Thêm thất bại";
            } else {
                return "Thêm thành công";
            }
        }

    }

    @Override
    public String update(ChiTietSP ctsp) {

            if (!checkMa(ctsp.getMaChiTietSP())) {
                return "Mã chi tiết sản phẩm không tồn tại";
            } else {
                if (ctspRepo.update(ctsp) < 0) {
                    return "Sửa thất bại";
                } else {
                    return "Sửa thành công";
                }
            }
    }

    @Override
    public String delete(String maCTSP) {
        if (ctspRepo.delete(maCTSP) < 0) {
            return "Xóa thất bại";
        } else {
            return "Xóa thành công";
        }
    }

    @Override
    public List<ChiTietSPResponse> getView() {
        return ctspRepo.getView();
    }

    public String checkValidate(ChiTietSP ctsp) {
        if (ctsp.getMaChiTietSP().isBlank() || String.valueOf(ctsp.getSoLuongTon()).isBlank() || String.valueOf(ctsp.getGiaNhap()).isBlank()
                || String.valueOf(ctsp.getGiaBan()).isBlank()) {
            return "Không được để trống dữ liệu";
        }

        if (ctsp.getMaChiTietSP().length() > 20) {
            return "Mã chi tiết sản phẩm không được quá 20 ký tự";
        }

        try {
            int soLuongTon = ctsp.getSoLuongTon();
            if (soLuongTon < 0 || soLuongTon > 1000000000) {
                return "Số lượng tồn không dược < 0 và > 1000000000 ";
            }

        } catch (NumberFormatException e) {
            return "Số lượng tồn phải là số nguyên";
        }

        try {
            double giaNhap = ctsp.getGiaNhap().doubleValue();
            if (giaNhap < 0 || giaNhap > 1000000000) {
                return "Giá nhập không dược < 0 và > 1000000000 ";
            }

        } catch (NumberFormatException e) {
            return "Giá nhập phải là số";
        }

        try {
            double giaBan = ctsp.getGiaBan().doubleValue();
            if (giaBan < 0 || giaBan > 1000000000) {
                return "Giá bán không dược < 0 và > 1000000000 ";
            }

        } catch (NumberFormatException e) {
            return "Giá bán phải là số";
        }

        if (String.valueOf(ctsp.getTrangThai()).isBlank()) {
            return "Hãy chọn 1 trạng thái";
        }

        return "Ok";
    }

}
