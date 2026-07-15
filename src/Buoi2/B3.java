/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi2;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class B3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Nhap vao 10 so nguyen:");
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        
        System.out.println("Mang sau khi sap xep: " + Arrays.toString(arr));
        sc.close();
    }
}
