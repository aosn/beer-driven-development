package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.entity.Player;
import io.github.aosn.camp2016.ui.service.GameStateService;
import io.github.aosn.camp2016.ui.service.HttpClient;
import io.github.aosn.camp2016.ui.stub.StubData;

import java.util.ArrayList;
import java.util.List;

public class GameStateServiceImpl implements GameStateService {

    private final HttpClient httpClient;

    public GameStateServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public GameState getInit(String userNames) {
        GameState gameState = new GameState();
        gameState.setPlayers(createPlayers(userNames.trim().split("\n")));
        gameState.setBoard(StubData.createBoard());
        return gameState;
    }

    private static List<Player> createPlayers(String[] names) {
        int cnt = 0;
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(++cnt, name));
        }
        return players;
    }

    @Override
    public GameState get() {
        return JsonSerializer.deserialize(
                httpClient.get("/bdd/game/0/state").get(),
                GameState.class
        )
                .orElseThrow(() -> new RuntimeException("GameState is not found."));
    }

    @Override
    public boolean update(GameState gameState) {
        return httpClient.put(
                "/bdd/game/0/state",
                gameState);
    }
}
