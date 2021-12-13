package com.example.helloapplication;
import javafx.scene.shape.Circle;

//
public class Player {
    private int currX ;
    private int currY;
    Circle c ;


    public Player(int currX, int currY, Circle c) {
        this.currX = currX;
        this.currY = currY;
        this.c = c;
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


    @Override
    public String toString() {
        return "{" +
                " currX='" + getCurrX() + "'" +
                ", currY='" + getCurrY() + "'" +
                "}";
    }
}