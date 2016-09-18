package io.github.aosn.camp2016.ui.entity;

import javafx.scene.paint.Color;

/**
 * @author akeboshi
 * @author mikan
 */
public class Player {

    private static final int INITIAL_CASH = 1500;
    private static final int INITIAL_POSITION = 1;

    private long id;
    private String name;
    private int position;
    private int cash;

    public Player() {
    }

    public Player(long id, String name) {
        this.id = id;
        this.name = name;
        this.position = INITIAL_POSITION;
        this.cash = INITIAL_CASH;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getCash(){
        return cash;
    }

    public void setCash(int cash){
        this.cash = cash;
    }
}
