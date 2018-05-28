package com.progmatic.tictactoeexam.interfaces;

import com.progmatic.tictactoeexam.Cell;
import com.progmatic.tictactoeexam.enums.PlayerType;

/**
 *
 * @author pappgergely
 */
public interface Player {
    /**
     * Returns the player's next move.
     * This method should not modify the parameter b.
     * @param b
     * @return the player's next move. The returned cell should be an empty cell on b.
     * If there are no more possible moves returns null.
     */
    Cell nextMove(Board b);
    
    /**
     * Returns the PlayerType associated with this Player.
     * It should be either PlayerType.X or PlayerType.O,
     * @return the PlayerType associated with this Player.
     */
    PlayerType getMyType();
}
