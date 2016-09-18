package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.service.DiceService;
import io.github.aosn.camp2016.ui.service.HttpClient;

public class DiceServiceImpl implements DiceService {

    private final HttpClient httpClient;

    public DiceServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public int[] twice() {
        return JsonSerializer.deserialize(
                httpClient.get("/bdd/game/0/dice").get(),
                Dice.class
        )
                .map(d -> d.dice)
                .orElseGet(() -> new int[]{0, 0});
    }

    private static final class Dice {
        public int[] dice;
    }

    public static void main(String[] args) {
//        Config.setApiEndPoint("http://apps.tasktoys.com:50000");
//        System.out.println(Arrays.toString(new DiceServiceImpl().twice()));
    }
}
