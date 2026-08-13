package buoi3;

import java.util.Scanner;

public class Cat extends Pet {
    private String colour;

    public Cat() {
        super();
    }

    public Cat(String petID, String name, int age, String status, String colour) throws InvalidPetDataException {
        super(petID, name, age, status);
        setColour(colour);
    }

    public String getColour() { return colour; }
    
    public void setColour(String colour) throws InvalidPetDataException {
        if (colour == null || colour.trim().isEmpty()) {
            throw new InvalidPetDataException("Mau long meo khong duoc de trong!");
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

    // CẬP NHẬT: Lưu thêm biến isVaccinated() vào File Text
    @Override
    public String toFileString() {
        return "CAT," + getPetID() + "," + getName() + "," + getAge() + "," + getStatus() + "," + colour + "," + isVaccinated();
    }

    @Override
    public double calculateWeight() {
        return getAge() * 0.8 + 0.5; 
    }

    @Override
    public String getHealthStatus() {
        if (getAge() > 10) {
            return "Meo già - Cần lưu ý";
        } else if (getAge() < 2) {
            return "Mèo con - Cần chăm sóc";
        }
        return "Mèo khoẻ";
    }
}