package buoi3;

import java.util.Scanner;

public class Dog extends Pet {
    private String breed;

    public Dog() {
        super();
    }

    public Dog(String petID, String name, int age, String status, String breed) throws InvalidPetDataException {
        super(petID, name, age, status);
        setBreed(breed);
    }

    public String getBreed() { return breed; }
    
    public void setBreed(String breed) throws InvalidPetDataException {
        if (breed == null || breed.trim().isEmpty()) {
            throw new InvalidPetDataException("Giong cho khong dc de trong!");
        }
        this.breed = breed.trim();
    }

    @Override
    public void input() {
        super.input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nhap giong cho: ");
                setBreed(sc.nextLine());
                break;
            } catch (InvalidPetDataException e) {
                System.out.println("Loi: " + e.getMessage() + " Vui long nhap lai");
            }
        }
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Giong cho: " + breed);
    }

    @Override
    public String toFileString() {
        return "DOG," + getPetID() + "," + getName() + "," + getAge() + "," + getStatus() + "," + breed;
    }

    @Override
    public boolean isVaccinated() {
        return getStatus() != null && getStatus().toLowerCase().contains("tiem");
    }

    @Override
    public double calculateWeight() {
        return getAge() * 2.5 + 1.0; 
    }

    @Override
    public String getHealthStatus() {
        if (getAge() > 12) {
            return "Cho da gia - Suc khoe yeu";
        } else if (getAge() < 1) {
            return "Cho con - Can chu y cham soc";
        }
        return "Khoe manh";
    }
}