public class Main {

    // BitwiseUtility class contains methods for performing bitwise operations on long, int, short, and byte types.
    public static class BitwiseUtility {

        // Sets a bit at the specified bitIndex in a long number.
        public long setBit(long number, int bitIndex) {
            return number | (1L << bitIndex); // OR operation with shifted bit to set the bit.
        }

        // Sets a bit at the specified bitIndex in an int number.
        public int setBit(int number, int bitIndex) {
            return number | (1 << bitIndex); // OR operation with shifted bit to set the bit.
        }

        // Sets a bit at the specified bitIndex in a short number.
        public short setBit(short number, int bitIndex) {
            return (short) (number | (1 << bitIndex)); // OR operation with shifted bit to set the bit.
        }

        // Sets a bit at the specified bitIndex in a byte number.
        public byte setBit(byte number, int bitIndex) {
            return (byte) (number | (1 << bitIndex)); // OR operation with shifted bit to set the bit.
        }

        // Clears a bit at the specified bitIndex in a long number.
        public long clearBit(long number, int bitIndex) {
            return number & ~(1L << bitIndex); // AND operation with negated shifted bit to clear the bit.
        }

        // Clears a bit at the specified bitIndex in an int number.
        public int clearBit(int number, int bitIndex) {
            return number & ~(1 << bitIndex); // AND operation with negated shifted bit to clear the bit.
        }

        // Clears a bit at the specified bitIndex in a short number.
        public short clearBit(short number, int bitIndex) {
            return (short) (number & ~(1 << bitIndex)); // AND operation with negated shifted bit to clear the bit.
        }

        // Clears a bit at the specified bitIndex in a byte number.
        public byte clearBit(byte number, int bitIndex) {
            return (byte) (number & ~(1 << bitIndex)); // AND operation with negated shifted bit to clear the bit.
        }

        // Toggles (flips) a bit at the specified bitIndex in a long number.
        public long toggleBit(long number, int bitIndex) {
            return number ^ (1L << bitIndex); // XOR operation with shifted bit to toggle the bit.
        }

        // Toggles (flips) a bit at the specified bitIndex in an int number.
        public int toggleBit(int number, int bitIndex) {
            return number ^ (1 << bitIndex); // XOR operation with shifted bit to toggle the bit.
        }

        // Toggles (flips) a bit at the specified bitIndex in a short number.
        public short toggleBit(short number, int bitIndex) {
            return (short) (number ^ (1 << bitIndex)); // XOR operation with shifted bit to toggle the bit.
        }

        // Toggles (flips) a bit at the specified bitIndex in a byte number.
        public byte toggleBit(byte number, int bitIndex) {
            return (byte) (number ^ (1 << bitIndex)); // XOR operation with shifted bit to toggle the bit.
        }

        // Checks if a bit at the specified bitIndex is set in a long number.
        public boolean getBit(long number, int bitIndex) {
            return (number & (1L << bitIndex)) != 0; // AND operation with shifted bit to check if the bit is set.
        }

        // Checks if a bit at the specified bitIndex is set in an int number.
        public boolean getBit(int number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0; // AND operation with shifted bit to check if the bit is set.
        }

        // Checks if a bit at the specified bitIndex is set in a short number.
        public boolean getBit(short number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0; // AND operation with shifted bit to check if the bit is set.
        }

        // Checks if a bit at the specified bitIndex is set in a byte number.
        public boolean getBit(byte number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0; // AND operation with shifted bit to check if the bit is set.
        }

        // Adds two long numbers and returns the result.
        public long add(long a, long b) {
            return a + b; // Simple addition operation.
        }

        // Subtracts two long numbers and returns the result.
        public long subtract(long a, long b) {
            return a - b; // Simple subtraction operation.
        }

        // Multiplies two long numbers and returns the result.
        public long multiply(long a, long b) {
            return a * b; // Simple multiplication operation.
        }

        // Divides two long numbers and returns the result, checks for division by zero.
        public long divide(long a, long b) {
            if (b == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed."); // Check for division by zero.
            }
            return a / b; // Division operation.
        }

        // Converts a decimal number to its binary string representation.
        public String decimalToBinary(long number) {
            return Long.toBinaryString(number); // Converts decimal to binary string.
        }

        // Converts a decimal number to its hexadecimal string representation.
        public String decimalToHexadecimal(long number) {
            return Long.toHexString(number); // Converts decimal to hexadecimal string.
        }

        // Converts a binary string to its decimal representation.
        public long binaryToDecimal(String binaryString) {
            return Long.parseLong(binaryString, 2); // Converts binary string to decimal.
        }

        // Converts a hexadecimal string to its decimal representation.
        public long hexadecimalToDecimal(String hexString) {
            return Long.parseLong(hexString, 16); // Converts hexadecimal string to decimal.
        }
    }

    // CheckersBitboard class handles the game logic for checkers using bitwise operations on bitboards.
    public static class CheckersBitboard {

        private long blackPieces; // Stores the position of black pieces on the board as a bitboard.
        private long whitePieces; // Stores the position of white pieces on the board as a bitboard.
        private BitwiseUtility bitwiseUtility; // Instance of the BitwiseUtility class to perform bitwise operations.

        // Constructor initializes the starting positions of black and white pieces on the checkers board.
        public CheckersBitboard() {
            bitwiseUtility = new BitwiseUtility(); // Creates an instance of BitwiseUtility.
            blackPieces = 0xFFF0000000000L; // Initializes black pieces' positions (top 3 rows of the board).
            whitePieces = 0x00000FFF00000L; // Initializes white pieces' positions (bottom 3 rows of the board).
        }

