/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Path;
import static java.nio.file.Files.write;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
    
    public void edit(){
        setBoard("A");
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
            case "A":
                buildBoard();
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
                return checkCell(i, j);
            }
        }
        return true;
    }

    public void buildBoard() {
        int file;
        Scanner input = new Scanner(System.in);
        print("Board number:");
        file = Integer.parseInt(input.next());
        readBoards(file);
        displayGrid();
        while (playGrid());
        writeBoard(file, "grid", true);
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = solution[i][j];
                }
            }
        }
        print("Input solution values");
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (grid[i][j] == 0) {
                    displayGrid();
                    print("Insert solution value for: " + i + "," + j);
                    addNumber(Integer.parseInt(input.next()), i, j);
                }
            }
        }
        displayGrid();
        while (playGrid());
        solution = grid;
        writeBoard(file, "solution", true);
    }

    public void print(String output) {
        System.out.println(output);
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

    private void writeBoard(int file, String type, boolean replace) {
        int[][] board = checkType(type);
        int[][] flippedGrid = new int[9][9];
        String filename = "Board" + file + "-" + type + ".sb2";
        Path path = Paths.get("Sudoku Saves\\" + filename);
        if (Files.exists(path)) {
            System.out.println("File already exists.");
            if (!replace) {
                print("canceling");
                return;
            } else {
                print("overriding");
                try {
                    Files.delete(path);
                } catch (IOException x) {
                    print("ERROR: " + x.getMessage());
                }
            }
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
            write(path, listGrid, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
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
            listGrid = (ArrayList<String>) readAllLines(path,StandardCharsets.UTF_8);
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

    public boolean playGrid() {
        Scanner input = new Scanner(System.in);
        String command;
        int x;
        int y;
        int value;
        System.out.println("Column:");
        command = input.next();
        command = command.trim().toUpperCase();
        if ("Q".equals(command)) {
            ExitMenuView exit = new ExitMenuView();
            if (exit.getIntake()) {
                return false;
            } else {
                displayGrid();
                return true;
            }
        }
        x = Integer.parseInt(command);
        if (x < 0 || x > 8) {
            System.out.println("ERROR: Invalid X value");
            return true;
        }
        System.out.println("Row:");
        y = Integer.parseInt(input.next());
        if (y < 0 || y > 8) {
            System.out.println("ERROR: Invalid Y value");
            return true;
        }
        System.out.println("Value:");
        value = Integer.parseInt(input.next());
        if (value < 0 || value > 9) {
            System.out.println("ERROR: Invalid value");
            return true;
        }
        addNumber(value, x, y);
        displayGrid();
        return true;
    }
}
