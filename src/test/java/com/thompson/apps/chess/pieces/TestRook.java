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
		piece = new Rook(true, Tile.A1.getX(), Tile.A1.getY());

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("R", piece.getShortName());

		// Second Rook
		piece = new Rook(true, Tile.H1.getX(), Tile.H1.getY());

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("R", piece.getShortName());
	}

	@Test
	public void testDefaultRook_BlackPieces() {
		// First Rook
		piece = new Rook(false, Tile.A8.getX(), Tile.A8.getY());

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("r", piece.getShortName());

		// Second Rook
		piece = new Rook(false, Tile.H8.getX(), Tile.H8.getY());

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.ROOK, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("r", piece.getShortName());
	}

	@Test
	public void testCustomWhiteRook() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.D6);
		tileExpectedMoves.add(Tile.D7);
		tileExpectedMoves.add(Tile.D8);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_OneWhitePiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(true, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_TwoWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(true, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Create Knight at C4
		p = new Knight(true, Tile.C4.getX(), Tile.C4.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_ThreeWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(true, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Create Knight at C4
		p = new Knight(true, Tile.C4.getX(), Tile.C4.getY());
		board.setCustomPiece(p);

		// Create Knight at E4
		p = new Knight(true, Tile.E4.getX(), Tile.E4.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_FourWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(true, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Create Rook at C4
		p = new Rook(true, Tile.C4.getX(), Tile.C4.getY());
		board.setCustomPiece(p);

		// Create Knight at E4
		p = new Knight(true, Tile.E4.getX(), Tile.E4.getY());
		board.setCustomPiece(p);

		// Create Bishop at D3
		p = new Bishop(true, Tile.D3.getX(), Tile.D3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}

	@Test
	public void testCustomWhiteRook_OneBlackPiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.B4);
		tileExpectedMoves.add(Tile.A4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(false, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_TwoBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.F4);
		tileExpectedMoves.add(Tile.G4);
		tileExpectedMoves.add(Tile.H4);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(false, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Create Rook at C4
		p = new Rook(false, Tile.C4.getX(), Tile.C4.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_ThreeBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.D2);
		tileExpectedMoves.add(Tile.D1);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(false, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Create Rook at C4
		p = new Rook(false, Tile.C4.getX(), Tile.C4.getY());
		board.setCustomPiece(p);

		// Create Knight at E4
		p = new Knight(false, Tile.E4.getX(), Tile.E4.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteRook_FourBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White Rook at D4
		piece = new Rook(true, Tile.D4.getX(), Tile.D4.getY());
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.D3);

		// Set Custom Rook
		board.setCustomPiece(piece);

		// Create Rook at D5
		AbstractPiece p = new Rook(false, Tile.D5.getX(), Tile.D5.getY());
		board.setCustomPiece(p);

		// Create Rook at C4
		p = new Rook(false, Tile.C4.getX(), Tile.C4.getY());
		board.setCustomPiece(p);

		// Create Knight at E4
		p = new Knight(false, Tile.E4.getX(), Tile.E4.getY());
		board.setCustomPiece(p);

		// Create Knight at D3
		p = new Knight(false, Tile.D3.getX(), Tile.D3.getY());
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}
}