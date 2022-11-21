package Sevices.impl;

import DomainModels.XuatXu;
import Reponsitories.XuatXuRepository;
import Reponsitories.impl.XuatXuRepositoryImpl;
import Sevices.XuatXuService;
import ViewModels.XuatXuResponse;
import java.util.List;

/**
 *
 * @author chutu
 */
public class XuatXuServiceImpl implements XuatXuService{

    private XuatXuRepository xuatXuRepository = new XuatXuRepositoryImpl();

    @Override
    public List<XuatXuResponse> getAll() {
        return xuatXuRepository.getAll();
    }

    @Override
    public String add(XuatXu xuatXu) {
        boolean add = xuatXuRepository.add(xuatXu);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String ma, XuatXu xuatXu) {
        boolean update = xuatXuRepository.update(ma, xuatXu);
        if (update) {
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String ma) {
        boolean delete = xuatXuRepository.delete(ma);
        if (delete) {
            return "Xoá thành công";
        }
        return "Xoá thất bại";
    }
}
