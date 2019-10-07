package dao;

import entities.Topic2Entity;

/**
 * @author XUYIFEI
 *
 * Dao layer of Topics with hibernate
 */

public interface Topic2EntityDao {


    Topic2Entity getTopicByName(String topicName);


    boolean existTopic(String topicName);


    boolean addNewTopic(Topic2Entity topic);



    boolean deleteTopic(String topicName);


    boolean updateTopic(String oldTopic, Topic2Entity newTopic);


}