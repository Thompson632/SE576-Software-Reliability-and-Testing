package com.thompson.apps.chess.pieces;

import java.util.List;

import com.thompson.apps.chess.board.Cell;

public class Queen extends AbstractPiece {

	/**
	 * FUNCTION_ABSTRACT: Queen
	 * 
	 * PURPOSE: Default constructor for the Queen Chess Piece that takes in a color
	 * and an initial position that is passed to the super class AbstractPiece.
	 * 
	 * @param boolean isWhite - true if white, false otherwise
	 * @param int     x - Initial X Position
	 * @param int     y - Initial Y Position
	 * 
	 *                END FUNCTION_ABSTRACT
	 */
	public Queen(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public List<Cell> getValidMoves(Cell[][] board) {
		/**
		 * Queen Logic per Wikipedia:
		 * 
		 * A queen combines the power of a rook and bishop and can move any number of
		 * squares along a rank, file, or diagonal, but cannot leap over other pieces.
		 */

		validMoves.clear();

		// Horizontal Moves
		validateHorizontalMoves(board);

		// Vertical Moves
		validateVerticalMoves(board);

		// Diagonal Moves
		validateDiagonalMoves(board);

		return validMoves;
	}

	@Override
	public PieceEnum getPieceEnum() {
		return PieceEnum.QUEEN;
	}
}