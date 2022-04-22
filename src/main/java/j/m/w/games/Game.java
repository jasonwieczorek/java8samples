package j.m.w.games;

import java.time.LocalDate;
import java.util.Objects;

/**
 * A simple video game object.
 */
public class Game {

    private String title;
    private Double cost;
    private LocalDate releasedDate;

    public Game() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(title, game.title) && Objects.equals(cost, game.cost) && Objects.equals(releasedDate, game.releasedDate);
    }

    public boolean test(Game game) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost, releasedDate);
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", cost=" + cost +
                ", releasedDate=" + releasedDate +
                '}';
    }


}