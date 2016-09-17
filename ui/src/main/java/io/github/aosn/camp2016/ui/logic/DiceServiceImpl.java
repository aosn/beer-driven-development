package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.service.DiceService;
import io.github.aosn.camp2016.ui.util.HttpClient;

public class DiceServiceImpl implements DiceService {

    @Override
    public int[] twice() {
        return JsonDeserializer.deserialize(
                HttpClient.get("/bdd/game/1/dice").get(),
                Dice.class
        )
                .map(d -> d.dice)
                .orElseGet(() -> new int[]{0, 0});
    }

    private static final class Dice {
        public int[] dice;
    }
    public static void main(String[] args) {
//        Config.setApiEndPoint("http://localhost:1337");
//        System.out.println(Arrays.toString(new DiceServiceImpl().twice()));
    }
}