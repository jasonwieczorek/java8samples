package j.m.w.games;

/**
 * Simple functional interface for getting a games title.
 */
@FunctionalInterface
public interface Title {

    /**
     * A simple functional interface that can accept a String as an argument.
     *
     * @param game
     * @return String
     */
    public String getTitle(Game game);
}
