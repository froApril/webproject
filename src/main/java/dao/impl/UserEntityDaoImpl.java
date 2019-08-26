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
                    .createQuery("from UserEntity where username='xyf'");
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
}
