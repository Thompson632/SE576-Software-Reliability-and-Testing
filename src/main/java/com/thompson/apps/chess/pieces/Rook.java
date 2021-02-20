package com.thompson.apps.chess.pieces;

import java.util.List;

import com.thompson.apps.chess.board.Cell;

public class Rook extends AbstractPiece {

	public Rook(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public List<Cell> getValidMoves(Cell[][] board) {
		/**
		 * Rook Logic per Wikipedia
		 * 
		 * A rook can move any number of squares along a rank or file, but cannot leap
		 * over other pieces. Along with the king, a rook is involved during the king's
		 * castling move.
		 */

		validMoves.clear();
		
		// Horizontal Moves
		validateHorizontalMoves(board);
		
		// Vertical Moves
		validateVerticalMoves(board);
		
		return validMoves;
	}

	@Override
	public PieceEnum getPieceEnum() {
		return PieceEnum.ROOK;
	}
}