package com.thompson.apps.chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thompson.apps.chess.board.Cell;
import com.thompson.apps.chess.board.ChessBoard;

public class TestRook {
	ChessBoard board = null;

	AbstractPiece piece = null;

	List<Cell> moves = null;

	@Before
	public void setUp() throws Exception {
		board = new ChessBoard();
		board.setDefaultBoard();
	}

	@After
	public void tearDown() throws Exception {
		board = null;
	}

	public void testDefaultRook_WhitePieces() {
		// First Rook
		piece = new Rook(true, 0, 0);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert toString
		assertEquals("R", piece.toString());

		// Second Rook
		piece = new Rook(true, 0, 7);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert toString
		assertEquals("R", piece.toString());
	}

	@Test
	public void testDefaultRook_DefaultPieces() {
		// First Rook
		piece = new Rook(false, 7, 0);

		// Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("r", piece.toString());

		// Second Rook
		piece = new Rook(false, 7, 7);

		// Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("r", piece.toString());
	}
}
