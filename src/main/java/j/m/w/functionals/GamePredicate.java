package j.m.w.functionals;

import j.m.w.games.Game;
import java.util.function.BiPredicate;

/**
 * Example of using a predicate to do some things.
 */
public class GamePredicate {

    private static BiPredicate<Game, Game> isEqual = (game1, game2) -> game1.equals(game2);

    // This is equivelent to the above line, and uses context reference to infer what it will do, in this case, g1.equals(g2)
    private static BiPredicate<Game, Game> isEqualWithMethodRef = Game::equals;


    public static boolean isEqual(Game game1, Game game2) {

        return isEqual.test(game1, game2);
    }

    public static boolean isEqual2(Game game1, Game game2) {

        return isEqualWithMethodRef.test(game1, game2);
    }
}
