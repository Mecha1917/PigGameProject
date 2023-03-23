package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {

    //Establishes Variables
    private int playerId;
    private int player0Score;
    private int player1Score;
    private int holdAmountValue;
    private int diceValue;

    //Constructor
    public PigGameState(){
        playerId = 0;
        player0Score = 0;
        player1Score = 0;
        holdAmountValue = 0;
        diceValue = 1;
    }

    //Setter Methods
    public void setId (int i){
        playerId = i;
    }

    public void setPlayer0Score (int i){
        player0Score = i;
    }

    public void setPlayer1Score (int i) {
        player1Score = i;
    }

    public void setHoldAmountValue (int i) {
        holdAmountValue = i;
    }

    public void setDiceValue (int i) {
        diceValue = i;
    }

    //Getter Methods
    public int getId(){
        return playerId;
    }

    public int getPlayer0Score(){
        return player0Score;
    }

    public int getPlayer1Score(){
        return player1Score;
    }

    public int getHoldAmountValue(){
        return holdAmountValue;
    }

    public int getDiceValue(){
        return diceValue;
    }

    //Copy state
    public PigGameState(PigGameState p){
        playerId = p.getId();
        player0Score = p.getPlayer0Score();
        player1Score = p.getPlayer1Score();
        holdAmountValue = p.getHoldAmountValue();
        diceValue = p.getDiceValue();
    }
}
