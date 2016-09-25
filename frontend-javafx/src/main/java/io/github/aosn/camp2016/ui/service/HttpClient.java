package io.github.aosn.camp2016.ui.service;

import io.github.aosn.util.tryable.Try;

import java.util.Map;

public interface HttpClient {
    Try<String> get(String url);
    Try<String> get(String url, Map<String, ?> params);
    boolean put(String url, Object params);
}
