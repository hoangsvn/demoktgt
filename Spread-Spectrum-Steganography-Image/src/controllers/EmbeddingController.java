package Controllers;

import lib.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class EmbeddingController {

    private final String messagePath;
    private final String imagePath;
    private final String stegoPath;
    private final String key;
    private String message="";
    private BufferedImage stegoImage;

    public EmbeddingController(String messagePath, String imagePath, String stegoPath, String key) throws IOException {
        this.messagePath = messagePath;
        this.imagePath = imagePath;
        this.stegoPath = stegoPath;
        this.key = key;
        this.message = new FileHandler().getMessageUTF8Encode(messagePath);
    }

    public boolean generateStegoImage() {
         
        StringBuilder binaryMessage = new DataConversion().stringToBinary(message);
        StringBuilder messageSpreading = new Spreader().spreading(binaryMessage);
        StringBuilder result = new Modulation().modulate(messageSpreading, key);        
        
        FileHandler filehander = new FileHandler();
        filehander.log("EMB");
        filehander.log(binaryMessage.toString());
        filehander.log(messageSpreading.toString());
        filehander.log(result.toString());
        
        result.append(new Delimiter("#").getDelimiter());
        int[] bits = new DataConversion().binaryToBits(result);
        BufferedImage image = new FileHandler().getImage(imagePath);
        stegoImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
        int[] stegoPixels = new int[pixels.length];
        int bitIndex = 0;
        int endoffset  = 16;
        DataConversion datacv = new DataConversion();
        StringBuilder flags = datacv.stringToBinary("SGTIMA");
        int[] flagsbits = datacv.binaryToBits(flags);
        int indexflagsbits = 0;
        for (int i = 0; i < pixels.length; i++) {
            int pixel = pixels[i];
            int red = (pixel >> 16) & 0xff;
            int green = (pixel >> 8) & 0xff;
            int blue = (pixel) & 0xff;
            int alpha = (pixel >> 24) & 0xff;
            
            if ( i < endoffset){
                red     = new LeastSignificantBit(red, flagsbits[indexflagsbits++]).generate();
                green   = new LeastSignificantBit(green, flagsbits[indexflagsbits++]).generate();
                blue    = new LeastSignificantBit(blue, flagsbits[indexflagsbits++]).generate();
                stegoPixels[i] = (alpha << 24) | (red << 16) | (green << 8) | blue;
                continue;
            }
            
            if (bitIndex < bits.length) {
                red = new LeastSignificantBit(red, bits[bitIndex]).generate();
                bitIndex++;
            }
            if (bitIndex < bits.length) {
                green = new LeastSignificantBit(green, bits[bitIndex]).generate();
                bitIndex++;
            }
            if (bitIndex < bits.length) {
                blue = new LeastSignificantBit(blue, bits[bitIndex]).generate();
                bitIndex++;
            }
            int stegoPixel = (alpha << 24) | (red << 16) | (green << 8) | blue;
            stegoPixels[i] = stegoPixel;
        }
        stegoImage.setRGB(0, 0, image.getWidth(), image.getHeight(), stegoPixels, 0, image.getWidth());
        
        return new FileHandler().saveImage(stegoImage, stegoPath);
    }

}
