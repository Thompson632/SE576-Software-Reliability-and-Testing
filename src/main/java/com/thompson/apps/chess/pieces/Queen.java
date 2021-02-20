package com.thompson.apps.chess.pieces;

import java.util.List;

import com.thompson.apps.chess.board.Cell;

public class Queen extends AbstractPiece {

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