package Sevices;


import DomainModels.SanPham;
import ViewModels.SanPhamResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public interface SanPhamService {
    List<SanPhamResponse> getAll();

    String add(SanPham sanPham);

    String update(String id, SanPham sanPham);

    String delete(String id);
}
