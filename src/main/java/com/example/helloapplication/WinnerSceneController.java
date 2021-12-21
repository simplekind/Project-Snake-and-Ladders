package com.example.helloapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class WinnerSceneController {

    private Stage stage;
    private Scene scene;
    private BorderPane root1;
    private Parent root;
    private FXMLLoader loader = new FXMLLoader();

    @FXML
    Button button2;

    @FXML
    Label label1;
    @FXML
    Label label2;

    public void PlayAgain(ActionEvent e) throws IOException {
        Parent root = loader.load(getClass().getResource("PlayerFinder.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Menu(ActionEvent e) throws IOException {
        Parent root = loader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void popUp(ActionEvent e){
//        final Stage stage1 = new Stage();
//        stage1.initModality(Modality.APPLICATION_MODAL);
//        stage1.initOwner(stage);
//        VBox box = new VBox(40);
//        box.getChildren().add(new Image(getClass().getResourceAsStream("Winner2.png")));
//        stage1.setScene(box);
//        stage1.show();
//    }

    public void winning(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root =  loader.load(getClass().getResource("Winner.fxml")) ;
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
