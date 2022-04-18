package com.TomaszB.Lab1;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        System.out.print("File name: ");
        var fileName = sc.nextLine();
        System.out.print("Text: ");
        var text = sc.nextLine();

        try{
            var outputStream = new FileOutputStream(fileName);
            byte[] strToBytes = text.getBytes();
            outputStream.write(strToBytes);

            outputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found! " + ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("File saved correctly as: " + fileName);
        }
    }
}
