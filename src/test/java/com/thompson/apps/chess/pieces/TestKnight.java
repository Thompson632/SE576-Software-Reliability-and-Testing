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

public class TestKnight {
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
	public void testDefaultKnight_WhitePieces() {
		// First Knight
		piece = new Knight(true, 0, 1);
		// Expected Moves
		tileExpectedMoves.add(Tile.A3);
		tileExpectedMoves.add(Tile.C3);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.KNIGHT, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert toString
		assertEquals("N", piece.toString());

		// Second Knight
		piece = new Knight(true, 0, 6);
		// Expected Moves
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.H3);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.KNIGHT, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert toString
		assertEquals("N", piece.toString());
	}

	@Test
	public void testDefaultKnight_BlackPieces() {
		// First Knight
		piece = new Knight(false, 7, 1);
		// Expected Moves
		tileExpectedMoves.add(Tile.A6);
		tileExpectedMoves.add(Tile.C6);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.KNIGHT, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("n", piece.toString());

		// Second Knight
		piece = new Knight(false, 7, 6);
		// Expected Moves
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.F6);
		tileExpectedMoves.add(Tile.H6);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.KNIGHT, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("n", piece.toString());
	}

	@Test
	public void testCustomWhiteKnight() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_OneWhitePiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_TwoWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(true, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_ThreeWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(true, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(true, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_FourWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(true, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(true, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(true, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_FiveWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(true, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(true, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(true, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(true, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_SixWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(true, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(true, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(true, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(true, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Create Pawn at F3
		p = new Pawn(true, Tile.F3.getX(), Tile.F3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_SevenWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(true, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(true, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(true, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(true, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Create Pawn at F3
		p = new Pawn(true, Tile.F3.getX(), Tile.F3.getY());
		board.setCustomPiece(p);

		// Create Pawn at C2
		p = new Pawn(true, Tile.C2.getX(), Tile.C2.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_EightWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(true, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(true, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(true, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(true, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(true, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Create Pawn at F3
		p = new Pawn(true, Tile.F3.getX(), Tile.F3.getY());
		board.setCustomPiece(p);

		// Create Pawn at C2
		p = new Pawn(true, Tile.C2.getX(), Tile.C2.getY());
		board.setCustomPiece(p);

		// Create Pawn at E2
		p = new Pawn(true, Tile.E2.getX(), Tile.E2.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}

	@Test
	public void testCustomWhiteKnight_OneBlackPiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_TwoBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(false, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_ThreeBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(false, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(false, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_FourBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(false, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(false, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(false, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_FiveBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(false, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(false, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(false, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(false, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_SixBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(false, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(false, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(false, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(false, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Create Pawn at F3
		p = new Pawn(false, Tile.F3.getX(), Tile.F3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_SevenBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(false, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(false, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(false, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(false, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Create Pawn at F3
		p = new Pawn(false, Tile.F3.getX(), Tile.F3.getY());
		board.setCustomPiece(p);

		// Create Pawn at C2
		p = new Pawn(false, Tile.C2.getX(), Tile.C2.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKnight_EightBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Knight at 3, 3
		piece = new Knight(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.B5);
		tileExpectedMoves.add(Tile.F5);
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.C2);
		tileExpectedMoves.add(Tile.E2);

		// Set Custom Knight
		board.setCustomPiece(piece);

		// Create Rook at B5
		AbstractPiece p = new Rook(false, Tile.B5.getX(), Tile.B5.getY());
		board.setCustomPiece(p);

		// Create Rook at F5
		p = new Rook(false, Tile.F5.getX(), Tile.F5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C6
		p = new Pawn(false, Tile.C6.getX(), Tile.C6.getY());
		board.setCustomPiece(p);

		// Create Pawn at E6
		p = new Pawn(false, Tile.E6.getX(), Tile.E6.getY());
		board.setCustomPiece(p);

		// Create Pawn at B3
		p = new Pawn(false, Tile.B3.getX(), Tile.B3.getY());
		board.setCustomPiece(p);

		// Create Pawn at F3
		p = new Pawn(false, Tile.F3.getX(), Tile.F3.getY());
		board.setCustomPiece(p);

		// Create Pawn at C2
		p = new Pawn(false, Tile.C2.getX(), Tile.C2.getY());
		board.setCustomPiece(p);

		// Create Pawn at E2
		p = new Pawn(false, Tile.E2.getX(), Tile.E2.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}
}
