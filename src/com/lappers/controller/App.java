package com.lappers.controller;

import com.lappers.model.board.Board;
import com.lappers.model.car.Car;
import com.lappers.model.circuit.Circuit_Enum;
import com.lappers.model.racer.Racer;
import com.lappers.model.time.Time;
import com.lappers.view.Menu;

import java.util.ArrayList;


public class App {


    public static void main(String[] args) {
        ReadAFile rf = new ReadAFile();
        String firstRunFilePath = "src/res/fr.dat";
        String nurburFilePath = "src/res/nurbur.dat";
        String topGearFilePath = "src/res/topgear.dat";
        String grandTourFilePath = "src/res/grandtour.dat";
        String monteblancoFilePath = "src/res/monteblanco.dat";

        if (!(rf.canRead(firstRunFilePath))) {
            Board monteblancoBoard = new Board(loadMonteblancoTimes());
            Board nurbBoard = new Board(loadNurburTimes());
            Board topGearBoard = new Board(loadTopGearTimes());
            Board grandTourBoard = new Board(loadGrandTourTimes());
            Board.boardToFile(null,firstRunFilePath);
            Board.boardToFile(nurbBoard, nurburFilePath);
            Board.boardToFile(monteblancoBoard, monteblancoFilePath);
            Board.boardToFile(grandTourBoard, grandTourFilePath);
            Board.boardToFile(topGearBoard, topGearFilePath);
        }


        Board nurbBoard = Board.fileToBoard(nurburFilePath);
        Board topGearBoard = Board.fileToBoard(topGearFilePath);
        Board grandTourBoard = Board.fileToBoard(grandTourFilePath);
        Board monteblancoBoard = Board.fileToBoard(monteblancoFilePath);


        int secondOption;
        int option;
        ArrayList<Time> auxTimes = new ArrayList<Time>();

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

            while ((secondOption = Menu.secondMenu(auxTimes)) != 0) {

                if (secondOption == 1) {
                    while (Menu.seeTimesMenu(auxTimes) != 0) ;
                }
                if (secondOption == 2) {
                    Menu.addTimeMenu(auxTimes);
                }
                if (secondOption == 3) {
                    while (Menu.quitTimeMenu(auxTimes) != 0) ;
                }
                if (secondOption == 4) {
                    Menu.seeCircuitMenu(auxTimes);
                }
                secondOption = 0;
            }
        }
        Board.boardToFile(nurbBoard, nurburFilePath);
        Board.boardToFile(monteblancoBoard, monteblancoFilePath);
        Board.boardToFile(grandTourBoard, grandTourFilePath);
        Board.boardToFile(topGearBoard, topGearFilePath);
    }



    // Only for the first run and make files

    @Deprecated
    public static ArrayList<Time> loadMonteblancoTimes() {


        Time timeOne = new Time(Circuit_Enum.MONTEBLANCO, new Car("Audi TT RS Coupe"), new Racer(), 0.5137, "wet", false);
        Time timeTwo = new Time(Circuit_Enum.MONTEBLANCO, new Car("Renault Megane RS (Mk III)"), new Racer(), 0.54080, "wet", false);
        Time timeThree = new Time(Circuit_Enum.MONTEBLANCO, new Car("BMW M3 (E92)"), new Racer(), 0.5620, "wet", false);
        Time timeThreee = new Time(Circuit_Enum.MONTEBLANCO, new Car("Alfa Romeo Brera 3.2 JTS V6 Q4"), new Racer(), 0.5680, "wet", false);


        ArrayList<Time> times = new ArrayList<>();


        times.add(timeOne);
        times.add(timeTwo);
        times.add(timeThree);
        times.add(timeThreee);

        return times;
    }

    @Deprecated
    public static ArrayList<Time> loadTopGearTimes() {


        Time timeOne = new Time(Circuit_Enum.TOP_GEAR, new Car("McLaren 675LT"), new Racer(), 1.137);
        Time timeTwo = new Time(Circuit_Enum.TOP_GEAR, new Car("Pagani Huayra"), new Racer(), 1.138);
        Time timeThree = new Time(Circuit_Enum.TOP_GEAR, new Car("BAC Mono"), new Racer(), 1.143);
        Time timeFour = new Time(Circuit_Enum.TOP_GEAR, new Car("Mercedes-AMG GT R"), new Racer(), 1.16);

        Time timeOnee = new Time(Circuit_Enum.TOP_GEAR, new Car("Dodge Viper ACR"), new Racer(), 1.151);
        Time timeTwoe = new Time(Circuit_Enum.TOP_GEAR, new Car("Lamborghini Aventador LP700-4"), new Racer(), 1.165);
        Time timeThreee = new Time(Circuit_Enum.TOP_GEAR, new Car("Bugatti Veyron Super Sport"), new Racer(), 1.168);
        Time timeFoure = new Time(Circuit_Enum.TOP_GEAR, new Car("Enzo Ferrari"), new Racer(), 1.19);
        Time timeOneo = new Time(Circuit_Enum.TOP_GEAR, new Car("Ferrari 458 Italia"), new Racer(), 1.191);
        Time timeTwoo = new Time(Circuit_Enum.TOP_GEAR, new Car("Ariel Atom 2 300"), new Racer(), 1.195);
        Time timeThreeo = new Time(Circuit_Enum.TOP_GEAR, new Car("Nissan GT-R"), new Racer(), 1.197);
        Time timeFouro = new Time(Circuit_Enum.TOP_GEAR, new Car("Ferrari 430 Scuderia"), new Racer(), 1.197);


        ArrayList<Time> times = new ArrayList<>();


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


        Time timeOne = new Time(Circuit_Enum.GRAND_TOUR, new Car("Mclaren 675LT"), new Racer(), 1.137, "", false);
        Time timeTwo = new Time(Circuit_Enum.GRAND_TOUR, new Car("Pagani Huayra"), new Racer(), 1.138, "", false);
        Time timeThree = new Time(Circuit_Enum.GRAND_TOUR, new Car("Bac Mono"), new Racer(), 1.143, "", false);
        Time timeOnet = new Time(Circuit_Enum.GRAND_TOUR, new Car("Aston Martin Vulcan"), new Racer(), 1.155, "", false);
        Time timeTwot = new Time(Circuit_Enum.GRAND_TOUR, new Car("McLaren 650S"), new Racer(), 1.179, "", false);
        Time timeThreet = new Time(Circuit_Enum.GRAND_TOUR, new Car("Nissan GT-R"), new Racer(), 1.212, "", false);
        Time timeTwote = new Time(Circuit_Enum.GRAND_TOUR, new Car("BMW M4 GTS"), new Racer(), 1.224, "", false);
        Time timeThreeet = new Time(Circuit_Enum.GRAND_TOUR, new Car("BMW M5"), new Racer(), 1.242, "", false);
        Time timeThreeeft = new Time(Circuit_Enum.GRAND_TOUR, new Car("Honda NSX"), new Racer(), 1.26, "wet", false);
        Time timeThdsfreeeft = new Time(Circuit_Enum.GRAND_TOUR, new Car("Fiat Abarth 124 Spider"), new Racer(), 1.337, "wet", false);

        ArrayList<Time> times = new ArrayList<>();


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


        Time timeOne = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("NextEV Nio EP9"), new Racer(), 6.4590, "", false);
        Time timeTwo = new Time(Circuit_Enum.NORDSCHLEIFE, new Car(" Radical SR8LM "), new Racer(), 6.48, "", false);
        Time timeThree = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Huracan Performante"), new Racer(), 6.5201, "", false);
        Time timeOnet = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Radical SR8"), new Racer(), 6.5608, "", false);
        Time timeTwot = new Time(Circuit_Enum.NORDSCHLEIFE, new Car(" Porsche 918 Spyder"), new Racer(), 6.57, "", false);
        Time timeThreet = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Nissan GT-R Nismo"), new Racer(), 7.0868, "", false);
        Time timeTwote = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Mercedes-AMG GT-R"), new Racer(), 7.1092, "", false);
        Time timeThreeet = new Time(Circuit_Enum.NORDSCHLEIFE, new Car(" Gumpert Apollo Speed"), new Racer(), 7.1157, "", false);
        Time timeThreeeft = new Time(Circuit_Enum.NORDSCHLEIFE, new Car("Dodge Viper SRT-10 ACR"), new Racer(), 7.1213, "wet", false);
        Time timeThdsfreeeft = new Time(Circuit_Enum.NORDSCHLEIFE, new Car(" Porsche 911 GT3"), new Racer(), 7.1270, "wet", false);

        ArrayList<Time> times = new ArrayList<>();


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

