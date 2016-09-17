package io.github.aosn.camp2016.ui.entity;

/**
 * Created by akari on 2016/09/18.
 */
public class Player {
    private long id;
    private String name;
    private int position;
    private int cash;

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
