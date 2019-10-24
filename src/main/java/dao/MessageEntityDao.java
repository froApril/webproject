package dao;

import Service.Service;
import entities.MessageEntity;
import entities.UserEntity;

import java.util.List;

public interface MessageEntityDao extends Service {

    /**
     *
     * @param user_id
     * @return
     */

    List<MessageEntity> getAllMessage(int user_id);

    List<MessageEntity> getAllMessageByReceiverId(int receiver_id);


    boolean createMessage(MessageEntity newMessage);

    UserEntity getReceiverDetail(int receiver_id);

    boolean addNewMessage(String message_detail);

    boolean deleteMessage (String message_detail);
}


