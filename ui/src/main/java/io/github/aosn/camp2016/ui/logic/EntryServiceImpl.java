package io.github.aosn.camp2016.ui.logic;

import io.github.aosn.camp2016.ui.Config;
import io.github.aosn.camp2016.ui.service.EntryService;
import io.github.aosn.camp2016.ui.util.HttpClient;

public class EntryServiceImpl implements EntryService {

    @Override
    public boolean create(String userNames) {
        //FIXME Don't use mock
        return HttpClient.putMock(
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
        System.out.println(new EntryServiceImpl().create(names));
    }
}
