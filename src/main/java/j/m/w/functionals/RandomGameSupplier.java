package j.m.w.functionals;

import com.github.javafaker.Faker;
import j.m.w.games.Game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * A simple class that demonstrates the use of a supplier
 */
public class RandomGameSupplier {

    // Random game supplier
    private static Faker faker = new Faker();
    private static Supplier<Game> gameSupplier = () -> new Game(faker.dragonBall().character(), faker.number().randomDouble(2,0,100), LocalDate.now());

    /**
     * Creates a random game
     *
     * @return Game
     */
    public static Game createNewGame() {

        return gameSupplier.get();
    }

    /**
     * Creates a random list of games
     *
     * @param numberOfGames
     * @return List<Game>
     */
    public static List<Game> createLotsOfGames(int numberOfGames) {

        List<Game> games = new ArrayList<>();

        for(int i = 0; i < numberOfGames; i++) {
            games.add(gameSupplier.get());
        }

        return games;
    }
}
