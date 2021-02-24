package com.thompson.apps.chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thompson.apps.chess.board.Cell;

public class TestAbstractPiece {
	AbstractPiece piece = null;

	@Before
	public void setUp() throws Exception {
		piece = new Rook(true, 0, 0);
	}

	@After
	public void tearDown() throws Exception {
		piece = null;
	}

	@Test
	public void testHashCode_Equals() {
		// Hashcode
		assertEquals(37597203, piece.hashCode());

		Rook rook = new Rook(false, 1, 1);

		// Equals Object
		assertTrue(piece.equals(piece));

		// Equals Null
		assertFalse(piece.equals(null));

		// Equals Class
		assertFalse(piece.equals(new Cell(0, 0, null)));

		// Equals isWhite
		assertFalse(piece.equals(rook));

		// Equals X
		rook = new Rook(true, 1, 1);
		assertFalse(piece.equals(rook));

		// Equals Y
		rook = new Rook(true, 0, 1);
		assertFalse(piece.equals(rook));

		// Equals True
		rook = new Rook(true, 0, 0);
		assertTrue(piece.equals(rook));
	}
}
