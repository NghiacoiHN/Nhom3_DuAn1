package Sevices.impl;


import DomainModels.ChatLieu;
import Reponsitories.ChatLieuRepository;
import Reponsitories.impl.ChatLieuRepositoryImpl;
import Sevices.ChatLieuService;
import ViewModels.ChatLieuResponse;
import java.util.List;


/**
 *
 * @author chutu
 */
public class ChatLieuServiceImpl implements ChatLieuService {

    private ChatLieuRepository chatLieuRepository = new ChatLieuRepositoryImpl();

    @Override
    public List<ChatLieuResponse> getAll() {
        return chatLieuRepository.getAll();
    }

    @Override
    public String add(ChatLieu chatLieu) {
        boolean add = chatLieuRepository.add(chatLieu);
        if (add) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(String id, ChatLieu chatLieu) {
        boolean update = chatLieuRepository.update(id, chatLieu);
        if (update) {
            return "Sửa thành công id:" + id;
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean delete = chatLieuRepository.delete(id);
        if (delete) {
            return "Xoá thành công id:" + id;
        }
        return "Xoá thất bại";
    }
}
