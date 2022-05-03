package j.m.w.streams;

import j.m.w.functionals.RandomGameSupplier;
import j.m.w.games.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public void testGetCheapestGameDuplicateValuesReturnsFirstItemFromList() {

        Game game1 = new Game("game1", 10.00, LocalDate.now());
        Game game2 = new Game("game2", 10.00, LocalDate.now());
        Game game3 = new Game("game3", 10.00, LocalDate.now());

        List<Game> games = Arrays.asList(game2, game3, game1);

        Optional<Game> cheapestGame = GameUtil.getCheapestGame(games);
        Assertions.assertEquals(game2, cheapestGame.get());
    }

    @Test
    public void testMostExpensiveGame() {

        Game game1 = new Game("game1", 10.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game3", 5.00, LocalDate.now());

        List<Game> games = Arrays.asList(game3, game2, game1);

        Optional<Game> cheapestGame = GameUtil.getMostExpensiveGame(games);
        Assertions.assertEquals(game2, cheapestGame.get());
    }

    @Test
    public void testMostExpensiveGameDuplicateValuesReturnsFirstItemFromList() {

        Game game1 = new Game("game1", 20.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game3", 20.00, LocalDate.now());

        List<Game> games = Arrays.asList(game1, game2, game3);

        Optional<Game> cheapestGame = GameUtil.getMostExpensiveGame(games);
        Assertions.assertEquals(game1, cheapestGame.get());
    }

    @Test
    public void testFindFirst() {

        Game game3 = new Game("game3", 20.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game1 = new Game("game1", 20.00, LocalDate.now());

        List<Game> games = Arrays.asList(game3, game2, game1);

        Optional<Game> firstGame = GameUtil.findFirstGame(games);
        Assertions.assertEquals(firstGame.get(), game3);
    }

    @Test
    public void testFindFirstReturnsEmptyOptionalForEmptyList() {

        Optional<Game> firstGame = GameUtil.findFirstGame(new ArrayList<>());
        Assertions.assertFalse(firstGame.isPresent());
    }

    @Test
    public void testDoAllGamesMatch() {

        Game game1 = new Game("game2", 20.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game2", 20.00, LocalDate.now());

        List<Game> games = Arrays.asList(game1, game2, game3);

        boolean allGamesMatch = GameUtil.doAllGamesMatch(games, (game) -> game.getTitle().equals("game2"));
        Assertions.assertTrue(allGamesMatch);
    }

    @Test
    public void testAllGamesDoNotMatch() {

        Game game1 = new Game("game1", 20.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game3", 20.00, LocalDate.now());

        List<Game> games = Arrays.asList(game1, game2, game3);

        boolean allGamesMatch = GameUtil.doAllGamesMatch(games, (game) -> game.getTitle().equals("game2"));
        Assertions.assertFalse(allGamesMatch);
    }

    @Test
    public void testDoAnyGamesMatch() {

        Game game1 = new Game("game1", 20.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game3", 20.00, LocalDate.now());

        List<Game> games = Arrays.asList(game1, game2, game3);

        boolean isAnyGameMatch = GameUtil.doAnyGamesMatch(games, (game) -> game.getTitle().equals("game3"));
        Assertions.assertTrue(isAnyGameMatch);
    }

    @Test
    public void testNoMatch() {

        Game game1 = new Game("game1", 20.00, LocalDate.now());
        Game game2 = new Game("game2", 20.00, LocalDate.now());
        Game game3 = new Game("game3", 20.00, LocalDate.now());

        List<Game> games = Arrays.asList(game1, game2, game3);

        boolean isNoMatch = GameUtil.doNoGamesMatch(games, (game) -> game.getTitle().equals("blah blah"));
        Assertions.assertTrue(isNoMatch);
    }
}
