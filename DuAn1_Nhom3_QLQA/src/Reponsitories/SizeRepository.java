package Reponsitories;

import DomainModels.Size;
import ViewModels.SizeResponse;
import java.util.List;



/**
 *
 * @author chutu
 */
public interface SizeRepository {
    List<SizeResponse> getAll();

    boolean add(Size size);
    
    boolean update(String id, Size size);
    
    boolean delete(String id);
}
