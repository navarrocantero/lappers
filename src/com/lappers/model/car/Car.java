package com.lappers.model.car;


import com.lappers.controller.Util;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Car implements Serializable {

    private static final long serialVersionUID = -6231095497873426276L;
    private String carModel;
    private String carTyres;
    private String carType;


    // Constructors

    /**
     * Default Constructor
     */
    public Car() {

        this(" ", " ", " ");
    }

    /**
     * Constructor with only one param
     * the blanks parameters will be "Stock"
     *
     * @param carModel String of car model
     */
    public Car(String carModel) {

        this(carModel, " ", " ");
    }

    /**
     * @param carModel String of the car model
     * @param carType  String of the car type
     * @param carTyres String of the car tyres comp
     */
    public Car(String carModel, String carType, String carTyres) {

        this.setCarModel(carModel);
        this.setCarTyres(carTyres);
        this.setCarType(carType);
    }

    // Accesors

    public String getCarModel() {

        return carModel;
    }

    public String getCarType() {

        return carType;
    }

    public String getCarTyres() {

        return carTyres;
    }

    /**
     * See the @Util class for more details about
     * next method
     *
     * @param carModel String of car Model
     */
    public void setCarModel(String carModel) {

        this.carModel = Util.checkEmptyString(carModel);
    }

    /**
     * See the @Car class for more details
     * about the next method
     *
     * @param carTyres String of car Tyres comp
     */
    public void setCarTyres(String carTyres) {

        this.carTyres = Car.checkCarString(carTyres);
    }

    /**
     * See the @Car class for more details
     * about the next method
     *
     * @param carType String of car Type
     */
    public void setCarType(String carType) {

        this.carType = Car.checkCarString(carType);
    }

    // Helpers

    @Override
    public String toString() {
        return
                "Car Model       = " + carModel + "\n" +
                        "Car Tyres       = " + carTyres + "\n" +
                        "Car Type        = " + carType + "\n";
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

        Car car = (Car) obj;  // Instance of new car object

        return this.getCarModel().equalsIgnoreCase(car.getCarModel())      // It is the same car model?
                && this.getCarTyres().equalsIgnoreCase(car.getCarTyres())   // It is the same car tyres?
                && this.getCarType().equalsIgnoreCase(car.getCarType());  // It is the same car type ?

    }

    /**
     * @param car Value of our car
     * @return If the value is not valid , set the default car ("Street","Street")
     * else the value of our car
     */
    static public Car checkCar(Car car) {

        Car carOne = new Car();
        return (car != null) ? car : carOne;
    }

    /**
     * Method to check if the value of our carType and carTyres is empty or not
     *
     * @param string Value of String arg
     * @return If the value is empty, set the 'street' attribute
     */
    static public String checkCarString(String string) {

        String emptyString = "";
        String unknown = "Street";

        return (string.trim().equalsIgnoreCase(emptyString) ? unknown : string);
    }
}

