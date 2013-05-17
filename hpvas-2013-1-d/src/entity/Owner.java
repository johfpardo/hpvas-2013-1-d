/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author AntonioJose
 */
@Entity
public class Owner extends Person{
    
    public Owner(){
        this.setName("name");
        this.setLastName("lastname");
        this.setSSN("ssn");
        this.setBirthDate(null);
        this.setBirthPlace("bithplace");
        this.setPets(null);
    }
    
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
