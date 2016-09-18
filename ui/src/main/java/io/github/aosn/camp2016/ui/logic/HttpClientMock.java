package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.service.HttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HttpClientMock implements HttpClient {

    private static Map<String, String> internalStorage = new HashMap<>();

    @Override
    public Optional<String> get(String url) {
        return Optional.ofNullable(internalStorage.get(url));
    }

    @Override
    public Optional<String> get(String url, Map<String, ?> params) {
        throw new UnsupportedOperationException("Mock get can't use params");
    }

    @Override
    public boolean put(String url, Object params) {
        JsonSerializer.serialize(params).ifPresent(json -> internalStorage.put(url, json));
        return true;
    }

}
