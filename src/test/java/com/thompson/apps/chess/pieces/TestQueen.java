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

public class TestQueen {
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
	public void testDefaultQueen_WhitePiece() {
		// Queen
		piece = new Queen(true, 0, 3);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());
		assertTrue(moves.isEmpty());

		// Assert Piece Enum
		assertEquals(PieceEnum.QUEEN, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert toString
		assertEquals("Q", piece.toString());
	}

	@Test
	public void testDefaultQueen_BlackPiece() {
		// Queen
		piece = new Queen(false, 7, 3);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());
		assertTrue(moves.isEmpty());

		// Assert Piece Enum
		assertEquals(PieceEnum.QUEEN, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert toString
		assertEquals("q", piece.toString());
	}

	@Test
	public void testCustomWhiteQueen() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
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
	public void testCustomWhiteQueen_OneWhitePiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhitePiece_TwoWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(true, 2, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_ThreeWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(true, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(true, 3, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_FourWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(true, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(true, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(true, 3, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_FiveWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(true, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(true, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(true, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(true, 4, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_SixWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.F2);
		tileExpectedMoves.add(Tile.G1);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.B2);
		tileExpectedMoves.add(Tile.A1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(true, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(true, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(true, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(true, 4, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_SevenWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.F2);
		tileExpectedMoves.add(Tile.G1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(true, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(true, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(true, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(true, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 2
		p = new Pawn(true, 2, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_EightWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(true, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(true, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(true, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(true, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(true, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 2
		p = new Pawn(true, 2, 2);
		board.setCustomPiece(p);

		// Create Pawn at 2, 4
		p = new Pawn(true, 2, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}

	@Test
	public void testCustomWhiteQueen_OneBlackPiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhitePiece_TwoBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(false, 2, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_ThreeBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(false, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(false, 3, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_FourBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(false, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(false, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(false, 3, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_FiveBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
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

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(false, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(false, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(false, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(false, 4, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_SixBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.F2);
		tileExpectedMoves.add(Tile.G1);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.B2);
		tileExpectedMoves.add(Tile.A1);
		tileExpectedMoves.add(Tile.E5);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(false, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(false, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(false, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(false, 4, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_SevenBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.F2);
		tileExpectedMoves.add(Tile.G1);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.E5);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(false, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(false, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(false, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(false, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 2
		p = new Pawn(false, 2, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteQueen_EightBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Queen at 3, 3
		piece = new Queen(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.E3);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.E5);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at 4, 3
		AbstractPiece p = new Rook(false, 4, 3);
		board.setCustomPiece(p);

		// Create Rook at 2, 3
		p = new Rook(false, 2, 3);
		board.setCustomPiece(p);

		// Create Knight at 3, 2
		p = new Knight(false, 3, 2);
		board.setCustomPiece(p);

		// Create Knight at 3, 4
		p = new Knight(false, 3, 4);
		board.setCustomPiece(p);

		// Create Bishop at 4, 2
		p = new Bishop(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(false, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 2
		p = new Pawn(false, 2, 2);
		board.setCustomPiece(p);

		// Create Pawn at 2, 4
		p = new Pawn(false, 2, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}
}
