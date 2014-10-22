/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Danny
 */
public class Board {

    private int[][] grid;
    private int[][] solution;
    private String difficulty;

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
                if (!checkCell(i, j)) {
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
        System.out.println(""+ row + "|" + displayCell(0, row) + displayCell(1, row)
                + displayCell(2, row) + "|" + displayCell(3, row) + displayCell(4, row)
                + displayCell(5, row) + "|" + displayCell(6, row) + displayCell(7, row)
                + displayCell(8, row) + "|");
    }

    public String displayCell(int x, int y) {
        if(grid[x][y]!=0){
            String value = "" + grid[x][y];
            return value;
        }
        else
            return " ";
        }

    public void fillEasy() {
        grid[0][0] = 4;
        grid[1][0] = 9;
        grid[2][0] = 5;
        grid[5][0] = 6;
        grid[6][0] = 7;
        grid[4][1] = 9;
        grid[8][1] = 4;
        grid[1][2] = 2;
        grid[2][2] = 1;
        grid[6][2] = 8;
        grid[8][2] = 9;
        grid[0][3] = 6;
        grid[1][3] = 5;
        grid[2][3] = 3;
        grid[3][3] = 9;
        grid[4][3] = 8;
        grid[6][3] = 2;
        grid[8][3] = 1;
        grid[0][4] = 2;
        grid[3][4] = 6;
        grid[5][4] = 1;
        grid[8][4] = 7;
        grid[0][5] = 9;
        grid[2][5] = 7;
        grid[4][5] = 2;
        grid[5][5] = 3;
        grid[6][5] = 6;
        grid[7][5] = 5;
        grid[8][5] = 8;
        grid[0][6] = 5;
        grid[2][6] = 9;
        grid[6][6] = 1;
        grid[7][6] = 7;
        grid[0][7] = 7;
        grid[4][7] = 3;
        grid[2][8] = 4;
        grid[3][8] = 5;
        grid[6][8] = 9;
        grid[7][8] = 2;
        grid[8][8] = 6;

        solution[0][0] = 4;
        solution[1][0] = 9;
        solution[2][0] = 5;
        solution[3][0] = 8;
        solution[5][0] = 6;
        solution[6][0] = 7;
        solution[4][1] = 9;
        solution[8][1] = 4;
        solution[1][2] = 2;
        solution[2][2] = 1;
        solution[6][2] = 8;
        solution[8][2] = 9;
        solution[0][3] = 6;
        solution[1][3] = 5;
        solution[2][3] = 3;
        solution[3][3] = 9;
        solution[4][3] = 8;
        solution[6][3] = 2;
        solution[8][3] = 1;
        solution[0][4] = 2;
        solution[3][4] = 6;
        solution[5][4] = 1;
        solution[8][4] = 7;
        solution[0][5] = 9;
        solution[2][5] = 7;
        solution[4][5] = 2;
        solution[5][5] = 3;
        solution[6][5] = 6;
        solution[7][5] = 5;
        solution[8][5] = 8;
        solution[0][6] = 5;
        solution[2][6] = 9;
        solution[6][6] = 1;
        solution[7][6] = 7;
        solution[0][7] = 7;
        solution[4][7] = 3;
        solution[2][8] = 4;
        solution[3][8] = 5;
        solution[6][8] = 9;
        solution[7][8] = 2;
        solution[8][8] = 6;
    }

    public void fillMedium() {

    }

    public void fillHard() {

    }
}
