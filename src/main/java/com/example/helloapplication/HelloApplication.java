package com.example.helloapplication;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Parent ;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
//
public class HelloApplication extends Application {

    public static void main(String[] args) {
        launch();
        // Its same as Application.launch() since its a static method
    }
    // The below method only closes only if it presses close button so when it clicks X button, we addded in the main class
    public void LogOut(Stage stage){
//        stage = (Stage) logOutConfScreen.getScene().getWindow();
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("LOGOUT SCREEN");
        alert.setHeaderText("You are about to Logout");
        alert.setContentText("You sure you want to Logout ?");
        // The alert has by default 2 buttons OK and CANCEL , we are gonna logout only if it presses OK

        if(alert.showAndWait().get() == ButtonType.OK){
            // The output to system is same as console.log.out to JavaScript
            System.out.println("You have successfully Logged out");
            stage.close();    // This actually LOGS OUT !!
            Platform.exit();
            System.exit(0);
        }
    }

    @Override
    public void start(Stage stage1) throws Exception {

        FXMLLoader loader= new FXMLLoader();
//        BorderPane root = (BorderPane) loader.load(getClass().getResource("application.fxml").openStream()) ;
        Parent root = loader.load(getClass().getResource("HomePage.fxml")) ;
        stage1.setTitle("Snakes and Ladders") ;
        Scene scene = new Scene(root);
//        String css = this.getClass().getResource("application.css").toExternalForm() ;
//        scene.getStylesheets().add(css);
//         To close on clicking X on right-top X button: using labmda function
        stage1.setOnCloseRequest(event->{
            event.consume();    // This will help when user clicks cancel after X , so that screen doesnt gets closed
            LogOut(stage1);
        });

        stage1.setScene(scene);
        // TO display stage
        stage1.show();
    }
}