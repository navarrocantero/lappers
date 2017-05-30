package com.lappers.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

class ReadAFile {

    public Boolean canRead(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            int letra = fileReader.read();

            while (letra != -1) {
                System.out.print((char) letra);
                letra = fileReader.read();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}