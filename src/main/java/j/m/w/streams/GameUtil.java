package j.m.w.streams;

import j.m.w.games.Game;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class GameUtil {

   public static Optional<Long> getTotalNumberOfGames(List<Game> games) {

       if (games == null) {
           return Optional.empty();
       }

       return Optional.of(games.stream().count());
   }

    public static Optional<Game> getCheapestGame(List<Game> games) {

        if (games == null || games.size() == 0) {
            return Optional.empty();
        }

        // min returns an optional (explicit lambda sample)
        return games.stream().min((game1, game2) -> game1.getCost().compareTo(game2.getCost()));
    }

    public static Optional<Game> getMostExpensiveGame(List<Game> games) {

        if (games == null || games.size() == 0) {
            return Optional.empty();
        }

        // min returns an optional
        return games.stream().max(Comparator.comparing(Game::getCost));
    }

}
