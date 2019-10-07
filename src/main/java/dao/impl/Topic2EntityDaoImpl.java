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
    public boolean addNewTopic(Topic2Entity topic) {
        if(existTopic(topic.getName()))
            return false;
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            session.save(topic);
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
    public boolean updateTopic(String oldTopic, Topic2Entity newTopic) {
        Session session =null;
        try{
            session =HibernateFactory.getSession();
            session.beginTransaction();

            if(!this.existTopic(oldTopic)){
                addNewTopic(newTopic);
                return true;
            }
            else{

                session.update(newTopic);
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