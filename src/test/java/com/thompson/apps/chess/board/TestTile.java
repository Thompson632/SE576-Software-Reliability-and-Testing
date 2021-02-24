package com.thompson.apps.chess.board;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTile {

	@Test
	public void testTile() {
		assertEquals(0, Tile.A1.getX());
		assertEquals(0, Tile.A1.getX());
		assertEquals("A1", Tile.A1.getName());

		String actual = Tile.getTileAtPosition(0, 0);
		assertEquals("A1", actual);

		actual = Tile.getTileAtPosition(9, 9);
		assertEquals(null, actual);
	}
}
