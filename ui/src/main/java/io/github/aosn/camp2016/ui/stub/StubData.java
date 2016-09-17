package io.github.aosn.camp2016.ui.stub;

import io.github.aosn.camp2016.ui.entity.*;
import javafx.util.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mikan
 */
public final class StubData {

    private StubData() {
        // static-use only
    }

    private static Random random = new Random(LocalTime.now().toNanoOfDay());

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

    public static Board createBoard() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(1, -1, Type.INCOME, new CellSpec("START", 0, 0)));
        cells.add(new Cell(2, -1, Type.LAND, new CellSpec("A1", 200, 100)));
        cells.add(new Cell(3, -1, Type.LAND, new CellSpec("A2", 200, 100)));
        cells.add(new Cell(4, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(5, -1, Type.LAND, new CellSpec("A3", 200, 100)));
        cells.add(new Cell(6, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(7, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(8, -1, Type.LAND, new CellSpec("B1", 200, 100)));
        cells.add(new Cell(9, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(10, -1, Type.LAND, new CellSpec("B2", 200, 100)));
        cells.add(new Cell(11, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(12, -1, Type.LAND, new CellSpec("C1", 200, 100)));
        cells.add(new Cell(13, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(14, -1, Type.LAND, new CellSpec("C2", 200, 100)));
        cells.add(new Cell(15, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(16, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(17, -1, Type.LAND, new CellSpec("D1", 200, 100)));
        cells.add(new Cell(18, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(19, -1, Type.LAND, new CellSpec("D2", 200, 100)));
        cells.add(new Cell(20, -1, Type.LAND, new CellSpec("D3", 200, 100)));
        cells.add(new Cell(21, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(22, -1, Type.LAND, new CellSpec("E1", 200, 100)));
        cells.add(new Cell(23, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(24, -1, Type.LAND, new CellSpec("E2", 200, 100)));
        cells.add(new Cell(25, -1, Type.LAND, new CellSpec("E3", 200, 100)));
        cells.add(new Cell(26, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(27, -1, Type.LAND, new CellSpec("F1", 200, 100)));
        cells.add(new Cell(28, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(29, -1, Type.LAND, new CellSpec("F2", 200, 100)));
        cells.add(new Cell(30, -1, Type.LAND, new CellSpec("F3", 200, 100)));
        cells.add(new Cell(31, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(32, -1, Type.LAND, new CellSpec("G1", 200, 100)));
        cells.add(new Cell(33, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(34, -1, Type.LAND, new CellSpec("G2", 200, 100)));
        cells.add(new Cell(35, -1, Type.LAND, new CellSpec("G3", 200, 100)));
        cells.add(new Cell(36, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(37, -1, Type.LAND, new CellSpec("H1", 200, 100)));
        cells.add(new Cell(38, -1, Type.LAND, new CellSpec("H2", 200, 100)));
        cells.add(new Cell(39, -1, Type.EVENT, new CellSpec("Event", 0, 0)));
        cells.add(new Cell(40, -1, Type.LAND, new CellSpec("H3", 200, 100)));
        Board board = new Board();
        board.setCells(cells);
        return board;
    }

    public static GameState createGame() {
        GameState gameState = new GameState();
        gameState.setPlayers(createPlayers());
        gameState.setBoard(createBoard());
        return gameState;
    }

    public static Pair<Integer, Integer> doShuffle() {
        return new Pair<>(Math.abs(random.nextInt()) % 6 + 1, Math.abs(random.nextInt()) % 6 + 1);
    }
}
