/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Pet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
public class PetDao {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
    
    public void create(Pet object) {
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
    
    public boolean delete(Pet object) {
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
    
    public Pet read(Pet object) {
        EntityManager em = emf.createEntityManager();
        Pet veterinarian = null;
        Query q = em.createQuery("SELECT v FROM Pet v " + "WHERE v.name LIKE :name")
                .setParameter("name", object.getName());
        try {
            veterinarian = (Pet) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return veterinarian;
        }
    }
    
    public boolean update(Pet object,Pet newObject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
         try {
            object = read(object);
            object.setName(newObject.getName());
            object.setSpecies(newObject.getSpecies());
            object.setAge(newObject.getAge());
            object.setWeight(newObject.getWeight());
            object.setPictureUrl(newObject.getPictureUrl());
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
