package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.Config;
import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.logic.*;
import io.github.aosn.camp2016.ui.service.DiceService;
import io.github.aosn.camp2016.ui.service.EntryService;
import io.github.aosn.camp2016.ui.service.GameStateService;
import io.github.aosn.camp2016.ui.service.HttpClient;
import io.github.aosn.camp2016.ui.stub.StubData;

import java.util.Arrays;

interface ServiceRepository {

    HttpClient httpClient = Config.usesExternalBackend() ? new HttpClientImpl() : new HttpClientMock();
    //FIXME Don't use mock
    HttpClient mockHttpClient = new HttpClientMock();

    DiceService diceService = new DiceServiceImpl(httpClient);
    EntryService entryService = new EntryServiceImpl(mockHttpClient);
    GameStateService gameStateService = new GameStateServiceImpl(mockHttpClient);

    static void main(String[] args) {
        // test
        int[] dice = diceService.twice();
        assert 0 < dice[0];
        assert 0 < dice[1];
        System.out.println("dice: " + Arrays.toString(dice));

        {
            boolean result = entryService.create("mikan\nakari");
            System.out.println("entry.create: " + result);
        }

        {
            GameState gs1 = StubData.createGame();
            gameStateService.update(gs1);

            GameState gs2 = gameStateService.get();
            assert gs1.getBoard().getCells().get(0) == gs2.getBoard().getCells().get(0);
        }
    }
}
