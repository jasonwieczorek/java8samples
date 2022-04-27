package j.m.w.functionals;

import j.m.w.games.Game;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A simple class demonstrating the use of a BiFunction.
 */
public class GameFunction {

    // arg1, arg2, return type of the Function
    private static BiFunction<Game, Double, Game> discountGame = (game1, discount) -> {
        game1.setCost(game1.getCost() * discount);
        return game1;
    };

    // turns the price of a game into a String (using explicit syntax)
    public static Function<Game, String> costToString = (game) -> {
        return game.getCost().toString();
    };

    public static Game discountGame(Game game, Double percent) throws IllegalArgumentException{

       if (percent >= 1 || percent <= 0) {
            throw new IllegalArgumentException("Discount must be a percentage");
       }

      return discountGame.apply(game, percent);
    }
}
