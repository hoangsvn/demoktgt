/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import Controllers.EmbeddingController;

/**
 *
 * @author Admin
 */
public class main_emberdding_utf8 {
      public static void main(String[] args) {
        // TODO code application logic here
        Boolean flas =new EmbeddingController(
            ".\\textvn.txt",
            ".\\anh goc.png",
            ".\\anh goc sau khi giau tin spread spectrum vn.png",
            "123456").generateStegoImageUTF8();
        System.out.print(flas );
    }
}
