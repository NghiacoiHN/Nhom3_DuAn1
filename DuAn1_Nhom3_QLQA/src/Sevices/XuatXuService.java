package Sevices;

import DomainModels.XuatXu;
import ViewModels.XuatXuResponse;
import java.util.List;

/**
 *
 * @author chutu
 */
public interface XuatXuService {

    List<XuatXuResponse> getAll();

    String add(XuatXu xuatXu);

    String update(String ma, XuatXu xuatXu);

    String delete(String ma);
}
