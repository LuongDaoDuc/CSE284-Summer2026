/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.Scanner;

public class Dog extends Pet {
    private String breed;

    public Dog() {
        super();
    }

    public Dog(String petID, String name, int age, double price, String status, String breed) {
        super(petID, name, age, status);
        this.breed = breed;
    }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập giống chó: ");
        this.breed = sc.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Giống chó: " + breed);
    }


    
    @Override
    public boolean isVaccinated() {
        return getStatus() != null && getStatus().toLowerCase().contains("tiêm");
    }

    @Override
    public double calculateWeight() {
        // Chó thường phát triển cân nặng lớn hơn mèo
        return getAge() * 2.5 + 1.0; 
    }

    @Override
    public String getHealthStatus() {
        if (getAge() > 12) {
            return "Chó già - Sức khỏe yếu";
        } else if (getAge() < 1) {
            return "Chó con - Cần tiêm phòng đủ mũi";
        }
        return "Khỏe mạnh";
    }
}