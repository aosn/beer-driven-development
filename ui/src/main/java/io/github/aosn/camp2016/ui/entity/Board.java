package io.github.aosn.camp2016.ui.entity;

import java.util.List;

/**
 * Created by akari on 2016/09/18.
 */
public class Board {
    private List<Cell> cells;

    public List<Cell> getCells(){
        return cells;
    }

    public void setCells(List<Cell> cells){
        this.cells = cells;
    }
}
