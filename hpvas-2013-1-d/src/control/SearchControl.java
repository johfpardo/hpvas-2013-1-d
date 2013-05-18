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
    
    List<Veterinarian> veterinarians;
    List<Pet> petsattended;
    List<Owner> owners;

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }
    List<Pet> pets;
    Person personV;
    Person personO;
    
    //ESTA Es la busquedageneral
    public void searchAll(String word){
        //Allow a search by name, displaying all of the veterinarians, pets and owners which name match the word(s) entered 
        searchVeterinarian(word);
        searchOwner(word);
        searchPet(word);
    }
    //ESTA Es la busqueda por veterinario
    public void searchVeterinarian(String word){
        //Allow a search by veterinarian’s name, displaying only the veterinarians in which the name contains any of the search word(s)
        VeterinarianDao vet = new VeterinarianDao();
        veterinarians = vet.read(word);
    }
    //ESTA Es la busqueda por propietario
    public void searchOwner(String word){
        OwnerDao own = new OwnerDao();
        owners = own.read(word);
    }
    //ESTA Es la busqueda por mascota
    public void searchPet(String word){
        PetDao pt = new PetDao();
        pets = pt.read(word);
    }
    //ESTA Es la busqueda por SSN
    public void searchPerson(String word){
        
        VeterinarianDao vet = new VeterinarianDao();
        personV = vet.readSSN(word);
        OwnerDao own = new OwnerDao();
        personO = own.readSSN(word);
    }
}
