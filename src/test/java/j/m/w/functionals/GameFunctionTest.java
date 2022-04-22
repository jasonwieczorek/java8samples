package j.m.w.functionals;

import j.m.w.games.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameFunctionTest {

    @Test
    public void testPercentageDiscount() {

        Double tenPercentOff = .90;
        Game game = RandomGameSupplier.createNewGame();
        Double expectedDiscount = game.getCost() * tenPercentOff;
        game = GameFunction.discountGame(game, tenPercentOff);

        Assertions.assertEquals(expectedDiscount, game.getCost());
    }
}
