package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.exceptions.CellException;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kornél
 */
public class BoardImpl implements Board{

    private final Cell[][] board;
    private static final int ROW_COUNT = 3;
    private static final int COL_COUNT = 3;

    public BoardImpl() {
        this.board = new Cell[ROW_COUNT][COL_COUNT];
        for (int i = 0; i < COL_COUNT; i++) {
            for (int j = 0; j < ROW_COUNT; j++) {
                this.board[i][j] = new Cell(i, j);
            }
        }
    }

    @Override
    public PlayerType getCell(int rowIdx, int colIdx) throws CellException {
        if ((rowIdx >= ROW_COUNT || rowIdx < 0)
                || (colIdx >= COL_COUNT || colIdx < 0)) {
            throw new CellException(rowIdx, colIdx, "The cell is not on the board!");
        }
        return board[rowIdx][colIdx].getCellsPlayer();

    }

    @Override
    public void put(Cell cell) throws CellException {

        if (getCell(cell.getRow(), cell.getCol()) != PlayerType.EMPTY) {
            throw new CellException(cell.getRow(), cell.getCol(), "The cell is already occupied");
        } else {
            this.board[cell.getRow()][cell.getCol()].setCellsPlayer(cell.getCellsPlayer());
        }

    }

    @Override
    public boolean hasWon(PlayerType p) {
        
        if(p==PlayerType.EMPTY){
            return false;
        }
        
        int sum = 0;
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COL_COUNT; j++) {
                if (board[i][j].getCellsPlayer() == p) {
                    sum++;
                }
            }
            if (sum == 3) {
                return true;
            }
            sum = 0;
        }
        for (int i = 0; i < COL_COUNT; i++) {
            for (int j = 0; j < ROW_COUNT; j++) {
                if (board[j][i].getCellsPlayer() == p) {
                    sum++;
                }
            }
            if (sum == 3) {
                return true;
            }
            sum = 0;
        }
        for (int i = 0; i < ROW_COUNT; i++) {
            if (board[i][i].getCellsPlayer() == p) {
                sum++;
            }
        }
        if (sum == 3) {
            return true;
        }
        sum = 0;

        for (int i = 0; i < ROW_COUNT; i++) {
            if (board[ROW_COUNT - 1 - i][i].getCellsPlayer() == p) {
                sum++;
            }
        }
        if (sum == 3) {
            return true;
        }

        return false;
    }

    @Override
    public List<Cell> emptyCells() {

        List<Cell> empties = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getCellsPlayer() == PlayerType.EMPTY) {
                    empties.add( new Cell(i, j) );
                }
            }
        }
        return empties;
    }

}
