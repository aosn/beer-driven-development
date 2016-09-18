package io.github.aosn.camp2016.ui;

public class Config {
    private static String apiEndPoint = "http://apps.tasktoys.com:50000";

    public static void setApiEndPoint(String s) {
        apiEndPoint = s;
    }

    public static String getApiEndPoint() {
        return apiEndPoint;
    }
}
