/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import Controllers.EmbeddingController;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class main_embedding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Boolean flas =new EmbeddingController(
            ".\\textvn.txt",
            ".\\anh goc.png",
            ".\\anh goc sau khi giau tin spread spectrum vn.png",
            "123456").generateStegoImage();
        System.out.print(flas );
    }
    
}
