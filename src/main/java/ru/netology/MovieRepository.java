package ru.netology;

public class MovieRepository {
    private Movie[] repo;
    public int Movies;
    private Movie service;

    public MovieRepository() {
        Movies = 10;
        repo = new Movie[0];
    }

    public MovieRepository(int Movies) {
        this.Movies = Movies;
        repo = new Movie[Movies];
    }

    public void save(Movie film) {
        Movie[] packs = new Movie[repo.length + 1];
        for (int i = 0; i < repo.length; i++) {
            packs[i] = repo[i];
        }
        packs[packs.length - 1] = film;
        repo = packs;
    }

    public Movie[] findAll() {
        return repo;
    }

    public void removeById(int id) {
        Movie[] tmp = new Movie[repo.length - 1];
        int copyToIndex = 0;
        for (Movie item : repo) {
            if (item == null || item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        repo = tmp;
    }

    public Movie[] findById(int id) {
        Movie[] tmp = new Movie[1];
        int copyToIndex = 0;
        for (Movie item : repo) {
            if (item == null || item.getId() == id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        repo = tmp;
        return repo;
    }

    public Movie[] removeAll() {
        return repo = new Movie[] {};
    }
}
