package Sevices;


import DomainModels.LoaiSp;
import ViewModels.LoaiSpResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public interface LoaiSpService {
    List<LoaiSpResponse> getAll();

    String add(LoaiSp loaiSp);

    String update(String id, LoaiSp loaiSp);

    String delete(String id);
}
