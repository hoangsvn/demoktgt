/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.image.BufferedImage;
import lib.DataConversion;
import lib.FileHandler;

/**
 *
 * @author Admin
 */
public class CheckSegatoImage {

    private final  int[] pixels;
    public CheckSegatoImage(String path) {
        BufferedImage image = new FileHandler().getImage(path);
        this.pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
    }
    public  boolean Check(){
        DataConversion datacv = new DataConversion();
        int index = 0;
        int endofffset = 16;
        int[] bits = new int[endofffset * 4];
        int bitsindex=0;
        for (int pixel : pixels) {
            if (bitsindex > endofffset*3){
                break;
            }
            int red = (pixel >> 16) & 0xff;
            int green = (pixel >> 8) & 0xff;
            int blue = (pixel) & 0xff;
            bits[bitsindex++] = red & 1;
            bits[bitsindex++] = green & 1;
            bits[bitsindex++] = blue & 1;
            
        }
        int[] bits1 = new int[endofffset * 3];
        for (int i = 0; i < 48; i++) {
            bits1[i] = bits[i];
        }
        
        StringBuilder checkflag0 = datacv.bitsToBinary(bits1);
        StringBuilder checkflag1 = datacv.binaryToString(checkflag0);
        String checkflag2 =checkflag1.toString();
        
        return checkflag2.equals("SGTIMA");
//        return  checkflags.equals("SGTIMA");
    }
}
