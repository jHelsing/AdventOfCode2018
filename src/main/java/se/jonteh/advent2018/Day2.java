package se.jonteh.advent2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Day2 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();

        ArrayList<String> task1Input = task1.readInput();
        System.out.println("Result task 1 " + task1.checksum(task1Input));

        System.exit(0);
    }


    private static class Task1 {
        private final String path = "src/main/resources/day2-input1.txt";

        int checksum(ArrayList<String> input) {
            int countTwo = 0;
            int countThree = 0;
            for (String id : input) {
                TreeSet<Character> chars = new TreeSet<>();
                for (int i = 0; i < id.length(); i++) {
                    chars.add(id.charAt(i));
                }
                System.out.println("Chars: " + chars.toString());

                Iterator<Character> iterator = chars.iterator();
                boolean countTwoNotFound = true;
                boolean countThreeNotFound = true;
                while (iterator.hasNext()) {

                    char next = iterator.next();
                    int count = 0;
                    for (int i = 0; i < id.length(); i++) {
                        if (next == id.charAt(i)) {
                            count++;
                        }
                    }
                    if (count == 2 && countTwoNotFound) {
                        countTwo++;
                        countTwoNotFound = false;
                    } else if (count == 3 && countThreeNotFound) {
                        countThree++;
                        countThreeNotFound = false;
                    }
                }
                System.out.println("ID " + id + " count2 = " + countTwo + " count3 = " + countThree);

            }
            return countTwo * countThree;
        }

        ArrayList<String> readInput() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(path));
            } catch (FileNotFoundException e) {
                System.out.println("Failed to instantiate FileReader for " + path);
            }
            ArrayList<String> strs = new ArrayList<>();
            try {
                String currentLine = null;
                if (reader != null) {
                    currentLine = reader.readLine();
                }
                while (currentLine != null) {
                    strs.add(currentLine);
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
            return strs;
        }
    }

}
