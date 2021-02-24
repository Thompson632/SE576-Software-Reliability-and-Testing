package com.thompson.apps.chess.pieces;

import java.util.List;

import com.thompson.apps.chess.board.Cell;

public class Bishop extends AbstractPiece {

	/**
	 * FUNCTION_ABSTRACT: Bishop
	 * 
	 * PURPOSE: Default constructor for the Bishop Chess Piece that takes in a color
	 * and an initial position that is passed to the super class AbstractPiece.
	 * 
	 * @param boolean isWhite - true if white, false otherwise
	 * @param int     x - Initial X Position
	 * @param int     y - Initial Y Position
	 * 
	 *                END FUNCTION_ABSTRACT
	 */
	public Bishop(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public List<Cell> getValidMoves(Cell[][] board) {
		/**
		 * Bishop Move Logic per Wikipedia:
		 * 
		 * A bishop can move any number of squares diagonally, but cannot leap over
		 * other pieces.
		 */

		validMoves.clear();

		// Diagonal Moves
		validateDiagonalMoves(board);

		return validMoves;
	}

	@Override
	public PieceEnum getPieceEnum() {
		return PieceEnum.BISHOP;
	}
}