package Sevices;


import DomainModels.ChatLieu;
import ViewModels.ChatLieuResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public interface ChatLieuService {
    List<ChatLieuResponse> getAll();

    String add(ChatLieu chatLieu);

    String update(String ma, ChatLieu chatLieu);

    String delete(String ma);
}
