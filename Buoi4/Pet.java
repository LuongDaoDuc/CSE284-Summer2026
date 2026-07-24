/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.Scanner;

public abstract class Pet implements IPet {
    private String petID;
    private String name;
    private int age;
    private String status;

    public Pet() {}

    public Pet(String petID, String name, int age, String status) {
        this.petID = petID;
        this.name = name;
        this.age = age;
        this.status = status;
    }
    public String getPetID() { return petID; }
    public void setPetID(String id) { this.petID = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }


    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thú cưng (Pet ID): ");
        this.petID = sc.nextLine();
        System.out.print("Nhập tên thú cưng: ");
        this.name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = sc.nextInt();
        sc.nextLine(); // Đọc bỏ dòng thừa
        System.out.print("Nhập trạng thái (Status): ");
        this.status = sc.nextLine();
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