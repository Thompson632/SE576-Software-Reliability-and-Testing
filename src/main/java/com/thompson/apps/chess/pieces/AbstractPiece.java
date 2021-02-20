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
