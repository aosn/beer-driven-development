package io.github.aosn.camp2016.ui.entity;

/**
 * Created by akari on 2016/09/18.
 */
public class Cell {
    private int id;
    private long owner;
    private Type type;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public long getOwner(){
        return owner;
    }

    public void setOwner(long owner){
        this.owner = owner;
    }

    public Type getType(){
        return type;
    }

    public void setType(Type type){
        this.type = type;
    }
}
