package com.example.helloapplication;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class PlayerController {

    private Block grid [][] ;
    private int roll ;

    public PlayerController(Block grid [][] ) {
        this.grid = grid ;
    }

    public void getMove(Player p){
//        System.out.println("getMove Player 1 = "+p);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(p.getC());
        translate.setDuration(Duration.millis(500));
//        translate.setCycleCount(TranslateTransition.INDEFINITE);

        System.out.println();
        translate.setByX(p.getCurrBlock().getNextX()-p.getCurrBlock().getCurrX());
        translate.setByY(p.getCurrBlock().getCurrY() - p.getCurrBlock().getNextY());
        System.out.println(p.getC().getCenterY());
//        p.setPrevX(p.getCurrBlock().getNextX());
//        p.setPrevY(p.getCurrBlock().getCurrY());

        System.out.println("p.getCurrBlock().getNextX() = "+ p.getCurrBlock().getNextX());
        System.out.println("p.getCurrBlock().getNextY() = "+ p.getCurrBlock().getNextY());

//        translate.setAutoReverse(true);
        p.setCurrBlock(this.grid[(p.getCurrBlock().getNextY())/50][(p.getCurrBlock().getNextX())/50]);
        translate.play();
        this.roll--;
    }

    public void setRoll(int roll){
        this.roll=roll;
    }

    public int getRoll(){
        return this.roll;
    }
}