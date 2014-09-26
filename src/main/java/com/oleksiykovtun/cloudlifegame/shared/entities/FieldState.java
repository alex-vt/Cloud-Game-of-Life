package com.oleksiykovtun.cloudlifegame.shared.entities;

import java.io.Serializable;

/**
 * The layout of the game field in a moment of time
 */
public class FieldState implements Serializable {

    private double time;
    private byte[][] cellStates;

    public FieldState() {

    }

    public FieldState(double time, int fieldWidth, int fieldHeight) {
        this.time = time;
        cellStates = new byte[fieldWidth][fieldHeight];
    }

    public void setCell(int x, int y, int state) {
        cellStates[x][y] = (byte) state;
    }

    public int getCellsCount(int state) {
        int cellsCount = 0;
        for (int i = 0; i < cellStates.length; ++i) {
            for (int j = 0; j < cellStates[0].length; ++j) {
                if (cellStates[i][j] == (int) state) {
                    ++cellsCount;
                }
            }
        }
        return cellsCount;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public byte[][] getCellStates() {
        return cellStates;
    }

    public void setCellStates(byte[][] cellStates) {
        this.cellStates = cellStates;
    }

}