        // Displays the current state of the black and white pieces in binary format.
        public void displayBoardInBinary() {
            System.out.println("Black Pieces (Binary): " + bitwiseUtility.decimalToBinary(blackPieces));
            System.out.println("White Pieces (Binary): " + bitwiseUtility.decimalToBinary(whitePieces));
        }

        // Displays the current state of the black and white pieces in hexadecimal format.
        public void displayBoardInHexadecimal() {
            System.out.println("Black Pieces (Hexadecimal): " + bitwiseUtility.decimalToHexadecimal(blackPieces));
            System.out.println("White Pieces (Hexadecimal): " + bitwiseUtility.decimalToHexadecimal(whitePieces));
        }

        // Moves a piece from sourceIndex to destinationIndex for the specified player (black or white).
        public void movePiece(int sourceIndex, int destinationIndex, boolean isBlack) {
            if (isBlack) {
                blackPieces = bitwiseUtility.clearBit(blackPieces, sourceIndex); // Clear the bit at sourceIndex for black pieces.
                blackPieces = bitwiseUtility.setBit(blackPieces, destinationIndex); // Set the bit at destinationIndex for black pieces.
            } else {
                whitePieces = bitwiseUtility.clearBit(whitePieces, sourceIndex); // Clear the bit at sourceIndex for white pieces.
                whitePieces = bitwiseUtility.setBit(whitePieces, destinationIndex); // Set the bit at destinationIndex for white pieces.
            }
        }

        // Checks if a move to destinationIndex is legal by ensuring no pieces occupy that square.
        public boolean isMoveLegal(int destinationIndex) {
            return !bitwiseUtility.getBit(blackPieces | whitePieces, destinationIndex); // Ensure no piece is at destinationIndex.
        }

        // Checks if a capture move is possible: opponent's piece is at opponentIndex, destinationIndex is free.
        public boolean canCapture(int sourceIndex, int opponentIndex, int destinationIndex, boolean isBlack) {
            return !bitwiseUtility.getBit(blackPieces | whitePieces, destinationIndex) // Check if destination is empty.
                    && bitwiseUtility.getBit(isBlack ? whitePieces : blackPieces, opponentIndex); // Check if opponent's piece is at opponentIndex.
        }

        // Captures an opponent's piece if a capture is legal and moves the player's piece to destinationIndex.
        public void capturePiece(int sourceIndex, int opponentIndex, int destinationIndex, boolean isBlack) {
            if (canCapture(sourceIndex, opponentIndex, destinationIndex, isBlack)) {
                if (isBlack) {
                    whitePieces = bitwiseUtility.clearBit(whitePieces, opponentIndex); // Clear the bit for the captured white piece.
                } else {
                    blackPieces = bitwiseUtility.clearBit(blackPieces, opponentIndex); // Clear the bit for the captured black piece.
                }
                movePiece(sourceIndex, destinationIndex, isBlack); // Move the piece after capture.
            }
        }
    }

    public static void main(String[] args) {
        BitwiseUtility util = new BitwiseUtility(); // Create an instance of BitwiseUtility.

        CheckersBitboard board = new CheckersBitboard(); // Create an instance of CheckersBitboard.

        // Display the initial state of the checkers board in binary and hexadecimal formats.
        board.displayBoardInBinary();
        board.displayBoardInHexadecimal();

        // If the move to square 33 is legal, move a black piece from square 40 to 33.
        if (board.isMoveLegal(33)) {
            board.movePiece(40, 33, true);
            System.out.println("Moved black piece from 40 to 33.");
        }

        // If a capture is possible, capture a white piece at square 23 by a black piece moving from 33 to 14.
        if (board.canCapture(33, 23, 14, true)) {
            board.capturePiece(33, 23, 14, true);
            System.out.println("Captured white piece at position 23.");
        }

        // Display the updated board state after the move and capture in binary and hexadecimal formats.
        board.displayBoardInBinary();
        board.displayBoardInHexadecimal();

        // Demonstrating the BitwiseUtility methods.
        System.out.println("Set Bit Example: " + util.setBit(0, 3)); // Set bit 3 in a 0 value.
        System.out.println("Clear Bit Example: " + util.clearBit(15, 1)); // Clear bit 1 in value 15.
        System.out.println("Toggle Bit Example: " + util.toggleBit(8, 3)); // Toggle bit 3 in value 8.
        System.out.println("Get Bit Example: " + util.getBit(8, 3)); // Get the value of bit 3 in value 8.

        // Demonstrating arithmetic operations.
        System.out.println("Addition Example: " + util.add(5, 3)); // Add two numbers.
        System.out.println("Subtraction Example: " + util.subtract(10, 4)); // Subtract two numbers.
        System.out.println("Multiplication Example: " + util.multiply(5, 4)); // Multiply two numbers.
        System.out.println("Division Example: " + util.divide(20, 4)); // Divide two numbers.

        // Demonstrating conversion methods.
        System.out.println("Decimal to Binary Example: " + util.decimalToBinary(10)); // Convert decimal to binary.
        System.out.println("Decimal to Hexadecimal Example: " + util.decimalToHexadecimal(255)); // Convert decimal to hexadecimal.
        System.out.println("Binary to Decimal Example: " + util.binaryToDecimal("1010")); // Convert binary to decimal.
        System.out.println("Hexadecimal to Decimal Example: " + util.hexadecimalToDecimal("ff")); // Convert hexadecimal to decimal.
    }
}
