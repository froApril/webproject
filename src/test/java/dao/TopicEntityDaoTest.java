package dao;
import dao.impl.TopicEntityDaoImpl;
import entities.TopicsEntity;
import junit.framework.TestCase;

import java.util.List;
//BingKun Miao
public class TopicEntityDaoTest extends TestCase {
    private TopicEntityDao topicDao;
    private TopicsEntity topic1 = new TopicsEntity();
    private TopicsEntity topic2 = new TopicsEntity();

    protected void setUp() {
        topicDao = new TopicEntityDaoImpl();
        topic1.setId(2);
        topic1.setTopicName("ELEC5619");
        topic1.setCommentNum(0);
        topic1.setTopicDescription("This unit aims to introduce students to the main issues involved in producing large Internet systems by using and building application frameworks. Frameworks allow great reuse so developers do not have to design and implement applications from scratch");

        topic2.setId(50);
        topic2.setCommentNum(0);
        topic2.setTopicName("aha");
        topic2.setTopicDescription("description");
    }

    public void testGetTopicByName() {
        assertNull(topicDao.getTopicByName("aha"));
        assertEquals(topic1, topicDao.getTopicByName("ELEC5619"));
    }

    public void testExistTopic() {
        assertTrue(topicDao.existTopic("ELEC5619"));
        assertFalse(topicDao.existTopic("aha"));
    }

    public void testAddNewTopic() {
        assertTrue(topicDao.addNewTopic("test1"));
        assertFalse(topicDao.addNewTopic("ELEC5619"));

        assertTrue(topicDao.addNewTopic(topic2));
        assertFalse(topicDao.addNewTopic(topic1));
    }

    public void testDeleteTopic() {
        assertTrue(topicDao.deleteTopic("ELEC5619"));
        assertFalse(topicDao.deleteTopic("tttttt"));
    }

    public void testUpdateTopic() {
        assertTrue(topicDao.updateTopic("ELEC5619", "aha"));
    }

    public void testGetAllTopicsTopics() {
        List<TopicsEntity> topicList = topicDao.getAllTopics();
        assertEquals(8, topicList.size());
        assertEquals(topic1, topicList.get(0));
    }
}
