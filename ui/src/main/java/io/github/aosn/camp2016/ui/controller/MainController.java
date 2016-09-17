package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.Launcher;
import io.github.aosn.camp2016.ui.util.Logs;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 */
public class MainController implements Initializable {

    private static final Logger log = Logger.getLogger(MainController.class.getName());
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logs.applyLogLevel(log);

        dice1.setText("0");
        dice2.setText("0");

        // TODO: GET /bdd/game/1/state

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
    }
}
