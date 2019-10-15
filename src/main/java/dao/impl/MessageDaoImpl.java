package dao.impl;

import dao.MessageEntityDao;
import entities.MessageEntity;
import entities.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;

import java.util.ArrayList;
import java.util.List;


public class MessageDaoImpl implements MessageEntityDao {
    @Override
    public List<MessageEntity> getAllMessage(int userid) {

        List<MessageEntity> findmessages=new ArrayList <MessageEntity>();
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from MessageEntity where posterId= "+userid+" and " +
                            "receiverId = "+userid);
            findmessages.addAll(query.list());
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return findmessages;
    }


    @Override
    public List<MessageEntity> getAllMessageByReceiverId(int receiver_id) {

        List<MessageEntity> findmessages=new ArrayList <MessageEntity>();
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from MessageEntity where receiverId= "+receiver_id);
            findmessages.addAll(query.list());
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return findmessages;
    }

    @Override
    public boolean createMessage(MessageEntity newMessage) {
        return false;
    }

    @Override
    public UserEntity getReceiverDetail(int receiver_id) {
        return null;
    }
//
//    @Override
//    public UserEntity getReceiverDetail(int receiver_id) {
//        return null;
//    }

    @Override
    public boolean addNewMessage(String message_detail) {
        return false;
    }

    @Override
    public boolean deleteMessage(String message_detail) {
        return false;
    }

    public boolean deletaMessage(String message_detail) {
        return false;
    }
}
