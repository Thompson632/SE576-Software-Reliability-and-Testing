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

		// Initial X for West Validation
		int posX = getX() - 1;

		// Horizontal - West Validation
		while (posX >= 0) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[posX][getY()].getPiece()) {
				validMoves.add(board[posX][getY()]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[posX][getY()].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[posX][getY()]);
				break;
			}

			// Moving to the Left (or West)
			posX--;
		}

		// Initial X for East Validation
		posX = getX() + 1;

		// Horizontal - East Validation
		while (posX < 8) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[posX][getY()].getPiece()) {
				validMoves.add(board[posX][getY()]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[posX][getY()].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[posX][getY()]);
				break;
			}

			// Move to the Right (or East)
			posX++;
		}

		// Initial y for South Validation
		int posY = getY() - 1;

		// Vertical - South Validation
		while (posY >= 0) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[getX()][posY].getPiece()) {
				validMoves.add(board[getX()][posY]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[getX()][posY].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[getX()][posY]);
				break;
			}

			// Move Downwards (or South)
			posY--;
		}

		// Initial Y for North Validation
		posY = getY() + 1;

		// Vertical - North Validation
		while (posY < 8) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[getX()][posY].getPiece()) {
				validMoves.add(board[getX()][posY]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[getX()][posY].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[getX()][posY]);
				break;
			}

			// Move Upwards (or North)
			posY++;
		}

		// Initial X, Y Position for South East Validation
		posX = getX() + 1;
		posY = getY() - 1;

		// Diagonal - South East Validation
		while (posX < 8 && posY >= 0) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[posX][posY].getPiece()) {
				validMoves.add(board[posX][posY]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[posX][posY].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[posX][posY]);
				break;
			}

			posX++;
			posY--;
		}

		// Initial X, Y Position for North West Validation
		posX = getX() - 1;
		posY = getY() + 1;

		// Diagonal - North West Validation
		while (posX >= 0 && posY < 8) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[posX][posY].getPiece()) {
				validMoves.add(board[posX][posY]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[posX][posY].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[posX][posY]);
				break;
			}

			posX--;
			posY++;
		}

		// Initial X, Y Position for South West Validation
		posX = getX() - 1;
		posY = getY() - 1;

		// Diagonal - South West Validation
		while (posX >= 0 && posY >= 0) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[posX][posY].getPiece()) {
				validMoves.add(board[posX][posY]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[posX][posY].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[posX][posY]);
				break;
			}

			posX--;
			posY--;
		}

		// Initial X, Y Position for South East Validation
		posX = getX() + 1;
		posY = getY() + 1;

		// Diagonal - North East Validation
		while (posX < 8 && posY < 8) {
			// Step 1. Check if the Initial Temporary Spot has a piece
			if (null == board[posX][posY].getPiece()) {
				validMoves.add(board[posX][posY]);
			}
			// Step 2. Check if the temporary spot has a piece of the same color
			else if (this.isWhite() == board[posX][posY].getPiece().isWhite()) {
				break;
			}
			// Step 3. If the temporary spot has a piece
			// and its not the current piece color,
			// we can capture the piece
			else {
				validMoves.add(board[posX][posY]);
				break;
			}

			posX++;
			posY++;
		}

		return validMoves;
	}

	@Override
	public PieceEnum getPieceEnum() {
		return PieceEnum.QUEEN;
	}
}