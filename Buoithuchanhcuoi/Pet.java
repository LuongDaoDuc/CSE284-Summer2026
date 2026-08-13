package buoi3;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Pet implements IPet, Serializable {
    private static final long serialVersionUID = 1L;

    private String petID;
    private String name;
    private int age;
    private String status;
    private boolean vaccinated;

    public Pet() {}

    public Pet(String petID, String name, int age, String status) throws InvalidPetDataException {
        setPetID(petID);
        setName(name);
        setAge(age);
        setStatus(status);
        this.vaccinated = false;
    }

    public Pet(String petID, String name, int age, String status, boolean vaccinated) throws InvalidPetDataException {
        this(petID, name, age, status);
        this.vaccinated = vaccinated;
    }

    public String getPetID() { return petID; }
    
    public void setPetID(String id) throws InvalidPetDataException {
        if (id == null || id.trim().isEmpty()) {
            throw new InvalidPetDataException("Ma thu cung khong duoc de trong!");
        }
        this.petID = id.trim();
    }

    public String getName() { return name; }
    
    public void setName(String name) throws InvalidPetDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPetDataException("Ten thu cung khong duoc de trong!");
        }
        this.name = name.trim();
    }

    public int getAge() { return age; }
    
    public void setAge(int age) throws InvalidPetDataException {
        if (age < 0 || age > 30) {
            throw new InvalidPetDataException("Tuoi thu cung tu 1 den 30!");
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

    @Override
    public boolean isVaccinated() {
        return this.vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
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

        System.out.print("Da tiem vacxin chưa (true/false): ");
        this.vaccinated = Boolean.parseBoolean(sc.nextLine().trim());
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

    public abstract String toFileString();

    public static Pet fromFileString(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] parts = line.split(",");
        if (parts.length < 6) return null;

        String type = parts[0].trim();
        String id = parts[1].trim();
        String name = parts[2].trim();
        int age = Integer.parseInt(parts[3].trim());
        String status = parts[4].trim();
        String extra = parts[5].trim();
        boolean vaccinated = (parts.length >= 7) && Boolean.parseBoolean(parts[6].trim());

        try {
            Pet p = null;
            if (type.equalsIgnoreCase("DOG")) {
                p = new Dog(id, name, age, status, extra);
            } else if (type.equalsIgnoreCase("CAT")) {
                p = new Cat(id, name, age, status, extra);
            }
            if (p != null) {
                p.setVaccinated(vaccinated);
            }
            return p;
        } catch (InvalidPetDataException e) {
            System.err.println("Loi doc du lieu pet tu file text: " + e.getMessage());
        }
        return null;
    }

    @Override
    public abstract double calculateWeight();

    @Override
    public abstract String getHealthStatus();
}