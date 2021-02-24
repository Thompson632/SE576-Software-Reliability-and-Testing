package com.thompson.apps.chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.thompson.apps.chess.pieces.AbstractPiece;
import com.thompson.apps.chess.pieces.Bishop;
import com.thompson.apps.chess.pieces.King;
import com.thompson.apps.chess.pieces.Knight;
import com.thompson.apps.chess.pieces.Pawn;
import com.thompson.apps.chess.pieces.Queen;
import com.thompson.apps.chess.pieces.Rook;

public class TestMain {
	Main main = null;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		main = new Main();
	}

	@After
	public void tearDown() throws Exception {
		main = null;
	}

	@Test
	public void testSetLocalPieces_WhiteNullPieces_Exception() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("No White pieces have been entered!");

		// Null Pieces
		main.setLocalPieces(null, true);
	}

	@Test
	public void testSetLocalPieces_WhiteEmptyPieces_Exception() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("No White pieces have been entered!");

		// Null Pieces
		main.setLocalPieces("", true);
	}

	@Test
	public void testSetLocalPieces_WhitePieces_NullConvertedPiece() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Piece Ca1 was unable to be converted to a Chess Piece. Invalid entry!");

		main.setLocalPieces("Ca1", true);
		// White Pieces
		assertTrue(main.getWhitePieces().isEmpty());
		assertEquals(0, main.getWhitePieces().size());
		// Black Pieces
		assertTrue(main.getBlackPieces().isEmpty());
		assertEquals(0, main.getBlackPieces().size());
	}

	@Test
	public void testSetLocalPieces_WhitePieces() throws Exception {
		main.setLocalPieces("Ra1", true);
		// White Pieces
		assertEquals(1, main.getWhitePieces().size());
		assertTrue(main.getWhitePieces().get(0) instanceof Rook);
		// Black Pieces
		assertTrue(main.getBlackPieces().isEmpty());
		assertEquals(0, main.getBlackPieces().size());
	}

	@Test
	public void testSetLocalPieces_BlackNullPieces_Exception() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("No Black pieces have been entered!");

		// Null Pieces
		main.setLocalPieces(null, false);
	}

	@Test
	public void testSetLocalPieces_BlackEmptyPieces_Exception() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("No Black pieces have been entered!");

		// Null Pieces
		main.setLocalPieces("", false);
	}

	@Test
	public void testSetLocalPieces_BlackPieces_NullConvertedPiece() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Piece Ca1 was unable to be converted to a Chess Piece. Invalid entry!");

		main.setLocalPieces("Ca1", false);
		// White Pieces
		assertTrue(main.getWhitePieces().isEmpty());
		assertEquals(0, main.getWhitePieces().size());
		// Black Pieces
		assertTrue(main.getBlackPieces().isEmpty());
		assertEquals(0, main.getBlackPieces().size());
	}

	@Test
	public void testSetLocalPieces_BlackPieces() throws Exception {
		main.setLocalPieces("Ra8", false);
		// White Pieces
		assertEquals(1, main.getBlackPieces().size());
		assertTrue(main.getBlackPieces().get(0) instanceof Rook);
		// Black Pieces
		assertTrue(main.getWhitePieces().isEmpty());
		assertEquals(0, main.getWhitePieces().size());
	}

	@Test
	public void testConvertStringToPiece_WhitePieces() {
		AbstractPiece actual = null;

		// Null - Piece less than 3 characters
		actual = main.convertStringToPiece("Ra", true);
		assertEquals(null, actual);

		// Null - Invalid First Character
		actual = main.convertStringToPiece("Ca1", true);
		assertEquals(null, actual);
		actual = main.convertStringToPiece("1a1", true);
		assertEquals(null, actual);

		// King
		actual = main.convertStringToPiece("Ke1", true);
		assertTrue(actual instanceof King);
		assertTrue(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(4, actual.getY());

		// Queen
		actual = main.convertStringToPiece("Qd1", true);
		assertTrue(actual instanceof Queen);
		assertTrue(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(3, actual.getY());

		// Rook
		actual = main.convertStringToPiece("Ra1", true);
		assertTrue(actual instanceof Rook);
		assertTrue(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(0, actual.getY());

		// Bishop
		actual = main.convertStringToPiece("Bc1", true);
		assertTrue(actual instanceof Bishop);
		assertTrue(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(2, actual.getY());

		// Knight
		actual = main.convertStringToPiece("Nb1", true);
		assertTrue(actual instanceof Knight);
		assertTrue(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(1, actual.getY());

		// Pawn
		actual = main.convertStringToPiece("Pa2", true);
		assertTrue(actual instanceof Pawn);
		assertTrue(actual.isWhite());
		assertEquals(1, actual.getX());
		assertEquals(0, actual.getY());
	}

	@Test
	public void testConvertStringToPiece_BlackPieces() {
		AbstractPiece actual = null;

		// Null - Piece less than 3 characters
		actual = main.convertStringToPiece("Ra", false);
		assertEquals(null, actual);

		// Null - Invalid First Character
		actual = main.convertStringToPiece("Ca1", false);
		assertEquals(null, actual);
		actual = main.convertStringToPiece("1a1", false);
		assertEquals(null, actual);

		// King
		actual = main.convertStringToPiece("Ke1", false);
		assertTrue(actual instanceof King);
		assertFalse(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(4, actual.getY());

		// Queen
		actual = main.convertStringToPiece("Qd1", false);
		assertTrue(actual instanceof Queen);
		assertFalse(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(3, actual.getY());

		// Rook
		actual = main.convertStringToPiece("Ra1", false);
		assertTrue(actual instanceof Rook);
		assertFalse(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(0, actual.getY());

		// Bishop
		actual = main.convertStringToPiece("Bc1", false);
		assertTrue(actual instanceof Bishop);
		assertFalse(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(2, actual.getY());

		// Knight
		actual = main.convertStringToPiece("Nb1", false);
		assertTrue(actual instanceof Knight);
		assertFalse(actual.isWhite());
		assertEquals(0, actual.getX());
		assertEquals(1, actual.getY());

		// Pawn
		actual = main.convertStringToPiece("Pa2", false);
		assertTrue(actual instanceof Pawn);
		assertFalse(actual.isWhite());
		assertEquals(1, actual.getX());
		assertEquals(0, actual.getY());
	}

	@Test
	public void testGetPieceToMove_NullPiece_Exception() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("No piece has been entered!");

		// Null Piece
		main.getPieceToMove(null);
	}

	@Test
	public void testGetPieceToMove_EmptyPiece_Exception() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("No piece has been entered!");

		// Null Piece
		main.getPieceToMove("");
	}
	
	@Test
	public void testGetPieceToMove_NullConvertedPiece() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Piece Ca1 was unable to be converted to a Chess Piece. Invalid entry!");

		main.getPieceToMove("Ca1");
	}
	
	@Test
	public void testGetPieceToMove_NotInEitherPieceList() throws Exception {
		exception.expect(Exception.class);
		exception.expectMessage("Piece ROOK A1 is not found in either the White or Black List of Pieces!");

		main.getPieceToMove("Ra1");
	}
	
	@Test
	public void testGetPieceToMove_WhitePiece() throws Exception {
		// Add Rook to White Piece's List
		main.setLocalPieces("Ra1", true);
		
		// Choosing Ra1 to Move
		main.getPieceToMove("Ra1");
		assertTrue(main.getPiece() instanceof Rook);
		assertTrue(main.getPiece().isWhite());
		assertEquals(0, main.getPiece().getX());
		assertEquals(0, main.getPiece().getY());
	}
	
	@Test
	public void testGetPieceToMove_BlackPiece() throws Exception {
		// Add Rook to Black Piece's List
		main.setLocalPieces("Ra1", false);
		
		// Choosing Ra1 to Move
		main.getPieceToMove("Ra1");
		assertTrue(main.getPiece() instanceof Rook);
		assertFalse(main.getPiece().isWhite());
		assertEquals(0, main.getPiece().getX());
		assertEquals(0, main.getPiece().getY());
	}
}
