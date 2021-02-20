package com.thompson.apps.chess.board;

import com.thompson.apps.chess.pieces.Bishop;
import com.thompson.apps.chess.pieces.King;
import com.thompson.apps.chess.pieces.Knight;
import com.thompson.apps.chess.pieces.Pawn;
import com.thompson.apps.chess.pieces.Queen;
import com.thompson.apps.chess.pieces.Rook;

public class ChessBoard {
	/* Chess Board - 2D Array of Cells */
	private Cell board[][];

	public ChessBoard() {
		board = new Cell[8][8];
		createBlankBoard();
	}

	/**
	 * FUNCTION_ABSTRACT: createBlankBoard
	 * 
	 * PURPOSE: Creates a blank board by placing cells with null pieces for every
	 * row/column of the board.
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void createBlankBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = new Cell(i, j, null);
			}
		}
	}

	/**
	 * FUNCTION_ABSTRACT: setDefaultBoard
	 * 
	 * PURPOSE: Sets a default generic chess board
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	public void setDefaultBoard() {
		setBoard(true);
		setBoard(false);
	}

	/**
	 * FUNCTION_ABSTRACT: setBoard
	 * 
	 * PURPOSE: Sets the board at specific position for each piece based on the
	 * parameter of if the piece is white or black
	 * 
	 * @param boolean white
	 * 
	 *                END FUNCTION_ABSTRACT
	 */
	private void setBoard(boolean white) {
		int pawnRow = white ? 1 : 6;
		int pieceRow = white ? 0 : 7;

		// Set Rooks
		board[pieceRow][0] = new Cell(pieceRow, 0, new Rook(white, pieceRow, 0));
		board[pieceRow][7] = new Cell(pieceRow, 7, new Rook(white, pieceRow, 7));

		// Set Knights
		board[pieceRow][1] = new Cell(pieceRow, 1, new Knight(white, pieceRow, 1));
		board[pieceRow][6] = new Cell(pieceRow, 6, new Knight(white, pieceRow, 6));

		// Set Bishops
		board[pieceRow][2] = new Cell(pieceRow, 2, new Bishop(white, pieceRow, 2));
		board[pieceRow][5] = new Cell(pieceRow, 5, new Bishop(white, pieceRow, 5));

		// Set Queens and Kings
		board[pieceRow][3] = new Cell(pieceRow, 3, new Queen(white, pieceRow, 3));
		board[pieceRow][4] = new Cell(pieceRow, 4, new King(white, pieceRow, 4));

		// Set Pawns
		for (int i = 0; i < 8; i++) {
			board[pawnRow][i] = new Cell(pawnRow, i, new Pawn(white, pawnRow, i));
		}
	}

	/**
	 * FUNCTION_ABSTRACT: getChessBoard
	 * 
	 * PURPOSE: Returns a reference to the 2D-Array of the Chess Board
	 * 
	 * @return Cell[][] board
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	public Cell[][] getChessBoard() {
		return this.board;
	}
}
