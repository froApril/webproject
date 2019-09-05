package dao.impl;

import dao.TopicEntityDao;
import entities.TopicEntity;

public class TopicEntityDaoImpl implements TopicEntityDao {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public TopicEntity getTopicByName(String topicName) {
        return null;
    }

    @Override
    public boolean existTopic(String topicName) {
        return false;
    }

    @Override
    public boolean addNewTopic(TopicEntity topicEntity) {
        return false;
    }

    @Override
    public boolean deleteTopic(String topicName) {
        return false;
    }

    @Override
    public boolean updateTopic(String topicName) {
        return false;
    }
}
