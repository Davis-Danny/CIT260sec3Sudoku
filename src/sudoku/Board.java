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
public class Board implements java.io.Serializable {

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

    private void fill() {
        switch (difficulty) {
            case "E":
                readBoards(1);
                break;
            case "M":
                readBoards(2);
                break;
            case "H":
                readBoards(3);
                break;
            default:
                break;
        }
    }

    public void addNumber(int num, int x, int y) {
        grid[x][y] = num;
    }

    private boolean checkCell(int x, int y) {
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

    private void printRow(int row) {
        System.out.println("" + row + "|" + displayCell(0, row) + displayCell(1, row)
                + displayCell(2, row) + "|" + displayCell(3, row) + displayCell(4, row)
                + displayCell(5, row) + "|" + displayCell(6, row) + displayCell(7, row)
                + displayCell(8, row) + "|");
    }

    private String displayCell(int x, int y) {
        if (grid[x][y] != 0) {
            String value = "" + grid[x][y];
            return value;
        } else {
            return " ";
        }
    }

    private void writeBoard(int file, String type) {
        int[][] board = checkType(type);
        int[][] flippedGrid = new int[9][9];
        String filename = "Board" + file + "-" + type + ".sb2";
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
                flippedGrid[j][i] = board[i][j];
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

    private void readBoard(int file, String type) {
        int[][] board = checkType(type);
        String filename = "Board" + file + "-" + type + ".sb2";
        Path path = Paths.get("Sudoku Saves\\" + filename);
        int[][] flippedGrid = new int[9][9];
        if (Files.notExists(path)) {
            System.out.println("File " + path + "not found.");
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
                board[j][i] = flippedGrid[i][j];
            }
        }
    }

    private int[][] checkType(String type) {
        switch (type) {
            case "grid":
                return grid;
            case "solution":
                return solution;
            default:
                System.out.println("ERROR: Invalid type sent to writeBoard: " + type + " recieved.");
                return new int[9][9];
        }
    }

    private void readBoards(int file) {
        readBoard(file, "solution");
        readBoard(file, "grid");
    }

}
