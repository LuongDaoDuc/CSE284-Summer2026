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
            throw new InvalidPetDataException("Mau long khong duoc de trong!");
        }
        this.colour = colour.trim();
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhap mau long meo: ");
                setColour(sc.nextLine());
                break;
            } catch (InvalidPetDataException e) {
                System.out.println("Loi: " + e.getMessage() + " Vui long nhap lai");
            }
        }
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Mau long meo: " + colour);
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
            return "Meo gia - Can kiem tra dinh ky";
        } else if (getAge() < 1) {
            return "Meo con - Can cham soc day du";
        }
        return "Tot";
    }
}