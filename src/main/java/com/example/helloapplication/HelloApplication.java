package com.example.helloapplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent ;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
    }
    public void LogOut(Stage stage){
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("LOGOUT SCREEN");
        alert.setHeaderText("You are about to Logout");
        alert.setContentText("You sure you want to Logout ?");
        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You have successfully Logged out");
            stage.close();    // This actually LOGS OUT !!
            Platform.exit();
            System.exit(0);
        }
    }

    @Override
    public void start(Stage stage1) throws Exception {

        FXMLLoader loader= new FXMLLoader();
        Parent root = loader.load(getClass().getResource("HomePage.fxml")) ;
        stage1.setTitle("Snakes and Ladders") ;
        Scene scene = new Scene(root);
        stage1.setOnCloseRequest(event->{
            event.consume();    // This will help when user clicks cancel after X , so that screen doesnt gets closed
            LogOut(stage1);
        });

        stage1.setScene(scene);
        stage1.show();
    }
}