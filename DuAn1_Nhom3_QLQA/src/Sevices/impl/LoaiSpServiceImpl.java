package Sevices.impl;


import DomainModels.LoaiSp;
import Reponsitories.LoaiSpRepository;
import Reponsitories.impl.LoaiSpRepositoryImpl;
import Sevices.LoaiSpService;
import ViewModels.LoaiSpResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public class LoaiSpServiceImpl implements LoaiSpService {

    private LoaiSpRepository loaiSpRepository = new LoaiSpRepositoryImpl();

    @Override
    public List<LoaiSpResponse> getAll() {
        return loaiSpRepository.getAll();
    }

    @Override
    public String add(LoaiSp loaiSp) {
        boolean add = loaiSpRepository.add(loaiSp);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, LoaiSp loaiSp) {
        boolean update = loaiSpRepository.update(id, loaiSp);
        if (update) {
            return "Sửa thành công id:" + id;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean delete = loaiSpRepository.delete(id);
        if (delete) {
            return "Xoá thành công id:" + id;
        }
        return "Xoá thất bại";
    }
}
