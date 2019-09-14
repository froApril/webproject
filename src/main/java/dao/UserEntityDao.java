package dao;

import entities.UserEntity;

public interface UserEntityDao {

    UserEntity getUserByName(String username);

    Boolean isUsernameExist(String username);
    Boolean isStaff(String username);
    Boolean addUser(UserEntity user);
    Boolean setNewnickname(String username, String name);
    Boolean setNewpassword(String username, String password);
    Boolean setGender(String username, String gender);
    Boolean setDes(String username, String description);
    Boolean setContactInfo(String username, String contactInfo);
    Boolean setNewphoto(String username, String photoUrl);
    Boolean deleteUser(String username);
    

}
