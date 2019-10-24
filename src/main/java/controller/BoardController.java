package controller;


import Service.ServiceFactory;
import dao.CommentEntityDao;
import dao.TopicEntityDao;
import dao.UserEntityDao;
import dao.impl.CommentEntityImpl;
import dao.impl.TopicEntityDaoImpl;
import dao.impl.UserEntityDaoImpl;
import entities.CommentEntity;
import entities.TopicsEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {
    ServiceFactory serviceFactory = new ServiceFactory();

    @RequestMapping(value="/comments",method = RequestMethod.GET)
    public String getComments(){

        return "board";
    }

    @RequestMapping(value = "/comments/all",method = RequestMethod.GET)
    @ResponseBody
    public List<CommentEntity> getAllComments(String topic){
        TopicEntityDao topicEntityDao = (TopicEntityDao) serviceFactory.serviceFactory("TopicEntityDao");
        TopicsEntity topicEntity = topicEntityDao.getTopicByName(topic);
        int topic_id = topicEntity.getId();
        System.out.println(topic_id);
        CommentEntityDao commentEntityDao = (CommentEntityDao) serviceFactory.serviceFactory("CommentEntityDao");
        List<CommentEntity> commentEntityList =  commentEntityDao.getCommentsByTopic(topic_id);
        System.out.println(commentEntityList);
        return commentEntityList;

    }


    @RequestMapping(value="/comments/detail", method = RequestMethod.GET)
    @ResponseBody
    public List<CommentEntity> getCommentsBytitle(String topic, String title){
        CommentEntityDao commentEntityDao = (CommentEntityDao) serviceFactory.serviceFactory("CommentEntityDao");
        List<CommentEntity>commentEntityList = commentEntityDao.getCommentByTopicAndTitle(topic,title);
        return commentEntityList;

    }

    @RequestMapping(value="/comments/topicComment", method = RequestMethod.GET)
    @ResponseBody
    public CommentEntity getTopicComment(String topicComment,String topic){
        CommentEntityDao commentEntityDao = (CommentEntityDao) serviceFactory.serviceFactory("CommentEntityDao");
        TopicEntityDao topicEntityDao = (TopicEntityDao) serviceFactory.serviceFactory("TopicEntityDao");
        TopicsEntity topicEntity = topicEntityDao.getTopicByName(topic);
        CommentEntity findComment=null;
        int topic_id = topicEntity.getId();
        List<CommentEntity> commentEntityList =  commentEntityDao.getCommentsByTopic(topic_id);
        for(CommentEntity c:commentEntityList){
            if(c.getCommentTitle().equals(topicComment)){
                findComment = c;
            }
        }
        if(findComment == null)
        {
            findComment = new CommentEntity();
            findComment.setId(-1);

        }
        return findComment;
    }

//    data:{topic:t,author:"test user",parent_id:parent_comment.id
//            ,message:$("#textarea-id").text(),topic_id: parent_comment.topicId},
    @RequestMapping(value="/comments/add", method = RequestMethod.POST)
    @ResponseBody
    public CommentEntity addNewComment( String author, int parent_id
            , String message,int topic_id){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setParentId(parent_id);
        commentEntity.setCommentMessage(message);
        commentEntity.setTopicId(topic_id);
        commentEntity.setAuthorName(author);
        UserEntityDao userEntityDao = new UserEntityDaoImpl();
        commentEntity.setImgUrl(
                userEntityDao.getEntityByNickname(author).getPhotoPro());
        CommentEntityDao commentEntityDao = (CommentEntityDao) serviceFactory.serviceFactory("CommentEntityDao");
        commentEntityDao.addNewComment(commentEntity);


        return commentEntity;
    }


    @RequestMapping(value = "/comments/newthread", method = RequestMethod.POST)
    @ResponseBody
    public CommentEntity addNewThread(String author, String commentTitle,String topic,String message){
        TopicEntityDao topicEntityDao = (TopicEntityDao) serviceFactory.serviceFactory("TopicEntityDao");
        TopicsEntity topicsEntity = topicEntityDao.getTopicByName(topic);
        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setAuthorName(author);
        commentEntity.setTopicId(topicsEntity.getId());
        commentEntity.setCommentMessage(message);
        commentEntity.setCommentTitle(commentTitle);

        UserEntityDao userEntityDao = (UserEntityDao) serviceFactory.serviceFactory("UserEntityDao");
        commentEntity.setImgUrl(
                userEntityDao.getEntityByNickname(author).getPhotoPro());

        CommentEntityDao commentEntityDao = (CommentEntityDao) serviceFactory.serviceFactory("CommentEntityDao");
        if(!commentEntityDao.addNewThread(commentEntity)){
            commentEntity = null;

            return commentEntity;
        }
        return commentEntity;
    }
    

}
