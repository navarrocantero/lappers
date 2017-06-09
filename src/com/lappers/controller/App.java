package com.lappers.controller;

import com.lappers.model.Board;
import com.lappers.model.Car;
import com.lappers.model.Circuit_Enum;
import com.lappers.model.Racer;
import com.lappers.model.Time;
import com.lappers.view.Menu;

import java.util.ArrayList;


public class App {


    public static void main(String[] args) {

        //  The first block is instantiation of:
        //  String of different file paths
        String firstRunFilePath = "src/res/fr.dat";
        String nurburFilePath = "src/res/nurbur.dat";
        String topGearFilePath = "src/res/topgear.dat";
        String grandTourFilePath = "src/res/grandtour.dat";
        String monteblancoFilePath = "src/res/monteblanco.dat";

        //  In this  block will check if is the first run of app or not:
        //  That does it based on whether you can read a control file means
        //  it is not the first time of the app`s run
        if (!(NaCaFile.canRead(firstRunFilePath))) {

            // If can enter here (means first run)
            // That will make 4 new Board objects loading data from
            // data loading methods and then saving them to files.
            // See the @Board class for see the boardTofile Method
            Board monteblancoBoard = new Board(loadMonteblancoTimes());
            Board nurbBoard = new Board(loadNurburTimes());
            Board topGearBoard = new Board(loadTopGearTimes());
            Board grandTourBoard = new Board(loadGrandTourTimes());

            Board.boardToFile(nurbBoard, nurburFilePath);
            Board.boardToFile(monteblancoBoard, monteblancoFilePath);
            Board.boardToFile(grandTourBoard, grandTourFilePath);
            Board.boardToFile(topGearBoard, topGearFilePath);

            //  Finally, the verification file is saved
            NaCaFile.writer(firstRunFilePath);


        }

        // In all the other starts of the program are instancian 4 objects Board
        // See the @Board class for see the fileToBoard method
        Board nurbBoard = Board.fileToBoard(nurburFilePath);
        Board topGearBoard = Board.fileToBoard(topGearFilePath);
        Board grandTourBoard = Board.fileToBoard(grandTourFilePath);
        Board monteblancoBoard = Board.fileToBoard(monteblancoFilePath);

        //  This integer  will make as selector in our main menu
        int option;

        // This integer  will make as selector in our second  menu
        int secondOption;

        // This  arrayList  Will be an arraylist that will
        // contain the main attribute of the previously declared
        // board objects (See the @Board class for more details)
        // and we Use as Joker for all the times.
        ArrayList<Time> auxTimes = new ArrayList<Time>();

        // Main menu
        // 1- Monteblanco menu
        // 2- Top gear   menu
        // 3- Grand tour menu
        // 4- Nurbur menu
        // In each option the board will do sorted (by lap time)
        // and calculate the gap.
        while ((option = Menu.firstMenu()) != 0) {

            if (option == 1) {
                Board.sortAndCalculateGap(monteblancoBoard.getTimes());
                auxTimes = monteblancoBoard.getTimes();
            }
            if (option == 2) {
                Board.sortAndCalculateGap(topGearBoard.getTimes());
                auxTimes = topGearBoard.getTimes();
            }
            if (option == 3) {
                Board.sortAndCalculateGap(grandTourBoard.getTimes());
                auxTimes = grandTourBoard.getTimes();
            }
            if (option == 4) {
                Board.sortAndCalculateGap(nurbBoard.getTimes());
                auxTimes = nurbBoard.getTimes();
            }

            // Main menu
            // 1- See times     menu
            // 2- Add time      menu
            // 3- Delete time   menu
            // 4- Se track spcs menu
            // In each option the board selected will be
            // the option selected in Main menu
            while ((secondOption = Menu.secondMenu(auxTimes)) != 0) {

                if (secondOption == 1) {
                    while (Menu.seeTimesMenu(auxTimes) != 0) ;
                }
                if (secondOption == 2) {
                    Menu.newTimeMenu(auxTimes);
                }
                if (secondOption == 3) {
                    while (Menu.quitTimeMenu(auxTimes) != 0) ;
                }
                if (secondOption == 4) {
                    Menu.modifyTimeMenu(auxTimes);
                }
                if (secondOption == 5) {
                    Menu.seeCircuitMenu(auxTimes);
                }
                secondOption = 0;
            }
        }

        // Finally when the Main and Second menu, will be
        // 0 the app stops, and all the boards will be saved
        // to their respective files
        Board.boardToFile(nurbBoard, nurburFilePath);
        Board.boardToFile(monteblancoBoard, monteblancoFilePath);
        Board.boardToFile(grandTourBoard, grandTourFilePath);
        Board.boardToFile(topGearBoard, topGearFilePath);
    }


