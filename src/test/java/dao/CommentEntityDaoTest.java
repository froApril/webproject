package dao;
import dao.impl.CommentEntityImpl;
import entities.CommentEntity;
import junit.framework.TestCase;

import java.util.List;
//BingKun Miao
public class CommentEntityDaoTest extends TestCase {
    private CommentEntityDao commentDao;

    protected void setUp() {
        commentDao = new CommentEntityImpl();
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
