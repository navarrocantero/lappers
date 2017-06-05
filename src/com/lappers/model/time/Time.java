package com.lappers.model.time;


import com.lappers.controller.Util;
import com.lappers.view.Menu;
import com.lappers.view.UtilString;
import com.lappers.model.car.Car;
import com.lappers.model.circuit.Circuit_Enum;
import com.lappers.model.racer.Racer;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Time implements Comparable<Time>, Comparator<Time>, java.io.Serializable {

    private static final long serialVersionUID = -7506173295960216530L;
    private Circuit_Enum circuit;
    private Car car;
    private Racer racer;
    private double lapTime;
    private String wheater;
    private Boolean simulated;
    private double gapToFirst;

    //Constructors

    public Time() {


    }

    /**
     * This constructor only can be called in this class  because only if used to use in the addTimeMenu method
     * for a temporaly and not usable instance
     *
     * @param circuit Circuit_Enum
     * @param car
     * @param racer
     */
    public Time(Circuit_Enum circuit, Car car, Racer racer) {
        this(circuit, car, racer, 0);
    }

    public Time(Circuit_Enum circuit, Car car, Racer racer, double lapTime) {
        this(circuit, car, racer, lapTime, "", false);
    }


    public Time(Circuit_Enum circuit, Car car, Racer racer, Double lapTime,
                String wheater, Boolean simulated) {

        this.setCircuit(circuit);
        this.setCar(car);
        this.setRacer(racer);
        this.setLapTime(lapTime);
        this.setWheater(wheater);
        this.setSimulated(simulated);
    }

    public Time(Circuit_Enum circuit, Car car, Racer racer, double lapTime, String wheater, Boolean simulated, double gapToFirst) {
        this.setCircuit(circuit);
        this.setCar(car);
        this.setRacer(racer);
        this.setLapTime(lapTime);
        this.setWheater(wheater);
        this.setSimulated(simulated);
        this.gapToFirst = gapToFirst;
    }

    //Accesors

    //Getters

    public Car getCar() {
        return car;
    }

    public Racer getRacer() {
        return racer;
    }

    public Double getLapTime() {
        return lapTime;
    }

    public String getWheater() {
        return wheater;
    }

    public Boolean isSimulated() {
        return simulated;
    }

    public Circuit_Enum getCircuit() {

        return circuit;
    }

    public double getGapToFirst() {
        return gapToFirst;
    }

    //Setters

    public void setCircuit(Circuit_Enum circuit) {
        this.circuit = circuit;
    }

    public void setCar(Car car) {
        this.car = Car.checkCar(car);
    }

    public void setRacer(Racer racer) {
        this.racer = Racer.checkRacer(racer);
    }

    public void setLapTime(Double lapTime) {
        this.lapTime = Util.checkPositiveDouble(lapTime);
    }

    public void setWheater(String wheater) {
        this.wheater = Time.checkWheater(wheater);
    }

    public void setSimulated(Boolean simulated) {
        this.simulated = simulated;
    }

    public void setGapToFirst(double gapToFirst) {
        this.gapToFirst = Util.checkPositiveDouble(gapToFirst);
    }

    // Helpers

    @Override
    public String toString() {

        return

                this.getRacer() +
                        "Lap time        = " + this.getLapTime() + "'\n" +
                        "Gap to First    = " + this.getGapToFirst() + "'\n" +
                        this.getCar() +
                        this.getCircuit() +
                        "Wheater         = " + this.getWheater() + "\n" +
                        "Simulation      = " + this.isSimulated() + "\n";
    }


    /**
     * Method to check if the value of our time tipe is null or not
     *
     * @param booleanArg Can be true or false
     * @return If the value is empty, set the 'false' attribute
     */
    static public Boolean checkTimeType(Boolean booleanArg) {


        return (booleanArg == null ? false : booleanArg);
    }


    /**
     * Method to check if the value of our wheater is empty or not
     *
     * @param string Value of String arg
     * @return If the value is empty, set the '30º, clear' attribute
     */
    static public String checkWheater(String string) {

        String emptyString = "";
        String unknown = "30º, Clear ";

        return (string.trim().equalsIgnoreCase(emptyString) ? unknown : string);
    }


    /**
     * Comparator by Lap Time
     */
    public static Comparator<Time> compareByLapTime = new Comparator<Time>() {
        @Override
        public int compare(Time f1, Time f2) {
            return (int) (f2.getLapTime() - f1.getLapTime());
        }
    };

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


        Time time = (Time) obj; // Instance of new time object


        return this.getLapTime().equals(time.getLapTime())
                && this.isSimulated().equals(time.isSimulated())
                && this.getCircuit().equals(time.getCircuit())
                && this.getCar().equals(time.getCar())
                && this.getRacer().equals(time.getRacer());
    }

    @Override
    public int compare(Time o1, Time o2) {

        return o1.compareTo(o2);
    }

    @Override
    public int compareTo(Time time) {

        int res = Double.compare(this.getLapTime(), time.getLapTime());


        return res;
    }
}