package io.github.aosn.camp2016.ui.controller;

import io.github.aosn.camp2016.ui.Launcher;
import io.github.aosn.camp2016.ui.util.Logs;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 *
 */
public class EntryController implements Initializable, ServiceRepository {

    private static final Logger log = Logger.getLogger(EntryController.class.getName());
    @FXML
    public VBox wrapper;
    @FXML
    public TextArea userList;
    @FXML
    public Button startButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Logs.applyLogLevel(log);

        log.info(EntryController.class.getSimpleName() + " initialized.");
    }

    /**
     * Click handler for "clock" button.
     *
     * @param event mouse event
     */
    @FXML
    public void onStartClicked(MouseEvent event) {
        log.info("Start button clicked.");
        entryService.create(userList.getText());
        Launcher.setScreen(getClass(), "main", Launcher.getPrimaryStage().isFullScreen());
    }

    public void onWrapperClicked(Event event) {
    }
}
