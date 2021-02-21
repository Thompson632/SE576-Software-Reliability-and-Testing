package com.thompson.apps.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.thompson.apps.chess.board.Cell;
import com.thompson.apps.chess.board.ChessBoard;
import com.thompson.apps.chess.board.Tile;
import com.thompson.apps.chess.pieces.AbstractPiece;
import com.thompson.apps.chess.pieces.Bishop;
import com.thompson.apps.chess.pieces.King;
import com.thompson.apps.chess.pieces.Knight;
import com.thompson.apps.chess.pieces.Pawn;
import com.thompson.apps.chess.pieces.Queen;
import com.thompson.apps.chess.pieces.Rook;

public class Main {
	/* Chess Board Reference */
	private ChessBoard board = null;

	/* List of White Pieces */
	private List<AbstractPiece> whitePieces = null;

	/* List of Black Pieces */
	private List<AbstractPiece> blackPieces = null;

	/* Default White Pieces and Locations */
	private String defaultWhitePieces = null;

	/* Default Black Pieces and Locations */
	private String defaultBlackPieces = null;

	/* Piece to Validate */
	private AbstractPiece piece = null;

	/* Scanner */
	private Scanner scanner = null;

	/**
	 * FUNCTION_ABSTRACT: Main
	 * 
	 * PURPOSE: Default Constructor for the Main Classes. Initializes the board,
	 * piece lists, default pieces, and the user-input scanner
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	public Main() {
		board = new ChessBoard();

		whitePieces = new ArrayList<AbstractPiece>();
		blackPieces = new ArrayList<AbstractPiece>();

		defaultWhitePieces = "Ra1, Nb1, Bc1, Qd1, Ke1, Bf1, Ng1, Rh1, Pa2, Pb2, Pc2, Pd2, Pe2, Pf2, Pg2, Ph2";
		defaultBlackPieces = "Ra8, Nb8, Bc8, Qd8, Ke8, Bf8, Ng8, Rh8, Pa7, Pb7, Pc7, Pd7, Pe7, Pf7, Pg7, Ph7";

		scanner = new Scanner(System.in);
	}

	/**
	 * FUNCTION_ABSTRACT: getUserInput
	 * 
	 * PURPOSE: Prompts the user with two choices for the process: (1) Validation of
	 * the entire default Chess Board at the start. (2) Custom Chess Board
	 * Validation
	 * 
	 * Based on user selection, different prompts/output will be provided
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void getUserInput() {
		System.out.println("Welcome to SE-567 Chess Validation!");

		System.out.println("Please choose one of the following options:");
		System.out.println("(1) Validation for the Default Chess Board");
		System.out.println("(2) Custom Chess Board Validation");

		int choice = scanner.nextInt();

		switch (choice) {
		case 0:
			System.out.println("Invalid Input");
			break;
		case 1:
			testDefaultChessBoard();
			break;
		case 2:
			break;
		default:
			break;
		}
	}

	/**
	 * FUNCTION_ABSTRACT: testDefaultChessBoard
	 * 
	 * PURPOSE: Method that does the following actions: (1) Creates a new instance
	 * of the ChessBoard and sets the default pieces and their locations (2) Sets
	 * the local Lists of White and Black Pieces to have the default pieces and
	 * their locations (3) Calls validation methods to verify and print out each
	 * piece's valid moves
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void testDefaultChessBoard() {
		board = new ChessBoard();
		board.setDefaultBoard();
		System.out.println("\n" + board.printBoard());

		// White Pieces
		System.out.println("WHITE PIECES: ");
		setWhitePieces(defaultWhitePieces);
		testDefaultWhitePieces();

		System.out.println("BLACK PIECES: ");
		setBlackPieces(defaultBlackPieces);
		testDefaultBlackPieces();
	}

	/**
	 * FUNCTION_ABSTRACT: printMoves
	 * 
	 * PURPOSE: Prints the valid moves for the piece in human-readable format to
	 * align with an actual chess board piece designation
	 * 
	 * @param List<Cell> 
	 * 		validMoves - List of Valid Moves
	 * 
	 *      END FUNCTION_ABSTRACT
	 */
	private void printMoves(List<Cell> validMoves) {
		boolean hasMoves = true;
		List<Tile> moves = new ArrayList<Tile>();
		
		String color = (piece.isWhite() ? "WHITE" : "BLACK");
		System.out.println("LEGAL MOVES FOR " + color + " " + piece.toString() + ":");

		if (null == validMoves || validMoves.isEmpty()) {
			System.out.println("No legal moves!");
			hasMoves = false;
		} else {
			for (Cell c : validMoves) {
				for (Tile s : Tile.values()) {
					if ((s.getX() == c.getX()) && (s.getY() == c.getY())) {
						moves.add(s);
					}
				}
			}
		}
		
		// Only print moves if they are available
		if (hasMoves) {
			System.out.println(moves);
		}
		
		System.out.println();
	}

