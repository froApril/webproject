package dao.impl;

import dao.UserEntityDao;
import entities.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateFactory;


public class UserEntityDaoImpl implements UserEntityDao {
    @Override
    public UserEntity getUserByName(String user) {
        UserEntity findUser = null;
        Session session = HibernateFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session
                    .createQuery("from UserEntity where username= " +"\'" +user+"\'");
            findUser = (UserEntity) query.uniqueResult();
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return findUser;
    }

    @Override
    public Boolean isUsernameExist(String username) {

      return this.getUserByName(username) != null;

    }

    @Override
    public Boolean addUser(UserEntity user) {
        if(isUsernameExist(user.getUsername())){
            return false;
        }

        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean isStaff(String username) {
        UserEntity userEntity = this.getUserByName(username);
        if(userEntity.getiSstaff() == 1){
            return true;
        }
        return false;
    }

    @Override
    public Boolean setNewnickname(String username, String name) {
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if(!isUsernameExist(userEntity.getUsername())){
                return false;
            }

            userEntity.setNickname(name);
            session.update(userEntity);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean setNewpassword(String username, String password) {
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if(!isUsernameExist(userEntity.getUsername())){
                return false;
            }

            userEntity.setPassword(password);
            session.update(userEntity);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean setGender(String username, String gender) {
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if(!isUsernameExist(userEntity.getUsername())){
                return false;
            }

            userEntity.setGender(gender);
            session.update(userEntity);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean setDes(String username, String description) {
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if(!isUsernameExist(userEntity.getUsername())){
                return false;
            }

            userEntity.setPerDes(description);
            session.update(userEntity);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean setContactInfo(String username, String contactInfo) {
        Session session = null;
        try {
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if (!isUsernameExist(userEntity.getUsername())) {
                return false;
            }

            userEntity.setContactIno(contactInfo);
            session.update(userEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
        return true;
    }
    @Override
    public Boolean setNewphoto(String username, String photoUrl) {
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if(!isUsernameExist(userEntity.getUsername())){
                return false;
            }

            userEntity.setPhotoPro(photoUrl);
            session.update(userEntity);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean deleteUser(String username) {
        Session session =null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if(userEntity==null){
                return false;
            }
            session.delete(userEntity);
            session.getTransaction().commit();

        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally{
            session.close();
        }

        return true;
    }

    @Override
    public Boolean isUsercanlogin(String username, String password) {
        Session session = null;
        try{
            session = HibernateFactory.getSession();
            session.beginTransaction();
            UserEntity userEntity = this.getUserByName(username);
            if(userEntity==null){
                return false;
            }
           String rightPassword = userEntity.getPassword();
            return rightPassword.equals(password);

        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
        finally{
            session.close();
        }


    }
}
