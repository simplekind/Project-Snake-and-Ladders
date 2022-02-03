package com.example.helloapplication;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class RunnablePlayerThread extends Thread {

    private Player currPlayer ;
    private int roll ;
    private PlayerController playerController ;
    private Thread threadDiceAnimation ;

    public RunnablePlayerThread(Player currPlayer,int roll,PlayerController playerController, Thread threadDiceAnimation) {
        this.currPlayer = currPlayer ;
        this.roll = roll ;
        this.playerController = playerController ;
        this.threadDiceAnimation = threadDiceAnimation ;
    }

    @Override
    public void run(){
        if(currPlayer.getC().getTranslateX()==0 && currPlayer.getC().getTranslateY() ==0){
            if(roll== 1 || roll ==6 || roll>6){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TranslateTransition translate = new TranslateTransition();
                translate.setNode(currPlayer.getC());
                translate.setDuration(Duration.millis(200));
                translate.setByY(-50);
                translate.play();
                if(roll>=6){
                    this.move(this.currPlayer,roll-1);
                }else {
                    this.move(currPlayer,0);
                }
            }else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.move(currPlayer,0);
                return ;
            }
        }else{
            if(this.currPlayer.getCurrBlock().getCurrY()==450 && roll>this.currPlayer.getCurrBlock().getCurrX()/50){
                this.move(currPlayer,0);
                System.out.println("No Moves possible !");
                return;
            }else {
                this.move(this.currPlayer,roll);
            }
        }
    }

    public void move(Player player,int roll){
        playerController.setRoll(roll);
        Timer timer = new Timer() ;
        final int[] counter = {1};
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            if(roll==0){
                currPlayer.setOtherActive();
            }
            if (counter[0] <= roll) {
                    player.setActive();
                    counter[0]++;
                    playerController.getMove(player);
                } else {
                    Timer timer2 = new Timer();
                    TimerTask task2 = new MoveTask(player, playerController.getGrid(), timer2);
                    timer2.scheduleAtFixedRate(task2, 500, 500);
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task,1000,500);
    }
}