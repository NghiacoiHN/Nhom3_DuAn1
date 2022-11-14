package Sevices;


import DomainModels.Size;
import ViewModels.SizeResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public interface SizeService {
    List<SizeResponse> getAll();

    String add(Size size);

    String update(String id, Size size);

    String delete(String id);
}
