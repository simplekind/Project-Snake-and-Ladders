package com.example.helloapplication;

public class MoveTask extends TimerTask {
    Player p;
    Block currBlock ;
    Block nxtBlock ;
    Block [][] grid ;

    public MoveTask(Player p,Block [][] grid ){
        this.p=p;
        this.grid=grid ;
    }

    public void getMove(Player p,Block currBlock ,Block nxtBlock){
        p.setCurrBlock(currBlock);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(p.getC());
//            translate.setDelay(Duration.millis(1000));
        translate.setDuration(Duration.millis(500));
        System.out.println();
        translate.setByX(nxtBlock.getCurrX()-p.getCurrBlock().getCurrX());
        translate.setByY(p.getCurrBlock().getCurrY() - nxtBlock.getCurrY());
        System.out.println(p.getC().getCenterY());
        System.out.println("p.getCurrBlock().getNextX() = "+ nxtBlock.getCurrX());
        System.out.println("p.getCurrBlock().getNextY() = "+ nxtBlock.getCurrY());
        p.setCurrBlock(this.grid[(nxtBlock.getCurrY())/50][(nxtBlock.getCurrX())/50]);
        p.setOtherActive();
        translate.play();
    }

    public void moveOnLadder(Player p){
        if(p.getCurrBlock()==grid[0][1]){
            this.getMove(p,grid[0][1],grid[2][0]);
//            this.getMove(p,grid[2][0]);
        }else if (p.getCurrBlock()== grid[0][5]){
            this.getMove(p,grid[0][5],grid[2][6]);
//            this.getMove(p,grid[2][6]);
        }
    }

    @Override
    public void run() {
        this.moveOnLadder(p);
    }
}