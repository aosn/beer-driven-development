package io.github.aosn.camp2016.ui.service;

import io.github.aosn.camp2016.ui.entity.GameState;

public interface GameStateService {

    /**
     * Get initial state
     *
     * @return Initial GameState
     */
    GameState getInit(String userNames);

    /**
     * Get GameState
     *
     * @return GameState
     */
    GameState get();

    /**
     * Update GameState
     *
     * @param gameState New GameState
     * @return succeeded | failed
     */
    boolean update(GameState gameState);
}
