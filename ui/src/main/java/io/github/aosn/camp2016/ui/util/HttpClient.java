package io.github.aosn.camp2016.ui.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.github.aosn.camp2016.ui.Config;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HttpClient {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static Optional<String> get(String url) {
        return get(url, Collections.emptyMap());
    }

    public static Optional<String> get(String url, Map<String, ?> params) {
        try {
            AsyncHttpClient.BoundRequestBuilder builder = client.preparePut(Config.getApiEndPoint() + url);
            for (Map.Entry<String, ?> p : params.entrySet()) {
                toJson(p.getValue()).map(json -> builder.addQueryParam(p.getKey(), json));
            }
            Future<Response> f = builder.execute();
            return Optional.of(f.get().getResponseBody());
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static boolean put(String url, Object params) {
        AsyncHttpClient.BoundRequestBuilder builder = client.preparePut(Config.getApiEndPoint() + url);
        return toJson(params)
                .map(json -> builder.setBody(json).execute())
                .isPresent();
    }

    private static Optional<String> toJson(Object o) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Optional.of(mapper.writeValueAsString(o));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Config.setApiEndPoint("localhost:1337");

//        get("", )
    }
}
