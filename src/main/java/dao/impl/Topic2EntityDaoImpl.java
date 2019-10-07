package dao.impl;

import dao.Topic2EntityDao;
import entities.Topic2Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;


public class Topic2EntityDaoImpl implements Topic2EntityDao {

    @Override
    public Topic2Entity getTopicByName(String topicName) {

        Topic2Entity findTopic=null ;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from Topic2Entity where name= " +"\'" +topicName+"\'");
            findTopic = (Topic2Entity) query.uniqueResult();
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
    public boolean existTopic(String topicName) {
        Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        return topicEntityDao.getTopicByName(topicName)!=null;
    }

    @Override
    public boolean addNewTopic(String topicName, String courseId, String major) {
        if(existTopic(topicName))
            return false;
        Session session =null;
        try{
            Topic2Entity topicEntity = new Topic2Entity();
            topicEntity.setName(topicName);
            topicEntity.setCourseId(courseId);
            topicEntity.setMajor(major);
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
            Topic2Entity topicEntity = this.getTopicByName(topicName);
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
            Topic2Entity topicEntity = this.getTopicByName(oldName);
            if(topicEntity==null){
                addNewTopic(newName,"","");
                return true;
            }
            else{
                topicEntity.setName(newName);
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