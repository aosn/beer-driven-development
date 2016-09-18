package io.github.aosn.camp2016.ui.service;

public interface EntryService {

    /**
     * Create new game
     *
     * @param userNames The names of users separated by `\n`
     * @return succeeded | failed
     */
    boolean create(String userNames);
}
