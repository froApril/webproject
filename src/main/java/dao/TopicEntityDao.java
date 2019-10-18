package dao;

import entities.TopicsEntity;

import java.util.List;

public interface TopicEntityDao {


    TopicsEntity getTopicByName(String topicName);

    boolean existTopic(String topicName);

    boolean addNewTopic(String topicName);

    boolean deleteTopic(String topicName);

    boolean updateTopic(String oldName,String newName);

    public List<TopicsEntity> getAllTopic();


}
