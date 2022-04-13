package j.m.w.functionals;

import com.github.javafaker.Faker;
import j.m.w.games.Game;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Supplier;

/**
 * A simple class that demonstrates the use of a supplier, which generates a random game
 */
public class RandomGameSupplier {

    // Make a Supplier
    private static Faker faker = new Faker();
    private static Supplier<Game> gameSupplier = () -> new Game(faker.dragonBall().character(), new Random().nextDouble(), LocalDate.now());

    public static Game createNewGame() {

        // Supplier.get will invoke the above lambda to get a random game
        return gameSupplier.get();
    }
}
