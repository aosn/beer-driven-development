package io.github.aosn.camp2016.ui;

public class Config {
    private static String apiEndPoint = "localhost:8080"; //FIXME

    public static void setApiEndPoint(String s) {
        apiEndPoint = s;
    }

    public static String getApiEndPoint() {
        return apiEndPoint;
    }
}
