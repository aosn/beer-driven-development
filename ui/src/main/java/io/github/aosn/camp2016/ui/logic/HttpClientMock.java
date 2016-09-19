package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.service.HttpClient;
import io.github.aosn.util.tryable.Try;
import io.github.aosn.util.tryable.Tryable;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class HttpClientMock implements HttpClient, Tryable {

    private static Map<String, String> internalStorage = new HashMap<>();

    @Override
    public Try<String> get(String url) {
        return Try(() -> Optional.ofNullable(internalStorage.get(url)).orElseThrow(() -> new NoSuchElementException(url)));
    }

    @Override
    public Try<String> get(String url, Map<String, ?> params) {
        return Failed(new UnsupportedOperationException("Mock get can't use params"));
    }

    @Override
    public boolean put(String url, Object params) {
        JsonSerializer.serialize(params).forEach(json -> internalStorage.put(url, json));
        return true;
    }

}
