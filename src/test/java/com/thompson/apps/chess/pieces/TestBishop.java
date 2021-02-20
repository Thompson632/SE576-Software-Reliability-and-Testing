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

public class TestBishop {
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
	public void testDefaultBishop_WhitePieces() {
		// First Bishop
		piece = new Bishop(true, 0, 2);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.BISHOP, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert toString
		assertEquals("B", piece.toString());

		// Second Bishop
		piece = new Bishop(true, 0, 5);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.BISHOP, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert toString
		assertEquals("B", piece.toString());
	}

	@Test
	public void testDefaultBishop_BlackPieces() {
		// First Bishop
		piece = new Bishop(false, 7, 2);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.BISHOP, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("b", piece.toString());

		// Second Bishop
		piece = new Bishop(false, 7, 5);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.BISHOP, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("b", piece.toString());
	}

	@Test
	public void testCustomWhiteBishop() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Bishop(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.B6);
		tileExpectedMoves.add(Tile.A7);
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.F2);
		tileExpectedMoves.add(Tile.G1);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.B2);
		tileExpectedMoves.add(Tile.A1);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.F6);
		tileExpectedMoves.add(Tile.G7);
		tileExpectedMoves.add(Tile.H8);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteBishop_OneWhitePiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Bishop(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.F2);
		tileExpectedMoves.add(Tile.G1);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.B2);
		tileExpectedMoves.add(Tile.A1);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.F6);
		tileExpectedMoves.add(Tile.G7);
		tileExpectedMoves.add(Tile.H8);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create White Bishop at 4, 2
		AbstractPiece p = new Bishop(true, 4, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteBishop_TwoBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Bishop(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.B2);
		tileExpectedMoves.add(Tile.A1);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.F6);
		tileExpectedMoves.add(Tile.G7);
		tileExpectedMoves.add(Tile.H8);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Black Bishop at 4, 2
		AbstractPiece p = new Bishop(false, 4, 2);
		board.setCustomPiece(p);

		// Create Black Bishop at 2, 4
		p = new Bishop(false, 2, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteBishop_ThreeBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Bishop(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.F6);
		tileExpectedMoves.add(Tile.G7);
		tileExpectedMoves.add(Tile.H8);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Black Bishop at 4, 2
		AbstractPiece p = new Bishop(false, 4, 2);
		board.setCustomPiece(p);

		// Create Black Bishop at 2, 4
		p = new Bishop(false, 2, 4);
		board.setCustomPiece(p);

		// Create Black Knight at 2, 2
		p = new Knight(false, 2, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteBishop_FourBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at 3, 3
		piece = new Bishop(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.E5);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Black Bishop at 4, 2
		AbstractPiece p = new Bishop(false, 4, 2);
		board.setCustomPiece(p);

		// Create Black Bishop at 2, 4
		p = new Bishop(false, 2, 4);
		board.setCustomPiece(p);

		// Create Black Knight at 2, 2
		p = new Knight(false, 2, 2);
		board.setCustomPiece(p);

		// Create Black Knight at 4, 4
		p = new Knight(false, 4, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

}
