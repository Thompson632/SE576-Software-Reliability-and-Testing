package com.thompson.apps.chess.pieces;

import java.util.List;

import com.thompson.apps.chess.board.Cell;

public class Knight extends AbstractPiece {

	public Knight(boolean isWhite, int x, int y) {
		super(isWhite, x, y);
	}

	@Override
	public List<Cell> getValidMoves(Cell[][] board) {
		/**
		 * Knight Logic per Wikipedia: 
		 * 
		 * A knight moves to any of the closest squares that
		 * are not on the same rank, file, or diagonal. (Thus the move forms an
		 * "L"-shape: two squares vertically and one square horizontally, or two squares
		 * horizontally and one square vertically.) The knight is the only piece that
		 * can leap over other pieces.
		 */
		
		validMoves.clear();

		// Step 1. Create Array of X-Position Moves with the understanding that
		// we can have max 8 valid moves.
		int xPositions[] = {
				getX() + 1,
				getX() + 1,
				getX() + 2,
				getX() + 2,
				getX() - 1,
				getX() - 1,
				getX() - 2,
				getX() - 2
		};
		
		// Step 2. Create Array of Y-Positions Moves with the understanding that
		// we can have max 8 valid moves.
		int yPositions[] = {
				getY() - 2,
				getY() + 2,
				getY() - 1,
				getY() + 1,
				getY() - 2,
				getY() + 2,
				getY() - 1,
				getY() + 1
				
		};

		// Step 3. Iterate Each Position
		for (int i = 0; i < 8; i++) {
			int xP = xPositions[i];
			int yP = yPositions[i];

			// Step 4. Verify that we are still on the board
			if ((xP >= 0 && xP < 8) && (yP >= 0 && yP < 8)) {
				Cell c = board[xP][yP];
				AbstractPiece p = c.getPiece();

				// Step 5. If there is no piece at the cell or the piece is not equal to the
				// same color, add the cell as a valid move
				if (null == p || this.isWhite() != p.isWhite()) {
					validMoves.add(c);
				}
			}
		}

		return validMoves;
	}

	@Override
	public PieceEnum getPieceEnum() {
		return PieceEnum.KNIGHT;
	}
}