package dao;

import entities.MessageEntity;
import entities.UserEntity;

import java.util.List;

public interface MessageEntityDao {

    /**
     *
     * @param user_id
     * @return
     */
    List<MessageEntity> getAllMessageByPostId(int user_id);

    List<MessageEntity> getAllMessageByReceiveId(int user_id);


    boolean createMessage(MessageEntity newMessage);

    UserEntity getReceiverDetail(int receive_id);


}
