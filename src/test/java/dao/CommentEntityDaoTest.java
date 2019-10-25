package dao;
import dao.impl.CommentEntityImpl;
import entities.CommentEntity;
import junit.framework.TestCase;

import java.util.List;

public class CommentEntityDaoTest extends TestCase {
    private CommentEntityDao commentDao;
    private CommentEntity comment1 = new CommentEntity();
    private CommentEntity comment2 = new CommentEntity();

    protected void setUp() {
        commentDao = new CommentEntityImpl();
        /*comment1.setId(29);
        comment1.setTopicId(22);
        comment1.setAuthorName("KIKO");
        comment1.setCommentTitle("111");
        comment1.setCommentMessage("1");
        comment1.setParentId(29);
        comment1.setImgUrl("UMR");

        comment2.setId(1);
        comment2.setTopicId(3);
        comment2.setAuthorName("Jimmy");
        comment2.setCommentTitle("123");
        comment2.setCommentMessage("message");
        comment2.setParentId(2);
        comment2.setImgUrl("UMR");*/
    }

    public void testGetCommentsByTopic() {
        assertNull(commentDao.getCommentsByTopic(23));
        List<CommentEntity> commentList = commentDao.getCommentsByTopic(22);
        assertEquals(6, commentList.size());
    }

    public void testSetImgURL() {
        commentDao.setimgURL("KIKO", "Joker");
        assertEquals("Joker", commentDao.getCommentByAuthor("KIKO").get(0).getImgUrl());
    }

    public void testDeleteComment() {
        assertTrue(commentDao.deleteComment(22));
        assertFalse(commentDao.deleteComment(23));
        assertTrue(commentDao.deleteComment("KIKO"));
        assertFalse(commentDao.deleteComment("Jimmy"));
    }

    public void testGetCommentByAuthor() {
        assertNull(commentDao.getCommentByAuthor("Jimmy"));
        List<CommentEntity> commentList = commentDao.getCommentByAuthor("KIKO");
        assertEquals(6, commentList.size());
    }


}
