package ru.netology;

public class MovieManager {

    private int Movies;

    private MovieRepository service;
    private MovieRepository[] repo;

    public MovieManager() {
        Movies = 10;
        repo = new MovieRepository[0];
    }

    public MovieManager(int Movies) {
        this.Movies = Movies;
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
        for (int i = 0; i < result.length; i++) {
            result[i] = repo[repo.length - 1 - i];
        }
        return result;
    }
}
