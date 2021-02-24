package com.thompson.apps.chess;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	/* Flag to Continue Running */
	private boolean continueRunning = true;

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

		scanner = new Scanner(System.in, "UTF-8");
	}

	/**
	 * FUNCTION_ABSTRACT: start
	 * 
	 * PURPOSE: Prompts the user with two choices for the process: (1) Validation of
	 * the entire default Chess Board at the start. (2) Custom Chess Board
	 * Validation
	 * 
	 * Based on user selection, different prompts/output will be provided
	 * 
	 * NOTE: Exception handling is in place for bad / incorrect user input from the
	 * start of the program to the end of the program.
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void start() {
		do {
			try {
				System.out.println("Welcome to SE-567 Chess Validation!");

				System.out.println("Please choose one of the following options:");
				System.out.println("(1) Validation for the Default Chess Board");
				System.out.println("(2) Custom Chess Board Validation");

				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					testDefaultChessBoard();
					break;
				case 2:
					testCustomChessBoard();
					break;
				default:
					System.out.println("Invalid Input - please enter 1 or 2.\n");
					break;
				}

				promptRunAgain();
			} catch (InputMismatchException e) {
				System.err.println("Please enter an integer value.\n");
				scanner.nextLine();
			} catch (Exception e) {
				System.err.println(e);
				// Call reset here because we caught an exception during one of the following
				// cases and need to clean-up the data for future runs:
				// (1) Empty user input for White or Black Pieces
				// (2) No piece being entered to validate
				// (3) Piece entered to be validated is not in the List of White or Black Pieces
				reset();
			}
		} while (continueRunning);
	}

	/**
	 * FUNCTION_ABSTRACT: testCustomChessBoard
	 * 
	 * PURPOSE: Method that does the following actions: (1) Prompts the user for
	 * input for the White and Black Pieces for the custom board (2) Prompts the
	 * user for the piece to validate. (3) Calls validation methods to verify and
	 * print out the piece's valid moves.
	 * 
	 * @throws Exception
	 * 
	 *                   END FUNCTION_ABSTRACT
	 */
	private void testCustomChessBoard() throws Exception {
		// Step 1. Prompt user for white pieces and read the value
		System.out.println("ENTER WHITE PIECES: ");
		String whitePieces = "Rf1, Kg1, Pf2, Ph2, Pg3";
//				scanner.nextLine();

		// Step 2. Set the local list of white pieces
		setLocalPieces(whitePieces, true);

		// Step 3. Prompt user for black pieces and read the value
		System.out.println("ENTER BLACK PIECES:");
		String blackPieces = "Kb8, Ne8, Pa7, Pb7, Pc7, Ra5";
//				scanner.nextLine();

		// Step 4. Set the local list of black pieces
		setLocalPieces(blackPieces, false);

		// Step 5. Set the custom chess board
		board.setCustomBoard(this.whitePieces, this.blackPieces);

		// Step 6. Prompt the user for piece to validate and read the value
		System.out.println("ENTER PIECE TO GET MOVES FOR: ");
		String stringPiece = scanner.nextLine();

		// Step 7. Set the piece to move based on the user input
		getPieceToMove(stringPiece);

		// Step 8. Print the current state of the board
		System.out.println("\n " + board.printBoard());

		// Step 9. Get the valid moves for the current piece
		List<Cell> moves = piece.getValidMoves(board.getChessBoard());

		// Step 10. Print the valid moves in human-readable format
		printMoves(moves);
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
	 * @throws Exception
	 * 
	 *                   END FUNCTION_ABSTRACT
	 */
	private void testDefaultChessBoard() throws Exception {
		// Step 1. Create new Chess Board and set it to the default layout
		board = new ChessBoard();
		board.setDefaultBoard();

		// Step 2. Print current state of the board
		System.out.println("\n" + board.printBoard());

		// Step 3. Set local list of white pieces to the default
		System.out.println("WHITE PIECES: ");
		setLocalPieces(defaultWhitePieces, true);

		// Step 4. Get valid moves for all default layout white pieces
		testDefaultWhitePieces();

		// Step 5. Set the local list of black pieces to the default
		System.out.println("BLACK PIECES: ");
		setLocalPieces(defaultBlackPieces, false);

		// Step 6. Get valid moves for all default layout black pieces
		testDefaultBlackPieces();
	}

	/**
	 * FUNCTION_ABSTRACT: printMoves
	 * 
	 * PURPOSE: Prints the valid moves for the piece in human-readable format to
	 * align with an actual chess board piece designation
	 * 
	 * @param List<Cell> validMoves - List of Valid Moves
	 * 
	 *                   END FUNCTION_ABSTRACT
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
	 * @throws Exception
	 * 
	 *                   END FUNCTION_ABSTRACT
	 */
	private void testDefaultWhitePieces() throws Exception {
		// Rook
		String pieceToValidate = "Ra1";
		getPieceToMove(pieceToValidate);
		List<Cell> moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToValidate = "Nb1";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToValidate = "Bc1";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToValidate = "Qd1";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// King
		pieceToValidate = "Ke1";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToValidate = "Bf1";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToValidate = "Ng1";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Rook
		pieceToValidate = "Rh1";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Pawns
		pieceToValidate = "Pa2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pb2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pc2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pd2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pe2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pf2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pg2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Ph2";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);
	}

	/**
	 * FUNCTION_ABSTRACT: testDefaultBlackPieces
	 * 
	 * PURPOSE: Validates each black piece's move by calling the abstract
	 * getValidMoves method with the current state of the board
	 * 
	 * @throws Exception
	 * 
	 *                   END FUNCTION_ABSTRACT
	 */
	private void testDefaultBlackPieces() throws Exception {
		// Rook
		String pieceToValidate = "Ra8";
		getPieceToMove(pieceToValidate);
		List<Cell> moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToValidate = "Nb8";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToValidate = "Bc8";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToValidate = "Qd8";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// King
		pieceToValidate = "Ke8";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Bishop
		pieceToValidate = "Bf8";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Knight
		pieceToValidate = "Ng8";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Rook
		pieceToValidate = "Rh8";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		// Pawns
		pieceToValidate = "Pa7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pb7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pc7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pd7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pe7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pf7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Pg7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);

		pieceToValidate = "Ph7";
		getPieceToMove(pieceToValidate);
		moves = piece.getValidMoves(board.getChessBoard());
		printMoves(moves);
	}

	/**
	 * FUNCTION_ABSTRACT: setLocalPieces
	 * 
	 * PURPOSE: Parses the comma-separated String and converts it to a List of
	 * Strings. Then converts the String to an Abstract Piece based on the boolean
	 * value passed in as a parameter.
	 * 
	 * @param String  pieces - Comma-Separated String of Pieces
	 * @param boolean isWhite - true if white, false otherwise
	 * @throws Exception
	 * 
	 *                   END FUNCTION_ABSTRACT
	 */
	private void setLocalPieces(String pieces, boolean isWhite) throws Exception {
		// Step 1. Check to see if pieces is null or is equal to an empty string
		if (null != pieces && !pieces.equals("")) {
			// Step 2. Convert comma-separated String to List of String
			List<String> listPieces = Stream.of(pieces.split(",", -1)).map(String::trim).collect(Collectors.toList());

			// Step 3. Iterate over each String in the List
			for (String s : listPieces) {
				// Step 4. Convert the String to an AbstractPiece
				AbstractPiece p = convertStringToPiece(s, isWhite);

				// Step 5. If the piece is not null, add to either the local list of white or
				// black pieces
				if (null != p) {
					if (isWhite) {
						whitePieces.add(p);
					} else {
						blackPieces.add(p);
					}
				}
			}

			// Step 6. Print the white or black pieces based on the isWhite parameter
			if (isWhite) {
				System.out.println(whitePieces);
			} else {
				System.out.println(blackPieces);
			}
		}
		// Step 2. If the pieces parameter is null or an empty string, throw an
		// exception so we can prompt the user to restart the program
		else {
			String message = "No " + (isWhite ? "White" : "Black") + " pieces have been entered!\n";
			throw new Exception(message);
		}
	}

	/**
	 * FUNCTION_ABSTRACT: getPieceToMove
	 * 
	 * PURPOSE: Converts the String to a Piece and then checks to see if the piece
	 * is white or black. If neither, nothing will be validated
	 * 
	 * @param String pieceString
	 * @throws Exception
	 * 
	 *                   END FUNCTION_ABSTRACT
	 */
	private void getPieceToMove(String pieceString) throws Exception {
		// Step 1. Check to see if pieces is null or is equal to an empty string
		if (null != pieceString && !pieceString.equals("")) {
			boolean isFound = false;

			// Step 2. Get White Piece
			this.piece = convertStringToPiece(pieceString, true);

			// Step 3. If the Piece is not null, check to see if the list of white pieces
			// contains the piece to be validated.
			if (null != piece) {
				// Step 4. If the List of White Pieces contains the piece, return
				if (whitePieces.contains(piece)) {
					isFound = true;
					return;
				}
			}

			// Step 4/5. If the piece has not been found, check List of Black Pieces
			if (!isFound) {
				// Step 5/6. Get Black Piece
				this.piece = convertStringToPiece(pieceString, false);

				// Step 6/7. If the Piece is not null, check to see if the List of Black Pieces
				// contains the piece to be validated.
				if (null != piece) {
					// Step 7/8. If the List of Black Pieces contains the piece, return
					if (blackPieces.contains(piece)) {
						isFound = true;
						return;
					} else {
						String message = "Piece " + piece.toString()
								+ " is not found in either the White or Black List of Pieces!\n";
						throw new Exception(message);
					}
				}
				// Step 6/7. If the Piece is null, there is no piece to be validated
				else {
					String message = "Piece " + pieceString
							+ " is not found in either the White or Black List of Pieces!\n";
					throw new Exception(message);
				}
			}
		}
		// Step 2. If the pieces parameter is null or an empty string, throw an
		// exception so we can prompt the user to restart the program
		else {
			String message = "No piece has been entered!\n";
			throw new Exception(message);
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
		String pieceString = piece.substring(0, 1).toUpperCase();
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
		// Step 1. Prompt user to validate another board
		System.out.println("Would you like to validate another Chess Board?");
		String c = scanner.nextLine();

		// Step 2. If the input is not null or an empty String, we need to check the
		// input
		if (null != c && !c.equals("")) {
			// Step 3. If the input is 'yes' or 'y', we clean-up the local attributes
			// and re-prompt the user
			if (c.equalsIgnoreCase("yes") || c.equalsIgnoreCase("y")) {
				reset();
			}
			// Step 4. If the input is not 'yes' or 'y', we set continueRunning to false
			// which will trigger the program to break out of the do/while loop that is
			// dependent on this variable
			else {
				System.out.println("\nProgram Complete!");
				scanner.close();
				continueRunning = false;
			}
		}
		// Step 3. If the input is not null or an empty String, we set continueRunning
		// to false which will trigger the program to break out of the do/while loop
		// that is dependent on this variable
		else {
			System.out.println("\nProgram Complete!");
			scanner.close();
			continueRunning = false;
		}
	}

	/**
	 * FUNCTION_ABSTRACT: reset
	 * 
	 * PURPOSE: Cleans up the local class attributes by creating a new instance of
	 * the ChessBoard object and clears the Lists of White and Black pieces.
	 * 
	 * END FUNCTION_ABSTRACT
	 */
	private void reset() {
		// Step 1. Garbage clean up for the ChessBoard and then new instance for the ChessBoard
		board = null;
		board = new ChessBoard();

		// Step 2. Clear the White and Black Piece Lists
		whitePieces.clear();
		blackPieces.clear();
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
		m.start();
	}
}