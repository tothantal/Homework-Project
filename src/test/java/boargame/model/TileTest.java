package boargame.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import boardgame.model.Position;
import boardgame.model.Tile;

import org.junit.Before;
import org.junit.Test;



public class TileTest {

    Tile tile;

    @Before
    public void init() {
        tile = new Tile(0, new Position(0, 0));
    }

    @Test
    public void testTile() {
        assertEquals(tile.getValue(), 0);
        assertEquals(tile.getPosition(), new Position(0, 0));
    }

    @Test
    public void testTileToString() {
        assertEquals(tile.toString(), "0");
    }

    @Test
    public void testTileEquals() {
        assertEquals(tile, new Tile(0, new Position(0, 0)));
    }

    @Test
    public void testSetPosition() {
        tile.setPosition(new Position(1, 1));
        Tile otherTile = new Tile(0, new Position(1, 1));
        assertEquals(tile, otherTile);
    }

    @Test
    public void testSetValue() {
        tile.setValue(1);
        assertEquals(1, tile.getValue());
    }

    @Test
    public void testIsMarked() {
        assertFalse(tile.isMarked());
        tile.mark();
        assertTrue(tile.isMarked());
    }

    @Test
    public void testMark() {
        assertFalse(tile.isMarked());
        tile.mark();
        assertTrue(tile.isMarked());
        tile.mark();
        assertTrue(tile.isMarked());
    }

    @Test
    public void testDemark() {
        assertFalse(tile.isMarked());
        tile.demark();
        assertFalse(tile.isMarked());
        tile.mark();
        tile.demark();
        assertFalse(tile.isMarked());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(tile.isEmpty());
        tile.setValue(1);
        assertFalse(tile.isEmpty());
    }
}
