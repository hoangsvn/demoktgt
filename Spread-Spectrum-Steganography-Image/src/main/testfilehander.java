/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.util.Base64;
import lib.DataConversion;
 

/**
 *
 * @author Admin
 */
public class testfilehander {

    public static void main(String[] args) throws IOException {
       
        DataConversion datacv = new DataConversion();
        byte[] bytes = "Hoàng".getBytes(StandardCharsets.UTF_8);
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println(s);
        byte[] decode = Base64.getDecoder().decode(s);
        String ss = new String(decode, StandardCharsets.UTF_8);
        System.out.println("Output : " + ss);
        String tes ="SGTIMA";
        byte[] flags = tes.getBytes();
        for (byte flag : flags) {
            System.out.println(flag);
        }
        System.out.println(flags.length);
        StringBuilder tes1 = datacv.stringToBinary(tes);
        int[] tes2 = datacv.binaryToBits(tes1);
        for (int i : tes2) {
            System.out.println(i);
        }
        System.out.println(tes2.length);
        StringBuilder tes3 = datacv.bitsToBinary(tes2);
        System.out.println(datacv.binaryToString(tes3));
        

    }
}
