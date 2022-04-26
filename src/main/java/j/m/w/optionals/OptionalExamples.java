package j.m.w.optionals;

import j.m.w.games.Game;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * A sample class to test some optionals
 */
public class OptionalExamples {

    /**
     * Gets the total price of all the games.
     *
     * @param games
     * @return Optional<Double>
     */
    public static Optional<Double> getTotalPriceOfGames(List<Game> games) {

        if (games == null) {
            return Optional.empty();
        }

        Double totalPrice = new Double(0);

        for (Game game: games) {
            totalPrice += game.getCost();
        }

        return Optional.of(totalPrice);
    }
}
