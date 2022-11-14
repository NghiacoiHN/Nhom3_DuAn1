package Reponsitories;

import DomainModels.LoaiSp;
import ViewModels.LoaiSpResponse;
import java.util.List;



/**
 *
 * @author chutu
 */
public interface LoaiSpRepository {
    List<LoaiSpResponse> getAll();

    boolean add(LoaiSp loaiSp);
    
    boolean update(String id, LoaiSp loaiSp);
    
    boolean delete(String id);
}