    // The following methods are only used for the first start of the program.
    // It is responsible for doing some test times and adding it to your corresponding arraylist.
    // For this reason are @Deprecated Methods

    // ONLY WILL WORK ON THE FIRST START


    @Deprecated
    public static ArrayList<Time> loadMonteblancoTimes() {

        // Instances of some test times

        Time timeOne = new Time(Circuit_Enum.MONTEBLANCO, new Car("Audi TT RS Coupe","slick"), new Racer(), 0.5137, "", false);
        Time timeTwo = new Time(Circuit_Enum.MONTEBLANCO, new Car("Renault Megane RS (Mk III)"), new Racer(), 0.54080, "wet", false);
        Time timeThree = new Time(Circuit_Enum.MONTEBLANCO, new Car("BMW M3 (E92)"), new Racer(), 0.5620, "wet", false);
        Time timeThreee = new Time(Circuit_Enum.MONTEBLANCO, new Car("Alfa Romeo Brera 3.2 JTS V6 Q4","slick"), new Racer(), 0.5680, "wet", false);

        // Instance of arrayList
        ArrayList<Time> times = new ArrayList<>();

        // And add all times to the upper arrayList

        times.add(timeOne);
        times.add(timeTwo);
        times.add(timeThree);
        times.add(timeThreee);

        return times;
    }

    @Deprecated
    public static ArrayList<Time> loadTopGearTimes() {

        // Instances of some test times
        Time timeOne = new Time(Circuit_Enum.TOP_GEAR, new Car("McLaren 675LT","slick"), new Racer(), 1.137,"wet",true);
        Time timeTwo = new Time(Circuit_Enum.TOP_GEAR, new Car("Pagani Huayra"), new Racer(), 1.138,"wet",true);
        Time timeThree = new Time(Circuit_Enum.TOP_GEAR, new Car("BAC Mono"), new Racer(), 1.143,"",false);
        Time timeFour = new Time(Circuit_Enum.TOP_GEAR, new Car("Mercedes-AMG GT R"), new Racer(), 1.16,"wet",true);

        Time timeOnee = new Time(Circuit_Enum.TOP_GEAR, new Car("Dodge Viper ACR","slick"), new Racer(), 1.151);
        Time timeTwoe = new Time(Circuit_Enum.TOP_GEAR, new Car("Lamborghini Aventador LP700-4","slick"), new Racer(), 1.165);
        Time timeThreee = new Time(Circuit_Enum.TOP_GEAR, new Car("Bugatti Veyron Super Sport"), new Racer(), 1.168);
        Time timeFoure = new Time(Circuit_Enum.TOP_GEAR, new Car("Enzo Ferrari","slick"), new Racer(), 1.19);
        Time timeOneo = new Time(Circuit_Enum.TOP_GEAR, new Car("Ferrari 458 Italia"), new Racer(), 1.191,"wet",true);
        Time timeTwoo = new Time(Circuit_Enum.TOP_GEAR, new Car("Ariel Atom 2 300"), new Racer(), 1.195);
        Time timeThreeo = new Time(Circuit_Enum.TOP_GEAR, new Car("Nissan GT-R","slick"), new Racer(), 1.197);
        Time timeFouro = new Time(Circuit_Enum.TOP_GEAR, new Car("Ferrari 430 Scuderia","slick"), new Racer(), 1.197);

        // Instance of arrayList

        ArrayList<Time> times = new ArrayList<>();


        // And add all times to the upper arrayList

        times.add(timeOne);
        times.add(timeTwo);
        times.add(timeThree);
        times.add(timeFour);
        times.add(timeOnee);
        times.add(timeTwoe);
        times.add(timeThreee);
        times.add(timeFoure);
        times.add(timeOneo);
        times.add(timeTwoo);
        times.add(timeThreeo);
        times.add(timeFouro);

        return times;
    }

