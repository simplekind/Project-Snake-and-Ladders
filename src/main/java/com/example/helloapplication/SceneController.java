package com.example.helloapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private BorderPane root;

    @FXML
    ImageView image;

    public void StartGame(ActionEvent e) throws IOException {
        FXMLLoader loader = new FXMLLoader();
//        image.setImage(new Image(getClass().getResourceAsStream("HomePage.png")));
        BorderPane root =  loader.load(getClass().getResource("application.fxml").openStream()) ;
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("application.css").toExternalForm() ;
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
