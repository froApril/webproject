package dao;

import entities.UserEntity;

public interface UserEntityDao {
    UserEntity getUserByName(String username);
}
