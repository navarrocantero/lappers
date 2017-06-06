package com.lappers.controller;

import com.lappers.model.car.Car;
import com.lappers.model.circuit.Circuit_Enum;
import com.lappers.model.racer.Racer;
import com.lappers.model.time.Time;

import java.io.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;

public class Util {

    /**
     * Method to check if the value of our string is empty or not
     *
     * @param string Value of String arg
     * @return String with  content of the string or  a "Unkwnown" string
     */
    static public String checkEmptyString(String string) {


        String emptyString = "";
        String unknown = "Unknown";

        return string.trim().equalsIgnoreCase(emptyString) ? unknown : string;

    }

    /**
     * Method to check if the value of our double is valid
     * Valid Double greather than  0
     * @param doubleArg Value of double arg
     * @return Double with the value of our doubleArg if is valid  or the value of a minimum double valid (0)
     */
    static public Double checkPositiveDouble(Double doubleArg) {

        Double minDouble = 0.0;

        return doubleArg < minDouble ? minDouble : doubleArg;

    }

}
