package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.Config;
import io.github.aosn.camp2016.ui.entity.Board;
import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.entity.Player;
import io.github.aosn.camp2016.ui.logic.*;
import io.github.aosn.camp2016.ui.service.DiceService;
import io.github.aosn.camp2016.ui.service.EntryService;
import io.github.aosn.camp2016.ui.service.GameStateService;
import io.github.aosn.camp2016.ui.service.HttpClient;
import io.github.aosn.camp2016.ui.stub.StubData;

import java.util.List;

public class ServiceRepository {
    public static final ServiceRepository instances = new ServiceRepository();

    private final HttpClient httpClient = Config.usesExternalBackend() ? new HttpClientImpl() : new HttpClientMock();
    //FIXME Don't use mock
    private final HttpClient mockHttpClient = new HttpClientMock();

    public final DiceService diceService = new DiceServiceImpl(httpClient);
    public final EntryService entryService = new EntryServiceImpl(mockHttpClient);
    public final GameStateService gameStateService = new GameStateServiceImpl(mockHttpClient);

    private ServiceRepository() {
    }

    public static void main(String[] args) {
        // test
        int[] dice = instances.diceService.twice();
        assert 0 < dice[0];
        assert 0 < dice[1];

        instances.entryService.create("mikan\nakari");

        {
            GameState gs1 = StubData.createGame();
            instances.gameStateService.update(gs1);

            GameState gs2 = instances.gameStateService.get();
            assert gs1.getBoard().getCells().get(0) == gs2.getBoard().getCells().get(0);
        }
    }
}
