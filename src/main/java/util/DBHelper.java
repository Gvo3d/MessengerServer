package util;

import org.hibernate.Query;
import org.hibernate.Session;
import persons.Person;

import java.sql.SQLException;

public class DBHelper {

    public boolean sendNewPersontoDB(Person pers) throws SQLException{
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pers);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    public boolean updatePersontoDB(Person pers) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(pers);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    public boolean eraseAllPersonDataFromDB(Person pers) throws SQLException {
        Session session = null;
        if (erasePersonMessagesFromDB(pers)) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(pers);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
        }
        return false;
    }

    private boolean erasePersonMessagesFromDB(Person pers) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createSQLQuery("DELETE FROM Messages WHERE author like :author");
            query.setString("author", pers.getUser_login());
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }
}