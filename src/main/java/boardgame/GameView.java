package boardgame;

import boardgame.model.Board;
import boardgame.model.Highscore;
import boardgame.model.Position;

/**
 * The View part of the MVC architecture
 * TODO
 */
public class GameView {

    /**
     * Temporary
     *
     * @param board
     * @param currentPosition
     */
    public void drawBoardState(Board board, Position currentPosition) {
        System.out.println(board.toString() + "\n\n"
                + currentPosition.toString() + ": " + board.at(currentPosition));
    }

    /**
     * Temporary
     *
     * @param highscore
     */
    public void drawHighscore(Highscore highscore) {
        System.out.println(highscore.toString());
    }
}
