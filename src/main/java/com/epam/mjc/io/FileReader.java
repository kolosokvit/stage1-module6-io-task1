package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            StringBuilder data = new StringBuilder();
            while (fileInputStream.available() > 0) {
                data.append((char) fileInputStream.read());
            }
            String[] personalData = data.toString().split(System.lineSeparator());
            String name = personalData[0].split(": ")[1];
            int age = Integer.parseInt(personalData[1].split(": ")[1]);
            String email = personalData[2].split(": ")[1];
            long phone = Long.parseLong(personalData[3].split(": ")[1]);
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
