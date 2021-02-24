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

public class TestKing {
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
	public void testDefaultKing_WhitePiece() {
		// First King
		piece = new King(true, 0, 4);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.KING, piece.getPieceEnum());

		// Assert Color
		assertTrue(piece.isWhite());

		// Assert getShortName
		assertEquals("K", piece.getShortName());
	}

	@Test
	public void testDefaultKing_BlackPiece() {
		// First King
		piece = new King(false, 7, 4);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		assertEquals(0, moves.size());

		// Assert Piece Enum
		assertEquals(PieceEnum.KING, piece.getPieceEnum());

		// Assert Color
		assertFalse(piece.isWhite());

		// Assert getShortName
		assertEquals("k", piece.getShortName());
	}

	@Test
	public void testCustomWhiteKing() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_OneWhitePiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_TwoWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(true, 4, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_ThreeWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(true, 2, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_FourWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(true, 2, 2);
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
	public void testCustomWhiteKing_FiveWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(true, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(true, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(true, 4, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_SixWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(true, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(true, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(true, 4, 3);
		board.setCustomPiece(p);

		// Create Pawn at 3, 4
		p = new Pawn(true, 3, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_SevenWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.D3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(true, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(true, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(true, 4, 3);
		board.setCustomPiece(p);

		// Create Pawn at 3, 4
		p = new Pawn(true, 3, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 4
		p = new Pawn(true, 2, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_EightWhitePieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(true, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(true, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(true, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(true, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(true, 4, 3);
		board.setCustomPiece(p);

		// Create Pawn at 3, 4
		p = new Pawn(true, 3, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 4
		p = new Pawn(true, 2, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 3
		p = new Pawn(true, 2, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(0, tileActualMoves.size());
		assertTrue(tileActualMoves.isEmpty());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void testCustomWhiteKing_OneBlackPiece() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_TwoBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(false, 4, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_ThreeBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(false, 2, 2);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_FourBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(false, 2, 2);
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
	public void testCustomWhiteKing_FiveBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(false, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(false, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(false, 4, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_SixBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(false, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(false, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(false, 4, 3);
		board.setCustomPiece(p);

		// Create Pawn at 3, 4
		p = new Pawn(false, 3, 4);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileExpectedMoves, tileActualMoves);
	}

	@Test
	public void testCustomWhiteKing_SevenBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(false, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(false, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(false, 4, 3);
		board.setCustomPiece(p);

		// Create Pawn at 3, 4
		p = new Pawn(false, 3, 4);
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

	@Test
	public void testCustomWhiteKing_EightBlackPieces() {
		// Create Blank Board
		board = new ChessBoard();

		// Create White King at 3, 3
		piece = new King(true, 3, 3);
		// Expected Moves
		tileExpectedMoves.add(Tile.C4);
		tileExpectedMoves.add(Tile.E4);
		tileExpectedMoves.add(Tile.C5);
		tileExpectedMoves.add(Tile.D5);
		tileExpectedMoves.add(Tile.E5);
		tileExpectedMoves.add(Tile.C3);
		tileExpectedMoves.add(Tile.D3);
		tileExpectedMoves.add(Tile.E3);

		// Set Custom King
		board.setCustomPiece(piece);

		// Create Rook at 3, 2
		AbstractPiece p = new Rook(false, 3, 2);
		board.setCustomPiece(p);

		// Create Rook at 4, 2
		p = new Rook(false, 4, 2);
		board.setCustomPiece(p);

		// Create Bishop at 2, 2
		p = new Bishop(false, 2, 2);
		board.setCustomPiece(p);

		// Create Bishop at 4, 4
		p = new Bishop(false, 4, 4);
		board.setCustomPiece(p);

		// Create Pawn at 4, 3
		p = new Pawn(false, 4, 3);
		board.setCustomPiece(p);

		// Create Pawn at 3, 4
		p = new Pawn(false, 3, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 4
		p = new Pawn(false, 2, 4);
		board.setCustomPiece(p);

		// Create Pawn at 2, 3
		p = new Pawn(false, 2, 3);
		board.setCustomPiece(p);

		// Assert Moves
		moves = piece.getValidMoves(board.getChessBoard());
		System.out.println(board.printBoard());
		convertMovesToTiles(moves);
		assertEquals(tileActualMoves, tileActualMoves);
	}
}
