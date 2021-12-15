package com.example.helloapplication;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class DiceController{
    @FXML
    ImageView diceImages ;
    @FXML
    Button dice;

    public DiceController(ImageView iv, Button button) {
        this.diceImages=iv;
        this.dice=button;
    }

    public int getRoll(ActionEvent event) {
        Random rand = new Random();
        int n = rand.nextInt(6); // this will generate no. from 0-5
        n++;
        Image image1 = this.diceImages.getImage();
        if(n==1){
            Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(), image1)),new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("one.jpeg")))),new KeyFrame(Duration.seconds(5), new KeyValue(diceImages.imageProperty(), new Image(getClass().getResourceAsStream("dice_roll.gif")))));
            timeline.play();
//            diceImages.setImage();
        }
        if(n==2){
            Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(), image1)),new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("two.jpeg")))),new KeyFrame(Duration.seconds(5), new KeyValue(diceImages.imageProperty(), new Image(getClass().getResourceAsStream("dice_roll.gif")))));
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("two.jpeg")));
        }
        if(n==3){
            Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(), image1)),new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("three.jpeg")))),new KeyFrame(Duration.seconds(5), new KeyValue(diceImages.imageProperty(), new Image(getClass().getResourceAsStream("dice_roll.gif")))));
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("three.jpeg")));
        }
        if(n==4){
            Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(), image1)),new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("four.jpeg")))),new KeyFrame(Duration.seconds(5), new KeyValue(diceImages.imageProperty(), new Image(getClass().getResourceAsStream("dice_roll.gif")))));
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("four.jpeg")));1
        }
        if(n==5){
            Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(), image1)),new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("five.jpeg")))),new KeyFrame(Duration.seconds(5), new KeyValue(diceImages.imageProperty(), new Image(getClass().getResourceAsStream("dice_roll.gif")))));
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("five.jpeg")));
        }
        if(n==6){
            Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(), image1)),new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("six.jpeg")))),new KeyFrame(Duration.seconds(5), new KeyValue(diceImages.imageProperty(), new Image(getClass().getResourceAsStream("dice_roll.gif")))));
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("six.jpeg")));
        }
        return n;
    }
}