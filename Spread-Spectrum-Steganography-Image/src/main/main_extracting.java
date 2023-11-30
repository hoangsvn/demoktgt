/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

 
import Controllers.ExtractingController;

/**
 *
 * @author Admin
 */
public class main_extracting {
    public static void main(String[] args) {
        Boolean flags = new ExtractingController(
            ".\\emberdding-image.png",
            ".\\extrac.txt",
            "123456").extractMessage();
        System.out.print(flags);
    }
}
