package com.example.helloapplication;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class MoveTask extends TimerTask {
    Player p;
    Block currBlock ;
    Block nxtBlock ;
    Block [][] grid ;
    Timer timer2 ;

    public MoveTask(Player p, Block [][] grid, Timer timer2 ){
        this.p=p;
        this.grid=grid ;
        this.timer2=timer2;
    }

    public void getMove(Player p,Block currBlock ,Block nxtBlock,int flag){
        if(flag==0){
            p.setOtherActive();
            timer2.cancel();
            return;
        }
        p.setCurrBlock(currBlock);
        TranslateTransition translateTransition = new TranslateTransition() ;
        TranslateTransition translateTransition1 = new TranslateTransition() ;
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(p.getC());
        translateTransition.setNode(p.getC());
        translateTransition1.setNode(p.getC());
//            translate.setDelay(Duration.millis(1000));
        translate.setDuration(Duration.millis(500));

        translateTransition.setDuration(Duration.millis(250));
        translateTransition1.setDuration(Duration.millis(250));

        translateTransition.setDuration(Duration.millis(100));
        translateTransition1.setDuration(Duration.millis(100));
        System.out.println();
        translate.setByX(nxtBlock.getCurrX()-p.getCurrBlock().getCurrX());
        translate.setByY(p.getCurrBlock().getCurrY() - nxtBlock.getCurrY());

        translateTransition.setFromY(p.getC().getTranslateY());
        translateTransition.setToY(p.getC().getTranslateY()-25);
        translateTransition.setFromY(p.getC().getTranslateY()-25);
        translateTransition.setToY(p.getC().getTranslateY());

        translateTransition.setCycleCount(2);
        translateTransition1.setCycleCount(2);

        System.out.println(p.getC().getCenterY());
        System.out.println("p.getCurrBlock().getNextX() = "+ nxtBlock.getCurrX());
        System.out.println("p.getCurrBlock().getNextY() = "+ nxtBlock.getCurrY());
        p.setCurrBlock(this.grid[(nxtBlock.getCurrY())/50][(nxtBlock.getCurrX())/50]);
//        p.setOtherActive();
        translate.play();
        translateTransition.play();
        translateTransition1.play();
        p.setOtherActive();
        timer2.cancel();
    }

    public void moveOnfurther(Player p){
        // For ladders
        if(p.getCurrBlock()==grid[0][1]){
            this.getMove(p,grid[0][1],grid[2][0],1);
        }else if (p.getCurrBlock()== grid[0][5]){
            this.getMove(p,grid[0][5],grid[2][6],1);
        }else if (p.getCurrBlock()== grid[0][7]){
            this.getMove(p,grid[0][7],grid[3][7],1);
        }else if (p.getCurrBlock()== grid[1][4]){
            this.getMove(p,grid[1][4],grid[3][6],1);
        }else if (p.getCurrBlock()== grid[2][3]){
            this.getMove(p,grid[2][3],grid[6][3],1);
        }else if (p.getCurrBlock()== grid[3][2]){
            this.getMove(p,grid[3][2],grid[5][2],1);
        }else if (p.getCurrBlock()== grid[6][2]){
            this.getMove(p,grid[6][2],grid[8][1],1);
        }else if (p.getCurrBlock()== grid[6][9]){
            this.getMove(p,grid[6][9],grid[9][9],1);
        }else if (p.getCurrBlock()== grid[7][7]){
            this.getMove(p,grid[7][7],grid[9][6],1);
        }else if (p.getCurrBlock()== grid[8][4]){
            this.getMove(p,grid[8][4],grid[9][3],1);
        }
        // Now for snake bites
        else if (p.getCurrBlock()== grid[2][2]){
            this.getMove(p,grid[2][2],grid[0][4],1);
        }else if (p.getCurrBlock()== grid[3][8]){
            this.getMove(p,grid[3][8],grid[0][8],1);
        }else if (p.getCurrBlock()== grid[4][5]){
            this.getMove(p,grid[4][5],grid[2][4],1);
        }else if (p.getCurrBlock()== grid[5][9]){
            this.getMove(p,grid[5][9],grid[1][9],1);
        }else if (p.getCurrBlock()== grid[5][1]){
            this.getMove(p,grid[5][1],grid[3][0],1);
        }else if (p.getCurrBlock()== grid[6][5]){
            this.getMove(p,grid[6][5],grid[5][4],1);
        }else if (p.getCurrBlock()== grid[8][0]){
            this.getMove(p,grid[8][0],grid[6][1],1);
        }else if (p.getCurrBlock()== grid[9][8]){
            this.getMove(p,grid[9][8],grid[4][7],1);
        }else if (p.getCurrBlock()== grid[9][5]){
            this.getMove(p,grid[9][5],grid[5][6],1);
        }else if (p.getCurrBlock()== grid[9][2]){
            this.getMove(p,grid[9][2],grid[6][4],1);
        }else {
            this.getMove(p,null,null,0);
        }
    }

    @Override
    public void run() {
        this.moveOnfurther(p);
    }
}