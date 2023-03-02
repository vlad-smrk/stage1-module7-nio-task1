package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileReader {
    public Profile getDataFromFile(File file) {
        String content = "";
        try {
            content = Files.readString(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] tokens = content.split("[ \n]");
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0L;
        for (int i = 0; i < tokens.length - 1; i++) {
            String next = tokens[i + 1];
            switch (tokens[i]) {
                case "Name:": name = next;
                    break;
                case "Age:": age = Integer.parseInt(next);
                    break;
                case "Email:": email = next;
                    break;
                case "Phone:": phone = Long.parseLong(next);
                    break;
                default: break;
            }
        }
        return new Profile(name, age, email, phone);
    }

}
