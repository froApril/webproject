package entities;
import junit.framework.TestCase;
//BingKun Miao
public class TopicsEntityTest extends TestCase {
    private TopicsEntity topic;

    protected void setUp() throws Exception {
        topic = new TopicsEntity();
    }

    public void testSetAndGetId() {
        int testId = 1;
        topic.setId(testId);
        assertEquals(testId, topic.getId());
    }

    public void testSetAndGetTopicName() {
        String testName = "ELEC5619";
        topic.setTopicName(testName);
        assertEquals(testName, topic.getTopicName());
    }

    public void testSetAndGetCommentNum() {
        Integer testNum = 10;
        topic.setCommentNum(testNum);
        assertEquals(testNum, topic.getCommentNum());
    }

    public void testSetAndGetTopicDescription() {
        String testDes = "This is description";
        topic.setTopicDescription(testDes);
        assertEquals(testDes, topic.getTopicDescription());
    }

    public void testEquals() {
        TopicsEntity testTopic = new TopicsEntity();
        topic.setId(1);
        topic.setCommentNum(10);
        topic.setTopicName("ELEC5619");
        topic.setTopicDescription("This is description");
        testTopic.setId(1);
        testTopic.setCommentNum(10);
        testTopic.setTopicName("ELEC5619");
        testTopic.setTopicDescription("This is description");
        assertTrue(topic.equals(testTopic));
        testTopic.setId(2);
        assertFalse(topic.equals(testTopic));
    }
}
