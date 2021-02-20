package com.thompson.apps.chess.pieces;

import java.util.List;

import com.thompson.apps.chess.board.Cell;

public class Knight extends AbstractPiece {

	public Knight(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public List<Cell> getValidMoves(Cell[][] board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PieceEnum getPieceEnum() {
		return PieceEnum.KNIGHT;
	}

}
