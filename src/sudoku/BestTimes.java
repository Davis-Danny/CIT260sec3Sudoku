/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import citbyui.cit260.sudoku.exceptions.TimeException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Files.write;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 *
 * @author Jeff and Danny
 */
public final class BestTimes {

    private static final int[] bestTimes = new int[5];

    public BestTimes() {
        readTimes();
    }

    public void reset() {
        bestTimes[0] = 1800;
        bestTimes[1] = 1200;
        bestTimes[2] = 900;
        bestTimes[3] = 600;
        bestTimes[4] = 300;
        writeTimes();
    }

    public String[] getBestTimes() {
        String output[] = new String[5];
        sortBestTimes();
        for (int c = 0; c < bestTimes.length; c++) {
            int i = bestTimes[c];
            String line = "   " + (c + 1) + ": ";
            line += formatTimes(i);
            output[c] = line;
        }
        return output;
    }

    private void sortBestTimes() {
        for (int j = 0; j <= 3; j++) {
            for (int i = j + 1; i <= 4; i++) {
                if (bestTimes[j] > bestTimes[i]) {
                    int temp = bestTimes[i];
                    bestTimes[i] = bestTimes[j];
                    bestTimes[j] = temp;
                }

            }
        }
    }

    public void addTime(int newTime) {
        sortBestTimes();
        if (newTime < bestTimes[4]) {
            bestTimes[4] = newTime;
        }
        writeTimes();
    }

    public void readTimes() {
        ArrayList<String> bestTimesStringList;
        Path path = Paths.get("Sudoku Saves\\BestTimes");
        if (Files.notExists(path)) {
            reset();
            writeTimes();
            return;
        }
        try {
            bestTimesStringList = (ArrayList<String>) readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            bestTimes[i] = Integer.parseInt(bestTimesStringList.get(i));
        }
    }

    public void writeTimes() {
        Path path = Paths.get("Sudoku Saves\\BestTimes");
        ArrayList<String> stringList = new ArrayList();

        try {
            Files.delete(path);
        } catch (IOException x) {
            System.out.print("ERROR: " + x.getMessage());
        }
        if (!stringList.isEmpty()) {
            stringList.clear();
        }
        for (int i = 0; i < 5; i++) {
            stringList.add(Integer.toString(bestTimes[i]));
        }
        try {
            write(path, stringList, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    public static String formatTimes(int i) {
        String line = "";
        if ((i / 360) < 10) {
            line += "0";
        }
        line += i / 360 + ":";

        if (((i % 360) / 60) < 10) {
            line += "0";
        }
        line += (i % 360) / 60 + ":";

        if ((i % 60) < 10) {
            line += "0";
        }
        line += (i % 60);
        return line;
    }

}
