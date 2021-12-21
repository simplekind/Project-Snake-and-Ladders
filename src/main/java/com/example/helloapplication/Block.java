package com.example.helloapplication;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block {
    private int currX ;
    private int currY;
    private int nextX;
    private int nextY;
    Block nextBlock ;
    private Rectangle r ;

    public Block(int currX, int currY, int nextX, int nextY, Rectangle r) {
        this.currX = currX;
        this.currY = currY;
        this.nextX = nextX;
        this.nextY = nextY;
        this.r = r;
    }

    public Block(){}

    public int getCurrX() {
        return this.currX;
    }

    public void setCurrX(int currX) {
        this.currX = currX;
    }

    public Block currX(int currX) {
        setCurrX(currX);
        return this;
    }

    public int getCurrY() {
        return this.currY;
    }

    public void setCurrY(int currY) {
        this.currY = currY;
    }

    public Block currY(int currY) {
        setCurrY(currY);
        return this;
    }

    public int getNextX() {
        return this.nextX;
    }

    public void setNextX(int nextX) {
        this.nextX = nextX;
    }

    public Block nextX(int nextX) {
        setNextX(nextX);
        return this;
    }

    public int getNextY() {
        return this.nextY;
    }

    public void setNextY(int nextY) {
        this.nextY = nextY;
    }

    public Block nextY(int nextY) {
        setNextY(nextY);
        return this;
    }

    public Rectangle getR() {
        return this.r;
    }

    public void setR(Rectangle r) {
        this.r = r;
    }

    public Block r(Rectangle r) {
        setR(r);
        return this;
    }


    public Block getNextBlock() {
        return this.nextBlock;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }

    public Block nextBlock(Block nextBlock) {
        setNextBlock(nextBlock);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " currX='" + getCurrX() + "'" +
                ", currY='" + getCurrY() + "'" +
                ", nextX='" + getNextX() + "'" +
                ", nextY='" + getNextY() + "'" +
                "}";
    }
}