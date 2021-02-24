package com.thompson.apps.chess.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import com.thompson.apps.chess.pieces.Bishop;
import com.thompson.apps.chess.pieces.King;
import com.thompson.apps.chess.pieces.Knight;
import com.thompson.apps.chess.pieces.Pawn;
import com.thompson.apps.chess.pieces.Queen;
import com.thompson.apps.chess.pieces.Rook;

public class TestCell {
	Cell cell = null;

	@After
	public void tearDown() throws Exception {
		cell = null;
	}

	@Test
	public void testGetPiece() {
		// Null Piece
		cell = new Cell(0, 0, null);
		assertEquals(null, cell.getPiece());

		// Rook
		cell = new Cell(0, 0, new Rook(true, 0, 0));
		assertTrue(cell.getPiece() instanceof Rook);

		// Knight
		cell = new Cell(1, 1, new Knight(true, 1, 1));
		assertTrue(cell.getPiece() instanceof Knight);

		// Bishop
		cell = new Cell(2, 2, new Bishop(true, 2, 2));
		assertTrue(cell.getPiece() instanceof Bishop);

		// Queen
		cell = new Cell(3, 3, new Queen(true, 3, 3));
		assertTrue(cell.getPiece() instanceof Queen);

		// King
		cell = new Cell(4, 4, new King(true, 4, 4));
		assertTrue(cell.getPiece() instanceof King);

		// Pawn
		cell = new Cell(5, 6, new Pawn(true, 5, 5));
		assertTrue(cell.getPiece() instanceof Pawn);
	}

	@Test
	public void testGetX() {
		// Null Piece
		cell = new Cell(0, 0, null);
		assertEquals(0, cell.getX());

		// Rook
		cell = new Cell(0, 0, new Rook(true, 0, 0));
		assertEquals(0, cell.getX());
		
		// Knight
		cell = new Cell(1, 1, new Knight(true, 1, 1));
		assertEquals(1, cell.getX());
		
		// Bishop
		cell = new Cell(2, 2, new Bishop(true, 2, 2));
		assertEquals(2, cell.getX());
		
		// Queen
		cell = new Cell(3, 3, new Queen(true, 3, 3));
		assertEquals(3, cell.getX());
		
		// King
		cell = new Cell(4, 4, new King(true, 4, 4));
		assertEquals(4, cell.getX());
		
		// Pawn
		cell = new Cell(5, 5, new Pawn(true, 5, 5));
		assertEquals(5, cell.getX());
	}

	@Test
	public void testGetY() {
		// Null Piece
		cell = new Cell(0, 0, null);
		assertEquals(0, cell.getY());

		// Rook
		cell = new Cell(0, 0, new Rook(true, 0, 0));
		assertEquals(0, cell.getY());
		
		// Knight
		cell = new Cell(1, 1, new Knight(true, 1, 1));
		assertEquals(1, cell.getY());
		
		// Bishop
		cell = new Cell(2, 2, new Bishop(true, 2, 2));
		assertEquals(2, cell.getY());
		
		// Queen
		cell = new Cell(3, 3, new Queen(true, 3, 3));
		assertEquals(3, cell.getY());
		
		// King
		cell = new Cell(4, 4, new King(true, 4, 4));
		assertEquals(4, cell.getY());
		
		// Pawn
		cell = new Cell(5, 5, new Pawn(true, 5, 5));
		assertEquals(5, cell.getY());
	}

	@Test
	public void testToString() {
		// Null Piece
		cell = new Cell(0, 0, null);
		assertTrue(cell.toString().equals("Empty"));

		// Rook
		cell = new Cell(0, 0, new Rook(true, 0, 0));
		assertTrue(cell.toString().equals("ROOK A1"));
	}
}
