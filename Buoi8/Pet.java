/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Pet implements IPet, Serializable {
    private static final long serialVersionUID = 1L; // Đảm bảo tính tương thích phiên bản khi Serializable
    
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
            throw new InvalidPetDataException("Tuổi thú cưng phải nằm trong khoảng từ 0 đến 30!");
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
                System.out.print("Nhập mã thú cưng (Pet ID): ");
                setPetID(sc.nextLine());
                break;
            } catch (InvalidPetDataException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }


        while (true) {
            try {
                System.out.print("Nhập tên thú cưng: ");
                setName(sc.nextLine());
                break;
            } catch (InvalidPetDataException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }

        while (true) {
            try {
                System.out.print("Nhập tuổi: ");
                int inputAge = Integer.parseInt(sc.nextLine().trim());
                setAge(inputAge);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Tuổi phải là một số nguyên hợp lệ! Vui lòng nhập lại.");
            } catch (InvalidPetDataException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }


        System.out.print("Nhập trạng thái (Status): ");
        this.status = sc.nextLine().trim();
    }

    public void output() {
        System.out.println("--- THÔNG TIN THÚ CƯNG ---");
        System.out.println("Mã thú cưng: " + petID);
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Trạng thái: " + status);
        System.out.println("Đã tiêm vắc-xin: " + (isVaccinated() ? "Rồi" : "Chưa"));
        System.out.println("Cân nặng ước tính: " + calculateWeight() + " kg");
        System.out.println("Tình trạng sức khỏe: " + getHealthStatus());
    }

    @Override
    public abstract boolean isVaccinated();

    @Override
    public abstract double calculateWeight();

    @Override
    public abstract String getHealthStatus();
}