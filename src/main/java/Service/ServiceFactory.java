package Service;

import dao.impl.CommentEntityImpl;
import dao.impl.MessageDaoImpl;
import dao.impl.TopicEntityDaoImpl;
import dao.impl.UserEntityDaoImpl;

public class ServiceFactory {
    private Service service;

    public Service getService() {
        return service;
    }
    public void setService(Service service) {
        this.service = service;
    }

    public Service serviceFactory(String serviceType){
        if(serviceType.equalsIgnoreCase("CommentEntityDao")){
            this.service = new CommentEntityImpl();
        }
        else if(serviceType.equalsIgnoreCase("MessageEntityDao")){
            this.service = new MessageDaoImpl();
        }
        else if(serviceType.equalsIgnoreCase("TopicEntityDao")){
            this.service = new TopicEntityDaoImpl();
        }
        else if(serviceType.equalsIgnoreCase("UserEntityDao")){
            this.service = new UserEntityDaoImpl();
        }
        return getService();
    }
}
