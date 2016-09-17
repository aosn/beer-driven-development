package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.Launcher;
import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.entity.Player;
import io.github.aosn.camp2016.ui.stub.StubData;
import io.github.aosn.camp2016.ui.util.Logs;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 */
public class MainController implements Initializable {

    private static final Logger log = Logger.getLogger(MainController.class.getName());

    private static int START_ADD = 200;

    @FXML
    public VBox wrapper;
    @FXML
    public Label dice1;
    @FXML
    public Label dice2;
    @FXML
    public Button shuffleButton;
    @FXML
    public HBox userList;
    @FXML
    public VBox cell01;
    @FXML
    public VBox cell02;
    @FXML
    public VBox cell03;
    @FXML
    public VBox cell04;
    @FXML
    public VBox cell05;
    @FXML
    public VBox cell06;
    @FXML
    public VBox cell07;
    @FXML
    public VBox cell08;
    @FXML
    public VBox cell09;
    @FXML
    public VBox cell10;
    @FXML
    public VBox cell11;
    @FXML
    public VBox cell12;
    @FXML
    public VBox cell13;
    @FXML
    public VBox cell14;
    @FXML
    public VBox cell15;
    @FXML
    public VBox cell16;
    @FXML
    public VBox cell17;
    @FXML
    public VBox cell18;
    @FXML
    public VBox cell19;
    @FXML
    public VBox cell20;
    @FXML
    public VBox cell21;
    @FXML
    public VBox cell22;
    @FXML
    public VBox cell23;
    @FXML
    public VBox cell24;
    @FXML
    public VBox cell25;
    @FXML
    public VBox cell26;
    @FXML
    public VBox cell27;
    @FXML
    public VBox cell28;
    @FXML
    public VBox cell29;
    @FXML
    public VBox cell30;
    @FXML
    public VBox cell31;
    @FXML
    public VBox cell32;
    @FXML
    public VBox cell33;
    @FXML
    public VBox cell34;
    @FXML
    public VBox cell35;
    @FXML
    public VBox cell36;
    @FXML
    public VBox cell37;
    @FXML
    public VBox cell38;
    @FXML
    public VBox cell39;
    @FXML
    public VBox cell40;

    private List<Label> userLabels;
    private int turn = 1;
    private List<Player> players;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logs.applyLogLevel(log);

        dice1.setText("0");
        dice2.setText("0");

        GameState gameState = StubData.createGame(); // TODO: GET /bdd/game/1/state
        players = gameState.getPlayers();
        userLabels = players.stream().map(this::createUserLabel).collect(Collectors.toList());
        userList.getChildren().addAll(userLabels);
        userLabels.get(turn - 1).setBorder(createUserBorder(true));

        // TODO: PUSH State

        log.info(MainController.class.getSimpleName() + " initialized.");
    }

    /**
     * Click handler for screen background.
     *
     * @param event mouse event
     */
    @FXML
    public void onWrapperClicked(MouseEvent event) {
        switch (event.getButton()) {
            case PRIMARY:
                // Double-clicked
                if (event.getClickCount() == 2) {
                    log.finer("Wrapper double-clicked.");
                    Stage primaryStage = Launcher.getPrimaryStage();
                    primaryStage.setFullScreen(!primaryStage.isFullScreen()); // Change full-screen or window.
                }
                break;
            default:
                log.finer("Wrapper clicked: ev=" + event.getEventType() + ",count=" + event.getClickCount());
                break;
        }
    }

    public void inShuffleClicked(Event event) {
        // TODO: GET /bdd/game/1/dice
        Pair<Integer, Integer> dice = StubData.doShuffle();
        dice1.setText(dice.getKey().toString());
        dice2.setText(dice.getValue().toString());

        // move
        int steps = dice.getKey() + dice.getValue();
        Player p = players.get(turn - 1);
        int prePosition = p.getPosition();
        int postPosition = prePosition + steps;
        if (postPosition > 40) {
            postPosition = 1;
            p.setCash(p.getCash() + START_ADD);
        }
        p.setPosition(postPosition);

        // update position indicator
        userLabels = players.stream().map(this::createUserLabel).collect(Collectors.toList());
        userList.getChildren().clear();
        userList.getChildren().addAll(userLabels);

        // next
        turn++;
        if (turn > players.size()) {
            turn = 1;
        }
        userLabels.get(turn - 1).setBorder(createUserBorder(true));
    }

    private Label createUserLabel(Player p) {
        Label label = new Label(p.getName() + " $" + p.getCash() + " @" + p.getPosition());
        label.setPadding(new Insets(10, 10, 10, 10));
        label.setBorder(createUserBorder(false));
        label.setTextFill(Color.WHITE);
        label.setBackground(new Background(new BackgroundFill(p.getColor(), new CornerRadii(5), new Insets(0, 0, 0, 0))));
        return label;
    }

    private Border createUserBorder(boolean turned) {
        return new Border(new BorderStroke(turned ? Color.RED : Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(3)));
    }

    private Label createUserPosition(Player p) {
        Label label = new Label("*");
        label.setTextFill(p.getColor());
        return label;
    }

    private List<VBox> getAllCell() {
        return Arrays.asList(
                cell01, cell02, cell03, cell04, cell05, cell06, cell07, cell08, cell09, cell10,
                cell11, cell12, cell13, cell14, cell15, cell16, cell17, cell18, cell19, cell20,
                cell21, cell22, cell23, cell24, cell25, cell26, cell27, cell28, cell29, cell30,
                cell31, cell32, cell33, cell34, cell35, cell36, cell37, cell38, cell39, cell40);
    }

    private VBox getCell(int position) {
        return getAllCell().get(position - 1);
    }
}
