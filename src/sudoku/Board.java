/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Path;
import static java.nio.file.Files.write;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Danny
 */
public class Board {

    private int[][] grid;
    private int[][] solution;
    private String difficulty;
    private ArrayList<String> listGrid = new ArrayList<>();

    public void setBoard(String difficulty) {
        grid = new int[9][9];
        solution = new int[9][9];
        this.difficulty = difficulty;
        fill();
    }

    public void fill() {
        switch (difficulty) {
            case "E":
                fillEasy();
                break;
            case "M":
                fillMedium();
                break;
            case "H":
                fillHard();
                break;
            default:
                break;
        }
    }

    public void addNumber(int num, int x, int y) {
        grid[x][y] = num;
    }

    public boolean checkCell(int x, int y) {
        return (grid[x][y] == solution[x][y]);
    }

    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] != solution[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void displayGrid() {
        System.out.println("  012 345 678 ");
        System.out.println(" +---+---+---+");
        printRow(0);
        printRow(1);
        printRow(2);
        System.out.println(" |---+---+---|");
        printRow(3);
        printRow(4);
        printRow(5);
        System.out.println(" |---+---+---|");
        printRow(6);
        printRow(7);
        printRow(8);
        System.out.println(" +---+---+---+");
    }

    public void printRow(int row) {
        System.out.println("" + row + "|" + displayCell(0, row) + displayCell(1, row)
                + displayCell(2, row) + "|" + displayCell(3, row) + displayCell(4, row)
                + displayCell(5, row) + "|" + displayCell(6, row) + displayCell(7, row)
                + displayCell(8, row) + "|");
    }

    public String displayCell(int x, int y) {
        if (grid[x][y] != 0) {
            String value = "" + grid[x][y];
            return value;
        } else {
            return " ";
        }
    }

    public void writeBoard(int file) {
        int[][] flippedGrid = new int[9][9];
        String filename = "Board" + file + ".sb1";
        Path path = Paths.get("Sudoku Saves\\" + filename);
        if (Files.exists(path)) {
            System.out.println("File already exists.");
            return;
        }
        if (Files.notExists(path.getParent())) {
            try {
                Files.createDirectory(path.getParent());
            } catch (IOException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
        if (!listGrid.isEmpty()) {
            listGrid.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                flippedGrid[j][i] = grid[i][j];
            }
        }
        for (int[] j : flippedGrid) {
            listGrid.add(Arrays.toString(j));
        }
        try {
            write(path, listGrid, StandardOpenOption.CREATE_NEW);
        } catch (IOException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    public void readBoard(int file) {
        String filename = "Board" + file + ".sb1";
        Path path = Paths.get("c:\\Sudoku Saves\\" + filename);
        int[][] flippedGrid = new int[9][9];
        if (Files.notExists(path)) {
            System.out.println("File not found.");
            return;
        }
        if (!listGrid.isEmpty()) {
            listGrid.clear();
        }
        try {
            listGrid = (ArrayList<String>) readAllLines(path);
        } catch (IOException ex) {
            System.out.println("ERROR:" + ex.getMessage());
        }
        for (int j = 0; j < 9; j++) {
            String stringRow = listGrid.get(j);
            String[] stringsRow = stringRow.replaceAll("\\[", "").replaceAll("\\]", "").split(", ");
            for (int i = 0; i < 9; i++) {
                flippedGrid[j][i] = Integer.parseInt(stringsRow[i]);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[j][i] = flippedGrid[i][j];
            }
        }
    }

    public void fillEasy() {

        solution[0][0] = 4;
        solution[1][0] = 9;
        solution[2][0] = 5;
        solution[3][0] = 8;
        solution[4][0] = 1;
        solution[5][0] = 6;
        solution[6][0] = 7;
        solution[7][0] = 3;
        solution[8][0] = 2;
        solution[0][1] = 8;
        solution[1][1] = 7;
        solution[2][1] = 6;
        solution[3][1] = 3;
        solution[4][1] = 9;
        solution[5][1] = 2;
        solution[6][1] = 5;
        solution[7][1] = 1;
        solution[8][1] = 4;
        solution[0][2] = 3;
        solution[1][2] = 2;
        solution[2][2] = 1;
        solution[3][2] = 7;
        solution[4][2] = 4;
        solution[5][2] = 5;
        solution[6][2] = 8;
        solution[7][2] = 6;
        solution[8][2] = 9;
        solution[0][3] = 6;
        solution[1][3] = 5;
        solution[2][3] = 3;
        solution[3][3] = 9;
        solution[4][3] = 8;
        solution[5][3] = 7;
        solution[6][3] = 2;
        solution[7][3] = 4;
        solution[8][3] = 1;
        solution[0][4] = 2;
        solution[1][4] = 4;
        solution[2][4] = 8;
        solution[3][4] = 6;
        solution[4][4] = 5;
        solution[5][4] = 1;
        solution[6][4] = 3;
        solution[7][4] = 9;
        solution[8][4] = 7;
        solution[0][5] = 9;
        solution[1][5] = 1;
        solution[2][5] = 7;
        solution[3][5] = 4;
        solution[4][5] = 2;
        solution[5][5] = 3;
        solution[6][5] = 6;
        solution[7][5] = 5;
        solution[8][5] = 8;
        solution[0][6] = 5;
        solution[1][6] = 8;
        solution[2][6] = 9;
        solution[3][6] = 2;
        solution[4][6] = 6;
        solution[5][6] = 4;
        solution[6][6] = 1;
        solution[7][6] = 7;
        solution[8][6] = 3;
        solution[0][7] = 7;
        solution[1][7] = 6;
        solution[2][7] = 2;
        solution[3][7] = 1;
        solution[4][7] = 3;
        solution[5][7] = 9;
        solution[6][7] = 4;
        solution[7][7] = 8;
        solution[8][7] = 5;
        solution[0][8] = 1;
        solution[1][8] = 3;
        solution[2][8] = 4;
        solution[3][8] = 5;
        solution[4][8] = 7;
        solution[5][8] = 8;
        solution[6][8] = 9;
        solution[7][8] = 2;
        solution[8][8] = 6;
        readBoard(1);
    }

    public void fillMedium() {
        grid[0][0] = 1;
        grid[1][0] = 2;

        solution[0][0] = 1;
        solution[1][0] = 2;
        solution[2][0] = 3;

    }

    public void fillHard() {

    }
}
