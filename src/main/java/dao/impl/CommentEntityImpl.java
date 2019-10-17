package dao.impl;

import dao.CommentEntityDao;
import entities.CommentEntity;
import entities.TopicsEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;

import java.util.ArrayList;
import java.util.List;

public class CommentEntityImpl implements CommentEntityDao {

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
            findcomments = finallist;
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return findcomments;
    }

    @Override
    public List<CommentEntity> getCommentByTopicAndTitle(String topic, String title) {
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        List<CommentEntity> findComments = null;
        TopicsEntity findtopic = null;
        CommentEntity findComment = null;
        System.out.println(title+ "title!!!!");
        try{
            Query query = session
                    .createQuery("from TopicsEntity where topicName=  "
                            + '\''+topic+'\'');
            findtopic = (TopicsEntity) query.uniqueResult();
            int topic_id = findtopic.getId();

            query = session
                    .createQuery("from CommentEntity where topicId= "+ topic_id+
                            " and commentTitle="+"\'"+title+"\'");
            findComment =(CommentEntity) query.uniqueResult();
            int topic_comment_id = findComment.getId();

            findComments = (List<CommentEntity>)session
                    .createQuery("from CommentEntity where parentId= "+ topic_comment_id).list();

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return findComments;

    }

    @Override
    public void addNewComment(CommentEntity commentEntity) {

        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(commentEntity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }

    }

    public CommentEntity getTopicCommentByTitle(String commentTitle) {
        CommentEntity findcomment=null ;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from CommentEntity where commentTitle= "
                    +"\'"+commentTitle+"\'");
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
}
