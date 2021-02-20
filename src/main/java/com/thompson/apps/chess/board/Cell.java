package com.thompson.apps.chess.board;

import com.thompson.apps.chess.pieces.AbstractPiece;

public class Cell {
	/* Represents the Chess Piece at the Given Position */
	private AbstractPiece piece = null;

	/* Cell X Position */
	private int x = 0;
	/* Cell Y Position */
	private int y = 0;

	/**
	 * FUNCTION_ABSTRACT: Default constructor for the Cell
	 * 
	 * PURPOSE: Represents a position on the chess board. This cell will either be
	 * occupied by an AbstractPiece or be empty.
	 * 
	 * @param int 
	 * 		x - X Position of the Piece
	 * @param int 
	 * 		y - Y Position of the Piece
	 * @param AbstractPiece 
	 * 		piece - Piece at the given x, y position
	 * 
	 *                      END FUNCTION_ABSTRACT
	 */
	public Cell(int x, int y, AbstractPiece piece) {
		this.x = x;
		this.y = y;
		this.piece = piece;
	}

	/**
	 * FUNCTION_ABSTRACT: getPiece
	 * 
	 * PURPOSE: Returns the Piece at the given cell
	 * 
	 * @return AbstractPiece piece
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public AbstractPiece getPiece() {
		return piece;
	}

	/**
	 * FUNCTION_ABSTRACT: getX
	 * 
	 * PURPOSE: Returns the X Position of the Cell
	 * 
	 * @return int x
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public int getX() {
		return x;
	}

	/**
	 * FUNCTION_ABSTRACT: getY
	 * 
	 * PURPOSE: Returns the Y Position of the Cell
	 * 
	 * @return int y
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		if (null != piece) {
			return piece.toString();
		} else {
			return "Empty";
		}
	}
}