package j.m.w.streams;

import j.m.w.functionals.RandomGameSupplier;
import j.m.w.games.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GameUtilTest {

    @Test
    public void testGetTotalNumberOfGames() {

        List<Game> games = RandomGameSupplier.createLotsOfGames(20);
        Assertions.assertEquals(20, GameUtil.getTotalNumberOfGames(games).get());
    }

    @Test
    public void testGetCheapestGame() {

        Game game1 = new Game("game1", 10.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game3", 5.00, LocalDate.now());

        List<Game> games = Arrays.asList(game1, game2, game3);

        Optional<Game> cheapestGame = GameUtil.getCheapestGame(games);
        Assertions.assertEquals(game3, cheapestGame.get());
    }

    @Test
    public void testMostExpensiveGame() {

        Game game1 = new Game("game1", 10.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game3", 5.00, LocalDate.now());

        List<Game> games = Arrays.asList(game1, game2, game3);

        Optional<Game> cheapestGame = GameUtil.getMostExpensiveGame(games);
        Assertions.assertEquals(game2, cheapestGame.get());
    }
}
