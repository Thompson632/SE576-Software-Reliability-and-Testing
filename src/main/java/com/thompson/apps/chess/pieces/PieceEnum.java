package com.thompson.apps.chess.pieces;

public enum PieceEnum {
	BISHOP("B"), 
	KING("K"), 
	KNIGHT("N"), 
	PAWN("P"), 
	QUEEN("Q"), 
	ROOK("R");

	private String name;

	/**
	 * FUNCTION_ABSTRACT: PieceEnum
	 * 
	 * PURPOSE: Represents a Chess Piece.
	 * 
	 * Note: toString returns the name of enum value and getName returns the single
	 * character of the piece
	 * 
	 * @param String name
	 * 
	 *               END FUNCTION_ABSTRACT
	 */
	PieceEnum(String name) {
		this.name = name;
	}

	/**
	 * FUNCTION_ABSTRACT: getName
	 * 
	 * PURPOSE: Returns the name of the Piece
	 * 
	 * @return String name
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public String getName() {
		return name;
	}
}
