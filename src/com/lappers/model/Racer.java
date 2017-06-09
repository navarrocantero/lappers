package com.lappers.model;


import com.lappers.controller.Util;

import java.io.Serializable;

public class Racer implements Serializable {

    private static final long serialVersionUID = -2281577272162642360L;
    private String racerName;
    private String racerCountry;

    // Constructors

    /**
     * Default Constructor
     */
    public Racer() {
        this("", "");

    }

    /**
     * Constructor with only one param
     * the blanks parameters will be "unknown"
     *
     * @param racerName String of racer Name
     */
    public Racer(String racerName) {

        this.setRacerName(racerName);
    }

    /**
     * @param racerName    String of the racer Name
     * @param racerCountry String of the racer Country
     */
    public Racer(String racerName, String racerCountry) {

        this.setRacerName(racerName);
        this.setRacerCountry(racerCountry);

    }

    // Accesors

    public String getRacerName() {

        return racerName;
    }

    public String getRacerCountry() {

        return racerCountry;
    }

    /**
     * See the @Util class for more details about
     * next method
     *
     * @param racerName String of racer name
     */
    public void setRacerName(String racerName) {

        this.racerName = Util.checkEmptyString(racerName);
    }

    /**
     * See the @Util class for more details about
     * next method
     *
     * @param racerCountry String of racer Country
     */
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
}
