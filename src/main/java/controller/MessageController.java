package controller;

import dao.MessageEntityDao;
import dao.impl.MessageDaoImpl;
import entities.MessageEntity;
import entities.UserEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller

public class MessageController {

    @RequestMapping(value="/messages",method = RequestMethod.GET)
    public String getMessages(){

        return "message";
    }

    @RequestMapping(value = "/messages/allmessages",method = RequestMethod.GET)
    @ResponseBody
    public List<MessageEntity> getAllMessage(int userid){
        MessageEntityDao messageEntityDao = new MessageDaoImpl();
        List<MessageEntity> messageEntityList = messageEntityDao.getAllMessage(userid);

        return messageEntityList;
    }

    @RequestMapping(value = "/messages/allmessagebyreceiver",method = RequestMethod.GET)
    @ResponseBody
    public List<MessageEntity> getAllMessageByReceiverId(int receiver_id) {
        MessageEntityDao messageEntityDao = new MessageDaoImpl();
        List<MessageEntity> messageEntityList = messageEntityDao.getAllMessageByReceiverId(receiver_id);

        return messageEntityList;
    }

}