package dao.impl;

import dao.UserEntityDao;
import entities.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;

import java.util.ArrayList;
import java.util.List;


public class UserEntityDaoImpl implements UserEntityDao {
    @Override
    public UserEntity getUserByName(String user) {
        UserEntity findUser = null;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session
                    .createQuery("from UserEntity where username= " + "\'" + user + "\'");
            findUser = (UserEntity) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return findUser;
    }

    @Override
    public UserEntity getUserById(int id) {
        UserEntity findUser = null;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session
                    .createQuery("from UserEntity where id= " + "\'" + id + "\'");
            findUser = (UserEntity) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return findUser;
    }

    @Override
    public Boolean isUsernameExist(String username) {

        if (getUserByName(username) == null) {
            return false;
        } else
            return true;
    }

    @Override
    public Boolean addUser(UserEntity user) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        if (isUsernameExist(user.getUsername())) {
            return false;
        }
        session.save(user);
        session.getTransaction().commit();

        return true;
    }

    @Override
    public Boolean isStaff(UserEntity user) {
        if (user.getiSstaff() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean setNewnickname(UserEntity user, String name) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();

        if (isUsernameExist(user.getUsername())) {
            user.setNickname(name);
            session.save(user);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Boolean setNewpassword(UserEntity user, String password) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        if (isUsernameExist(user.getUsername())) {
            user.setPassword(password);
            session.save(user);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public Boolean setGender(UserEntity user, String gender) {
        Session session = HibernateFactory.getSession();
        session.beginTransaction();
        if (isUsernameExist(user.getUsername())) {
            user.setGender(gender);
            session.save(user);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }


//    @Override
//    public Boolean setDes(UserEntity user, String description) {
//        Session session = HibernateFactory.getSession();
//        session.beginTransaction();
//        if(isUsernameExist(user.getUsername())){
//            user.setPerDes(description);
//            session.save(user);
//            session.getTransaction().commit();
//            return true;
//
//        }
//
//
//        return false;
//    }
//
//    @Override
//    public Boolean setContactInfo(UserEntity user, String contactInfo) {
//        Session session = HibernateFactory.getSession();
//        session.beginTransaction();
//        if(isUsernameExist(user.getUsername())){
//            user.setContactIno(contactInfo);
//            session.save(user);
//            session.getTransaction().commit();
//            return true;
//
//        }
//
//
//        return false;
//    }
}