    @Deprecated
    public static ArrayList<Time> loadGrandTourTimes() {

        // Instances of some test times

        Time timeOne = new Time(Circuit_Enum.GRAND_TOUR, new Car("Mclaren 675LT","slick"), new Racer(), 1.137, "", false);
        Time timeTwo = new Time(Circuit_Enum.GRAND_TOUR, new Car("Pagani Huayra"), new Racer(), 1.138, "", false);
        Time timeThree = new Time(Circuit_Enum.GRAND_TOUR, new Car("Bac Mono"), new Racer(), 1.143, "", false);
        Time timeOnet = new Time(Circuit_Enum.GRAND_TOUR, new Car("Aston Martin Vulcan"), new Racer(), 1.155, "", false);
        Time timeTwot = new Time(Circuit_Enum.GRAND_TOUR, new Car("McLaren 650S"), new Racer(), 1.179, "", false);
        Time timeThreet = new Time(Circuit_Enum.GRAND_TOUR, new Car("Nissan GT-R","slick","slick"), new Racer(), 1.212, "", false);
        Time timeTwote = new Time(Circuit_Enum.GRAND_TOUR, new Car("BMW M4 GTS"), new Racer(), 1.224, "", false);
        Time timeThreeet = new Time(Circuit_Enum.GRAND_TOUR, new Car("BMW M5"), new Racer(), 1.242, "", false);
        Time timeThreeeft = new Time(Circuit_Enum.GRAND_TOUR, new Car("Honda NSX","slick"), new Racer(), 1.26, "wet", false);
        Time timeThdsfreeeft = new Time(Circuit_Enum.GRAND_TOUR, new Car("Fiat Abarth 124 Spider","slick"), new Racer(), 1.337, "wet", false);

        // Instance of arrayList

        ArrayList<Time> times = new ArrayList<>();


        // And add all times to the upper arrayList

        times.add(timeOne);
        times.add(timeTwo);
        times.add(timeThree);
        times.add(timeOnet);
        times.add(timeTwot);
        times.add(timeThreet);
        times.add(timeThreeet);
        times.add(timeTwote);
        times.add(timeThdsfreeeft);
        times.add(timeThreeeft);

        return times;
    }

    @Deprecated
    public static ArrayList<Time> loadNurburTimes() {

        // Instances of some test times

        Time timeOne = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("NextEV Nio EP9"), new Racer(), 6.4590, "", true);
        Time timeTwo = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Radical SR8LM ","slick"), new Racer(), 6.48, "", false);
        Time timeThree = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Huracan Performante"), new Racer(), 6.5201, "", false);
        Time timeOnet = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Radical SR8","slick"), new Racer(), 6.5608, "", false);
        Time timeTwot = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Porsche 918 Spyder"), new Racer(), 6.57, "", true);
        Time timeThreet = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Nissan GT-R Nismo","slick"), new Racer(), 7.0868, "", false);
        Time timeTwote = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Mercedes-AMG GT-R"), new Racer(), 7.1092, "", true);
        Time timeThreeet = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Gumpert Apollo Speed"), new Racer(), 7.1157, "", false);
        Time timeThreeeft = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Dodge Viper SRT-10 ACR","slick"), new Racer(), 7.1213, "wet", false);
        Time timeThdsfreeeft = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Porsche 911 GT3"), new Racer(), 7.1270, "wet", true);

        // Instance of arrayList
        ArrayList<Time> times = new ArrayList<>();

        // And add all times to the upper arrayList
        times.add(timeOne);
        times.add(timeTwo);
        times.add(timeThree);
        times.add(timeOnet);
        times.add(timeTwot);
        times.add(timeThreet);
        times.add(timeThreeet);
        times.add(timeTwote);
        times.add(timeThdsfreeeft);
        times.add(timeThreeeft);

        return times;
    }
}

