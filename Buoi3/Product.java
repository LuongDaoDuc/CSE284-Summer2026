/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package buoi3;

/**
 *
 * @author PC
 */
import java.util.Scanner;

public class Product {

    private String productID;
    private String productName;
    private String category;
    private double price;
    private int stockQuantity;

    public Product() {}


    public Product(String productID, String productName, String category, double price, int stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm (Product ID): ");
        this.productID = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        this.productName = sc.nextLine();
        System.out.print("Nhập danh mục (Category): ");
        this.category = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        this.price = sc.nextDouble();
        System.out.print("Nhập số lượng tồn kho: ");
        this.stockQuantity = sc.nextInt();
    }

    public void xuatThongTin() {
        System.out.println("--- THÔNG TIN SẢN PHẨM ---");
        System.out.println("Mã sản phẩm: " + productID);
        System.out.println("Tên sản phẩm: " + productName);
        System.out.println("Danh mục: " + category);
        System.out.println("Giá: " + price);
        System.out.println("Số lượng tồn kho: " + stockQuantity);
    }
}