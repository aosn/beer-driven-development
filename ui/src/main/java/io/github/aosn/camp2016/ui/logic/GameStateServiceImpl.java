package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.service.GameStateService;
import io.github.aosn.camp2016.ui.util.HttpClient;

public class GameStateServiceImpl implements GameStateService {

    @Override
    public GameState get() {
        return JsonDeserializer.deserialize(
                //FIXME Don't use mock
                HttpClient.getMock("/bdd/game/0/state").get(),
                GameState.class
        )
                .orElseThrow(() -> new RuntimeException("GameState is not found."));
    }

    @Override
    public boolean update(GameState gameState) {
        //FIXME Don't use mock
        return HttpClient.putMock(
                "/bdd/game/0/change",
                gameState);
    }
}
