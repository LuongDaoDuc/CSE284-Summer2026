/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PetFileManager {

    /**
     * 
     * @param list
     * @param fileName
     */
    public static void saveToFile(List<Pet> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(list);
            System.out.println("-> Lưu dữ liệu vào file '" + fileName + "' thành công!");
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: Không tìm thấy đường dẫn file hoặc không thể tạo file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Lỗi I/O xảy ra trong quá trình ghi file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi lưu file: " + e.getMessage());
        }
    }

    /**
     * 
     * @param fileName
     * @return 
     */
    @SuppressWarnings("unchecked")
    public static List<Pet> loadFromFile(String fileName) {
        List<Pet> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                list = (List<Pet>) obj;
                System.out.println("-> Tải dữ liệu từ file '" + fileName + "' thành công!");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Lỗi: File '" + fileName + "' không tồn tại!");
        } catch (ClassNotFoundException e) {
            System.err.println("Lỗi: Cấu trúc lớp trong file không tương thích với chương trình hiện tại!");
        } catch (IOException e) {
            System.err.println("Lỗi I/O xảy ra trong quá trình đọc file (có thể file bị hỏng): " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi không xác định khi tải file: " + e.getMessage());
        }
        return list;
    }
}