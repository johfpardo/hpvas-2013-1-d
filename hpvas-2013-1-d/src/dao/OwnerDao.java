/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Owner;
import java.util.List;
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
    
    public Owner readSSN(String SSN) {
        EntityManager em = emf.createEntityManager();
        Owner owner = null;
        Query q = em.createQuery("SELECT v FROM Owner v " + "WHERE v.ssn LIKE :ssn")
                .setParameter("ssn", SSN);
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
    
    public List<Owner> read(String word){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT o FROM Owner o " + "WHERE (o.name LIKE :name OR v.lastName LIKE : name)")
                .setParameter("name", word);
        List owners = q.getResultList();
        em.close();
        return owners;
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
