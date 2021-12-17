package com.example.helloapplication;

import javafx.event.ActionEvent;
import javafx.util.Duration;

public class ThreadDiceAnimation extends Thread {

    DiceController diceController ;
    ActionEvent event ;
    private int roll ;

    public ThreadDiceAnimation(DiceController diceController,ActionEvent event) {
        this.diceController = diceController ;
        this.event = event ;
    }

    @Override
    public void run(){
        this.roll= this.diceController.getRoll(event);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getRoll() {
        return roll;
    }
}