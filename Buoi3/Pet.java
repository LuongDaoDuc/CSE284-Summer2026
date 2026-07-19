/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

/**
 *
 * @author PC
 */
import java.util.Scanner;

public class Pet {

    private String petID;
    private String name;
    private String species;
    private int age;
    private double price;
    private String status;

    public Pet() {}


    public Pet(String petID, String name, String species, int age, double price, String status) {
        this.petID = petID;
        this.name = name;
        this.species = species;
        this.age = age;
        this.price = price;
        this.status = status;
    }

    public String getPetID() {
        return petID;
    }

    public void setPetID(String id) {
        this.petID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Phương thức (Methods)
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thú cưng (Pet ID): ");
        this.petID = sc.nextLine();
        System.out.print("Nhập tên thú cưng: ");
        this.name = sc.nextLine();
        System.out.print("Nhập chủng loại (Species): ");
        this.species = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        this.age = sc.nextInt();
        System.out.print("Nhập giá bán: ");
        this.price = sc.nextDouble();
        sc.nextLine(); // Xóa bộ nhớ đệm
        System.out.print("Nhập trạng thái (Status): ");
        this.status = sc.nextLine();
    }

    public void xuatThongTin() {
        System.out.println("--- THÔNG TIN THÚ CƯNG ---");
        System.out.println("Mã thú cưng: " + petID);
        System.out.println("Tên: " + name);
        System.out.println("Chủng loại: " + species);
        System.out.println("Tuổi: " + age);
        System.out.println("Giá bán: " + price);
        System.out.println("Trạng thái: " + status);
    }
}