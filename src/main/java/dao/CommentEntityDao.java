package dao;

import Service.Service;
import entities.CommentEntity;

import java.util.List;

public interface CommentEntityDao extends Service {


    List<CommentEntity> getCommentsByTopic(int topic_id);
    List<CommentEntity> getCommentsByNick(String nick);

    List<CommentEntity> getCommentByTopicAndTitle(String topic,String title);

    void setimgURL(String nick,String imgUrl);

    void addNewComment(CommentEntity commentEntity);

    boolean addNewThread(CommentEntity commentEntity);

    //BingKun Miao
    boolean deleteComment(int topic_id);

    List<CommentEntity> getCommentByAuthor(String author_name);

    boolean deleteComment(String author_name);


}
