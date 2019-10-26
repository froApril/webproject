package dao;

import Service.Service;
import entities.TopicsEntity;

import java.util.List;

/**
 * @author XUYIFEI
 *
 * Dao layer of Topics with hibernate
 */

public interface TopicEntityDao extends Service {

    /**
     *
     * @param String topicName
     * @return TopicEntity
     *
     * used to find topic entity with name
     * if no exist return null
     */
    TopicsEntity getTopicByName(String topicName);

    /**
     *
     * @param String topicName
     * @return boolean
     *
     * check if the given topic is exist
     */
    boolean existTopic(String topicName);

    /**
     *
     * @param String topicName
     * @return boolean
     *
     * when adding a new topic check if the topic is existing
     * cancel add action if true and return false
     */
    boolean addNewTopic(String topicName);

    /**
     *
     * @param String topicName
     * @return boolean
     *
     * delete existing topic
     */

    boolean deleteTopic(String topicName);

    /**
     *
     * @param String oldName
     * @param String newName
     * @return boolean
     *
     * update topic name with new name, if the old one not
     * exist, create one with new name.
     */
    boolean updateTopic(String oldName,String newName);

    List<TopicsEntity> getAllTopics();
    //BingKun Miao
    boolean addNewTopic(TopicsEntity topic);


}
