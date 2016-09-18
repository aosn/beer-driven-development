package io.github.aosn.camp2016.ui.service;

import java.util.Map;
import java.util.Optional;

public interface HttpClient {
    Optional<String> get(String url);
    Optional<String> get(String url, Map<String, ?> params);
    boolean put(String url, Object params);
}
