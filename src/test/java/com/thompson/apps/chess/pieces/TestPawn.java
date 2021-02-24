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

public class TestPawn {
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
	public void testDefaultPawn_WhitePieces() {
		// First Pawn
		piece = new Pawn(true, Tile.A2.getX(), Tile.A2.getY());
		tileExpectedMoves.add(Tile.A3);
		tileExpectedMoves.add(Tile.A4);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());

		// Second Pawn
		piece = new Pawn(true, Tile.B2.getX(), Tile.B2.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.B3);
		tileExpectedMoves.add(Tile.B4);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());

		// Third Pawn
		piece = new Pawn(true, Tile.C2.getX(), Tile.C2.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.C4);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());

		// Fourth Pawn
		piece = new Pawn(true, Tile.D2.getX(), Tile.D2.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D4);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());

		// Fifth Pawn
		piece = new Pawn(true, Tile.E2.getX(), Tile.E2.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.E4);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());

		// Sixth Pawn
		piece = new Pawn(true, Tile.F2.getX(), Tile.F2.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.F3);
		tileExpectedMoves.add(Tile.F4);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());

		// Seventh Pawn
		piece = new Pawn(true, Tile.G2.getX(), Tile.G2.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.G3);
		tileExpectedMoves.add(Tile.G4);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());

		// Eighth Pawn
		piece = new Pawn(true, Tile.H2.getX(), Tile.H2.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.H3);
		tileExpectedMoves.add(Tile.H4);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("P", piece.getShortName());
	}

	@Test
	public void testDefaultPawn_BlackPieces() {
		// First Pawn
		piece = new Pawn(false, Tile.A7.getX(), Tile.A7.getY());
		tileExpectedMoves.add(Tile.A6);
		tileExpectedMoves.add(Tile.A5);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());

		// Second Pawn
		piece = new Pawn(false, Tile.B7.getX(), Tile.B7.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.B6);
		tileExpectedMoves.add(Tile.B5);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());

		// Third Pawn
		piece = new Pawn(false, Tile.C7.getX(), Tile.C7.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.C6);
		tileExpectedMoves.add(Tile.C5);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());

		// Fourth Pawn
		piece = new Pawn(false, Tile.D7.getX(), Tile.D7.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.D6);
		tileExpectedMoves.add(Tile.D5);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());

		// Fifth Pawn
		piece = new Pawn(false, Tile.E7.getX(), Tile.E7.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.E6);
		tileExpectedMoves.add(Tile.E5);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());

		// Sixth Pawn
		piece = new Pawn(false, Tile.F7.getX(), Tile.F7.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.F6);
		tileExpectedMoves.add(Tile.F5);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());

		// Seventh Pawn
		piece = new Pawn(false, Tile.G7.getX(), Tile.G7.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.G6);
		tileExpectedMoves.add(Tile.G5);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());

		// Eighth Pawn
		piece = new Pawn(false, Tile.H7.getX(), Tile.H7.getY());
		tileExpectedMoves.clear();
		tileExpectedMoves.add(Tile.H6);
		tileExpectedMoves.add(Tile.H5);

		// Assert Moves
		tileActualMoves.clear();
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);

		// Assert Piece Enum
		assertEquals(PieceEnum.PAWN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("p", piece.getShortName());
	}

	@Test
	public void testCustomWhitePawn_NoMoves() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Pawn at D4
		piece = new Pawn(true, Tile.D8.getX(), Tile.D8.getY());
		// Expected Moves

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}

	@Test
	public void testCustomWhitePawn_WhitePieceInFront() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Pawn at D4
		piece = new Pawn(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Create Pawn at D5
		AbstractPiece p = new Pawn(true, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}

	@Test
	public void testCustomWhitePawn_WhitePieceToLeftAndRight() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Pawn at D4
		piece = new Pawn(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.D5);

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Create Pawn at C5
		AbstractPiece p = new Pawn(true, Tile.C5.getX(), Tile.C5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C5
		p = new Pawn(true, Tile.E5.getX(), Tile.E5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileActualMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhitePawn_BlackPieceToLeftAndRight() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Pawn at D4
		piece = new Pawn(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.E5);

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Create Pawn at C5
		AbstractPiece p = new Pawn(false, Tile.C5.getX(), Tile.C5.getY());
		board.setCustomPiece(p);

		// Create Pawn at C5
		p = new Pawn(false, Tile.E5.getX(), Tile.E5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileActualMoves, tileActualMoves);
	}

	@Test
	public void testCustomBlackPawn_NoMoves() {
		// Create Blank Board
		board = new ChessBoard();

		// Create Black Pawn at D4
		piece = new Pawn(false, Tile.D1.getX(), Tile.D1.getY());
		// Expected Moves

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}

	@Test
	public void testCustomBlackPawn_BlackPieceInFront() {
		// Create Blank Board
		board = new ChessBoard();

		// Create Black Pawn at D4
		piece = new Pawn(false, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Create Pawn at D5
		AbstractPiece p = new Pawn(false, Tile.D3.getX(), Tile.D3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}

	@Test
	public void testCustomBlackPawn_BlackPieceToLeftAndRight() {
		// Create Blank Board
		board = new ChessBoard();

		// Create Black Pawn at D4
		piece = new Pawn(false, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Create Pawn at C5
		AbstractPiece p = new Pawn(false, Tile.C3.getX(), Tile.C3.getY());
		board.setCustomPiece(p);

		// Create Pawn at C5
		p = new Pawn(false, Tile.E3.getX(), Tile.E3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileActualMoves, tileActualMoves);
	}

	@Test
	public void testCustomBlackPawn_WhitePieceToLeftAndRight() {
		// Create Blank Board
		board = new ChessBoard();

		// Create Black Pawn at D4
		piece = new Pawn(false, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom Pawn
		board.setCustomPiece(piece);

		// Create Pawn at C5
		AbstractPiece p = new Pawn(true, Tile.C3.getX(), Tile.C3.getY());
		board.setCustomPiece(p);

		// Create Pawn at C5
		p = new Pawn(true, Tile.E3.getX(), Tile.E3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileActualMoves, tileActualMoves);
	}
}
