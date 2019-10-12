package controller;


import dao.CommentEntityDao;
import dao.TopicEntityDao;
import dao.impl.CommentEntityImpl;
import dao.impl.TopicEntityDaoImpl;
import entities.CommentEntity;
import entities.TopicsEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {

    @RequestMapping(value="/comments",method = RequestMethod.GET)
    public String getComments(){

        return "board";
    }

    @RequestMapping(value = "/comments/all",method = RequestMethod.GET)
    @ResponseBody
    public List<CommentEntity> getAllComments(String topic){
        TopicEntityDao topicEntityDao = new TopicEntityDaoImpl();
        TopicsEntity topicEntity = topicEntityDao.getTopicByName(topic);
        int topic_id = topicEntity.getId();
        System.out.println(topic_id);
        CommentEntityDao commentEntityDao = new CommentEntityImpl();
        List<CommentEntity> commentEntityList =  commentEntityDao.getCommentsByTopic(topic_id);

        return commentEntityList;

    }


    @RequestMapping(value="/comments/detail", method = RequestMethod.GET)
    @ResponseBody
    public List<CommentEntity> getCommentBytitle(int parent_id, String title){
        CommentEntityDao commentEntityDao = new CommentEntityImpl();
        List<CommentEntity>commentEntity = commentEntityDao.getCommentByTopicAndTitle(parent_id,title);

        return commentEntity;

    }


}
