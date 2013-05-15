/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author John Fredy
 */
@Entity
@DiscriminatorValue("Veterinarian")
public class Veterinarian extends Person{
    
    private String focusOfPractice;
    private String specialities;
    private int salary;
    private String graduatedAt;
    @OneToMany(mappedBy = "veterinarian")
    private List<Appointment> appoinments;

    public void setFocusOfPractice(String focusOfPractice) {
        this.focusOfPractice = focusOfPractice;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setGraduatedAt(String graduatedAt) {
        this.graduatedAt = graduatedAt;
    }

    public void setAppoinments(List<Appointment> appoinments) {
        this.appoinments = appoinments;
    }
    

    public String getFocusOfPractice() {
        return focusOfPractice;
    }

    public String getSpecialities() {
        return specialities;
    }

    public int getSalary() {
        return salary;
    }

    public String getGraduatedAt() {
        return graduatedAt;
    }

    public List<Appointment> getAppoinments() {
        return appoinments;
    }
    
}
