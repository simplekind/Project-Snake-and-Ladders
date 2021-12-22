package com.example.helloapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController2  {
    private Stage stage;
    private Scene scene;
    private BorderPane root;
    private FXMLLoader loader = new FXMLLoader();

    public void HomePage(ActionEvent e) throws IOException {
        Parent root1 = loader.load(getClass().getResource("HomePage.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
    }

    public void startGame(ActionEvent event) throws IOException{
        root =  loader.load(getClass().getResource("application.fxml").openStream()) ;
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("application.css").toExternalForm() ;
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}