package Reponsitories;

import DomainModels.MauSac;
import ViewModels.MauSacResponse;
import java.util.List;

/**
 *
 * @author chutu
 */
public interface MauSacRepository {
    List<MauSacResponse> getAll();
    
    boolean add(MauSac mauSac);
    
    boolean update(String id, MauSac mauSac);
    
    boolean delete(String id);
}
