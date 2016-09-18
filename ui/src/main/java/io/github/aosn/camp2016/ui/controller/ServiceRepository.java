package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.logic.DiceServiceImpl;
import io.github.aosn.camp2016.ui.logic.EntryServiceImpl;
import io.github.aosn.camp2016.ui.logic.GameStateServiceImpl;
import io.github.aosn.camp2016.ui.service.DiceService;
import io.github.aosn.camp2016.ui.service.EntryService;
import io.github.aosn.camp2016.ui.service.GameStateService;

public class ServiceRepository {
    public static final ServiceRepository instances = new ServiceRepository();

    public final DiceService diceService = new DiceServiceImpl();
    public final EntryService entryService = new EntryServiceImpl();
    public final GameStateService gameStateService = new GameStateServiceImpl();

    private ServiceRepository() {
    }
}
