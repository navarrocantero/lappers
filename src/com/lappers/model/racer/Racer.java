package com.lappers.model.racer;


import com.lappers.controller.Util;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Racer implements Serializable {


    private static final long serialVersionUID = -2281577272162642360L;
    private String racerName;
    private String racerCountry;

    // Constructors

    public Racer() {
        this("","");

    }

    public Racer(String racerName) {

        this.setRacerName(racerName);
    }

    public Racer(String racerName, String racerCountry) {

        this.setRacerName(racerName);
        this.setRacerCountry(racerCountry);

    }

    // Accesors

    public String getRacerName() {

        return racerName;
    }

    public void setRacerName(String racerName) {


        this.racerName = Util.checkEmptyString(racerName);
    }

    public String getRacerCountry() {

        return racerCountry;
    }

    public void setRacerCountry(String racerCountry) {

        this.racerCountry = Util.checkEmptyString(racerCountry);
    }


    // Helpers

    @Override
    public String toString() {
        return
                "Racer name      = " + getRacerName() + " \n" +
                        "Racer country   = " + getRacerCountry() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {   // Are the same memory ID ?
            return true;
        }
        if (obj == null) {  // It is the object null ?
            return false;
        }
        if (obj.getClass() != this.getClass()) { // Are the same class ?
            return false;
        }
        Racer racer = (Racer) obj;  // Instance of new car object

        return this.getRacerName().equalsIgnoreCase(racer.getRacerName())      // It is the same racer name ?
                && this.getRacerCountry().equalsIgnoreCase(racer.getRacerCountry()); // It is the same racer country ?
    }

    /**
     * @param racer Value of our racer
     * @return If the value is not valid , set the default racer ("Unkwnown","Unkwnown",)
     */
    static public Racer checkRacer(Racer racer) {

        Racer racerOne = new Racer();
        return (racer != null) ? racer : racerOne;
    }

    /**
     * This method shows a interactive Menu which can add a new Racer
     *
     * @return Racer a new racer
     */
    public static Racer addRacerMenu() {
        Scanner input = new Scanner(System.in);
        Racer newRacer = new Racer();

        try {
            do {
                System.out.println("Input the racer name");
                newRacer.setRacerName(input.nextLine());
            } while (newRacer.getRacerName() == null);

            do {
                System.out.println("Input the racer country");
                newRacer.setRacerCountry(input.nextLine());
            } while (newRacer.getRacerCountry() == null);

        } catch (InputMismatchException e) {
        }
        return newRacer;
    }
}
