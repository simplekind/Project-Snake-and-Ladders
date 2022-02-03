package com.example.helloapplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
// inheritance
public class ThreadDiceAnimation extends Thread {
    private DiceController diceController ;
    private ActionEvent event ;
    private int roll ;
    private PlayerController playerController ;
    private Player currPlayer ;
    public ThreadDiceAnimation(DiceController diceController,ActionEvent event,Player currPlayer,PlayerController playerController) {
        this.diceController = diceController ;
        this.event = event ;
        this.playerController=playerController;
        this.currPlayer =currPlayer ;
    }
    public ThreadDiceAnimation(DiceController diceController,Player currPlayer,PlayerController playerController) {
        this.diceController = diceController ;
        this.playerController=playerController;
        this.currPlayer =currPlayer ;
    }
    @Override
    public void run(){
        if(event==null) this.roll = 0 ;
        else this.roll= this.diceController.getRoll(event);
        // instead of creating a class with interface we made a new class here
        Platform.runLater(new RunnablePlayerThread(this.currPlayer,this.roll,this.playerController,this));
    }
    public int getRoll() {
        return roll;
    }
}