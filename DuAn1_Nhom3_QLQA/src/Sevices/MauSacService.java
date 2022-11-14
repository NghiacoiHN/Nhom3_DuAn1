package Sevices;

import DomainModels.MauSac;
import ViewModels.MauSacResponse;
import java.util.List;

/**
 *
 * @author chutu
 */
public interface MauSacService {
    List<MauSacResponse> getAll();

    String add(MauSac mauSac);

    String update(String id, MauSac mauSac);

    String delete(String id);
}
