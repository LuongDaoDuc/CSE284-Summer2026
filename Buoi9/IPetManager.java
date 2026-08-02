/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.List;

public interface IPetManager {
    

    void addPet(Pet pet);
    boolean removePet(String petID);
    Pet searchPetById(String petID);
    void updatePetStatus(String petID, String newStatus);
    

    void displayAll();
    List<Pet> getPetList();
    

    void saveToFile(String fileName);
    void loadFromFile(String fileName);
}