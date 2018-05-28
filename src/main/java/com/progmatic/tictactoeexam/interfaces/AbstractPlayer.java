package com.progmatic.tictactoeexam.interfaces;

import com.progmatic.tictactoeexam.enums.PlayerType;

/**
 * AbstractPlayer provides access to the Player's type via a constructor and a getter.
 * Player implementations should extend AbstarctPlayer.
 * @author pappgergely
 */
public abstract class AbstractPlayer implements Player {
    
    protected final PlayerType myType;

    public AbstractPlayer(PlayerType p) {
        if (PlayerType.EMPTY.equals(p)) {
            throw new RuntimeException("PlayerType cannot be empty in a player. It can only be empty in a cell.");
        }
        this.myType = p;
    }

    @Override
    public PlayerType getMyType() {
        return myType;
    }
}
