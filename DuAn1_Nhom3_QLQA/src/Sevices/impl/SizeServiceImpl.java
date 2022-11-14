package Sevices.impl;


import DomainModels.Size;
import Reponsitories.SizeRepository;
import Reponsitories.impl.SizeRepositoryImpl;
import Sevices.SizeService;
import ViewModels.SizeResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public class SizeServiceImpl implements SizeService {

    private SizeRepository sizeRepository = new SizeRepositoryImpl();

    @Override
    public List<SizeResponse> getAll() {
        return sizeRepository.getAll();
    }

    @Override
    public String add(Size size) {
        boolean add = sizeRepository.add(size);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, Size size) {
        boolean update = sizeRepository.update(id, size);
        if (update) {
            return "Sửa thành công id:" + id;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean delete = sizeRepository.delete(id);
        if (delete) {
            return "Xoá thành công id:" + id;
        }
        return "Xoá thất bại";
    }
}
