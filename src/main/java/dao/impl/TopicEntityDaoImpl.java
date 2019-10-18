package dao.impl;

import dao.TopicEntityDao;
import entities.TopicsEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;

import java.util.List;

/**
 * @author XUYIFEI
 *
 * @see dao.TopicEntityDao
 *
 * Implementation of Topic DAO layer
**/

public class TopicEntityDaoImpl implements TopicEntityDao {

    @Override
    public TopicsEntity getTopicByName(String topicName) {

        TopicsEntity findTopic=null ;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from TopicsEntity where topicName= " +"\'" +topicName+"\'");
            findTopic = (TopicsEntity) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return findTopic;
    }

    @Override
    public List<TopicsEntity> getAllTopic() {

        List<TopicsEntity> allTopic = null ;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from TopicsEntity");
            allTopic.addAll(query.list());
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return allTopic;
    }

    @Override
    public boolean existTopic(String topicName) {
        TopicEntityDaoImpl topicEntityDao = new TopicEntityDaoImpl();
        return topicEntityDao.getTopicByName(topicName)!=null;
    }

    @Override
    public boolean addNewTopic(String topicName) {
        if(existTopic(topicName))
            return false;
        Session session =null;
        try{
            TopicsEntity topicEntity = new TopicsEntity();
            topicEntity.setTopicName(topicName);
            session = HibernateFactory.getSession();
            session.beginTransaction();
            session.save(topicEntity);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return true;
    }



    @Override
    public boolean deleteTopic(String topicName) {
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            TopicsEntity topicEntity = this.getTopicByName(topicName);
            if(topicEntity==null){
                return false;
            }
            session.delete(topicEntity);
            session.getTransaction().commit();

        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }

        return true;
    }

    @Override
    public boolean updateTopic(String oldName,String newName) {
        Session session =null;
        try{
            session =HibernateFactory.getSession();
            session.beginTransaction();
            TopicsEntity topicEntity = this.getTopicByName(oldName);
            if(topicEntity==null){
                addNewTopic(newName);
                return true;
            }
            else{
                topicEntity.setTopicName(newName);
                session.update(topicEntity);
            }

            session.getTransaction().commit();

        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }

        return true;
    }
}
