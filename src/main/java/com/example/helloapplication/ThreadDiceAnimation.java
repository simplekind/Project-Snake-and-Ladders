package com.example.helloapplication;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class ThreadDiceAnimation extends Thread {

    DiceController diceController ;
    ActionEvent event ;
    private int roll ;
    PlayerController playerController ;
    Player currPlayer ;

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
        Platform.runLater(new RunnablePlayerThread(this.currPlayer,this.roll,this.playerController,this));

//        currentThread().interrupt();
    }

    public int getRoll() {
        return roll;
    }
}