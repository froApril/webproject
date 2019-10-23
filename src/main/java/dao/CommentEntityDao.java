package dao;

import entities.CommentEntity;

import java.util.List;

public interface CommentEntityDao {


    List<CommentEntity> getCommentsByTopic(int topic_id);
    List<CommentEntity> getCommentsByNick(String nick);

    List<CommentEntity> getCommentByTopicAndTitle(String topic,String title);

    void setimgURL(String nick,String imgUrl);

    void addNewComment(CommentEntity commentEntity);

    boolean addNewThread(CommentEntity commentEntity);


}
