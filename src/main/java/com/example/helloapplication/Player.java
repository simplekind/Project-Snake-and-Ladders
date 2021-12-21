package com.example.helloapplication;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

//
public class Player {
    private int currX ;
    private int currY;
    private int prevX=0;
    private int prevY=0;
    private int boxState ;
    Circle c ;
    Block currBlock ;
    @FXML
    Rectangle Player1BoxContainer ;
    @FXML
    Rectangle Player2BoxContainer ;

    public Player(int currX, int currY, Circle c, Rectangle Player1BoxContainer, Rectangle Player2BoxContainer,int boxContainerActive) {
        this.currX = currX;
        this.currY = currY;
        this.c = c;
        this.Player1BoxContainer = Player1BoxContainer ;
        this.Player2BoxContainer = Player2BoxContainer ;
        this.boxState = boxContainerActive ;
    }

    public void setActive(){
        Platform.runLater(new BoxRunnable(boxState,Player1BoxContainer,Player2BoxContainer));
    }

    public void setOtherActive(){
        if(boxState==1){
            Platform.runLater(new BoxRunnable(0,Player1BoxContainer,Player2BoxContainer));
        }else{
            Platform.runLater(new BoxRunnable(1,Player1BoxContainer,Player2BoxContainer));
        }
    }

    public int getCurrX() {
        return this.currX;
    }

    public void setCurrX(int currX) {
        this.currX = currX;
    }

    public Player currX(int currX) {
        setCurrX(currX);
        return this;
    }

    public int getCurrY() {
        return this.currY;
    }

    public void setCurrY(int currY) {
        this.currY = currY;
    }

    public Player currY(int currY) {
        setCurrY(currY);
        return this;
    }


    public int getPrevX() {
        return this.prevX;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public Player prevX(int prevX) {
        setPrevX(prevX);
        return this;
    }

    public int getPrevY() {
        return this.prevY;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public Player prevY(int prevY) {
        setPrevY(prevY);
        return this;
    }


    public Circle getC() {
        return this.c;
    }

    public void setC(Circle c) {
        this.c = c;
    }

    public Player c(Circle c) {
        setC(c);
        return this;
    }


    public Block getCurrBlock() {
        return this.currBlock;
    }

    public void setCurrBlock(Block currBlock) {
        this.currBlock = currBlock;
    }

    public Player currBlock(Block currBlock) {
        setCurrBlock(currBlock);
        return this;
    }

    public int getBoxState() {
        return boxState;
    }

    @Override
    public String toString() {
        return "{" +
                " currX='" + getCurrX() + "'" +
                ", currY='" + getCurrY() + "'" +
                "}";
    }
}

class BoxRunnable implements Runnable{
    int boxState ;
    @FXML
    Rectangle Player1BoxContainer;
    @FXML
    Rectangle Player2BoxContainer ;
    BoxRunnable(int boxState , Rectangle Player1BoxContainer, Rectangle Player2BoxContainer){
        this.boxState=boxState;
        this.Player1BoxContainer=Player1BoxContainer;
        this.Player2BoxContainer=Player2BoxContainer;
    }
    @Override
    public void run() {
        if(boxState==0){
//            this.Player1BoxContainer.toFront();
//            this.Player2BoxContainer.toBack();
            this.Player2BoxContainer.toFront();
            this.Player1BoxContainer.toBack();
        }else{
            this.Player1BoxContainer.toFront();
            this.Player2BoxContainer.toBack();

//            this.Player2BoxContainer.toFront();
//            this.Player1BoxContainer.toBack();
        }
    }
}