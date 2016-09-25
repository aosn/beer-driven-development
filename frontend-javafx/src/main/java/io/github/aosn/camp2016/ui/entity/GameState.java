package io.github.aosn.camp2016.ui.entity;

import java.util.List;

/**
 * Created by akari on 2016/09/18.
 */
public class GameState {
    private Board board;
    private List<Player> players;

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard(){
        return board;
    }

    public void setPlayers(List<Player> players){
        this.players = players;
    }

    public List<Player> getPlayers(){
        return players;
    }
}
