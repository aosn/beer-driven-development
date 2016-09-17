/*
 * Cpoyright (c) 2016 mikan. All rights reserved.
 */
package io.github.aosn.camp2016.ui.util;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Initialize logs.
 *
 * @author mikan
 * @since 1.0
 */
public class Logs {

    private static final Level logLevel = Level.FINEST;
    private static final Handler consoleLogHandler = new ConsoleHandler();

    private Logs() {
    }

    public static void applyLogLevel(Logger logger) {
        consoleLogHandler.setLevel(logLevel);
        logger.addHandler(consoleLogHandler);
        logger.setUseParentHandlers(false);
        logger.setLevel(logLevel);
    }
}
