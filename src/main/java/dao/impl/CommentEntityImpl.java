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
            List<CommentEntity> finallist=new ArrayList<CommentEntity>();
            for(CommentEntity c: findcomments){
                if(c.getParentId()==null){
                    finallist.add(c);
                }
            }
            transaction.commit();
            session.close();
            return finallist;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return findcomments;
    }

    @Override
    public List<CommentEntity> getCommentByTopicAndTitle(int parent_id, String title) {
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        List<CommentEntity> findComment = null;
        try{
            Query query = session
                    .createQuery("from CommentEntity where parentId= " +parent_id+" and " +
                            "commentTitle="+ '\''+title+'\'');
            findComment = query.list();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return findComment;

    }

}
