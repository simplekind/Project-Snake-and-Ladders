package com.example.helloapplication;

import javafx.animation.*;
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
    @FXML
    ImageView loading ;
    Player currPlayer ;
    @FXML
    ImageView arrow ;

    static  int temp = 0;

    public DiceController(ImageView iv, Button button , Player currPlayer,ImageView loading,ImageView arrow) {
        this.diceImages=iv;
        this.dice=button;
        this.currPlayer=currPlayer ;
        this.loading=loading ;
        this.arrow = arrow ;
//        this.arrow.setImage(new Image(getClass()//.getResourceAsStream("arrow.gif")));
    }

    public int getRoll(ActionEvent event) {
        Random rand = new Random();
        int n = rand.nextInt(6); // this will generate no. from 0-5
        n++;
        Image image = new Image(getClass().getResourceAsStream("dice_roll.gif"));
        diceImages.setPreserveRatio(true);
        ScaleTransition st = new ScaleTransition(Duration.millis(800), diceImages);
        ScaleTransition st1 = new ScaleTransition(Duration.millis(500), diceImages);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(3);
        st.setToY(3);
        st1.setDelay(Duration.millis(800));
        st1.setFromX(3);
        st1.setFromY(3);
        st1.setToX(0.9);
        st1.setToY(0.9);
        st.play();

        if(n==1){
            Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("one.jpeg")))), new KeyFrame(Duration.seconds(1), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(1)));
            timeline.play();

//            diceImages.setImage();
        }
        if(n==2){
            Timeline timeline ;
            if(currPlayer.getC().getTranslateX()==0 && currPlayer.getC().getTranslateY() ==0){
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("two.jpeg")))), new KeyFrame(Duration.seconds(1), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(1)));;
            }else {
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("two.jpeg")))), new KeyFrame(Duration.seconds(1.4), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(1.4)));;
            }
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("two.jpeg")));
        }
        if(n==3){
            Timeline timeline ;
            if(currPlayer.getC().getTranslateX()==0 && currPlayer.getC().getTranslateY() ==0){
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("three.jpeg")))), new KeyFrame(Duration.seconds(1), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(1)));;
            }else {
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("three.jpeg")))), new KeyFrame(Duration.seconds(2.4), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(2.4)));;
            }
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("three.jpeg")));
        }
        if(n==4){
            Timeline timeline ;
            if(currPlayer.getC().getTranslateX()==0 && currPlayer.getC().getTranslateY() ==0){
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("four.jpeg")))), new KeyFrame(Duration.seconds(1), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(1)));;
            }else {
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("four.jpeg")))), new KeyFrame(Duration.seconds(2.9), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(2.9)));;
            }
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("four.jpeg")));1.5
        }
        if(n==5){
            Timeline timeline ;
            if(currPlayer.getC().getTranslateX()==0 && currPlayer.getC().getTranslateY() ==0){
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("five.jpeg")))), new KeyFrame(Duration.seconds(1), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(1)));;
            }else {
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("five.jpeg")))), new KeyFrame(Duration.seconds(3.6), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(3.6)));;
            }
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("five.jpeg")));
        }
        if(n==6){
            Timeline timeline ;
            if(currPlayer.getC().getTranslateX()==0 && currPlayer.getC().getTranslateY() ==0){
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("six.jpeg")))), new KeyFrame(Duration.seconds(3.6), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(3.6)));;
            }else {
                timeline = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(diceImages.imageProperty(),image), new KeyValue(arrow.imageProperty(),null)) ,new KeyFrame(Duration.seconds(1), new KeyValue(diceImages.imageProperty(),new Image(getClass().getResourceAsStream("six.jpeg")))), new KeyFrame(Duration.seconds(4.1), new KeyValue(loading.imageProperty(), new Image(getClass().getResourceAsStream("loading.gif"))),new KeyValue(arrow.imageProperty(), new Image(getClass().getResourceAsStream("arrow.gif")))),new KeyFrame(Duration.seconds(4.1)));;
            }
            timeline.play();
//            diceImages.setImage(new Image(getClass().getResourceAsStream("six.jpeg")));
        }

        st1.play();
        return n;
    }
}