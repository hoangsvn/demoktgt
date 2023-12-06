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
public class main_extracting_utf8 {
    public static void main(String[] args) {
        Boolean flags = new ExtractingController(
            ".\\anh goc sau khi giau tin spread spectrum vn.png",
            ".\\extracvn.txt",
            "123456").extractMessageUtf8();
        System.out.print(flags);
    }
}
