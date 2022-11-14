package Reponsitories;

import DomainModels.SanPham;
import ViewModels.SanPhamResponse;
import java.util.List;



/**
 *
 * @author chutu
 */
public interface SanPhamRepository {
    List<SanPhamResponse> getAll();

    boolean add(SanPham sanPham);
    
    boolean update(String id, SanPham sanPham);
    
    boolean delete(String id);
}
