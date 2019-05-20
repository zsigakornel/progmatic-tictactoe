package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.exceptions.CellException;
import com.progmatic.tictactoeexam.interfaces.AbstractPlayer;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kornél
 */
public class VictoryAwarePlayerImpl extends AbstractPlayer{

    public VictoryAwarePlayerImpl(PlayerType p) {
        super(p);
    }

    @Override
    public Cell nextMove(Board b) {
        List<Cell> empties = b.emptyCells();
        
        if(empties.isEmpty()){
            return null;
        }
        
        for (Cell empty : empties) {
            if(wouldIWinIfIPutMyMarkHere(empty, b)){
                empty.setCellsPlayer(myType);
                return empty;
            }
        }
        Cell next = empties.get(0);
        next.setCellsPlayer(myType);
        return next;
        
        
    }
    
    private boolean wouldIWinIfIPutMyMarkHere(Cell c, Board b){
        Board clone = cloneBoard(b);
        try {
            c.setCellsPlayer(myType);
            clone.put(c);
        } catch (CellException ex) {
            return false;
        }
        return clone.hasWon(myType);
    }
    
    private Board cloneBoard(Board b){
        Board clone = new BoardImpl();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    clone.put( new Cell (i, j, b.getCell(i, j)) );
                } catch (CellException ex) {
                    Logger.getLogger(VictoryAwarePlayerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return clone;
    }
    
}
