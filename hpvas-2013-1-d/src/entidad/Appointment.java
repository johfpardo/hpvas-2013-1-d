/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import javax.persistence.ManyToOne;

/**
 *
 * @author John Fredy
 */
class Appointment {
    
    @ManyToOne
    private Veterinarian veterianarian;
}
