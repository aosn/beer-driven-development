package io.github.aosn.camp2016.ui.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HttpClient {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static Optional<String> get(String url) {
        try {
            Future<Response> f = client.prepareGet(url).execute();
            return Optional.of(f.get().getResponseBody());
        } catch (IOException | ExecutionException | InterruptedException e) {
            // ignore
        }
        return Optional.empty();
    }

    public static Optional<String> put(String url, Map<String, ?> params) {
        try {
            AsyncHttpClient.BoundRequestBuilder builder = client.preparePut(url);
            for (Map.Entry<String, ?> p : params.entrySet()) {
                builder.addQueryParam(p.getKey(), toJson(p.getValue()));
            }
            Future<Response> f = builder.execute();
            return Optional.of(f.get().getResponseBody());
        } catch (IOException | ExecutionException | InterruptedException e) {
            // ignore
        }
        return Optional.empty();
    }

    private static String toJson(Object o) {
//        ObjectMapper mapper = new ObjectMapper();
//        Hoge hoge = mapper.readValue(json, Hoge.class);
        return o.toString(); //FIXME シリアライズ
    }

}
