package Sevices.impl;


import DomainModels.SanPham;
import Reponsitories.SanPhamRepository;
import Reponsitories.impl.SanPhamRepositoryImpl;
import Sevices.SanPhamService;
import ViewModels.SanPhamResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public class SanPhamServiceImpl implements SanPhamService {

    private SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();

    @Override
    public List<SanPhamResponse> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public String add(SanPham sanPham) {
        boolean add = sanPhamRepository.add(sanPham);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, SanPham sanPham) {
        boolean update = sanPhamRepository.update(id, sanPham);
        if (update) {
            return "Sửa thành công id:" + id;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean delete = sanPhamRepository.delete(id);
        if (delete) {
            return "Xoá thành công id:" + id;
        }
        return "Xoá thất bại";
    }
}
