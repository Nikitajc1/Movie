package ru.netology;

public class MovieManager {
    private MovieRepository service;
    public MovieManager(MovieRepository service) { this.service = service;}

    public void addNew(Movie film) {
        service.save(film);
    }

    public Movie[] findLast() {
        int resultLength;
        if (service.Movies == 10) {
            resultLength = 10;
        } else {
            resultLength = service.Movies;
        }
        Movie[] all = service.findAll();
        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = all[all.length - 1 - i];
        }
        return result;
    }

    public void removeManager(int film) {
        service.removeById(film);
    }

    public Movie[] findManager(int film) {
        return service.findById(film);
    }

    public Movie[] removeManager(){
        return service.removeAll();
    }
}
