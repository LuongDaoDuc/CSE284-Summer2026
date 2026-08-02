/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.ArrayList;
import java.util.List;

public class PetManager implements IPetManager {
    private List<Pet> petList;

    public PetManager() {
        this.petList = new ArrayList<>();
    }

    @Override
    public void addPet(Pet pet) {
        if (pet != null) {
            petList.add(pet);
        }
    }

    @Override
    public boolean removePet(String petID) {
        if (petID == null) return false;
        return petList.removeIf(p -> p.getPetID().equalsIgnoreCase(petID.trim()));
    }

    @Override
    public Pet searchPetById(String petID) {
        if (petID == null) return null;
        for (Pet p : petList) {
            if (p.getPetID().equalsIgnoreCase(petID.trim())) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        if (petList.isEmpty()) {
            System.out.println("Danh sach hien dang trong!");
            return;
        }
        System.out.println("\n===== DANH SACH THU CUNG =====");
        for (int i = 0; i < petList.size(); i++) {
            System.out.println("\n[ Thu cung thu " + (i + 1) + " ]");
            petList.get(i).output();
        }
    }

    @Override
    public void updatePetStatus(String petID, String newStatus) {
        Pet p = searchPetById(petID);
        if (p != null) {
            p.updateStatus(newStatus);
            System.out.println("-> Cap nhat trang thai!");
        } else {
            System.out.println("Khong thay thu cung co ma: " + petID);
        }
    }

    @Override
    public List<Pet> getPetList() {
        return this.petList;
    }

    @Override
    public void saveToFile(String fileName) {
        if (petList.isEmpty()) {
            System.out.println("Danh sach dang trong, van tien hanh ghi file.");
        }
        PetFileManager.saveToFile(this.petList, fileName);
    }

    @Override
    public void loadFromFile(String fileName) {
        List<Pet> loadedList = PetFileManager.loadFromFile(fileName);
        if (loadedList != null && !loadedList.isEmpty()) {
            this.petList = loadedList;
        }
    }
}