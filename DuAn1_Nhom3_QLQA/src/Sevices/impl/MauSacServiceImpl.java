package Sevices.impl;

import DomainModels.MauSac;
import Reponsitories.MauSacRepository;
import Reponsitories.impl.MauSacRepositoryImpl;
import Sevices.MauSacService;
import ViewModels.MauSacResponse;
import java.util.List;

/**
 *
 * @author chutu
 */
public class MauSacServiceImpl implements MauSacService {

    private MauSacRepository mauSacRepository = new MauSacRepositoryImpl();

    @Override
    public List<MauSacResponse> getAll() {
        return mauSacRepository.getAll();
    }

    @Override
    public String add(MauSac mauSac) {
        boolean add = mauSacRepository.add(mauSac);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, MauSac mauSac) {
        boolean update = mauSacRepository.update(id, mauSac);
        if (update) {
            return "Sửa thành công id:" + id;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean delete = mauSacRepository.delete(id);
        if (delete) {
            return "Xoá thành công id:" + id;
        }
        return "Xoá thất bại";
    }
}
