package j.m.w.functionals;

import j.m.w.games.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GamePredicateTest {

    @Test
    public void testGamesAreEqual() {

        Game game1 = RandomGameSupplier.createNewGame();
        Game game2 = new Game();
        game2.setTitle(game1.getTitle());
        game2.setCost(game1.getCost());
        game2.setReleasedDate(game1.getReleasedDate());

        Assertions.assertTrue(GamePredicate.isEqual(game1, game2));
        Assertions.assertTrue(GamePredicate.isEqual2(game1, game2));
    }
}
