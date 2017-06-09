package com.lappers.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class NaCaFile {

    /**
     * Method that allows us to read a file.
     * If you can read it, it will return True
     *
     * @param filePath String with the path of file
     * @return
     */
    static protected Boolean canRead(String filePath) {
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

    /**
     * Method that allows us to make a empty file
     *
     * @param filepath String with the path of file
     */
    static protected void writer(String filepath) {

        try {
            FileWriter fw = new FileWriter(filepath);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}