	/**
	 * FUNCTION_ABSTRACT: testDefaultWhitePieces
	 * 
	 * PURPOSE: Validates each white piece's move by calling the abstract
	 * getValidMoves method with the current state of the board
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void testDefaultWhitePieces() {
		// Rook
		String pieceToMove = "Ra1";
		getPieceToMove(pieceToMove);
		List<Cell> moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToMove = "Nb1";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToMove = "Bc1";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToMove = "Qd1";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// King
		pieceToMove = "Ke1";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToMove = "Bf1";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToMove = "Ng1";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Rook
		pieceToMove = "Rh1";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Pawns
		pieceToMove = "Pa2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pb2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pc2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pd2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pe2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pf2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pg2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Ph2";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);
	}

	/**
	 * FUNCTION_ABSTRACT: testDefaultBlackPieces
	 * 
	 * PURPOSE: Validates each black piece's move by calling the abstract
	 * getValidMoves method with the current state of the board
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void testDefaultBlackPieces() {
		// Rook
		String pieceToMove = "Ra8";
		getPieceToMove(pieceToMove);
		List<Cell> moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToMove = "Nb8";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToMove = "Bc8";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToMove = "Qd8";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// King
		pieceToMove = "Ke8";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToMove = "Bf8";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToMove = "Ng8";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Rook
		pieceToMove = "Rh8";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Pawns
		pieceToMove = "Pa7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pb7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pc7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pd7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pe7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pf7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Pg7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToMove = "Ph7";
		getPieceToMove(pieceToMove);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);
	}

	/**
	 * FUNCTION_ABSTRACT: setWhitePieces
	 * 
	 * PURPOSES: Parses the comma-separated String and converts the String to a
	 * White Piece
	 * 
	 * @param String pieces - Comma-Separated String of Pieces
	 * 
	 *               END FUNCTION_ABSTRACT
	 */
	public void setWhitePieces(String pieces) {
		String[] temp = pieces.split(", ");

		for (String str : temp) {
			AbstractPiece p = convertStringToPiece(str, true);
			if (null != p) {
				whitePieces.add(p);
			}
		}

		System.out.println(whitePieces);
	}
	
	/**
	 * FUNCTION_ABSTRACT: setBlackPieces
	 * 
	 * PURPOSES: Parses the comma-separated String and converts the String to a
	 * Black Piece
	 * 
	 * @param String pieces - Comma-Separated String of Pieces
	 * 
	 *               END FUNCTION_ABSTRACT
	 */
	public void setBlackPieces(String pieces) {
		String[] temp = pieces.split(", ");

		for (String str : temp) {
			AbstractPiece p = convertStringToPiece(str, false);
			if (null != p) {
				blackPieces.add(p);
			}
		}

		System.out.println(blackPieces);
	}

