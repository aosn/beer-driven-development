package io.github.aosn.camp2016.ui.logic;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import io.github.aosn.camp2016.ui.Config;
import io.github.aosn.camp2016.ui.service.HttpClient;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HttpClientImpl implements HttpClient {

    private static AsyncHttpClient client = new AsyncHttpClient();

    public Optional<String> get(String url) {
        return get(url, Collections.emptyMap());
    }

    public Optional<String> get(String url, Map<String, ?> params) {
        try {
            AsyncHttpClient.BoundRequestBuilder builder = client.preparePut(Config.getApiEndPoint() + url);
            for (Map.Entry<String, ?> p : params.entrySet()) {
                JsonSerializer.serialize(p.getValue()).map(json -> builder.addQueryParam(p.getKey(), json));
            }
            Future<Response> f = builder.execute();
            return Optional.of(f.get().getResponseBody());
        } catch (IOException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // XXX The body is nothing
    public boolean put(String url, Object params) {
        throw new UnsupportedOperationException("FIXME NOT IMPLEMENTED YET");
//        AsyncHttpClient.BoundRequestBuilder builder = client.preparePut(Config.getApiEndPoint() + url);
//        return JsonSerializer.serialize(params)
//                .map(json -> builder.setBody(json).execute())
//                .isPresent();
    }


    public static void main(String[] args) {
        Config.setApiEndPoint("localhost:1337");
        String names = "mikan\nakari";

        System.out.println(JsonSerializer.serialize(new EntryServiceImpl.UserNames(names.trim().split("\n"))));
//        get("", )
    }
}
