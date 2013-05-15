/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Appointment;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author sneiderhc
 */
public class AppointmentDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
    
    public void create(Appointment object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public boolean delete(Appointment object) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            em.remove(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
    
    public Appointment read(Appointment object) {
        EntityManager em = emf.createEntityManager();
        Appointment appointment = null;
        Query q = em.createQuery("SELECT a FROM Appointment a WHERE a.AppointmentID LIKE :id")
                .setParameter("id", object.getId());
        try {
            appointment = (Appointment) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return appointment;
        }
    }
    
    public boolean update(Appointment object, Appointment newObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
         try {
            object = read(object);
            object.setDate(newObject.getDate());
            object.setCharge(newObject.getCharge());
            object.setNotes(newObject.getNotes());
            em.merge(object);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
}
