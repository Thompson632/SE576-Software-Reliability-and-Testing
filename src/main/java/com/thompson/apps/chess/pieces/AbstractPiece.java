package com.thompson.apps.chess.pieces;

import java.util.ArrayList;
import java.util.List;

import com.thompson.apps.chess.board.Cell;

public abstract class AbstractPiece {
	/* Initial X Location - Not on Board */
	private int x = -1;
	
	/* Initial Y Location - Not on Board */
	private int y = -1;
	
	/* Piece Color */
	private boolean isWhite = false;
	
	/* Represents a List of Valid Moves */
	protected List<Cell> validMoves = null;
	
	/**
	 * FUNCTION_ABSTRACT: AbstractPiece
	 * 
	 * PURPOSE: Default constructor for the AbstractPiece. 
	 * 
	 * @param boolean 
	 * 		isWhite - true if white, false if black
	 * @param int 
	 * 		x - X position of the Piece at creation
	 * @param int
	 * 		y - Y Position of the Piece at creation
	 * 
	 *                END FUNCTION_ABSTRACT
	 */
	public AbstractPiece(boolean isWhite, int x, int y) {
		this.isWhite = isWhite;
		this.x = x;
		this.y = y;
		
		validMoves = new ArrayList<Cell>();
	}
	
	/**
	 * FUNCTION_ABSTRACT: isWhite
	 * 
	 * PURPOSE: Returns whether the piece is white or black
	 * 
	 * @return boolean isWhite
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public boolean isWhite() {
		return isWhite;
	}
	
	/**
	 * FUNCTION_ABSTRACT: getValidMoves
	 * 
	 * PURPOSE: Creates a list of valid moves based on the current state of the
	 * board.
	 * 
	 * @param Cell board[][] - 2D Array of the current state of the Chess Board
	 * @return List<Cell> - List of Valid Moves
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public abstract List<Cell> getValidMoves(Cell board[][]);
	
	/**
	 * FUNCTION_ABSTRACT: validateHorizontalMoves
	 * 
	 * PURPOSE: Validates East and West Horizontal Moves
	 * 
	 * @param Cell[][] board
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateHorizontalMoves(Cell[][] board) {
		int posX = getX() - 1;
		validateWestMoves(board, posX);

		posX = getX() + 1;
		validateEastMoves(board, posX);

	}

	/**
	 * FUNCTION_ABSTRACT: validateVerticalMoves
	 * 
	 * PURPOSE: Validates South and North Vertical Moves
	 * 
	 * @param Cell[][] board
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateVerticalMoves(Cell[][] board) {
		int posY = getY() - 1;
		validateSouthMoves(board, posY);

		posY = getY() + 1;
		validateNorthMoves(board, posY);
	}

	/**
	 * FUNCTION_ABSTRACT: validateDiagonalMoves
	 * 
	 * PURPOSE: Validates all Diagonal Moves
	 * 
	 * @param Cell[][] board
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateDiagonalMoves(Cell[][] board) {
		int posX = getX() + 1;
		int posY = getY() - 1;
		validateSouthEastMoves(board, posX, posY);

		posX = getX() - 1;
		posY = getY() + 1;
		validateNorthWestMoves(board, posX, posY);

		posX = getX() - 1;
		posY = getY() - 1;
		validateSouthWestMoves(board, posX, posY);

		posX = getX() + 1;
		posY = getY() + 1;
		validateNorthEastMoves(board, posX, posY);

	}

	/**
	 * FUNCTION_ABSTRACT: validateSouthEastMoves
	 * 
	 * PURPOSE: Validates Diagonal South-East Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * @param int      posY
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateSouthEastMoves(Cell[][] board, int posX, int posY) {
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
	}

	/**
	 * FUNCTION_ABSTRACT: validateNorthWestMoves
	 * 
	 * PURPOSE: Validates Diagonal North-West Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * @param int      posY
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateNorthWestMoves(Cell[][] board, int posX, int posY) {
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
	}

	/**
	 * FUNCTION_ABSTRACT: validateSouthWestMoves
	 * 
	 * PURPOSE: Validates Diagonal South-West Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * @param int      posY
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateSouthWestMoves(Cell[][] board, int posX, int posY) {
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
	}

	/**
	 * FUNCTION_ABSTRACT: validateNorthEastMoves
	 * 
	 * PURPOSE: Validates Diagonal North-East Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * @param int      posY
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateNorthEastMoves(Cell[][] board, int posX, int posY) {
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
	}

	/**
	 * FUNCTION_ABSTRACT: validateWestMoves
	 * 
	 * PURPOSE: Validates Horizontal West Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateWestMoves(Cell[][] board, int posX) {
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

			posX--;
		}
	}

	/**
	 * FUNCTION_ABSTRACT: validateEastMoves
	 * 
	 * PURPOSE: Validates Horizontal East Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateEastMoves(Cell[][] board, int posX) {
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
			
			posX++;
		}
	}

	/**
	 * FUNCTION_ABSTRACT: validateSouthMoves
	 * 
	 * PURPOSE: Validates Vertical South Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateSouthMoves(Cell[][] board, int posY) {
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
			
			posY--;
		}
	}

	/**
	 * FUNCTION_ABSTRACT: validateNorthMoves
	 * 
	 * PURPOSE: Validates Vertical North Moves
	 * 
	 * @param Cell[][] board
	 * @param int      posX
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public void validateNorthMoves(Cell[][] board, int posY) {
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
			
			posY++;
		}
	}
	
	/**
	 * FUNCTION_ABSTRACT: getPieceEnum
	 * 
	 * PURPOSE: Returns the Piece Enum
	 * 
	 * @return PieceEnum
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public abstract PieceEnum getPieceEnum();
	
	/**
	 * FUNCTION_ABSTRACT: toString
	 * 
	 * PURPOSE: Returns the String representation of the piece.
	 * 
	 * Note: Capitalized letter denotes white piece, lower case letter denotes black
	 * piece
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return isWhite() ? getPieceEnum().getName() : getPieceEnum().getName().toLowerCase();
	}
	
	/**
	 * FUNCTION_ABSTRACT: getX
	 * 
	 * PURPOSE: Gets the current X position of this piece
	 * 
	 * @return int x
	 * 
	 *         END FUNCTION_ABSTRACT
	 * 
	 */
	public int getX() {
		return x;
	}

	/**
	 * FUNCTION_ABSTRACT: getY
	 * 
	 * PURPOSE: Gets the current Y position of this piece
	 * 
	 * @return int y
	 * 
	 *         END FUNCTION_ABSTRACT
	 * 
	 */
	public int getY() {
		return y;
	}
}
