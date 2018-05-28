package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;

/**
 * Represents  cell on a tic-tac-toe Board.
 * A cell represented by it's row number, column number and if it is occupied by X, or O or it is an empty cell.
 * @author pappgergely
 */
public class Cell {
    private final int row;
    private final int col;
    private PlayerType cellsPlayer;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellsPlayer = PlayerType.EMPTY;
    }

    public Cell(int row, int col, PlayerType cellsPlayer) {
        this.row = row;
        this.col = col;
        this.cellsPlayer = cellsPlayer;
    }
    
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public PlayerType getCellsPlayer() {
        return cellsPlayer;
    }

    public void setCellsPlayer(PlayerType cellState) {
        this.cellsPlayer = cellState;
    }

    @Override
    public String toString() {
        return "Cell{" + "row=" + row + ", col=" + col + ", cellState=" + cellsPlayer + '}';
    }     
}
