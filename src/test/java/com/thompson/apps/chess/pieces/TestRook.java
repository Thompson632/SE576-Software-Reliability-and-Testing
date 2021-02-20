package com.thompson.apps.chess.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thompson.apps.chess.board.Cell;
import com.thompson.apps.chess.board.ChessBoard;
import com.thompson.apps.chess.board.Tile;

public class TestRook {
	ChessBoard board = null;

	AbstractPiece piece = null;

	List<Cell> moves = null;

	List<Tile> tileActualMoves = null;
	List<Tile> tileExpectedMoves = null;

	@Before
	public void setUp() throws Exception {
		board = new ChessBoard();
		board.setDefaultBoard();

		tileActualMoves = new ArrayList<Tile>();
		tileExpectedMoves = new ArrayList<Tile>();
	}

	@After
	public void tearDown() throws Exception {
		board = null;

		tileActualMoves = null;
		tileExpectedMoves = null;
	}

	private void convertMovesToTiles(List<Cell> validMoves) {
		boolean hasMoves = true;
		String color = (piece.isWhite() ? "WHITE" : "BLACK");
		System.out.println("LEGAL MOVES FOR " + color + " " + piece.toString() + " at (" + piece.getX() + ","
				+ piece.getY() + "):");

		if (null == validMoves || validMoves.isEmpty()) {
			System.out.println("No legal moves!");
			hasMoves = false;
		} else {
			for (Cell c : validMoves) {
				for (Tile s : Tile.values()) {
					if ((s.getX() == c.getX()) && (s.getY() == c.getY())) {
						tileActualMoves.add(s);
					}
				}
			}
		}

		if (hasMoves) {
			System.out.println(tileActualMoves);
		}

		System.out.println();
	}

	@Test
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
	public void testDefaultRook_BlackPieces() {
		// First Rook
		piece = new Rook(false, 7, 0);

		// Assert Moves
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

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("r", piece.toString());
	}

	@Test
	public void testCustomWhiteRook() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Rook(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.D6);
		tileExpectedMoves.add(Tile.D7);
		tileExpectedMoves.add(Tile.D8);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_OneWhitePiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Rook(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create White Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_TwoBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Rook(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Black Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Black Rook at 3, 2
		p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_ThreeBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Rook(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Black Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Black Rook at 3, 2
		p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Black Knight at 3, 4
		p = new Knight(false, 3, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_FourBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Rook(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Black Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Black Rook at 3, 2
		p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Black Knight at 3, 4
		p = new Knight(false, 3, 4);
		board.setCustomPiece(p);

		// Create Black Rook at 2, 3
		p = new Knight(false, 2, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}
}
