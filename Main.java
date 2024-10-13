public class Main {

    // Utility class for bitwise operations and basic arithmetic
    public static class BitwiseUtility {

        // Method to set a specific bit (turn to 1) at the given index for a long number
        public long setBit(long number, int bitIndex) {
            return number | (1L << bitIndex);
        }

        // Method to set a specific bit (turn to 1) at the given index for an int number
        public int setBit(int number, int bitIndex) {
            return number | (1 << bitIndex);
        }

        // Method to set a specific bit (turn to 1) at the given index for a short number
        public short setBit(short number, int bitIndex) {
            return (short) (number | (1 << bitIndex));
        }

        // Method to set a specific bit (turn to 1) at the given index for a byte number
        public byte setBit(byte number, int bitIndex) {
            return (byte) (number | (1 << bitIndex));
        }

        // Method to clear a specific bit (turn to 0) at the given index for a long number
        public long clearBit(long number, int bitIndex) {
            return number & ~(1L << bitIndex);
        }

        // Method to clear a specific bit (turn to 0) at the given index for an int number
        public int clearBit(int number, int bitIndex) {
            return number & ~(1 << bitIndex);
        }

        // Method to clear a specific bit (turn to 0) at the given index for a short number
        public short clearBit(short number, int bitIndex) {
            return (short) (number & ~(1 << bitIndex));
        }

        // Method to clear a specific bit (turn to 0) at the given index for a byte number
        public byte clearBit(byte number, int bitIndex) {
            return (byte) (number & ~(1 << bitIndex));
        }

        // Method to toggle (flip) a specific bit for a long number
        public long toggleBit(long number, int bitIndex) {
            return number ^ (1L << bitIndex);
        }

        // Method to toggle (flip) a specific bit for an int number
        public int toggleBit(int number, int bitIndex) {
            return number ^ (1 << bitIndex);
        }

        // Method to toggle (flip) a specific bit for a short number
        public short toggleBit(short number, int bitIndex) {
            return (short) (number ^ (1 << bitIndex));
        }

        // Method to toggle (flip) a specific bit for a byte number
        public byte toggleBit(byte number, int bitIndex) {
            return (byte) (number ^ (1 << bitIndex));
        }

        // Method to check if a specific bit is set (1) for a long number
        public boolean getBit(long number, int bitIndex) {
            return (number & (1L << bitIndex)) != 0;
        }

        // Method to check if a specific bit is set (1) for an int number
        public boolean getBit(int number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0;
        }

        // Method to check if a specific bit is set (1) for a short number
        public boolean getBit(short number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0;
        }

        // Method to check if a specific bit is set (1) for a byte number
        public boolean getBit(byte number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0;
        }

        // Basic arithmetic methods
        public long add(long a, long b) {
            return a + b;
        }

        public long subtract(long a, long b) {
            return a - b;
        }

        public long multiply(long a, long b) {
            return a * b;
        }

        // Division method with check to prevent division by zero
        public long divide(long a, long b) {
            if (b == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed.");
            }
            return a / b;
        }

        // Method to convert a decimal number to its binary string representation
        public String decimalToBinary(long number) {
            return Long.toBinaryString(number);
        }

        // Method to convert a decimal number to its hexadecimal string representation
        public String decimalToHexadecimal(long number) {
            return Long.toHexString(number);
        }

        // Method to convert a binary string to its decimal representation
        public long binaryToDecimal(String binaryString) {
            return Long.parseLong(binaryString, 2);
        }

        // Method to convert a hexadecimal string to its decimal representation
        public long hexadecimalToDecimal(String hexString) {
            return Long.parseLong(hexString, 16);
        }
    }

    // Class representing the checkers board using bitboards
    public static class CheckersBitboard {

        private long blackPieces;  // Bitboard for black pieces
        private long whitePieces;  // Bitboard for white pieces
        private BitwiseUtility bitwiseUtility;  // Instance of BitwiseUtility for manipulating the bitboard

        // Constructor to initialize the board with starting positions
        public CheckersBitboard() {
            bitwiseUtility = new BitwiseUtility();
            blackPieces = 0xFFF0000000000L;  // Black pieces start in the top rows
            whitePieces = 0x00000FFF00000L;  // White pieces start in the bottom rows
        }

        // Method to display the current board state in binary format
        public void displayBoardInBinary() {
            System.out.println("Black Pieces (Binary): " + bitwiseUtility.decimalToBinary(blackPieces));
            System.out.println("White Pieces (Binary): " + bitwiseUtility.decimalToBinary(whitePieces));
        }

        // Method to display the current board state in hexadecimal format
        public void displayBoardInHexadecimal() {
            System.out.println("Black Pieces (Hexadecimal): " + bitwiseUtility.decimalToHexadecimal(blackPieces));
            System.out.println("White Pieces (Hexadecimal): " + bitwiseUtility.decimalToHexadecimal(whitePieces));
        }

        // Method to move a piece from sourceIndex to destinationIndex
        public void movePiece(int sourceIndex, int destinationIndex, boolean isBlack) {
            if (isBlack) {
                // Clear the bit at the source position and set the bit at the destination for black pieces
                blackPieces = bitwiseUtility.clearBit(blackPieces, sourceIndex);
                blackPieces = bitwiseUtility.setBit(blackPieces, destinationIndex);
            } else {
                // Clear the bit at the source position and set the bit at the destination for white pieces
                whitePieces = bitwiseUtility.clearBit(whitePieces, sourceIndex);
                whitePieces = bitwiseUtility.setBit(whitePieces, destinationIndex);
            }
        }

        // Method to check if a move to a destination is legal (i.e., the square is empty)
        public boolean isMoveLegal(int destinationIndex) {
            return !bitwiseUtility.getBit(blackPieces | whitePieces, destinationIndex);
        }

        // Method to check if a capture move is possible
        public boolean canCapture(int sourceIndex, int opponentIndex, int destinationIndex, boolean isBlack) {
            // Check if destination is empty and opponent's piece is at the opponentIndex
            return !bitwiseUtility.getBit(blackPieces | whitePieces, destinationIndex)
                    && bitwiseUtility.getBit(isBlack ? whitePieces : blackPieces, opponentIndex);
        }

        // Method to perform a capture move
        public void capturePiece(int sourceIndex, int opponentIndex, int destinationIndex, boolean isBlack) {
            if (canCapture(sourceIndex, opponentIndex, destinationIndex, isBlack)) {
                // Clear the opponent's piece from the board
                if (isBlack) {
                    whitePieces = bitwiseUtility.clearBit(whitePieces, opponentIndex);
                } else {
                    blackPieces = bitwiseUtility.clearBit(blackPieces, opponentIndex);
                }
                // Move the capturing piece to the destination
                movePiece(sourceIndex, destinationIndex, isBlack);
            }
        }
    }

    // Main method demonstrating the bitboard checkers functionality
    public static void main(String[] args) {
        BitwiseUtility util = new BitwiseUtility();  // Create an instance of BitwiseUtility

        CheckersBitboard board = new CheckersBitboard();  // Create the checkers board

        // Display the initial state of the board
        board.displayBoardInBinary();
        board.displayBoardInHexadecimal();

        // Example move: move black piece from position 40 to 33
        if (board.isMoveLegal(33)) {
            board.movePiece(40, 33, true);  // Move black piece from 40 to 33
            System.out.println("Moved black piece from 40 to 33.");
        }

        // Example of a capture move: black piece capturing a white piece
        if (board.canCapture(33, 23, 14, true)) {
            board.capturePiece(33, 23, 14, true);  // Perform the capture
            System.out.println("Captured white piece at position 23.");
        }

        // Display the updated state of the board
        board.displayBoardInBinary();
        board.displayBoardInHex
