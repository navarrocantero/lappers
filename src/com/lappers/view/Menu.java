package com.lappers.view;

import com.lappers.controller.Util;
import com.lappers.model.board.Board;
import com.lappers.model.car.Car;
import com.lappers.model.circuit.Circuit_Enum;
import com.lappers.model.racer.Racer;
import com.lappers.model.time.Time;

import java.util.*;

import static com.lappers.model.time.Time.comparatorByWheater;
import static com.lappers.model.time.Time.compareByTimeType;

/**
 * Created by driftineo on 4/5/17.
 */
public class Menu {


    /**
     * The first Menu of the app
     * Shows the varied of Circuit`s board Name
     *
     * @return int with the reference of our board
     */
    public static int firstMenu() {

        // Control boolean
        Boolean bol = true;

        //  This integer  will make as selector in our main menu
        int option = 0;

        while (bol) {

            Scanner input = new Scanner(System.in);
            try {

                System.out.println("*****MAIN__MENU*****");
                System.out.println("*********************");
                System.out.println("1 - Monteblanco     ");
                System.out.println("2 - Top Gear        ");
                System.out.println("3 - Grand Tour      ");
                System.out.println("4 - Nordschleife    ");
                System.out.println("0 - Exit            ");
                System.out.println("*********************");
                System.out.println("*********************");
                System.out.printf("option :\n");
                option = input.nextInt();
                if ((option == 0 || option == 1 || option == 2 || option == 3 || option == 4)) {
                    bol = false;
                } else {
                    System.out.println(UtilString.ONLYACEPTEDVALUES.getString());//See  @UtilString Enum for more details
                }
            } catch (InputMismatchException e) {
                System.out.println(UtilString.ONLYACEPTEDVALUES.getString());//See  @UtilString Enum for more details
            }
        }
        return option;
    }

