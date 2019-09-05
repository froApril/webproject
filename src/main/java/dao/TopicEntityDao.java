package dao;

import entities.TopicEntity;

public interface TopicEntityDao {
    TopicEntity getTopicByName(String topicName);

    boolean existTopic(String topicName);

    boolean addNewTopic(TopicEntity topicEntity);

    boolean deleteTopic(String topicName);

    boolean updateTopic(String topicName);


}
