/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Veterinarian;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author John Fredy
 */
public class VeterinarianDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
    
    public void create(Veterinarian object) {
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
    
    public boolean delete(Veterinarian object) {
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
    
    public Veterinarian read(Veterinarian object) {
        EntityManager em = emf.createEntityManager();
        Veterinarian veterinarian = null;
        Query q = em.createQuery("SELECT v FROM Veterinarian v " + "WHERE v.name LIKE :name")
                .setParameter("name", object.getName());
        try {
            veterinarian = (Veterinarian) q.getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return veterinarian;
        }
    }
    
    public List<Veterinarian> read(String word){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT v FROM Veterinarian v " + "WHERE (v.name LIKE :*name* OR v.lastName LIKE : *name*)")
                .setParameter("name", word);
        List veterinarians = q.getResultList();
        em.close();
        return veterinarians;
    } 
    
    public boolean update(Veterinarian object,Veterinarian newObject) {
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
            object.setFocusOfPractice(newObject.getFocusOfPractice());
            object.setSpecialities(newObject.getSpecialities());
            object.setSalary(newObject.getSalary());
            object.setGraduatedAt(newObject.getGraduatedAt());
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
