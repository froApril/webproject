package dao;

import entities.Topic2Entity;
import org.hibernate.SessionFactory;

import java.util.List;


public interface Topic2EntityDao {


   /* Topic2Entity getTopicByName(String topicName);
    boolean existTopic(String topicName);
    boolean addNewTopic(Topic2Entity topic);
    boolean deleteTopic(String topicName);
    boolean updateTopic(String oldTopic, Topic2Entity newTopic);*/


    /*public void setSessionFactory(SessionFactory sf);
    public Topic2Entity getTopicByName(String topicName);
    public void addNewTopic(Topic2Entity topic);
    public boolean existTopic(String topicName);*/

    Topic2Entity getTopicByName(String topicName);
    Boolean addNewTopic(Topic2Entity topic);
    Boolean existTopic(String topicName);


    List<Topic2Entity> getAllTopics();


}