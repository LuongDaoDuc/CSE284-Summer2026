/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "pets.dat";

    public static void main(String[] args) {
        IPetManager petManager = new PetManager();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n========== Quan ly thu cung ==========");
            System.out.println("1. Them Cho (Dog)");
            System.out.println("2. Them Meo (Cat)");
            System.out.println("3. Hien thi danh sach thu cung");
            System.out.println("4. Luu danh sach vao File");
            System.out.println("5. Tai danh sach tu File");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Chon chuc nang: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Loi: lua chon phai la so nguyen!");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println("\n--- NHAP THONG TIN CHO ---");
                    Pet dog = new Dog();
                    dog.input();
                    petManager.addPet(dog);
                    System.out.println("-> Them cho thanh cong!");
                }

                case 2 -> {
                    System.out.println("\n--- NHAP THONG TIN MEO ---");
                    Pet cat = new Cat();
                    cat.input();
                    petManager.addPet(cat);
                    System.out.println("-> Them meo thanh cong!");
                }

                case 3 -> petManager.displayAll();

                case 4 -> petManager.saveToFile(FILE_NAME);

                case 5 -> petManager.loadFromFile(FILE_NAME);

                case 0 -> System.out.println("Chuong trinh ket thuc");

                default -> System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (choice != 0);

        sc.close();
    }
}