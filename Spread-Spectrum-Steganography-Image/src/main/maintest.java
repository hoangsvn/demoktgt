/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Controllers.EmbeddingController;
import Controllers.ExtractingController;
import lib.FileHandler;

/**
 *
 * @author Admin
 */
public class maintest {

    public static void main(String[] args) {
       
        
        new FileHandler().clearlog();
        Boolean flas = new EmbeddingController(
                ".\\text.txt",
                ".\\anh goc.png",
                ".\\test1.png",
                "123456").generateStegoImageUTF8();
        System.out.println(flas);

        Boolean flags = new ExtractingController(
                ".\\test1.png",
                ".\\extracvn.txt",
                "123456").extractMessageUtf8();
        System.out.println(flags);

    }
}
