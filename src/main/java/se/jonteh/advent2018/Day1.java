package se.jonteh.advent2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1 {

    public static void main(String[] args) {
        String path = "src/main/resources/day1-input2.txt";

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            System.out.println("Failed to instantiate FileReader for " + path);
        }
        ArrayList<Integer> inputInts = new ArrayList<>();
        try {
            String currentLine = null;
            if (reader != null) {
                currentLine = reader.readLine();
            }
            while (currentLine != null) {
                inputInts.add(Integer.valueOf(currentLine));
                currentLine = reader.readLine();
            }

            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Failed to read file at " + path);
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (NullPointerException e) {
            System.out.println("File not found at " + path);
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        ArrayList<Integer> prevFreq = new ArrayList<>();
        int currentFreq = 0;
        boolean isNotFound = true;

        while (isNotFound) {
            for (Integer inputInt : inputInts) {
                currentFreq += inputInt;
                for (Integer integer : prevFreq) {
                    if (currentFreq == integer) {
                        System.out.println("Found previous frequency: " + currentFreq);
                        isNotFound = false;
                    }
                }
                prevFreq.add(currentFreq);
            }
        }
        System.exit(0);
    }

}
