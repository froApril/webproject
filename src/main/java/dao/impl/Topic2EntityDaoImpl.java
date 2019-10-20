package dao.impl;

import dao.Topic2EntityDao;
import entities.Topic2Entity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;

import java.util.List;


/*import dao.Topic2EntityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import entities.Topic2Entity;*/





public class Topic2EntityDaoImpl implements Topic2EntityDao {

    /*private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    @Override
    public Topic2Entity getTopicByName(String topicName) {
        Session current = this.sessionFactory.getCurrentSession();
        Topic2Entity topic = (Topic2Entity) current.get(Topic2Entity.class, topicName);
        return topic;*/
        /*Topic2Entity findTopic=null ;
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
        return findTopic;*/
    //}

    /*@Override
    public boolean existTopic(String topicName) {*/
        /*Topic2EntityDaoImpl topicEntityDao = new Topic2EntityDaoImpl();
        return topicEntityDao.getTopicByName(topicName)!=null;*/
        /*if (this.sessionFactory!=null) {
            Session current = this.sessionFactory.getCurrentSession();
            Topic2Entity topic = (Topic2Entity) current.get(Topic2Entity.class, topicName);
            return topic!=null;
        }
        return false;
    }
    @Override*/
    /*public boolean addNewTopic(Topic2Entity topic) {
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
    }*/

    /*public void addNewTopic(Topic2Entity topic) {
        if (this.sessionFactory!=null) {
            this.sessionFactory.getCurrentSession().save(topic);
        }
    }*/



    /*@Override
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
    }*/




    @Override
    public Topic2Entity getTopicByName(String topicName) {
        Topic2Entity topic = null;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from Topic2Entity where name= " +"\'" +topicName+"\'");
            topic = (Topic2Entity) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return topic;

    }
    @Override
    public Boolean addNewTopic(Topic2Entity topic) {
        if(existTopic(topic.getName())){
            return false;
        }

        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            session.save(topic);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
        return true;

    }
    @Override
    public Boolean existTopic(String topicName) {
        return this.getTopicByName(topicName) != null;

    }

    @Override
    public List<Topic2Entity> getAllTopics() {
        Session session =null;
        List<Topic2Entity> list=null;
        try{
            session =HibernateFactory.getSession();
            session.beginTransaction();
            Query query = session
                    .createQuery("from Topic2Entity");
            list = query.list();
            session.getTransaction().commit();
            return list;

        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally{
            session.close();
        }

        return list;
    }
}