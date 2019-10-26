package entities;
import junit.framework.TestCase;
//BingKun Miao
public class CommentEntityTest extends TestCase{
    private CommentEntity comment;

    protected void setUp() {
        comment = new CommentEntity();
    }

    public void testSetAndGetId() {
        int id = 1;
        comment.setId(id);
        assertEquals(id, comment.getId());
    }

    public void testSetAndGetParentId() {
        Integer parentId = 12;
        comment.setParentId(parentId);
        assertEquals(parentId, comment.getParentId());
    }

    public void testSetAndGetCommentTitle() {
        String commentTitle = "111";
        comment.setCommentTitle(commentTitle);
        assertEquals(commentTitle, comment.getCommentTitle());
    }

    public void testSetAndGetAuthorName() {
        String authorName = "Jimmy";
        comment.setAuthorName(authorName);
        assertEquals(authorName, comment.getAuthorName());
    }

    public void testSetAndGetCommentMessage() {
        String commentMessage = "message";
        comment.setCommentMessage(commentMessage);
        assertEquals(commentMessage, comment.getCommentMessage());
    }

    public void testSetAndGetTopicId() {
        int topicId = 3;
        comment.setTopicId(topicId);
        assertEquals(topicId, comment.getTopicId());
    }

    public void testSetAndGetImgUrl() {
        String imgUrl = "UMR";
        comment.setImgUrl(imgUrl);
        assertEquals(imgUrl, comment.getImgUrl());
    }

    public void testEquals() {
        CommentEntity testComment = new CommentEntity();
        comment.setId(1);
        comment.setTopicId(3);
        comment.setAuthorName("Jimmy");
        comment.setCommentTitle("111");
        comment.setCommentMessage("message");
        comment.setParentId(2);
        comment.setImgUrl("UMR");
        testComment.setId(1);
        testComment.setTopicId(3);
        testComment.setAuthorName("Jimmy");
        testComment.setCommentTitle("111");
        testComment.setCommentMessage("message");
        testComment.setParentId(2);
        testComment.setImgUrl("UMR");
        assertTrue(comment.equals(testComment));
        testComment.setId(2);
        assertFalse(comment.equals(testComment));
    }
}
