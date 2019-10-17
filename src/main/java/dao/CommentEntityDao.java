package dao;

import entities.CommentEntity;

import java.util.List;

public interface CommentEntityDao {


    List<CommentEntity> getCommentsByTopic(int topic_id);

    List<CommentEntity> getCommentByTopicAndTitle(String topic,String title);

    void addNewComment(CommentEntity commentEntity);

    boolean addNewThread(CommentEntity commentEntity);

}
