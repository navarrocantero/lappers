package com.lappers.view;

import com.lappers.model.board.Board;
import com.lappers.model.car.Car;
import com.lappers.model.circuit.Circuit_Enum;
import com.lappers.model.racer.Racer;
import com.lappers.model.time.Time;

import java.util.*;

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


        Boolean bol = true;
        int option = 0;
        while (bol) {
            try {
                Scanner input = new Scanner(System.in);

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
                }
            } catch (InputMismatchException e) {
                System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
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
        Boolean bol = true;
        int option = 0;

        while (bol) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("********BOARD*********");
                System.out.println("**********************\n");
                System.out.println("    " + times.get(0).getCircuit().getCIRCUIT_NAME() + "\n");
                System.out.println("1 - See  Times        ");
                System.out.println("2 - Add   Time        ");
                System.out.println("3 - Delete Time       ");
                System.out.println("4 - Circuit specs     ");
                System.out.println("0 - Back              ");
                System.out.println("**********************");
                System.out.println("**********************");
                System.out.printf(" option :\n");
                option = input.nextInt();
                if ((option == 0 || option == 1 || option == 2 || option == 3 || option == 4)) {
                    bol = false;
                }
            } catch (InputMismatchException e) {
                System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
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

        Boolean bol = true;
        int option = 0;

        while (bol) {
            Board.sortAndCalculateGap(times);

            try {
                Scanner input = new Scanner(System.in);
                System.out.println("**********************");
                System.out.println("**********************");
                System.out.println("1 - Detailed  Times    ");
                System.out.println("2 - Simply    Times    ");
                System.out.println("0 - Back              ");
                System.out.println("**********************");
                System.out.println("**********************");
                option = input.nextInt();

                if (option == 0 || option == 1 || option == 2) {
                    bol = false;
                    if (option == 0) {
                        return option;

                    } else if (option == 1) {

                        for (Time time : times) {
                            System.out.println(time.toString());
                        }
                    } else if (option == 2) {
                        System.out.println(times.get(0).getCircuit().getCIRCUIT_NAME() + "\n");
                        for (Time time : times) {
                            System.out.println("Pos " + (times.indexOf(time) + 1) + " " + time.getCar().getCarModel() + " "
                                    + time.getLapTime() + "''");
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
            }
        }
        return option;
    }

    /**
     * This menu show the submenus for add a time :
     *
     * @param times our ArrayList of Time class
     */
    public static void addTimeMenu(ArrayList<Time> times) {


        Scanner input = new Scanner(System.in);
        Boolean bol = true;
        Car car = new Car();
        Racer racer = new Racer();
        Time time = new Time();
        Time timeAux = new Time();
        Circuit_Enum circuit = times.get(0).getCircuit();


        while (bol) {
            bol = false;
            time = Menu.addTimeMenu(circuit); // Call to submenu

            try {
                for (Time t : times) {
                    if (t.getCar().getCarModel().trim()
                            .equalsIgnoreCase(time.getCar().getCarModel().trim())) {

                        if (t.getLapTime() <= time.getLapTime()) {
                            time = new Time();
                            System.out.println(UtilString.BESTTIMEFOUND.getString());
                            System.out.println(UtilString.DONOTHING.getString());
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
     * This menu show a menu for delete a time
     *
     * @param times our ArrayList of Time class
     */
    public static int quitTimeMenu(ArrayList<Time> times) {
        int option = 0;
        Boolean check = true;

        if (times.size() <= 1) {
            System.out.println(UtilString.ERROR.getString() + "" + UtilString.ONLYHAVEONETIME.getString());
            check = false;
        }
        if (check) {
            Scanner input = new Scanner(System.in);
            boolean bol = true;
            Time timeAux = new Time();
            Iterator<Time> itTimes = times.iterator();
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
                    if (((option) <= times.size())) {
                        timeAux = times.get(option - 1);
                    } else {
                        System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                    }
                } catch (InputMismatchException e) {
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
     * This method shows a interactive Menu which can add a new Car
     *
     * @return Car a new car
     */
    public static Car addCarMenu() {
        Scanner input = new Scanner(System.in);
        Car car = new Car();
        String carModel;
        String carTyres;
        String carType;

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
     * @param circuit Circuit (see Enum @Circuit_Enum)
     * @return Instance of Time class
     */
    public static Time addTimeMenu(Circuit_Enum circuit) {


        Time time = new Time();
        boolean check = true;
        while (check) {


            Scanner wheaterInput = new Scanner(System.in);

            boolean lapTimeControl = true;
            boolean simulatedControl = true;
            boolean exitControl = true;
            boolean addControl = true;

            boolean simulated = true;
            int inputAux = 0;
            String wheater;
            double lapTime = 0;

            Car car = Menu.addCarMenu();          // Call to submenu
            Racer racer = Menu.addRacerMenu(); // Call to submenu


            while (lapTimeControl) {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.println("Lap time");
                    lapTime = input.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println(UtilString.ONLYACEPTEDVALUES.getString());
                } finally {
                    if (lapTime > 0) {
                        lapTimeControl = false;
                    }
                }
            }

            System.out.println("Input wheater");
            wheater = wheaterInput.nextLine();

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
                    System.out.println(UtilString.ONLYONEORTWOVALUES.getString());
                } finally {
                    if (inputAux == 1 || inputAux == 2) {
                        simulatedControl = false;

                    }
                }
            }

            time = new Time(circuit, car, racer, lapTime, wheater, simulated);

            addControl = true;
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
                            System.out.println(UtilString.ONLYONEORTWOVALUES.getString());

                        } else if (inputAux == 1) {
                            check = false;

                            return time;
                        } else if (inputAux == 2) {
                            int inputTwo;
                            addControl = false;
                            check = false;
                            inputAux = 0;

                            exitControl = true;
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


