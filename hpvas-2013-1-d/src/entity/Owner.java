/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author AntonioJose
 */
@Entity
public class Owner extends Person{
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    
    public Owner() {
    }
    
    public Owner(String n, String ln, String s, Date bd, String bp, List<Pet> p){
        this.setName(n);
        this.setLastName(ln);
        this.setSSN(s);
        this.setBirthDate(bd);
        this.setBirthPlace(bp);
        this.setPets(p);
    }
    
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
