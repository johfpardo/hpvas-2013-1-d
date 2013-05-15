/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Andres
 */
@Entity
public class Vacine implements Serializable{
    
    @ManyToOne
    private MedicalRecord medicalrecord;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    
    @Column(name = "VacineID")
    private Long id;
    private String name;
    private Long dosage;

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
        
    public Long getDosage() {
        return dosage;
    }

    public void setDosage(Long dosage) {
        this.dosage = dosage;
    }
        
}
