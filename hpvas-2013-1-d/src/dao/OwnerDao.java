/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Owner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author AntonioJose
 */
public class OwnerDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
    
    public void create(Owner object) {
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
    
    public boolean delete(Owner object) {
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
    
    public Owner read(Owner object) {
        EntityManager em = emf.createEntityManager();
        Owner owner = null;
        Query q = em.createQuery("SELECT v FROM Owner v " + "WHERE v.name LIKE :name")
                .setParameter("name", object.getName());
        try {
            owner = (Owner) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return owner;
        }
    }
    
    public boolean update(Owner object,Owner newObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
         try {
            object = read(object);
            object.setName(newObject.getName());
            object.setLastName(newObject.getLastName());
            object.setSSN(newObject.getSSN());
            object.setBirthDate(newObject.getBirthDate());
            object.setBirthPlace(newObject.getBirthPlace());
            object.setPets(newObject.getPets());
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
