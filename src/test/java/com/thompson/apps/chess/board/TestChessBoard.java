package com.thompson.apps.chess.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thompson.apps.chess.pieces.AbstractPiece;
import com.thompson.apps.chess.pieces.Bishop;
import com.thompson.apps.chess.pieces.King;
import com.thompson.apps.chess.pieces.Knight;
import com.thompson.apps.chess.pieces.Pawn;
import com.thompson.apps.chess.pieces.Queen;
import com.thompson.apps.chess.pieces.Rook;

public class TestChessBoard {
	ChessBoard board = null;

	@Before
	public void setUp() throws Exception {
		board = new ChessBoard();
	}

	@After
	public void tearDown() throws Exception {
		board = null;
	}

	@Test
	public void testCreateBlankBoard() {
		Cell[][] tmpBoard = board.getChessBoard();
		assertEquals(8, tmpBoard.length);

		for (int i = 0; i < tmpBoard.length; i++) {
			for (int j = 0; j < tmpBoard.length; j++) {
				assertEquals(null, tmpBoard[i][j].getPiece());
			}
		}
	}

	@Test
	public void setBoard() {
		board.setDefaultBoard();
		Cell[][] tmpBoard = board.getChessBoard();

		// White Rooks
		Cell c = tmpBoard[0][0];
		assertTrue(c.getPiece() instanceof Rook);
		assertTrue(c.getPiece().isWhite());
		c = tmpBoard[0][7];
		assertTrue(c.getPiece() instanceof Rook);
		assertTrue(c.getPiece().isWhite());

		// White Knights
		c = tmpBoard[0][1];
		assertTrue(c.getPiece() instanceof Knight);
		assertTrue(c.getPiece().isWhite());
		c = tmpBoard[0][6];
		assertTrue(c.getPiece() instanceof Knight);
		assertTrue(c.getPiece().isWhite());

		// White Bishops
		c = tmpBoard[0][2];
		assertTrue(c.getPiece() instanceof Bishop);
		assertTrue(c.getPiece().isWhite());
		c = tmpBoard[0][5];
		assertTrue(c.getPiece() instanceof Bishop);
		assertTrue(c.getPiece().isWhite());

		// White Queen
		c = tmpBoard[0][3];
		assertTrue(c.getPiece() instanceof Queen);
		assertTrue(c.getPiece().isWhite());

		// White King
		c = tmpBoard[0][4];
		assertTrue(c.getPiece() instanceof King);
		assertTrue(c.getPiece().isWhite());

		// White Pawns
		for (int i = 0; i < tmpBoard.length; i++) {
			c = tmpBoard[1][i];
			assertTrue(c.getPiece() instanceof Pawn);
			assertTrue(c.getPiece().isWhite());
		}

		// Black Rooks
		c = tmpBoard[7][0];
		assertTrue(c.getPiece() instanceof Rook);
		assertFalse(c.getPiece().isWhite());
		c = tmpBoard[7][7];
		assertTrue(c.getPiece() instanceof Rook);
		assertFalse(c.getPiece().isWhite());

		// Black Knights
		c = tmpBoard[7][1];
		assertTrue(c.getPiece() instanceof Knight);
		assertFalse(c.getPiece().isWhite());
		c = tmpBoard[7][6];
		assertTrue(c.getPiece() instanceof Knight);
		assertFalse(c.getPiece().isWhite());

		// Black Bishops
		c = tmpBoard[7][2];
		assertTrue(c.getPiece() instanceof Bishop);
		assertFalse(c.getPiece().isWhite());
		c = tmpBoard[7][5];
		assertTrue(c.getPiece() instanceof Bishop);
		assertFalse(c.getPiece().isWhite());

		// Black Queen
		c = tmpBoard[7][3];
		assertTrue(c.getPiece() instanceof Queen);
		assertFalse(c.getPiece().isWhite());

		// Black King
		c = tmpBoard[7][4];
		assertTrue(c.getPiece() instanceof King);
		assertFalse(c.getPiece().isWhite());

		// Black Pawns
		for (int i = 0; i < tmpBoard.length; i++) {
			c = tmpBoard[6][i];
			assertTrue(c.getPiece() instanceof Pawn);
			assertFalse(c.getPiece().isWhite());
		}
	}

	@Test
	public void testSetCustomBoard() {
		List<AbstractPiece> w = new ArrayList<AbstractPiece>();
		w.add(new Rook(true, 4, 4));

		List<AbstractPiece> b = new ArrayList<AbstractPiece>();
		b.add(new Rook(false, 5, 5));

		board.setCustomBoard(w, b);

		Cell[][] tmpBoard = board.getChessBoard();

		// White Rook
		Cell c = tmpBoard[4][4];
		assertTrue(c.getPiece() instanceof Rook);
		assertTrue(c.getPiece().isWhite());

		// Black Rook
		c = tmpBoard[5][5];
		assertTrue(c.getPiece() instanceof Rook);
		assertFalse(c.getPiece().isWhite());
	}
}