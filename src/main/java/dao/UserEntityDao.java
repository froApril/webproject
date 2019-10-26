package dao;

import Service.Service;
import entities.UserEntity;
import java.util.List;

public interface UserEntityDao extends Service {

    UserEntity getUserByName(String username);
    UserEntity getUserByNick(String username);
    UserEntity getUserById(int id);

    Boolean isUsernameExist(String username);
    Boolean isNicknameExist(String username);
    Boolean isStaff(String username);
    Boolean addUser(UserEntity user);
    Boolean setNewnickname(String username, String name);
    Boolean setNewpassword(String username, String password);
    Boolean setGender(String username, String gender);
    Boolean setDes(String username, String description);
    Boolean setContactInfo(String username, String contactInfo);
    Boolean setNewphoto(String username, String photoUrl);
    Boolean deleteUser(String username);
    Boolean isUsercanlogin(String username, String password);

    String getNicknameByUsername(String username);
    UserEntity getEntityByNickname(String nickname);


    //BingKun Miao
    List<UserEntity> getAllUsers();

    

}
