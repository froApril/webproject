package dao.impl;

import dao.CommentEntityDao;
import entities.CommentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;

import java.util.ArrayList;
import java.util.List;

public class CommentEntityImpl implements CommentEntityDao {

    @Override
    public CommentEntity getCommentById(int id) {
        CommentEntity findcomment=null ;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from CommentEntity where id= "+id);
            findcomment = (CommentEntity) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return findcomment;
    }

    @Override
    public List<CommentEntity> getCommentsByTopic(int topicId) {

        List<CommentEntity> findcomments=new ArrayList<CommentEntity>();
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from CommentEntity where topicId= "+topicId);
            findcomments.addAll(query.list());
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return findcomments;
    }
}
