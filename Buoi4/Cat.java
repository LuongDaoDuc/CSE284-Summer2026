/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.Scanner;

public class Cat extends Pet {
    private String colour;

    public Cat() {
        super();
    }

    public Cat(String petID, String name, int age, double price, String status, String colour) {
        super(petID, name, age, status);
        this.colour = colour;
    }

    public String getColour() { return colour; }
    public void setColour(String colour) { this.colour = colour; }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập màu lông mèo: ");
        this.colour = sc.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Màu lông mèo: " + colour);
    }

    
    
    @Override
    public boolean isVaccinated() {
        return getStatus() != null && getStatus().toLowerCase().contains("tiêm");
    }

    @Override
    public double calculateWeight() {
        // Mèo tăng cân chậm và nhỏ con hơn chó
        return getAge() * 0.8 + 0.5; 
    }

    @Override
    public String getHealthStatus() {
        if (getAge() > 10) {
            return "Mèo già - Cần kiểm tra thận định kỳ";
        } else if (getAge() < 1) {
            return "Mèo con - Cần giữ ấm";
        }
        return "Tốt / Năng động";
    }
}