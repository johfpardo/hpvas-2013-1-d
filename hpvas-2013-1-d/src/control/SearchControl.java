/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.*;
import entity.*;
import java.util.List;


/**
 *
 * @author John Fredy
 */
public class SearchControl {
    //ESTA Es la busquedageneral
    public void searchAll(){
        //Allow a search by name, displaying all of the veterinarians, pets and owners which name match the word(s) entered 
    }
    //ESTA Es la busqueda por veterinario
    public void searchVeterinarian(){
        //Allow a search by veterinarian’s name, displaying only the veterinarians in which the name contains any of the search word(s)
        VeterinarianDao vet = new VeterinarianDao();
        List<Veterinarian> veterinarians = vet.read("NAME word");
    }
    //ESTA Es la busqueda por propietario
    public void searchOwner(){
        OwnerDao own = new OwnerDao();
        List<Owner> owners = own.read("NAME word");
    }
    //ESTA Es la busqueda por mascota
    public void searchPet(){
        PetDao pt = new PetDao();
        List<Pet> pets = pt.read("NAME word");
    }
    //ESTA Es la busqueda por SSN
    public void searchPerson(){
        //PersonDao own = new PersonDao();
        //List<Person> owners = own.read("SSN word");
    }
}
