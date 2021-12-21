package com.example.helloapplication;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerController {

    private Block grid [][] ;
    private int roll ;

    @FXML
    ImageView boardImgView;

    @FXML
    ImageView winnerView;

    public PlayerController(Block grid [][],ImageView boardImgView, ImageView winnerView ) {
        this.grid = grid ;
        this.winnerView = winnerView;
        this.boardImgView = boardImgView;
    }

    public void getMove(Player p){
//        System.out.println("getMove Player 1 = "+p);
        TranslateTransition translateTransition = new TranslateTransition() ;
        TranslateTransition translateTransition1 = new TranslateTransition() ;
        TranslateTransition translate = new TranslateTransition();
        translateTransition.setNode(p.getC());
        translateTransition1.setNode(p.getC());
        translate.setNode(p.getC());

        translate.setDuration(Duration.millis(500));
        translateTransition.setDuration(Duration.millis(250));
        translateTransition1.setDuration(Duration.millis(250));

        translateTransition.setDelay(Duration.millis(100));
        translateTransition1.setDelay(Duration.millis(100));

        System.out.println();
        translateTransition.setFromY(p.getC().getTranslateY());
        translateTransition.setToY(p.getC().getTranslateY()-25);

        translate.setByX(p.getCurrBlock().getNextX()-p.getCurrBlock().getCurrX());
        translate.setByY(p.getCurrBlock().getCurrY() - p.getCurrBlock().getNextY());
        System.out.println(p.getC().getCenterY());


//        translateTransition.setAutoReverse(true);
//        translateTransition1.setAutoReverse(true);

        System.out.println("p.getCurrBlock().getNextX() = "+ p.getCurrBlock().getNextX());
        System.out.println("p.getCurrBlock().getNextX() = "+ p.getC().getTranslateZ());
        System.out.println("p.getCurrBlock().getNextY() = "+ p.getCurrBlock().getNextY());

        p.setCurrBlock(this.grid[(p.getCurrBlock().getNextY())/50][(p.getCurrBlock().getNextX())/50]);

        translateTransition.setFromY(p.getC().getTranslateY()-25);
        translateTransition.setToY(p.getC().getTranslateY());

        translate.play();
        translateTransition.play();
        translateTransition1.play();
        this.roll--;
//        System.out.println(p.getCurrBlock().getCurrY() + " || || "+ p.getCurrBlock().getCurrX());
        if(p.getCurrBlock().getCurrY()==450 && p.getCurrBlock().getCurrX()==0){
            if(p.getBoxState()==0){
                System.out.println("Player 1 Won!");
                winnerView.setImage(new Image(getClass().getResourceAsStream("player1.png")));
                winner();
            }else{
                System.out.println("Player 2 Won!");
                winnerView.setImage(new Image(getClass().getResourceAsStream("player2.png")));
                winner();
            }
            return;
        }
//        if(roll==0){
//            Timer timer = new Timer();
//            TimerTask task = new MoveTask(p,this.grid);
//            timer.scheduleAtFixedRate(task,800,800);
//        }
    }
    public void winner(){
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000),boardImgView);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.4f);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();
    }



    public void setRoll(int roll){
        this.roll=roll;
    }

    public int getRoll(){
        return this.roll;
    }

    public Block[][] getGrid() {
        return grid;
    }
}