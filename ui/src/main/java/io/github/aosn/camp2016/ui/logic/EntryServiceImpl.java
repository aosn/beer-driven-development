package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.Config;
import io.github.aosn.camp2016.ui.service.EntryService;
import io.github.aosn.camp2016.ui.service.HttpClient;

public class EntryServiceImpl implements EntryService {

    private final HttpClient httpClient;

    public EntryServiceImpl(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public boolean create(String userNames) {
        return httpClient.put(
                "/bdd/game/new",
                new UserNames(userNames.trim().split("\n")));
    }

    public static final class UserNames {
        private String[] array;

        public UserNames() {
        }

        public UserNames(String[] array) {
            this.array = array;
        }

        public String[] getArray() {
            return array;
        }

        public void setArray(String[] array) {
            this.array = array;
        }
    }

    public static void main(String[] args) {
        Config.setApiEndPoint("http://localhost:1337");
        String names = "mikan\nakari";
        System.out.println(new EntryServiceImpl(new HttpClientImpl()).create(names));
    }
}
