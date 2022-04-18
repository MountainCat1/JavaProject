package com.TomaszB.Lab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args){
        try{
            var file = new File("file.txt");
            var fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            String str = new String(data, "UTF-8");
            System.out.println(str);
        }catch (FileNotFoundException ex){
            System.out.println("File not found! " + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("File loaded correctly!");
        }
    }
}
