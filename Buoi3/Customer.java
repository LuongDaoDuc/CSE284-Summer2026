/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buoi3;

/**
 *
 * @author PC
 */
import java.util.Scanner;

public class Customer {
    // Thuộc tính (Attributes)
    private String customerID;
    private String name;
    private String phone;
    private String email;
    private int loyaltyPoints;

    public Customer() {}

    public Customer(String customerID, String name, String phone, String email, int loyaltyPoints) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int point) {
        this.loyaltyPoints = point;
    }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng (Customer ID): ");
        this.customerID = sc.nextLine();
        System.out.print("Nhập họ tên: ");
        this.name = sc.nextLine();
        System.out.print("Nhập số điện thoại: ");
        this.phone = sc.nextLine();
        System.out.print("Nhập email: ");
        this.email = sc.nextLine();
        System.out.print("Nhập điểm tích lũy: ");
        this.loyaltyPoints = sc.nextInt();
    }

    public void xuatThongTin() {
        System.out.println("--- THÔNG TIN KHÁCH HÀNG ---");
        System.out.println("Mã khách hàng: " + customerID);
        System.out.println("Họ tên: " + name);
        System.out.println("Số điện thoại: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Điểm tích lũy: " + loyaltyPoints);
    }
}