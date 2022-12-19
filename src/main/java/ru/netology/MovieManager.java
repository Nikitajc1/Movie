package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private int Movies;

    private MovieRepository service;
    private MovieRepository[] repo;

    public MovieManager() {
        Movies = 10;
        repo = new MovieRepository[0];
    }

    public MovieManager(int movies) {
        this.Movies = movies;
        repo = new MovieRepository[Movies];
    }

    public void addNew(MovieRepository film) {
        MovieRepository[] packs = new MovieRepository[repo.length + 1];
        for (int i = 0; i < repo.length; i++) {
            packs[i] = repo[i];
        }
        packs[packs.length - 1] = film;
        repo = packs;
    }

    public MovieRepository[] findAll() {
        return repo;
    }

    public MovieRepository[] findLast() {
        int resultLength;
        if (Movies == 10) {
            resultLength = 10;
        } else {
            resultLength = Movies;
        }
        MovieRepository[] result = new MovieRepository[resultLength];
        List<MovieRepository> resultList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            result[i] = repo[repo.length - 1 - i];
        }
        for (int i = 0; i < result.length; i++){
            if (result[i] != null) {
                resultList.add(result[i]);
            }
        }
        MovieRepository[] resultWithoutNull = new MovieRepository[resultList.size()];
        for (int i = 0; i < resultList.size(); i++){
            resultWithoutNull[i] = resultList.get(i);
        }
        return resultWithoutNull;
    }
}
