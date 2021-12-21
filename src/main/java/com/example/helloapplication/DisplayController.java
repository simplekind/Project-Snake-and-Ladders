package com.example.helloapplication;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class DisplayController {

    private Block grid [][] ;
    private DiceController diceController ;
    private PlayerController playerController ;

    private Player p1 ;
    private Player p2 ;

    private int chance = 0 ; // 0 means P1 chance , 1 means P2 chance
    TimerTask diceAutoTask  ;

    @FXML
    Pane pane1 ;
    @FXML
    Circle Player1;
    @FXML
    Circle Player2;
    @FXML
    ImageView diceImages;
    @FXML
    Button dice;
    @FXML
    ImageView player1Img , player2Img ;
    @FXML
    Rectangle Player1BoxContainer ;
    @FXML
    Rectangle Player2BoxContainer ;
    @FXML
    ImageView boardImgView  ;
    @FXML
    ImageView loading ;
    @FXML
    ImageView arrow ;
    @FXML
    ImageView winnerView ;

    @FXML
    public void initialize(){       // This method overrides inital intialize method

        this.loading.setImage(new Image(getClass().getResourceAsStream("loading.gif")));
        this.boardImgView.setImage(new Image(getClass().getResourceAsStream("Board.jpg")));
        Image img = new Image(getClass().getResourceAsStream("six.jpeg")) ;
//        diceImages.setFitHeight(150);
//        diceImages.setFitWidth(150);
//        diceImages.setX(-50);    // Relative
//        diceImages.setY(-45);
        this.player1Img.setImage(new Image(getClass().getResourceAsStream("red_piece.png")));
        this.player2Img.setImage((new Image(getClass().getResourceAsStream("blue_piece.png")) ) );
        this.player1Img.toFront();
        this.player2Img.toFront();
        this.diceImages.setImage(img);
        this.Player2BoxContainer.toFront();
        this.loading.toBack();
        this.arrow.setImage(new Image(getClass().getResourceAsStream("arrow.gif")));
        this.grid = new Block[10][10];
        Block originBlock = new Block();
        int sign = -1 ;
        for(int i =450;i>=0;i-=50){   // Y
            System.out.println("i= "+i);
            System.out.println();
            for(int j =450;j>=0;j-=50){   // X
                Block block= new Block(j,i,j+sign*50,i,new Rectangle(i,j,50,50)) ;
                if(block.getCurrY()==0 && block.getCurrX()==0 ){
                    originBlock = block ;
                }
                if(j==450 && sign ==1){ // For edge piece
                    block.setNextY(i+50);
                    block.setNextX(j);
                }
                else if(j==0 && i!=0 && sign==-1){ // except for the first row and rest of first columns
                    block.setNextY(i+50);
                    block.setNextX(j);
                }
                Rectangle r = new Rectangle(i,j,50,50);
                r.setFill(Color.BLACK);
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

        boardImgView.toFront();
//        this.Player1 = new Circle(20,Color.BLACK);
        this.Player1.setLayoutX(25);
//        this.Player1.setLayoutY(525);

//        Uncomment below ->
        this.Player1.setLayoutY(520);

//        this.Player1.setLayoutY(25);

        this.Player1.setRadius(20);
        this.Player1.toFront();
        this.Player1.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("red_piece_50.png"))));
        this.Player1.setStrokeWidth(0);

//        Uncomment below ->
        this.p1 = new Player(0,0,Player1,this.Player1BoxContainer,this.Player2BoxContainer,0);

//        this.p1 = new Player(450,450,Player1,this.Player1BoxContainer,this.Player2BoxContainer,0);

        this.playerController = new PlayerController(this.grid,boardImgView,winnerView);

//        Uncomment below ->
        p1.setCurrBlock(originBlock);
//        p1.setCurrBlock(grid[9][9]);

        this.Player2.setLayoutX(25);
//        this.Player2.setLayoutY(525);
        this.Player2.setLayoutY(525);
        this.Player2.setRadius(20);
        this.Player2.toFront();
        this.Player2.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("blue_piece_50.png"))));
        this.Player2.setStrokeWidth(0);
        this.p2 = new Player(0,0,Player2,this.Player1BoxContainer,this.Player2BoxContainer,1);

        this.playerController = new PlayerController(this.grid,boardImgView,winnerView);

        p2.setCurrBlock(originBlock);

        Timer diceAutoTimer = new Timer();
        this.diceAutoTask = new secondsTask(0,this) ;
        diceAutoTimer.scheduleAtFixedRate(diceAutoTask,0,1000);
        this.winnerView.toFront();
        // Below part is to test simulation
