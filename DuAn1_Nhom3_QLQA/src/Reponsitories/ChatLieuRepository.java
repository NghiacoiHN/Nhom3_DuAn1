package Reponsitories;

import DomainModels.ChatLieu;
import ViewModels.ChatLieuResponse;
import java.util.List;



/**
 *
 * @author chutu
 */
public interface ChatLieuRepository {
    List<ChatLieuResponse> getAll();

    boolean add(ChatLieu chatLieu);
    
    boolean update(String ma, ChatLieu chatLieu);
    
    boolean delete(String ma);
}
