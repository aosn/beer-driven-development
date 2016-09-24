package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.Launcher;
import io.github.aosn.camp2016.ui.entity.Cell;
import io.github.aosn.camp2016.ui.entity.GameState;
import io.github.aosn.camp2016.ui.entity.Player;
import io.github.aosn.camp2016.ui.entity.Type;
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
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 */
public class MainController implements Initializable, ServiceRepository {

    private static final Logger log = Logger.getLogger(MainController.class.getName());

    private static int START_ADD = 200;
    private static String PRICE_LABEL_PREFIX = "Price: ";
    private static int LABELS_INDEX_PRICE = 1;
    private static int LABELS_INDEX_PLAYERS = 2;

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
    @FXML
    public Label priceLabel;
    @FXML
    public Button buyButton;
    @FXML
    public Button cancelButton;

    private List<Label> userLabels;
    private int turn = 1;
    private GameState gameState;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logs.applyLogLevel(log);

        dice1.setText("0");
        dice2.setText("0");
        buyButton.setDisable(true);
        cancelButton.setDisable(true);
        priceLabel.setText(PRICE_LABEL_PREFIX + "--");

        gameState = StubData.createGame(); // TODO: GET /bdd/game/1/state
        userLabels = gameState.getPlayers().stream().map(this::createUserLabel).collect(Collectors.toList());
        userList.getChildren().addAll(userLabels);
        userLabels.get(turn - 1).setBorder(createUserBorder(true));

        // Load pricing
        List<Cell> cells = gameState.getBoard().getCells();
        for (int i = 0; i < cells.size(); i++) {
            getCell(i + 1).getChildren().add(createPriceLabel(cells.get(i)));
        }
        getAllCell().forEach(c -> c.getChildren().add(new Label()));

        gameStateService.update(gameState);

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

    @FXML
    public void inShuffleClicked(Event event) {
        int[] dice = diceService.twice();
        dice1.setText(String.valueOf(dice[0]));
        dice2.setText(String.valueOf(dice[1]));

        // move
        int steps = dice[0] + dice[1];
        Player p = gameState.getPlayers().get(turn - 1);
        int prePosition = p.getPosition();
        int postPosition = prePosition + steps;
        if (postPosition > 40) {
            postPosition -= 40;
            p.setCash(p.getCash() + START_ADD);
        }
        p.setPosition(postPosition);

        // update position indicator
        VBox preCellBox = getCell(prePosition);
        VBox postCellBox = getCell(postPosition);
        if (preCellBox.getChildren().get(LABELS_INDEX_PLAYERS) != null) {
            Label label = (Label) preCellBox.getChildren().get(LABELS_INDEX_PLAYERS);
            label.setText(label.getText().replaceFirst(p.getName() + " ", "")); // remove player
        }
        if (postCellBox.getChildren().get(LABELS_INDEX_PLAYERS) == null) {
            Label label = new Label();
            label.setWrapText(true);
            label.setTextFill(Color.GRAY);
            postCellBox.getChildren().add(label);
        }
        Label postPosLabel = (Label) postCellBox.getChildren().get(LABELS_INDEX_PLAYERS);
        postPosLabel.setText(postPosLabel.getText() + p.getName() + " ");


        // land operation
        Cell cell = gameState.getBoard().getCells().get(postPosition - 1);
        if (cell.getType() == Type.LAND) {
            if (cell.getOwner() < 0) {
                // buy
                buyButton.setDisable(false);
                cancelButton.setDisable(false);
                shuffleButton.setDisable(true);
                priceLabel.setText(PRICE_LABEL_PREFIX + cell.getSpec().getPrice());
                return;
            } else if (cell.getOwner() != p.getId()) {
                p.setCash(p.getCash() - cell.getSpec().getFee());
                Player owner = getPlayer(cell.getOwner());
                owner.setCash(owner.getCash() + cell.getSpec().getFee());
            } else {
                // Currently do nothing (Rank up?)
            }
        }
        updateUserLabel();
        next();
    }

    @FXML
    public void onBuyClicked(Event event) {
        buyButton.setDisable(true);
        cancelButton.setDisable(true);
        shuffleButton.setDisable(false);
        priceLabel.setText(PRICE_LABEL_PREFIX + "--");

        // buy
        Player p = gameState.getPlayers().get(turn - 1);
        Cell c = gameState.getBoard().getCells().get(p.getPosition() - 1);
        p.setCash(p.getCash() - c.getSpec().getPrice());

        // owner set
        c.setOwner(p.getId());

        // display
        updateUserLabel();

        // set color to price label
        Label priceLabel = (Label) getCell(p.getPosition()).getChildren().get(LABELS_INDEX_PRICE);
        priceLabel.setTextFill(getColor(p.getId()));
        priceLabel.setText(c.getSpec().getFee() + "->" + p.getName());

        // TODO: State change

        next();
    }

    @FXML
    public void onCancelClicked(Event event) {
        buyButton.setDisable(true);
        cancelButton.setDisable(true);
        shuffleButton.setDisable(false);
        priceLabel.setText(PRICE_LABEL_PREFIX + "--");
        updateUserLabel();
        next();
    }

    private void next() {
        // next
        turn = nextTurn(turn);
        while (gameState.getPlayers().get(turn - 1).getCash() < 0) {
            turn = nextTurn(turn);
        }
        userLabels.get(turn - 1).setBorder(createUserBorder(true));
    }

    private void updateUserLabel() {
        // update position indicator
        userList.getChildren().clear();
        userLabels = gameState.getPlayers().stream().map(this::createUserLabel).collect(Collectors.toList());
        userList.getChildren().addAll(userLabels);
    }

    private Label createUserLabel(Player p) {
        Label label = new Label(p.getName() + " $" + p.getCash());
        label.setPadding(new Insets(10, 10, 10, 10));
        label.setBorder(createUserBorder(false));
        label.setTextFill(Color.WHITE);
        label.setBackground(new Background(new BackgroundFill(getColor(p.getId()), new CornerRadii(5), new Insets(0, 0, 0, 0))));
        return label;
    }

    private Border createUserBorder(boolean turned) {
        return new Border(new BorderStroke(turned ? Color.RED : Color.GRAY, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(3)));
    }

    private Label createPriceLabel(Cell c) {
        if (c.getType() == Type.LAND) {
            return new Label(c.getSpec().getPrice() + " " + c.getSpec().getFee());
        } else {
            return new Label();
        }
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

    private Player getPlayer(long id) {
        Optional<Player> opt = gameState.getPlayers().stream().filter(p -> p.getId() == id).findFirst();
        if (opt.isPresent()) {
            return opt.get();
        } else {
            throw new RuntimeException("Player not found: " + id);
        }
    }

    private int nextTurn(int turn) {
        if (turn >= gameState.getPlayers().size()) {
            return 1;
        }
        return turn + 1;
    }

    private Color getColor(long userId) {
        switch ((int) userId) {
            case 1:
                return Color.BLUE;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.RED;
            case 4:
                return Color.ORANGE;
            case 5:
                return Color.BROWN;
            case 6:
                return Color.PURPLE;
            default:
                return Color.BLACK;
        }
    }
}