    /**
     * The second menu of the app.
     * Show the varied of menus in the app
     *
     * @param times our ArrayList of Time class
     * @return int with the reference of different Menus
     */
    public static int secondMenu(ArrayList<Time> times) {


        ArrayList<Time> timeArrayList;

        // Control boolean
        Boolean bol = true;
        //  This integer  will make as selector in our main menu
        int option = 0;

        while (bol) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("********BOARD*********");
                System.out.println("**********************\n");
                System.out.println("    " + times.get(0).getCircuit().getCIRCUIT_NAME() + "\n"); // Show the board name
                System.out.println("1 - See     Times        ");
                System.out.println("2 - Add     Time        ");
                System.out.println("3 - Delete  Time       ");
                System.out.println("4 - Modify  Time       ");
                System.out.println("5 - Circuit Specs     ");
                System.out.println("0 - Back              ");
                System.out.println("**********************");
                System.out.println("**********************");
                System.out.printf(" option :\n");
                option = input.nextInt();
                if ((option == 0 || option == 1 || option == 2 || option == 3 || option == 4 || option == 5)) {
                    bol = false;
                } else {
                    System.out.println(UtilString.ONLYACEPTEDVALUES.getString()); //See  @UtilString Enum for more details
                }
            } catch (InputMismatchException e) {
                System.out.println(UtilString.ONLYACEPTEDVALUES.getString()); //See  @UtilString Enum for more details
            }
        }
        return option;
    }

    /**
     * This menu shows differents ways to see the board's times
     *
     * @param times our ArrayList of Time class
     * @return int , if int == 0 go to back menu
     */
    public static int seeTimesMenu(ArrayList<Time> times) {

        // Control boolean
        Boolean bol = true;
        //  This integer  will make as selector in our main menu
        int option = 0;


        // The next method will always be working until
        // in the next menu the user selects exit
        // and the control boolean marks the break.
        while (bol) {
            Board.sortAndCalculateGap(times); // See the @Board for more details about this method

            try {
                Scanner input = new Scanner(System.in);                     // This block prints a interactive Menu
                System.out.println("**********************");
                System.out.println("**********************");
                System.out.println("  SORTED BY LAP TIME  ");
                System.out.println("**********************");
                System.out.println("1 - Detailed  Times   ");
                System.out.println("2 - Simply    Times   ");
                System.out.println("**********************");
                System.out.println("  SORTED BY TIME TYPE ");
                System.out.println("**********************");
                System.out.println("3 - Simply    Times   ");
                System.out.println("**********************");
                System.out.println("  SORTED BY WHEATER   ");
                System.out.println("**********************");
                System.out.println("4 - Simply    Times   ");
                System.out.println("**********************");
                System.out.println("0 - Back              ");
                System.out.println("**********************");
                System.out.println("**********************");
                System.out.printf("option :\n");
                option = input.nextInt();

                if (option == 0 || option == 1 || option == 2 || option == 3 || option == 4) { // If '0' was selected the user will go back
                    bol = false;                                //  and will return 0 and go back
                    if (option == 0) {
                        return option;

                    } else if (option == 1) {                   // If '1' was selected will do it this 'SOUT'
                        System.out.println("Detailed Times Sorted By Lap Time\n");
                        for (Time time : times) {
                            System.out.println(time.toString());
                        }
                    } else if (option == 2) {                   // Same thing (that UP) but with '2' selected
                        System.out.println("Simply Times Sorted By Lap Time\n");
                        System.out.println(times.get(0).getCircuit().getCIRCUIT_NAME() + "\n");
                        for (Time time : times) {
                            System.out.println("Pos " + (times.indexOf(time) + 1) + " " + time.getCar().getCarModel() + " "
                                    + time.getLapTime() + "''");
                        }
                    } else if (option == 3) {
                        System.out.println("Simply Times Sorted By Time Type\n");

                        // If '3' was selected will
                        // do it compare by time type ( REAL OR SIMULATED)
                        Collections.sort(times, compareByTimeType);

                        for (Time time : times) {

                            System.out.println("Pos " + (times.indexOf(time) + 1) + " " + time.getCar().getCarModel() + " "
                                    + time.getLapTime() + "'' " + ((time.isSimulated() ? "Simulated" : "Real")) + " Time ");
                        }
                    } else if (option == 4) {
                        System.out.println("Simply Times Sorted By Time Wheater\n");

                        // If '4' was selected will
                        // do it compare by time Wheater
                        Collections.sort(times, comparatorByWheater);
                        for (Time time : times) {

                            System.out.println("Pos " + (times.indexOf(time) + 1) + " " + time.getCar().getCarModel() + " "
                                    + time.getLapTime() + "'' " + time.getWheater());
                        }
                    }
                } else {
                    System.out.println(UtilString.ONLYACEPTEDVALUES.getString()); //See  @UtilString Enum for more details
                }
            } catch (InputMismatchException e) {
                System.out.println(UtilString.ONLYACEPTEDVALUES.getString()); // See  @UtilString Enum for more  details
            }
        }
        return option;
    }

    /**
     * This menu show the submenus for add a time :
     *
     * @param times our ArrayList of Time class
     */
    public static void newTimeMenu(ArrayList<Time> times) {


        Scanner input = new Scanner(System.in);
        Boolean bol = true;
        Car car = new Car();
        Racer racer = new Racer();
        Time time = new Time();
        Time timeAux = new Time();
        Circuit_Enum circuit = times.get(0).getCircuit();


        while (bol) {
            bol = false;
            time = Menu.newTimeMenu(circuit); // See the @Menu class for more details about this method

            // - It checks to insert a new time, if there is already a
            //   previous time of that car in that arrayList
            //   - If so, check the previous times in the arraylist.
            //       - If it finds a worse time, the arraylist will be updated.
            //       - If it finds a better time, the arraylist will not change
            try {
                for (Time t : times) {
                    if (t.getCar().getCarModel().trim()
                            .equalsIgnoreCase(time.getCar().getCarModel().trim())) {

                        if (t.getLapTime() <= time.getLapTime()) {
                            time = new Time();
                            System.out.println(UtilString.BESTTIMEFOUND.getString()); // See UtilString for more details
                            System.out.println(UtilString.DONOTHING.getString());    // about all these Strings
                        } else {
                            timeAux = t;
                            System.out.println(UtilString.WORSTTIMEFOUND.getString());
                            System.out.println(UtilString.DOSOMETHING.getString());
                        }
                        break;
                    }
                }
            } catch (NullPointerException e) {
            }
        }

        if ((timeAux.getLapTime() > 0)) {
            times.remove(timeAux);
        }
        if ((time.getLapTime() > 0)) {
            times.add(time);
        }
    }

    /**
     * This menu shows the Circuit Specs
     *
     * @param times our ArrayList of Time class
     */
    public static void seeCircuitMenu(ArrayList<Time> times) {

        System.out.println(times.get(0).getCircuit());
    }

    /**
     * @param times our ArrayList of Time class
     * @return int
     */
    public static int quitTimeMenu(ArrayList<Time> times) {
        int option = 0;
        Boolean check = true;

        // Here we check that there is some time in the arraylist
        if (times.size() <= 1) {
            System.out.println(UtilString.ERROR.getString() + "" + UtilString.ONLYHAVEONETIME.getString());
            check = false;
        }

        if (check) {
            Scanner input = new Scanner(System.in);
            boolean bol = true;
            Time timeAux = new Time();
            Iterator<Time> itTimes = times.iterator();

            // Print the arrayList of Times
            while (itTimes.hasNext()) {
                Time time = itTimes.next();
                System.out.println("Pos " + " " + ((times.indexOf(time) + 1)) + " " + time.getCar().getCarModel() + " " + time.getLapTime() + "''");
            }

            System.out.println("\nPress 0 to exit\n");
            while (bol) {

                Scanner inputTwo = new Scanner(System.in);
                try {
                    System.out.println("Pos of time to remove:");
                    option = inputTwo.nextInt();
                    if (option <= 0) {
                        option = 0;
                    }

                    if (((option) <= times.size())) { // Check if is a valid Option
                        timeAux = times.get(option - 1);
                    } else {
                        System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                    }
                } catch (InputMismatchException e) {
                    option = 1;
                    System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                } catch (ArrayIndexOutOfBoundsException e) {
                } finally {
                    if (option == 0) {
                        bol = false;
                    } else if ((option <= times.size())) {
                        bol = false;
                    } else {
                        bol = true;
                    }
                }
            }
            Iterator<Time> itTimesTwo = times.iterator();
            while (itTimesTwo.hasNext()) {
                if (itTimesTwo.next().equals(timeAux)) {
                    itTimesTwo.remove();
                    System.out.println(UtilString.DELETED.getString());
                }
            }
        }

        return option;
    }

    /**
     * Method to modify a time in our Arraylist
     *
     * @param times our ArrayList of Time class
     */
    public static void modifyTimeMenu(ArrayList<Time> times) {

        int option = 0;
        int inputAux = 0;
        Boolean check = true;
        boolean addControl = true;


        // Here we check that there is some time in the arraylist
        if (times.size() < 1) {
            System.out.println(UtilString.ERROR.getString() + "" + UtilString.ONLYHAVEONETIME.getString()); // See the UtilString Enum for more details
            check = false;
        }

        // If the arrayList ist not Empty we go ahead
        if (check) {
            Scanner input = new Scanner(System.in);
            boolean bol = true;
            boolean control = true;
            boolean lapTimeControl = true;
            double oldLapTime = 0;
            double newLaptime = 0;
            Time timeAux = new Time();
            Iterator<Time> itTimes = times.iterator();

            // We sout the arrayList
            while (itTimes.hasNext()) {
                Time time = itTimes.next();
                System.out.println("Pos " + " " + ((times.indexOf(time) + 1)) + " " + time.getCar().getCarModel() + " " + time.getLapTime() + "''");
            }
            System.out.println("\nPress 0 to exit\n");

            // The first is ask the position to the element to modify
            while (bol) {
                control = true;

                while (control) {
                    try {
                        Scanner inputTwo = new Scanner(System.in);
                        System.out.println("Pos of time to modify:");
                        option = inputTwo.nextInt();

                        // Here  the user wants exit and all booleans turn off
                        if (option <= 0) {
                            option = 0;
                            bol = false;
                            lapTimeControl = false;
                            addControl = false;
                        }
                        if ((option <= times.size())) {
                            control = false;
                        } else {
                            System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                        }
                    } catch (InputMismatchException | IndexOutOfBoundsException e) {

                        System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                    }
                }

                // Here the user can see the old and the new time and add or not
                while (lapTimeControl) {
                    Scanner inputThree = new Scanner(System.in);
                    try {
                        System.out.println("Add the new Lap Time");
                        newLaptime = inputThree.nextDouble();

                        //Check that the time is greater than 0 and that it is double
                    } catch (InputMismatchException e) {
                        newLaptime = 0;
                    } finally {
                        if (newLaptime > 0) {
                            lapTimeControl = false;
                            bol = false;

                        } else {
                            System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                            System.out.println(UtilString.MUSTBEGREATHERTHANZERO.getString()); //See  @UtilString Enum for more details
                        }
                    }
                }

                while (addControl) {

                    if (((option) <= times.size())) {
                        timeAux = times.get(option - 1);
                        oldLapTime = timeAux.getLapTime();
                    } else {
                        System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                    }
                    Scanner inputFour = new Scanner(System.in);
                    try {
                        System.out.println("The old lap time " + oldLapTime);
                        System.out.println("The next lap time " + newLaptime);
                        System.out.println("Are you sure?");
                        System.out.println("1 = add new Time || 2 = keep the old time\n");
                        inputAux = inputFour.nextInt();
                    } catch (InputMismatchException e) {
                        inputAux = 3;
                    } finally {
                        if (inputAux == 1) {
                            timeAux.setLapTime(newLaptime);
                            System.out.println(UtilString.NEWTIMEADDED.getString());
                        }
                        if (inputAux == 2) {
                            System.out.println(UtilString.OLDTIMEKEEPED.getString());
                        }
                        if (inputAux == 1 || inputAux == 2) {
                            addControl = false;
                        }
                    }

                }
            }
        }

    }

    /**
     * This method shows a interactive Menu which can add a new Car
     *
     * @return Car a new car
     */
    public static Car addCarMenu() {
        Scanner input = new Scanner(System.in);
        Car car = new Car();

        try {
            do {
                System.out.println("Input the car model");
                car.setCarModel(input.nextLine());
            } while (car.getCarModel() == null);

            do {
                System.out.println("Input the car tyres");
                car.setCarTyres(input.nextLine());
            } while (car.getCarTyres() == null);

            do {
                System.out.println("Input the car type");
                car.setCarType(input.nextLine());
            } while (car.getCarType() == null);


        } catch (InputMismatchException e) {
        }
        return car;
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

    /**
     * Shows a interactive menu for add a new Time
     *
     * @param circuit Circuit see Enum @Circuit_Enum for more details about
     * @return Instance of Time class
     */
    public static Time newTimeMenu(Circuit_Enum circuit) {

        // New null Time
        Time time = new Time();

        // The main control boolean of the next 'Big Method'
        boolean check = true;


        while (check) {

            // Each time the method is started all the following
            // elements are declared to prevent errors
            Scanner wheaterInput = new Scanner(System.in);
            boolean lapTimeControl = true;
            boolean simulatedControl = true;
            boolean exitControl = true;
            boolean addControl = true;
            boolean simulated = true;
            int inputAux = 0;
            String wheater;
            double lapTime = 0;

            // The following two instances are done
            // through their own methods.
            // See the methods for more details about
            Car car = Menu.addCarMenu();
            Racer racer = Menu.addRacerMenu();


            // In this block the lap time is added
            // This block only breaks when the lapTime
            // added will be grather Than 0
            while (lapTimeControl) {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.println("Lap time");
                    lapTime = input.nextDouble();
                    //Check that the time is greater than 0 and that it is double
                } catch (InputMismatchException e) {
                    lapTime = -1;
                } finally {
                    if (lapTime > 0) {
                        lapTimeControl = false;
                    } else {
                        System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                        System.out.println(UtilString.MUSTBEGREATHERTHANZERO.getString()); //See  @UtilString Enum for more details

                    }
                }
            }

            System.out.println("Input wheater");
            wheater = wheaterInput.nextLine();


            // In this block shows a Interactive Menu
            // that asks the user if the time
            // is simulated
            // Only breaks when inputaux will be '1' or
            // '2'
            simulatedControl = true;
            while (simulatedControl) {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.println("Simulated  Time ?");
                    System.out.println("1 = yes");
                    System.out.println("2 = no");
                    inputAux = input.nextInt();

                    if (inputAux == 1) {
                        simulated = true;
                    }
                    if (inputAux == 2) {
                        simulated = false;
                    }

                } catch (InputMismatchException e) {
                    inputAux = -1;
                } finally {
                    if (inputAux == 1 || inputAux == 2) {
                        simulatedControl = false;
                    } else {
                        System.out.println(UtilString.ONLYONEORTWOVALUES.getString()); // See the @UtilString for more details
                    }
                }
            }
            // Instance of new Time
            time = new Time(circuit, car, racer, lapTime, wheater, simulated);
            addControl = true;


            // In this block shows a Interactive Menu
            // that asks the user if add the item or not
            //
            // If the user insert any data other
            // than 1 or 2 will be set to 3
            // Only breaks when inputaux will be '1'
            while (addControl) {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.println(time + "\nAdd ?\n " + "1 = yes || 2 = no\n");
                    inputAux = input.nextInt();

                } catch (InputMismatchException e) {
                    inputAux = 3;
                } finally {
                    try {
                        if ((inputAux == 3)) {
                            System.out.println(UtilString.ONLYONEORTWOVALUES.getString()); // See the @UtilString for more details

                        } else if (inputAux == 1) {
                            check = false;

                            return time;
                        } else if (inputAux == 2) {
                            int inputTwo;
                            addControl = false;
                            check = false;
                            inputAux = 0;
                            exitControl = true;

                            // In this block shows a Interactive Menu
                            // that asks the user if want exit to the
                            // main Menu or not.
                            //
                            // If the user insert any data other
                            // than 1 or 2 will be set to 3
                            // Only breaks when inputTwo will be '1'
                            while (exitControl) {
                                Scanner exitInput = new Scanner(System.in);
                                try {
                                    System.out.println("" + "\n Exit ?\n " + "1 = yes || 2 = no\n");
                                    inputTwo = exitInput.nextInt();
                                    if (inputTwo == 1) {

                                        return new Time();


                                    } else if (inputTwo == 2) {
                                        addControl = true;
                                        exitControl = false;
                                    }
                                } catch (InputMismatchException e) {
                                    exitControl = true;
                                }
                            }
                        }
                    } catch (InputMismatchException e) {
                        check = true;
                    }
                }
            }
        }
        return time;
    }
}


