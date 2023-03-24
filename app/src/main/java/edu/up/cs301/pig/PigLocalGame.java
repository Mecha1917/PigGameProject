package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;
import java.util.Random;

import android.util.Log;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState p;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        p = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (p.getId() != playerIdx) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {

        if (action instanceof PigHoldAction) {
            if (p.getId() == 0){
                p.setPlayer0Score(p.getPlayer0Score() + p.getHoldAmountValue());
            }
            else {
                p.setPlayer1Score(p.getPlayer1Score() + p.getHoldAmountValue());
            }
            return true;
        }
        else if (action instanceof PigRollAction) {
            Random random = new Random();
            int rand = random.nextInt(6) + 1;
            if (rand == 1) {
                p.setHoldAmountValue(0);
                if (p.getId() == 1){
                    p.setId(0);
                }
                else {
                    p.setId(1);
                }
            }
            p.setHoldAmountValue(rand);
            return true;
        }
        else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState pig = new PigGameState(this.p);
        p.sendInfo(pig);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (p.getPlayer0Score() >= 50){
            return "Player " + p.getId() + " with a score of " + p.getPlayer0Score();
        }
        else {
            return "Player " + p.getId() + " with a score of " + p.getPlayer1Score();
        }
    }
}// class PigLocalGame
