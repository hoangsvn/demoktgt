/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Controllers.EmbeddingController;
import Controllers.ExtractingController;
import controllers.CheckSegatoImage;
import java.io.IOException;
import lib.FileHandler;

/**
 *
 * @author Admin
 */
public class maintest {

    public static void main(String[] args) throws IOException {
       
        
        new FileHandler().clearlog();
        Boolean flag0 = new EmbeddingController(
                ".\\textvn.txt",
                ".\\anh goc.png",
                ".\\test1.png",
                "123456").generateStegoImage();
        System.out.println(flag0 ? "Embedding Success" : "Embedding Fail");
        
        Boolean flag1 = new CheckSegatoImage(".\\test1.png").Check();
        
        System.out.println(flag1 ? "CheckSegatoImage Success" : "CheckSegatoImage Fail");
        
        Boolean flag2 = new ExtractingController(
                ".\\test1.png",
                ".\\extracvn.txt",
                "123456").extractMessage();
        System.out.println(flag2 ? "Extracting Success" : "Extracting Fail");

    }
}
