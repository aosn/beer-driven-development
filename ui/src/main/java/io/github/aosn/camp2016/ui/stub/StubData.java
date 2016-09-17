package io.github.aosn.camp2016.ui.stub;

import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.entity.Player;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikan
 */
public final class StubData {

    private StubData() {
        // static-use only
    }

    public static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "LagunaPresa"));
        players.add(new Player(2, "kzt-ysmr"));
        players.add(new Player(3, "akeboshi"));
        players.add(new Player(4, "intptr-t"));
        players.add(new Player(5, "mikan"));
        players.add(new Player(6, "MrBearing"));
        return players;
    }

    public static GameState createGame() {
        GameState gameState = new GameState();
        gameState.setPlayers(createPlayers());
        return gameState;
    }

    public static Pair<Integer, Integer> doShuffle() {
        return new Pair<>(1, 1);
    }
}
