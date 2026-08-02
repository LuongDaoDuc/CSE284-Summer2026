/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.io.Serializable;
import java.util.Scanner;

public 
    abstract class Pet implements IPet, Serializable {
    private static final long serialVersionUID = 1L; 
    
    private String petID;
    private String name;
    private int age;
    private String status;

    public Pet() {}

    public Pet(String petID, String name, int age, String status) throws InvalidPetDataException {
        setPetID(petID);
        setName(name);
        setAge(age);
        setStatus(status);
    }

    public String getPetID() { return petID; }
    
    public void setPetID(String id) throws InvalidPetDataException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidPetDataException("Mã thú cưng không được để trống!");
        }
        this.petID = id.trim();
    }

    public String getName() { return name; }
    
    public void setName(String name) throws InvalidPetDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPetDataException("Tên thú cưng không được để trống!");
        }
        this.name = name.trim();
    }

    public int getAge() { return age; }
    
    public void setAge(int age) throws InvalidPetDataException {
        if (age < 0 || age > 30) {
            throw new InvalidPetDataException("Tuoi thu cung tu 0 den 30!");
        }
        this.age = age;
    }

    public String getStatus() { return status; }
    
    public void setStatus(String status) { 
        this.status = (status != null) ? status.trim() : ""; 
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhap ma thu cung (Pet ID): ");
                setPetID(sc.nextLine());
                break;
            } catch (InvalidPetDataException e) {
                System.out.println("Loi: " + e.getMessage() + " Vui long nhap lai.");
            }
        }


        while (true) {
            try {
                System.out.print("Nhap ten thu cung: ");
                setName(sc.nextLine());
                break;
            } catch (InvalidPetDataException e) {
                System.out.println("Loi: " + e.getMessage() + " Vui long nhap lai.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhap tuoi: ");
                int inputAge = Integer.parseInt(sc.nextLine().trim());
                setAge(inputAge);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Loi: Tuoi khong hop le.");
            } catch (InvalidPetDataException e) {
                System.out.println("Loi: " + e.getMessage() + " Vui long nhap lai");
            }
        }


        System.out.print("Nhap trang thai (Status): ");
        this.status = sc.nextLine().trim();
    }

    public void output() {
        System.out.println("--- THONG TIN THU CUNG ---");
        System.out.println("Ma thu cung: " + petID);
        System.out.println("Ten: " + name);
        System.out.println("Tuoi: " + age);
        System.out.println("Trang thai: " + status);
        System.out.println("Da tiem vacxin: " + (isVaccinated() ? "Roi" : "Chua"));
        System.out.println("Can nang uoc tinh: " + calculateWeight() + " kg");
        System.out.println("Tinh trang suc khoe: " + getHealthStatus());
    }

    @Override
    public abstract boolean isVaccinated();

    @Override
    public abstract double calculateWeight();

    @Override
    public abstract String getHealthStatus();
}