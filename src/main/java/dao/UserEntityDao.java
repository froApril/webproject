package dao;

import dao.impl.UserEntityDaoImpl;
import entities.UserEntity;
import java.util.List;

public interface UserEntityDao {

    UserEntity getUserByName(String username);
    UserEntity getUserById(int id);

    Boolean isUsernameExist(String username);
    Boolean isStaff(UserEntity user);
    Boolean addUser(UserEntity user);
    Boolean setNewnickname(UserEntity user, String name);
    Boolean setNewpassword(UserEntity user, String password);
    Boolean setGender(UserEntity user, String gender);
//    Boolean setDes(UserEntity user, String description);
//    Boolean setContactInfo(UserEntity user, String contactInfo);
    

}
