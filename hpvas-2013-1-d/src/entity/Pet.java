/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.MedicalRecord;
import entity.Owner;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


/**
 *
 * @author Andres
 */

@Entity
public class Pet implements Serializable{   
    
    @ManyToOne
    private Owner owner;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PetID")
    private Long id;
    private String name;
    private String species;
    private int age;
    private Float weight;
    private String pictureUrl;
    
    @OneToOne
    private MedicalRecord medicalRecord;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }
    
    public String getSpecies() {
        return species;
    }
    
    public void setSpecies(String species) {
         this.species = species;
    }
    
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public Float getWeight() {
        return weight;
    }   
    
    public void setWeight(Float weight){
        this.weight = weight;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    } 

}