	/**
	 * FUNCTION_ABSTRACT: getPieceToMove
	 * 
	 * PURPOSE: Converts the String to a Piece and then checks to see if the piece
	 * is white or black. If neither, nothing will be validated
	 * 
	 * @param String pieceString
	 * 
	 *               END FUNCTION_ABSTRACT
	 */
	public void getPieceToMove(String pieceString) {
		boolean isFound = false;

		// Step 1. Get White Piece
		this.piece = convertStringToPiece(pieceString, true);

		// Step 2. If the Piece is not null, check to see if the list of white pieces
		// contains the piece to be validated.
		if (null != piece) {
			// Step 3. If the List of White Pieces contains the piece, return
			if (whitePieces.contains(piece)) {
				isFound = true;
				return;
			}
		}

		// Step 3/4. If the piece has not been found, check List of Black Pieces
		if (!isFound) {
			// Step 4/5. Get Black Piece
			this.piece = convertStringToPiece(pieceString, false);

			// Step 5/6. If the Piece is not null, check to see if the List of Black Pieces
			// contains the piece to be validated.
			if (null != piece) {
				// Step 6/7. If the List of Black Pieces contains the piece, return
				if (blackPieces.contains(piece)) {
					isFound = true;
					return;
				}
			}
			// Step 6/7. If the Piece is null, there is no piece to be validated
			else {
				System.out.println("Piece not found!");
			}
		}
	}

	/**
	 * FUNCTION_ABSTRACT: convertStringToPiece
	 * 
	 * PURPOSE: Converts the String to a piece based on the first character (Piece
	 * Type) and then iterating over the Tiles to get the location provided in the
	 * String. Ex. Ra1 would return Rook at Tile A1
	 * 
	 * @param String  piece - Piece to be converted
	 * @param boolean isWhite - True if white, false otherwise
	 * @return AbstractPiece p
	 * 
	 *         END FUNCTION_ABSTRACT
	 */
	private AbstractPiece convertStringToPiece(String piece, boolean isWhite) {
		AbstractPiece p = null;

		// Step 1. Get First Letter of Piece (Ex. Ra1 - would return R)
		String pieceString = piece.substring(0, 1);
		int row = 0;
		int column = 0;

		// Step 2. Get Tile Location
		String tileString = piece.substring(1).toUpperCase();
		for (Tile t : Tile.values()) {
			if (t.getName().equalsIgnoreCase(tileString)) {
				row = t.getX();
				column = t.getY();
				break;
			}
		}

		// Step 3. Create Piece Based on First Letter of String
		if (pieceString.equals("K")) {
			p = new King(isWhite, row, column);
		} else if (pieceString.equals("Q")) {
			p = new Queen(isWhite, row, column);
		} else if (pieceString.equals("R")) {
			p = new Rook(isWhite, row, column);
		} else if (pieceString.equals("B")) {
			p = new Bishop(isWhite, row, column);
		} else if (pieceString.equals("N")) {
			p = new Knight(isWhite, row, column);
		} else if (pieceString.equals("P")) {
			p = new Pawn(isWhite, row, column);
		}

		// Step 3. Returns Valid Piece or Null
		return p;

	}

	/**
	 * FUNCTION_ABSTRACT: promptRunAgain
	 * 
	 * PURPOSE: Prompts the user to run the program again
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void promptRunAgain() {
		System.out.println("Would you like to validate another Chess Board?");
		String c = scanner.next();

		while (c.equalsIgnoreCase("yes") || c.equalsIgnoreCase("y")) {
			start();
		}

		scanner.close();
	}

	/**
	 * FUNCTION_ABSTRACT: start
	 * 
	 * PURPOSE: Starts the program
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void start() {
		getUserInput();
		promptRunAgain();
	}

	/**
	 * FUNCTIION_ABSTRACT: main
	 * 
	 * PURPOSE: Main method that starts the program
	 * 
	 * @param String[] args
	 * 
	 *                 END FUNCTION_ABSTRACT
	 */
	public static void main(String[] args) {
		Main m = new Main();

		try {
			m.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
