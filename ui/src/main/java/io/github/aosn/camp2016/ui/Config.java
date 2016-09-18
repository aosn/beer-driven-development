package io.github.aosn.camp2016.ui;

public class Config {
    private static boolean usesExternalBackend = true;

    private static String apiEndPoint = "http://apps.tasktoys.com:50000";

    public static boolean usesExternalBackend() {
        return usesExternalBackend;
    }

    public static void usesExternalBackend(boolean usesExternalBackend) {
        Config.usesExternalBackend = usesExternalBackend;
    }

    public static void setApiEndPoint(String s) {
        apiEndPoint = s;
    }

    public static String getApiEndPoint() {
        return apiEndPoint;
    }
}
