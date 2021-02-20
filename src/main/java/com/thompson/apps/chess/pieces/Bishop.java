package com.thompson.apps.chess.pieces;

import java.util.List;

import com.thompson.apps.chess.board.Cell;

public class Bishop extends AbstractPiece {

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