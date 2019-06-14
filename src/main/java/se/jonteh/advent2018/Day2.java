package se.jonteh.advent2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();

        String task1Input = task1.readInput();
        System.out.println("Result task 1 " + task1.checksum(task1Input));

        System.exit(0);
    }


    private static class Task1 {
        private final String path = "src/main/resources/day2-input1.txt";

        int checksum(String input) {
            // TODO Implement solution
            return -1;
        }

        String readInput() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
                System.out.println("Failed to instantiate FileReader for " + path);
            }
            StringBuilder builder = new StringBuilder();
            try {
                String currentLine = null;
                if (reader != null) {
                    currentLine = reader.readLine();
                }
                while (currentLine != null) {
                    builder.append(currentLine);
                    builder.append("\n");
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
            return builder.toString();
        }
    }

}
