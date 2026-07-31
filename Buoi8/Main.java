/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "pets.dat";

    public static void main(String[] args) {
        List<Pet> petList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n========== QUẢN LÝ THÚ CƯNG ==========");
            System.out.println("1. Thêm Chó (Dog)");
            System.out.println("2. Thêm Mèo (Cat)");
            System.out.println("3. Hiển thị danh sách thú cưng");
            System.out.println("4. Lưu danh sách vào File");
            System.out.println("5. Tải danh sách từ File");
            System.out.println("0. Thoát chương trình");
            System.out.print("Mời My Lord chọn chức năng: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Lựa chọn phải là một số nguyên!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- NHẬP THÔNG TIN CHÓ ---");
                    Pet dog = new Dog();
                    dog.input();
                    petList.add(dog);
                    System.out.println("-> Thêm chó thành công!");
                    break;

                case 2:
                    System.out.println("\n--- NHẬP THÔNG TIN MÈO ---");
                    Pet cat = new Cat();
                    cat.input();
                    petList.add(cat);
                    System.out.println("-> Thêm mèo thành công!");
                    break;

                case 3:
                    if (petList.isEmpty()) {
                        System.out.println("Danh sách hiện đang trống!");
                    } else {
                        System.out.println("\n===== DANH SÁCH THÚ CƯNG =====");
                        for (int i = 0; i < petList.size(); i++) {
                            System.out.println("\n[ Thú cưng thứ " + (i + 1) + " ]");
                            petList.get(i).output();
                        }
                    }
                    break;

                case 4:
                    if (petList.isEmpty()) {
                        System.out.println("Cảnh báo: Danh sách đang trống, vẫn tiến hành ghi file rỗng.");
                    }
                    PetFileManager.saveToFile(petList, FILE_NAME);
                    break;

                case 5:
                    List<Pet> loadedList = PetFileManager.loadFromFile(FILE_NAME);
                    if (!loadedList.isEmpty()) {
                        petList = loadedList;
                    }
                    break;

                case 0:
                    System.out.println("Chương trình kết thúc.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                    break;
            }
        } while (choice != 0);

        sc.close();
    }
}