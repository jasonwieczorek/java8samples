package j.m.w.games;

import java.time.LocalDate;
import java.time.Month;
import java.util.function.Predicate;

/**
 * A simple test program using a functional interface
 */
public class TestProgram {

    public static void main(String[] args) {

        Game gearsOfWar = new Game("Gears Of War", 20.00, LocalDate.of(2007, Month.NOVEMBER, 7));

        // Lambda Expression: 'input params' -> 'body of the lambda expression'

        // explicit lambda arguments
        printTitle(gearsOfWar, (Game game) -> { return game.getTitle(); });

        // implicit lambda argument
        printTitle(gearsOfWar, game -> game.getTitle());

        // we don't actually have to use the left side argument, we just return a type compatible with the iface
        printTitle(gearsOfWar, a -> "im a string returned cause I don't have to use the argument " + a);

        // Using Predicate
        gameIsNew(gearsOfWar, game -> game.getReleasedDate().isBefore(LocalDate.now()));
    }

    // My implementation
    private static void printTitle(Game game, Title title) {
        System.out.println(title.getTitle(game));
    }

    private static void gameIsNew(Game game, Predicate<Game> theGame) {
        System.out.println(theGame.test(game));
    }
}
