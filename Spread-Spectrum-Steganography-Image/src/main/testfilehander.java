/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.Base64;
 

/**
 *
 * @author Admin
 */
public class testfilehander {

    public static void main(String[] args) throws IOException {
       

        byte[] bytes = "Hoàng".getBytes(StandardCharsets.UTF_8);
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s);
        String ss = new String(decode, StandardCharsets.UTF_8);
        System.out.println("Output : " + ss);

    }
}
