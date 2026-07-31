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

    public Cat(String petID, String name, int age, double price, String status, String colour) throws InvalidPetDataException {
        super(petID, name, age, status);
        setColour(colour);
    }

    public String getColour() { return colour; }
    
    public void setColour(String colour) throws InvalidPetDataException {
        if (colour == null || colour.trim().isEmpty()) {
            throw new InvalidPetDataException("Màu lông không được để trống!");
        }
        this.colour = colour.trim();
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhập màu lông mèo: ");
                setColour(sc.nextLine());
                break;
            } catch (InvalidPetDataException e) {
                System.out.println("Lỗi: " + e.getMessage() + " Vui lòng nhập lại.");
            }
        }
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