package buoi3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetFileManager {

    public static void saveToFile(List<Pet> list, String fileName) {
        File file = new File(fileName);
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (fileName.toLowerCase().endsWith(".dat")) {
            saveToDatFile(list, file);
        } else {
            saveToTxtFile(list, file);
        }
    }

    public static List<Pet> loadFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("Loi: File '" + fileName + "' khong ton tai!");
            return new ArrayList<>();
        }

        if (fileName.toLowerCase().endsWith(".dat")) {
            return loadFromDatFile(file);
        } else {
            return loadFromTxtFile(file);
        }
    }

    // --- Ghi/Đọc File Text (.txt) ---
    private static void saveToTxtFile(List<Pet> list, File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Pet pet : list) {
                bw.write(pet.toFileString());
                bw.newLine();
            }
            System.out.println("-> Luu du lieu vao file Text '" + file.getPath() + "' thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi I/O khi ghi file text: " + e.getMessage());
        }
    }

    private static List<Pet> loadFromTxtFile(File file) {
        List<Pet> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Pet pet = Pet.fromFileString(line);
                    if (pet != null) list.add(pet);
                }
            }
            System.out.println("-> Tai du lieu tu file Text '" + file.getPath() + "' thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi I/O khi doc file text: " + e.getMessage());
        }
        return list;
    }

    // --- Ghi/Đọc File Binary (.dat) ---
    private static void saveToDatFile(List<Pet> list, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(list);
            System.out.println("-> Luu du lieu vao file DAT '" + file.getPath() + "' thanh cong!");
        } catch (IOException e) {
            System.err.println("Loi I/O khi ghi file .dat: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Pet> loadFromDatFile(File file) {
        List<Pet> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                list = (List<Pet>) obj;
                System.out.println("-> Tai du lieu tu file DAT '" + file.getPath() + "' thanh cong!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Loi: Lop trong file .dat khong tuong thich!");
        } catch (IOException e) {
            System.err.println("Loi I/O khi doc file .dat: " + e.getMessage());
        }
        return list;
    }
}