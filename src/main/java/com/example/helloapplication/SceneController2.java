package com.example.helloapplication;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.Timer;

public class SceneController2  {
    private Stage stage;
    private Scene scene;
    private BorderPane root;
    private FXMLLoader loader = new FXMLLoader();

    @FXML
    ImageView image;

    public void HomePage(ActionEvent e) throws IOException {
        Parent root1 = loader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

//class timerPlayTask extends TimerTask{
//    FXMLLoader loader;
//    BorderPane root;
//    Stage stage;
//    Scene scene ;
//    timerPlayTask(FXMLLoader loader,Stage stage){
//        this.loader=loader;
////        this.root=root;
//        this.stage=stage;
//    }

    public void startGame(ActionEvent event) throws IOException{
        root =  loader.load(getClass().getResource("application.fxml").openStream()) ;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("application.css").toExternalForm() ;
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

//    @Override
//    public void run() {
//        try {
//            this.startGame();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}