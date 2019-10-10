package dao;

import entities.CommentEntity;

import java.util.List;

public interface CommentEntityDao {

    CommentEntity getCommentById(int id);

    List<CommentEntity> getCommentsByTopic(int topicId);


}
