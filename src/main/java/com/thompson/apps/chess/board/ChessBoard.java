package com.thompson.apps.chess.board;

import java.util.Arrays;
import java.util.List;

import com.thompson.apps.chess.pieces.AbstractPiece;
import com.thompson.apps.chess.pieces.Bishop;
import com.thompson.apps.chess.pieces.King;
import com.thompson.apps.chess.pieces.Knight;
import com.thompson.apps.chess.pieces.Pawn;
import com.thompson.apps.chess.pieces.Queen;
import com.thompson.apps.chess.pieces.Rook;

public class ChessBoard {
	/* Chess Board - 2D Array of Cells */
	private Cell board[][];

	/**
	 * FUNCTION_ABSTRACT: ChessBoard
	 * 
	 * PURPOSE: Default constructor for the ChessBoard. Creates a new 2D-Array of
	 * Cells and then sets a new Cell object for each position in the array.
	 * 
	 * END FUNCTION_ABSTRACT
	 */
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
		for (int i = 0; i < board.length; i++) {
			board[pawnRow][i] = new Cell(pawnRow, i, new Pawn(white, pawnRow, i));
		}
	}

	/**
	 * FUNCTION_ABSTRACT: setCustomPiece
	 * 
	 * PURPOSE: Sets one custom piece on the board
	 * 
	 * NOTE: This method is primarily used for testing purposes as well as custom
	 * board creations.
	 * 
	 * @param AbstractPiece p - Custom Piece to be set
	 * 
	 *                      END FUNCTION_ABSTRACT
	 */
	public void setCustomPiece(AbstractPiece p) {
		int row = p.getX();
		int column = p.getY();
		board[row][column] = new Cell(row, column, p);
	}

	/**
	 * FUNCTION_ABSTRACT: setCustomBoard
	 * 
	 * PURPOSE: Iterates over List of White and Black pieces and sets them to their
	 * specific location on the board.
	 * 
	 * @param List<AbstractPiece> whitePieces - List of White Pieces
	 * @param List<AbstractPiece> blackPieces - List of Black Pieces
	 * 
	 *                            END FUNCTION_ABSTRACT
	 */
	public void setCustomBoard(List<AbstractPiece> whitePieces, List<AbstractPiece> blackPieces) {
		for (AbstractPiece p : whitePieces) {
			setCustomPiece(p);
		}

		for (AbstractPiece p : blackPieces) {
			setCustomPiece(p);
		}
	}

	/**
	 * FUNCTION_ABSTRACT: printBoard
	 * 
	 * PURPOSE: Prints the entirety of the board with the pieces
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	public String printBoard() {
		StringBuilder stringBuilder = new StringBuilder(64);

		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board[i].length; j++) {
				if (null != board[i][j].getPiece()) {
					stringBuilder.append(board[i][j].getPiece().getShortName());
				} else {
					stringBuilder.append(" ");
				}
			}

			stringBuilder.append("\n");
		}

		return stringBuilder.toString();
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
		return Arrays.copyOf(board, board.length);
	}
}