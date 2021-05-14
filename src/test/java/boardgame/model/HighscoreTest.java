package boardgame.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

public class HighscoreTest {

    Highscore highscore;

    Player player1;
    Player player2;
    Player player3;

    @Before
    public void init() {

        highscore = new Highscore();

        player1 = new Player("Adam");
        player2 = new Player("Bob");
        player3 = new Player("Charlie");

        highscore.addScore(player1);
        highscore.addScore(player2);
        highscore.addScore(player3);

    }

    @Test
    public void testGetScores() {

        assertEquals(highscore.getScores().get(0), player1);
        assertEquals(highscore.getScores().get(1), player2);
        assertEquals(highscore.getScores().get(2), player3);

    }

    @Test
    public void testGetScore() {

        assertEquals(highscore.getScore(), player1);

    }


    @Test
    public void testSetScores() {

        Player testPlayer = new Player("Daniel");
        List<Player> testScore = new ArrayList<>();

        testScore.add(testPlayer);
        highscore.setScores(testScore);

        assertEquals(highscore.getScore(), testPlayer);

    }

    @Test
    public void testOrder() {

        highscore.getScores().get(1).increaseMoves();
        highscore.getScores().get(0).increaseMoves();
        highscore.getScores().get(0).increaseMoves();

        highscore.order();

        assertEquals(highscore.getScores().get(0), player3);
        assertEquals(highscore.getScores().get(1), player2);
        assertEquals(highscore.getScores().get(2), player1);

    }

    @Test
    public void testFlush() {

        assertEquals(highscore.getScores().get(0), player1);
        assertEquals(highscore.getScores().get(1), player2);
        assertEquals(highscore.getScores().get(2), player3);

        this.highscore.flush();

        assertNull(highscore.getScores());

    }

    // TODO:    Works with Eclipse
    @Test
    public void testToAndFromXml() throws JAXBException {

        this.highscore.toXML();
        this.highscore.flush();
        this.highscore.fromXML();

        assertEquals(highscore.getScores().get(0).toString(), player1.toString());
        assertEquals(highscore.getScores().get(1).toString(), player2.toString());
        assertEquals(highscore.getScores().get(2).toString(), player3.toString());
    }

    // TODO:    Works with Eclipse
    @Test
    public void testSaveScores() throws JAXBException {

        Player testPlayer = new Player("Daniel");
        List<Player> testScore = new ArrayList<>();


        this.highscore.flush();
        this.highscore.toXML();
        this.highscore.saveScores();

        player3.increaseMoves();
        player2.increaseMoves();
        player2.increaseMoves();
        player1.increaseMoves();
        player1.increaseMoves();
        player1.increaseMoves();

        testScore.add(player3);
        testScore.add(player2);
        testScore.add(player1);
        this.highscore.setScores(testScore);
        this.highscore.saveScores();
        testScore = new ArrayList<>();

        testPlayer.increaseMoves();
        testPlayer.increaseMoves();
        testScore.add(testPlayer);
        this.highscore.setScores(testScore);
        this.highscore.saveScores();

        this.highscore.fromXML();
        assertEquals(this.highscore.getScores().get(0).toString(), player3.toString());
        assertEquals(this.highscore.getScores().get(1).toString(), player2.toString());
        assertEquals(this.highscore.getScores().get(2).toString(), testPlayer.toString());
        assertEquals(this.highscore.getScores().get(3).toString(), player1.toString());

    }
}
