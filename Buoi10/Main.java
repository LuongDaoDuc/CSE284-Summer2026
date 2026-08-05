package buoi3;

import java.util.Scanner;

public class Main {

    private static final String FILE_TXT = "E:\\Java\\Java_Storage\\Buoi3\\src\\buoi3\\Pet.txt";
    private static final String FILE_DAT = "E:\\Java\\Java_Storage\\Buoi3\\src\\buoi3\\Pet.dat";

    public static void main(String[] args) {
        IPetManager petManager = new PetManager();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n========== QUAN LY THU CUNG ==========");
            System.out.println("1. Them Cho (Dog)");
            System.out.println("2. Them Meo (Cat)");
            System.out.println("3. Hien thi danh sach thu cung");
            System.out.println("4. Tim kiem thu cung theo ID");
            System.out.println("5. Xoa thu cung theo ID");
            System.out.println("6. Cap nhat trang thai thu cung");
            System.out.println("7. Luu danh sach vao File Text (.txt)");
            System.out.println("8. Tai danh sach tu File Text (.txt)");
            System.out.println("9. Luu danh sach vao File Binary (.dat)");
            System.out.println("10. Tai danh sach tu File Binary (.dat)");
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

                case 4 -> {
                    System.out.print("Nhap ma thu cung can tim: ");
                    String id = sc.nextLine();
                    Pet p = petManager.searchPetById(id);
                    if (p != null) {
                        p.output();
                    } else {
                        System.out.println("-> Khong tim thay thu cung co ID: " + id);
                    }
                }

                case 5 -> {
                    System.out.print("Nhap ma thu cung can xoa: ");
                    String id = sc.nextLine();
                    if (petManager.removePet(id)) {
                        System.out.println("-> Xoa thanh cong!");
                    } else {
                        System.out.println("-> Khong tim thay thu cung de xoa!");
                    }
                }

                case 6 -> {
                    System.out.print("Nhap ma thu cung can cap nhat: ");
                    String id = sc.nextLine();
                    System.out.print("Nhap trang thai moi: ");
                    String newStatus = sc.nextLine();
                    petManager.updatePetStatus(id, newStatus);
                }

                case 7 -> petManager.saveToFile(FILE_TXT);

                case 8 -> petManager.loadFromFile(FILE_TXT);

                case 9 -> petManager.saveToFile(FILE_DAT);

                case 10 -> petManager.loadFromFile(FILE_DAT);

                case 0 -> System.out.println("Chuong trinh ket thuc.");

                default -> System.out.println("Lua chon khong hop le, vui long chon lai!");
            }
        } while (choice != 0);

        sc.close();
    }
}