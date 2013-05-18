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
    
    OwnerDao own;
    VeterinarianDao vet;
    PetDao pt;
    
    public List<Veterinarian> veterinarians;
    public List<Pet> petsattended;
    public List<Owner> owners;
    public List<Pet> pets;
    public List<Pet> petsVeterinarian;
    public List<Pet> petsOwner;
    public Person personV;
    public Person personO;
    
    //ESTA Es la busquedageneral
    public void searchAll(String word){
        //Allow a search by name, displaying all of the veterinarians, pets and owners which name match the word(s) entered 
        veterinarians = null;
        vet = new VeterinarianDao();
        veterinarians = vet.readCom(word);
        searchOwner(word);
        searchPet(word);
    }
    //ESTA Es la busqueda por veterinario
    public void searchVeterinarian(String word){
        //Allow a search by veterinarian’s name, displaying only the veterinarians in which the name contains any of the search word(s)
        veterinarians = null;
        vet = new VeterinarianDao();
        veterinarians = vet.readInc(word);
        petsVeterinarian = null;
        for(Veterinarian v : veterinarians){
            List<Pet> Ps = pt.read(v);
            for(Pet p : Ps){
                petsVeterinarian.add(p);
            }
        }
    }
    //ESTA Es la busqueda por propietario
    public void searchOwner(String word){
        owners = null;
        own = new OwnerDao();
        owners = own.read(word);
        petsOwner = null;
        for(Owner o : owners){
            List<Pet> Ps = pt.read(o);
            for(Pet p : Ps){
                petsOwner.add(p);
            }
        }
    }
    //ESTA Es la busqueda por mascota
    public void searchPet(String word){
        pets = null;
        pt = new PetDao();
        pets = pt.read(word);
    }
    //ESTA Es la busqueda por SSN
    public void searchPerson(String word){
        
        personV = null;
        personO = null;
        vet = new VeterinarianDao();
        personV = vet.readSSN(word);
        own = new OwnerDao();
        personO = own.readSSN(word);
    }
}