//        TranslateTransition t = new TranslateTransition(Duration.millis(2000));
//        t.setNode(p1.getC());
//        int icounter = 0,jcounter=0;
//        int i ,j; i=j=0;
//        while(icounter<=grid.length-1){
//            while(jcounter<= grid.length-1) {
////                t.setByX(grid[i][j].getNextX() + 25);
////                t.play();
//                System.out.println(grid[i][j]);
//                j=grid[i][j].getNextX();
//                j=j/50;
//                jcounter++;
//            }
//            i=grid[i][j].getNextY();
//            i=i/50;
//            if(i!=grid.length)t.setByY(grid[i][grid.length-1].getNextY()-25);
//            icounter++;jcounter=0;
////            t.play();
//        }
//        for (;i>=0;i--){
//            for (j= grid.length;-1j>=0;j--) {
//                t.setByX(grid[i][j].getNextX() + 25);
//                t.play();
//            }
//            t.setByY(grid[i][j].getNextY()+25);
//        }
    }

    public void getRoll(ActionEvent event) throws InterruptedException {
        if(chance==0){
            p1.setActive();
            System.out.println("p1.getC().getCenterX() = "+p1.getC().getTranslateX());
            System.out.println("p1.getC().getCenterY() = "+p1.getC().getTranslateY());

//            Thread sleep = new SleepThreadContainer(Player2BoxContainer,Player1BoxContainer);
            diceController = new DiceController(this.diceImages,this.dice,p1,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,event,p1,playerController);
            // We will let the thread sleep until our move is done
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).seconds = -roll ;
            else ((secondsTask) this.diceAutoTask).seconds = 0 ;
            System.out.println(roll);
            System.out.println("getRoll Player 1 "+p1);
            chance=1;
        }else{
            p2.setActive();
            System.out.println("p2.getC().getCenterX() = "+p2.getC().getTranslateX());
            System.out.println("p2.getC().getCenterY() = "+p2.getC().getTranslateY());

//            Thread sleep = new SleepThreadContainer(Player1BoxContainer,Player2BoxContainer);
            diceController = new DiceController(this.diceImages,this.dice,p2,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,event,p2,playerController);
            // We will let the thread sleep until our move is done
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).seconds = -roll ;
            else ((secondsTask) this.diceAutoTask).seconds = 0 ;
            System.out.println(roll);
            System.out.println("getRoll Player 2 "+p2);
            chance=0;
        }
    }

    // Overloading
    public void getRoll() throws InterruptedException {
        if(chance==0){
            p1.setActive();
            System.out.println("p1.getC().getCenterX() = "+p1.getC().getTranslateX());
            System.out.println("p1.getC().getCenterY() = "+p1.getC().getTranslateY());

//            Thread sleep = new SleepThreadContainer(Player2BoxContainer,Player1BoxContainer);
            diceController = new DiceController(this.diceImages,this.dice,p1,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,p1,playerController);
            // We will let the thread sleep until our move is done
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).seconds = -roll ;
            else ((secondsTask) this.diceAutoTask).seconds = 0 ;
            System.out.println(roll);
            System.out.println("getRoll Player 1 "+p1);
            chance=1;
        }else{
            p2.setActive();
            System.out.println("p2.getC().getCenterX() = "+p2.getC().getTranslateX());
            System.out.println("p2.getC().getCenterY() = "+p2.getC().getTranslateY());

//            Thread sleep = new SleepThreadContainer(Player1BoxContainer,Player2BoxContainer);
            diceController = new DiceController(this.diceImages,this.dice,p2,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,p2,playerController);
            // We will let the thread sleep until our move is done
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).seconds = -roll ;
            else ((secondsTask) this.diceAutoTask).seconds = 0 ;
            System.out.println(roll);
            System.out.println("getRoll Player 2 "+p2);
            chance=0;
        }
    }
}

class secondsTask extends TimerTask {
    int seconds  ;
    DisplayController displayController ;
    secondsTask(int seconds , DisplayController displayController){
        this.seconds = seconds ;
        this.displayController=displayController ;
    }
    @Override
    public void run() {
        this.seconds++ ;
        System.out.println("this.seconds = "+this.seconds);
        if(this.seconds==30){
            try {
                this.seconds = 0 ;
                this.displayController.getRoll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}