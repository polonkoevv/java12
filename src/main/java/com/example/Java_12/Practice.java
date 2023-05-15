package com.example.Java_12;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Practice {

    @PostConstruct
    public void init() throws IOException, NoSuchAlgorithmException {
        MessageDigest SHA1 = MessageDigest.getInstance("SHA-1");

        File srcFile = new File("C:\\Users\\Bersnakx\\Desktop\\Java\\Java_12\\src\\main\\java\\com\\example\\Java_12\\srcFile.txt");
        if (!srcFile.exists()){
            srcFile.createNewFile();
            FileWriter srcWriter = new FileWriter(srcFile);
            srcWriter.write("null");
            srcWriter.flush();
            srcWriter.close();
        }

        FileReader srcReader = new FileReader(srcFile);
        BufferedReader srcBuffReader = new BufferedReader(srcReader);

        File destFile = new File("C:\\Users\\Bersnakx\\Desktop\\Java\\Java_12\\src\\main\\java\\com\\example\\Java_12\\destFile.txt");
        if (!destFile.exists()){
            destFile.createNewFile();
        }

        FileWriter destWriter = new FileWriter(destFile);

        BufferedWriter destBuffWriter = new BufferedWriter(destWriter);
        while(srcBuffReader.ready()){

            String tempstr = srcBuffReader.readLine();
            System.out.println(tempstr);

            byte[] encStr = SHA1.digest(tempstr.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : encStr){
                builder.append(String.format("%02X", b));
            }
            System.out.println(builder.toString());
            destBuffWriter.write(builder.toString());
            destBuffWriter.newLine();
            destBuffWriter.flush();
        }
        System.out.println("Files are ready");

    }

    @PreDestroy
    public void destroy(){
        File srcFile = new File("C:\\Users\\Bersnakx\\Desktop\\Java\\Java_12\\src\\main\\java\\com\\example\\Java_12\\srcFile.txt");
        if (srcFile.exists()){
            srcFile.delete();
        }

        System.out.println("Files had been destroyed");
    }

}
