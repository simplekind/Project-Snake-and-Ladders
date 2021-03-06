package com.example.helloapplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class DisplayController {

    private Block grid [][] ;
    private DiceController diceController ;
    private PlayerController playerController ;

    private Player p1 ;
    private Player p2 ;

    private int chance = 0 ; // 0 means P1 chance , 1 means P2 chance
    private TimerTask diceAutoTask  ;

    @FXML
    private Pane pane1 ;
    @FXML
    private Circle Player1;
    @FXML
    private Circle Player2;
    @FXML
    private ImageView diceImages;
    @FXML
    private Button dice;
    @FXML
    private ImageView player1Img , player2Img ;
    @FXML
    private Rectangle Player1BoxContainer ;
    @FXML
    private Rectangle Player2BoxContainer ;
    @FXML
    private ImageView boardImgView  ;
    @FXML
    private ImageView loading ;
    @FXML
    private ImageView arrow ;
    @FXML
    private ImageView winnerView ;

    @FXML
    public void initialize(){       // This method overrides inital intialize method

        this.loading.setImage(new Image(getClass().getResourceAsStream("loading.gif")));
        this.boardImgView.setImage(new Image(getClass().getResourceAsStream("Board.jpg")));
        Image img = new Image(getClass().getResourceAsStream("six.jpeg")) ;
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
                System.out.println("i: "+gridX+" j: "+gridY);
                System.out.println(block);
            }
            sign=-sign;
            System.out.println();
            System.out.println();
        }

        boardImgView.toFront();
        this.Player1.setLayoutX(25);
        this.Player1.setLayoutY(520);
        this.Player1.setRadius(20);
        this.Player1.toFront();
        this.Player1.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("red_piece_50.png"))));
        this.Player1.setStrokeWidth(0);
        this.p1 = new Player(0,0,Player1,this.Player1BoxContainer,this.Player2BoxContainer,0);
        this.playerController = new PlayerController(this.grid,boardImgView,winnerView);
        p1.setCurrBlock(originBlock);
        this.Player2.setLayoutX(25);
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
    }

    public void getRoll(ActionEvent event) throws InterruptedException {
        if(chance==0){
            p1.setActive();
            System.out.println("p1.getC().getCenterX() = "+p1.getC().getTranslateX());
            System.out.println("p1.getC().getCenterY() = "+p1.getC().getTranslateY());
            diceController = new DiceController(this.diceImages,this.dice,p1,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,event,p1,playerController);
            // We will let the thread sleep until our move is done
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).setSeconds(-roll+3);
            else ((secondsTask) this.diceAutoTask).setSeconds(0) ;
            System.out.println(roll);
            System.out.println("getRoll Player 1 "+p1);
            chance=1;
        }else{
            p2.setActive();
            System.out.println("p2.getC().getCenterX() = "+p2.getC().getTranslateX());
            System.out.println("p2.getC().getCenterY() = "+p2.getC().getTranslateY());
            diceController = new DiceController(this.diceImages,this.dice,p2,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,event,p2,playerController);
            // We will let the thread sleep until our move is done
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).setSeconds(-roll+3);
            else ((secondsTask) this.diceAutoTask).setSeconds(0) ;
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
            diceController = new DiceController(this.diceImages,this.dice,p1,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,p1,playerController);
            // We will let the thread sleep until our move is done
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).setSeconds(-roll+3) ;
            else ((secondsTask) this.diceAutoTask).setSeconds(0) ;
            System.out.println(roll);
            System.out.println("getRoll Player 1 "+p1);
            chance=1;
        }else{
            p2.setActive();
            System.out.println("p2.getC().getCenterX() = "+p2.getC().getTranslateX());
            System.out.println("p2.getC().getCenterY() = "+p2.getC().getTranslateY());
            diceController = new DiceController(this.diceImages,this.dice,p2,loading,arrow);
            Thread diceThread = new ThreadDiceAnimation(diceController,p2,playerController);
            diceThread.run();
            int roll = ((ThreadDiceAnimation) diceThread).getRoll(); // Polymorphism
            if(p1.getC().getTranslateX()!=0 && p1.getC().getTranslateY()!=0) ((secondsTask) this.diceAutoTask).setSeconds(-roll+3) ;
            else ((secondsTask) this.diceAutoTask).setSeconds(0) ;
            System.out.println(roll);
            System.out.println("getRoll Player 2 "+p2);
            chance=0;
        }
    }
}
// inheritance
class secondsTask extends TimerTask {
    private int seconds  ;
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

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }
}