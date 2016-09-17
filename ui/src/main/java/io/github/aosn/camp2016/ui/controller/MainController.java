package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.Launcher;
import io.github.aosn.camp2016.ui.util.Logs;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    private Label statusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logs.applyLogLevel(log);

        // Setup status label.
        try {
            statusLabel.setText(InetAddress.getLocalHost().toString());
        } catch (UnknownHostException e) {
            log.throwing(MainController.class.getName(), "initialize", e);
            statusLabel.setText("[ERROR] " + e.getMessage());
        }

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

    /**
     * Click handler for "clock" button.
     *
     * @param event mouse event
     */
    @FXML
    public void onClockClicked(MouseEvent event) {
        log.info("Clock button clicked.");
        Launcher.setScreen(getClass(), "clock", Launcher.getPrimaryStage().isFullScreen());
    }

    /**
     * Click handler for "countdown" button.
     *
     * @param event mouse event
     */
    @FXML
    public void onTimerClicked(MouseEvent event) {
        Launcher.setScreen(getClass(), "timer", Launcher.getPrimaryStage().isFullScreen());
    }
}
