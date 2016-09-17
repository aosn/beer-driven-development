package io.github.aosn.camp2016.ui;

import io.github.aosn.camp2016.ui.controller.MainController;
import io.github.aosn.camp2016.ui.util.Logs;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author mikan
 */
public class Launcher extends Application {

    private static final Logger log = Logger.getLogger(Launcher.class.getName());
    private static Stage primaryStage;

    /**
     * Bootstrap the JavaFX application.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        if (primaryStage == null) {
            throw new IllegalStateException("Application not started.");
        }
        return primaryStage;
    }

    private static void setPrimaryStage(Stage primaryStage) {
        Launcher.primaryStage = primaryStage;
    }

    /**
     * Set screen.
     *
     * @param loader     loader class
     * @param fxml       name of fxml
     * @param fullScreen set {@code true} for full-screen, {@code false} otherwise.
     */
    public static void setScreen(Class<?> loader, String fxml, boolean fullScreen) {
        Parent root = null;
        try {
            root = FXMLLoader.load(loader.getResource("/fxml/" + fxml + ".fxml"));
        } catch (IOException e) {
            log.throwing(MainController.class.getName(), "onCountdownClicked", e);
            Platform.exit();
            return;
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/main.css");
        primaryStage.setTitle("BDD");
        primaryStage.setScene(scene);
//        primaryStage.setFullScreen(fullScreen);
        primaryStage.show();
    }

    /**
     * Displays entry.fxml.
     *
     * @param primaryStage primary stage
     * @throws Exception when the runtime exception thrown
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Logs.applyLogLevel(log);

        setPrimaryStage(primaryStage);
        setScreen(getClass(), "start", true);
        log.info("Application started.");
    }

    @Override
    public void stop() throws Exception {
        log.info("Application stopped.");
    }
}
