package dao;

import dao.impl.UserEntityDaoImpl;
import entities.UserEntity;

public interface UserEntityDao {

    UserEntity getUserByName(String username);


}
