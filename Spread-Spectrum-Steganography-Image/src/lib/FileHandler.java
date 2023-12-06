package lib;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Scanner;

public class FileHandler {

    public int index = 0;

    public FileHandler() {
        
    }
    
    public BufferedImage getImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Xin lỗi, không tìm thấy tập tin hình ảnh");
        }
        return image;
    }

    public String getMessage(String path) {
        StringBuilder message = new StringBuilder();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String next = scan.nextLine();
                message.append(next);
                if (scan.hasNextLine()) {
                    message.append("\n");
                }
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.err.println("Xin lỗi, không tìm thấy tập tin tin nhắn");
        }

        return message.toString();
    }

    public String getMessageUtf8(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        String message = Base64.getEncoder().encodeToString(bytes);
        return message;
    }

    public boolean saveImage(BufferedImage image, String path) {
        try {
            ImageIO.write(image, "png", new File(path));
            return true;
        } catch (IOException e) {
            System.err.println("Rất tiếc, không thể lưu được tệp hình ảnh");
            return false;
        }
    }

    public boolean saveMessage(String message, String path) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(message);
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            System.err.println("Rất tiếc, không thể lưu được tệp tin nhắn");
            return false;
        }
    }

    public boolean saveMessageUtf8(String messageencode, String path) {
        
        byte[] decode = Base64.getDecoder().decode(messageencode);
        String messagedecode = new String(decode, StandardCharsets.UTF_8);
        try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path), StandardCharsets.UTF_8))) {
            bufferedWriter.write(messagedecode);
            
            return true;
        } catch (IOException e) {
            System.err.println("Rất tiếc, không thể lưu được tệp tin nhắn");
            return false;
        }
    }

    public boolean log(String content, String path) {
        try ( BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"))) {
            writer.write(content);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean log(String emb) {
        try ( BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("log", true), "UTF-8"))) {
//            writer.write(index+":len="+emb.length()+" data="+emb);
            writer.write(String.format("%s len=%10s data=%s", index,emb.length(),emb));
            writer.newLine();
            index++;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void clearlog() {
        try { 
            byte[] emptyBytes = new byte[0]; 
            Path path = Path.of("log");
            Files.write(path, emptyBytes, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();  
        }
    }
}
