/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//
/**
 *
 * @author sneiderhc
 */
@Entity
public class MedicalRecord implements Serializable {    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "MedicalRecordID")
    private Long id;
    
    @OneToMany(mappedBy = "medicalRecord")
    private List<Appointment> appointments;
    
    @OneToMany(mappedBy = "medicalRecord")
    private List<Vacine> vacines;
    
    @OneToOne(mappedBy = "medicalRecord")
    private Pet pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
