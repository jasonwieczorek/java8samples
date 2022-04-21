package j.m.w.functionals;

import j.m.w.games.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomGameSupplierTest {

    @Test
    public void testRandomGameSupplier() {

        List<Game> games = RandomGameSupplier.createLotsOfGames(5);
        Assertions.assertEquals(5, games.size());
    }
}
