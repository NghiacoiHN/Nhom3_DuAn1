package Reponsitories;

import DomainModels.XuatXu;
import ViewModels.XuatXuResponse;
import java.util.List;

/**
 *
 * @author chutu
 */
public interface XuatXuRepository {

    List<XuatXuResponse> getAll();

    boolean add(XuatXu xuatXu);

    boolean update(String ma, XuatXu xuatXu);

    boolean delete(String ma);
    
}
