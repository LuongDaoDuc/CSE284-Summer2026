/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Buoi2;

/**
 *
 * @author PC
 */
public class B4 {
    public static void main(String[] args) {
        long a =1 ;
        long b =1;
        long c;
        System.out.println("Day 90 so fibo dau tien la:");
        for(int i=1;i<=45;i+=2){
            System.out.print(" "+a);
            c = a+b;
            a = b;
            b = c;
        }
        System.out.print("\n");
        
    }
}
