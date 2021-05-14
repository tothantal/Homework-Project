package boardgame;

import boardgame.model.Direction;
import boardgame.model.Game;
import boardgame.model.Position;

import javax.xml.bind.JAXBException;

/**
 * The Controller part of the MVC architecture
 */
public class GameController {

    private final Game game;
    private final GameView view;

    public GameController(Game game, GameView view) {
        this.game = game;
        this.view = view;
    }


    /**
     * Sets the {@code Player}'s name.
     *
     * @param name	the {@code Player}'s new name
     */
    public void setPlayerName(String name) {
        game.getPlayer().setName(name);
    }


    /**
     * Sets the number of moves the {@code Player} made.
     *
     * @param moves	the new number of moves
     */
    public void setPlayerMoves(int moves) {
        game.getPlayer().setMoves(moves);
    }


    /**
     * Sets the current {@code Position}
     *
     * @param position	the new {@code Position}
     */
    public void setCurrentPosition(Position position) {
        game.setPosition(position);
    }


    /**
     * Gets the name of the {@code Player}.
     *
     * @return	the name of the {@code Player}.
     */
    public String getPlayerName() {
        return game.getPlayer().getName();
    }


    /**
     * Gets the number of moves the {@code Player} made.
     *
     * @return	the number of moves the {@code Player} made
     */
    public int getPlayerMoves() {
        return game.getPlayer().getMoves();
    }


    /**
     * Gets the current {@code Position}
     *
     * @return	the current {@code Position}
     */
    public Position getCurrentPosition() {
        return game.getPosition();
    }


    /**
     * Increases the {@code Player} moves by one.
     */
    public void increasePlayerMoves() {
        game.getPlayer().increaseMoves();
    }


    /**
     * Moves the current {@code Position} towards the specified {@code Direction} by one.
     *
     * @param direction	the {@code Direction} the {@code Position} will change towards by one
     */
    public void moveCurrentPosition(Direction direction) {
        game.move(direction);
    }


    /**
     * Saves the score of the current player via the controller
     * @throws JAXBException
     */
    public void saveCurrentScore() throws JAXBException {
        game.saveScore();
    }


    /**
     * Moves the contents of the {@code Tile} at the current {@code Position}
     * towards the specified {@code Direction}. Will only do this if the move is valid.
     *
     * @param direction	the specified {@code Direction} of movement
     */
    public boolean moveTowards(Direction direction) {
        return game.moveTowards(direction);
    }


    /**
     * Temporary
     */
    public void drawBoard() {
        view.drawBoardState(game.getBoard(), this.getCurrentPosition());
    }


    /**
     * Temporary
     */
    public void drawHighscore() {
        view.drawHighscore(game.getScore());
    }
}
