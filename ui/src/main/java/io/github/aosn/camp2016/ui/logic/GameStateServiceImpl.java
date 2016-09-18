package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.service.GameStateService;
import io.github.aosn.camp2016.ui.service.HttpClient;

public class GameStateServiceImpl implements GameStateService {

    private final HttpClient httpClient;

    public GameStateServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
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
