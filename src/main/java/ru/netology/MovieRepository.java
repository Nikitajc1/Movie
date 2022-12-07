package ru.netology;

public class MovieRepository {
    private int id;
    private int productId;
    private String name;
    private String genre;
    private int cost;

    public MovieRepository(int id, int productId, String name, String genre, int cost) {
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.genre = genre;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
