package j.m.w.games;

import java.time.LocalDate;

/**
 * A simple video game object.
 */
public class Game {

    private String title;
    private Double cost;
    private LocalDate releasedDate;

    public Game(String title, Double cost, LocalDate releasedDate) {
        this.title = title;
        this.cost = cost;
        this.releasedDate = releasedDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }
}