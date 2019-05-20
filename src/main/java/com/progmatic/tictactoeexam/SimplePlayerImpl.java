package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.interfaces.AbstractPlayer;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.List;

/**
 *
 * @author Kornél
 */
public class SimplePlayerImpl extends AbstractPlayer{

    public SimplePlayerImpl(PlayerType p) {
        super(p);
    }

    @Override
    public Cell nextMove(Board b) {
        List<Cell> empties = b.emptyCells();
        if(empties.isEmpty()){
            return null;
        }else{
            Cell next = empties.get(0);
            next.setCellsPlayer(myType);
            return next;
        }
    }
    
}
