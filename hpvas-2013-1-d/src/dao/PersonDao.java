/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author John Fredy
 */
public class PersonDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
    
    public void create(Person object) {
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
    
    public boolean delete(Person object) {
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
    
    public Person read(Person object) {
        EntityManager em = emf.createEntityManager();
        Person person = null;
        Query q = em.createQuery("SELECT p FROM Person p " + "WHERE p.name LIKE :name")
                .setParameter("name", object.getName());
        try {
            person = (Person) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return person;
        }
    }
    
    public boolean update(Person object,Person newObject) {
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
