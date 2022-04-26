package j.m.w.optionals;

import j.m.w.functionals.RandomGameSupplier;
import j.m.w.games.Game;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExamplesTest {

    @Test
    public void getTotalPriceOfGamesReturnsEmptyOptional() {

        Optional<Double> emptyOptional = OptionalExamples.getTotalPriceOfGames(null);

        // ensure its not present
        Assertions.assertFalse(emptyOptional.isPresent());

        // get some other value if its not there
        Assertions.assertEquals(20.25, emptyOptional.orElse(20.25));

        // get value from a Consumer if nothings there
        Assertions.assertNotNull(emptyOptional.orElseGet(() -> RandomGameSupplier.createNewGame().getCost()));

        // throw exception if the optional isn't there
        try {
            emptyOptional.orElseThrow(() -> new IllegalStateException("test"));
        } catch (IllegalStateException e) {
            Assertions.assertTrue(true);
        }
    }

    @Test
    public void getTotalPriceOfGamesCalculatesCorrectAmount() {

        Game game1 = RandomGameSupplier.createNewGame();
        Game game2 = RandomGameSupplier.createNewGame();
        Game game3 = RandomGameSupplier.createNewGame();
        Double expectedAmount = game1.getCost() + game2.getCost() + game3.getCost();
        List<Game> games = Arrays.asList(game1, game2, game3);

        Optional<Double> optionalPrice = OptionalExamples.getTotalPriceOfGames(games);
        Double actualPrice = optionalPrice.isPresent() ? optionalPrice.get() : null;

        Assertions.assertEquals(expectedAmount, actualPrice);
    }
}
