package com.lappers.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by navarrocantero on 18/5/17.
 */
public class Board implements Serializable {

    private static final long serialVersionUID = 7007086254722183077L;

    private String circuitBoard;
    private ArrayList<Time> times;

    // Constructor


    public Board(ArrayList<Time> times) {
        this.circuitBoard = times.get(0).getCircuit().getCIRCUIT_NAME();
        this.times = times;
    }

    public Board(Time time) {

        ArrayList<Time> times = new ArrayList<Time>();
        this.circuitBoard = time.getCircuit().getCIRCUIT_NAME();
        times.add(time);
        this.setTimes(times);


    }

    // Accesors

    // Getters
    public String getCircuitBoard() {
        return circuitBoard;
    }

    public ArrayList<Time> getTimes() {
        return times;
    }

    // Setter

    public void setTimes(ArrayList<Time> times) {
        this.times = times;
    }

    // Helpers

    @Override
    public String toString() {
        return "board{" +
                "circuitBoard='" + circuitBoard + '\'' +
                " seeTimesMenu=" + times;
    }

    /**
     * This method  sett the gapTofirst valor to the all times on the arrayList
     * except the first (best time = 0)
     *
     * @param times ArrayList of Time
     */
    public static void calculateGapToFirst(ArrayList<Time> times) {

        double bestTime = times.get(0).getLapTime();

        for (int i = 1; i < times.size(); i++) {
            times.get(i).setGapToFirst(times.get(i).getLapTime() - bestTime);
        }


    }

    /**
     * This method first sort the Arraylist by Lap time
     * and later calculate the gap to the first
     * @param times ArrayList of Time
     */
    public static void sortAndCalculateGap(ArrayList<Time> times) {

        Collections.sort(times);
        Board.calculateGapToFirst(times);
    }

    /**
     * This method receives a board and saves in the specified path file
     *
     * @param board    Our board value
     * @param filePath Path where the board will save
     */
    public static void boardToFile(Board board, String filePath) {
        try {
            ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream(filePath));
            fos.writeObject(board);
            fos.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method receives a   path file and make a board with it
     *
     * @param filePath The path of our file
     * @return board, a new board
     */
    public static Board fileToBoard(String filePath) {
        Board board = null;

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
            try {

                board = (Board) ois.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return board;
    }
}


