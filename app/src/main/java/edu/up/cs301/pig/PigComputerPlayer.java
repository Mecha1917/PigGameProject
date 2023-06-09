package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;
import java.util.Random;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState pig = (PigGameState) info;
        if (pig.getId() != 1){
            return;
        }
        else {
            Random random = new Random();
            boolean rand = random.nextBoolean();
            if (rand == true){
                game.sendAction(new PigHoldAction(this));
            }
            else {
                game.sendAction(new PigRollAction(this));
            }
        }
        sleep(200);
    }//receiveInfo
}
