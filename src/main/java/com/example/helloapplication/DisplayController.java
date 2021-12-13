package com.example.helloapplication;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

class DiceController {

//    @FXML
//     Button
//
    public DiceController() {

    }

    void getRoll(ActionEvent event){
        Random rand = new Random();
        int n = rand.nextInt(6); // this will generate no. from 0-5
        n++;
    }
}

public class DisplayController {

    private Block grid [][] ;

    @FXML
    Pane pane1 ;

    @FXML
    Circle Player1;

    @FXML
    public void initialize(){       // This method overides inital intialize method
        this.grid = new Block[10][10];
        int sign = -1 ;
        for(int i =450;i>=0;i-=50){   // Y
            System.out.println("i= "+i);
            System.out.println();
            for(int j =450;j>=0;j-=50){   // X
                Block block= new Block(j,i,j+sign*50,i,new Rectangle(i,j,50,50)) ;
                if(j==450 && sign ==1){ // For edge piece
                    block.setNextY(i+50);
                    block.setNextX(j);
                }
                else if(j==0 && i!=0 && sign==-1){ // except for the first row and rest of first columns
                    block.setNextY(i+50);
                    block.setNextX(j);
                }
                Rectangle r = new Rectangle(i,j,50,50);
                r.setFill(Color.WHITE);
                r.setStroke(Color.BLACK);
                r.setStrokeWidth(5);
                block.setR(r);
                int gridX = i/50 ,gridY=j/50;
                grid[gridX][gridY] = block ;
                pane1.getChildren().add(block.getR());
//                System.out.println(j+". X = "+r.getX()+" Y = "+r.getY());
                System.out.println("i: "+gridX+" j: "+gridY);
                System.out.println(block);
            }
            sign=-sign;
            System.out.println();
            System.out.println();
        }
//        this.Player1 = new Circle(20,Color.BLACK);
        this.Player1.setLayoutX(25);
        this.Player1.setLayoutY(475);
        this.Player1.setRadius(20);
        this.Player1.toFront();
        this.Player1.setFill(Color.BLACK);

        Player p1 = new Player(0,0,Player1);

        // Below part is to test simulation
        TranslateTransition t = new TranslateTransition(Duration.millis(2000));
        t.setNode(p1.getC());
        int icounter = 0,jcounter=0;
        int i ,j; i=j=0;
        while(icounter<=grid.length-1){
            while(jcounter<= grid.length-1) {
//                t.setByX(grid[i][j].getNextX() + 25);
//                t.play();
                System.out.println(grid[i][j]);
                j=grid[i][j].getNextX();
                j=j/50;
                jcounter++;
            }
            i=grid[i][j].getNextY();
            i=i/50;
            if(i!=grid.length)t.setByY(grid[i][grid.length-1].getNextY()-25);
            icounter++;jcounter=0;
//            t.play();
        }
//        for (;i>=0;i--){
//            for (j= grid.length;-1j>=0;j--) {
//                t.setByX(grid[i][j].getNextX() + 25);
//                t.play();
//            }
//            t.setByY(grid[i][j].getNextY()+25);
//        }
    }
}