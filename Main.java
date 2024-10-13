public class Main {

    public static class BitwiseUtility {

        public long setBit(long number, int bitIndex) {
            return number | (1L << bitIndex);
        }

        public int setBit(int number, int bitIndex) {
            return number | (1 << bitIndex);
        }

        public short setBit(short number, int bitIndex) {
            return (short) (number | (1 << bitIndex));
        }

        public byte setBit(byte number, int bitIndex) {
            return (byte) (number | (1 << bitIndex));
        }

        public long clearBit(long number, int bitIndex) {
            return number & ~(1L << bitIndex);
        }

        public int clearBit(int number, int bitIndex) {
            return number & ~(1 << bitIndex);
        }

        public short clearBit(short number, int bitIndex) {
            return (short) (number & ~(1 << bitIndex));
        }

        public byte clearBit(byte number, int bitIndex) {
            return (byte) (number & ~(1 << bitIndex));
        }

        public long toggleBit(long number, int bitIndex) {
            return number ^ (1L << bitIndex);
        }

        public int toggleBit(int number, int bitIndex) {
            return number ^ (1 << bitIndex);
        }

        public short toggleBit(short number, int bitIndex) {
            return (short) (number ^ (1 << bitIndex));
        }

        public byte toggleBit(byte number, int bitIndex) {
            return (byte) (number ^ (1 << bitIndex));
        }

        public boolean getBit(long number, int bitIndex) {
            return (number & (1L << bitIndex)) != 0;
        }

        public boolean getBit(int number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0;
        }

        public boolean getBit(short number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0;
        }

        public boolean getBit(byte number, int bitIndex) {
            return (number & (1 << bitIndex)) != 0;
        }

        public long add(long a, long b) {
            return a + b;
        }

        public long subtract(long a, long b) {
            return a - b;
        }

        public long multiply(long a, long b) {
            return a * b;
        }

        public long divide(long a, long b) {
            if (b == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed.");
            }
            return a / b;
        }

        public String decimalToBinary(long number) {
            return Long.toBinaryString(number);
        }

        public String decimalToHexadecimal(long number) {
            return Long.toHexString(number);
        }

        public long binaryToDecimal(String binaryString) {
            return Long.parseLong(binaryString, 2);
        }

        public long hexadecimalToDecimal(String hexString) {
            return Long.parseLong(hexString, 16);
        }
    }

    public static class CheckersBitboard {

        private long blackPieces;
        private long whitePieces;
        private BitwiseUtility bitwiseUtility;

        public CheckersBitboard() {
            bitwiseUtility = new BitwiseUtility();
            blackPieces = 0xFFF0000000000L;
            whitePieces = 0x00000FFF00000L;
        }

        public void displayBoardInBinary() {
            System.out.println("Black Pieces (Binary): " + bitwiseUtility.decimalToBinary(blackPieces));
            System.out.println("White Pieces (Binary): " + bitwiseUtility.decimalToBinary(whitePieces));
        }

        public void displayBoardInHexadecimal() {
            System.out.println("Black Pieces (Hexadecimal): " + bitwiseUtility.decimalToHexadecimal(blackPieces));
            System.out.println("White Pieces (Hexadecimal): " + bitwiseUtility.decimalToHexadecimal(whitePieces));
        }

        public void movePiece(int sourceIndex, int destinationIndex, boolean isBlack) {
            if (isBlack) {
                blackPieces = bitwiseUtility.clearBit(blackPieces, sourceIndex);
                blackPieces = bitwiseUtility.setBit(blackPieces, destinationIndex);
            } else {
                whitePieces = bitwiseUtility.clearBit(whitePieces, sourceIndex);
                whitePieces = bitwiseUtility.setBit(whitePieces, destinationIndex);
            }
        }

        public boolean isMoveLegal(int destinationIndex) {
            return !bitwiseUtility.getBit(blackPieces | whitePieces, destinationIndex);
        }

        public boolean canCapture(int sourceIndex, int opponentIndex, int destinationIndex, boolean isBlack) {
            return !bitwiseUtility.getBit(blackPieces | whitePieces, destinationIndex)
                    && bitwiseUtility.getBit(isBlack ? whitePieces : blackPieces, opponentIndex);
        }

        public void capturePiece(int sourceIndex, int opponentIndex, int destinationIndex, boolean isBlack) {
            if (canCapture(sourceIndex, opponentIndex, destinationIndex, isBlack)) {
                if (isBlack) {
                    whitePieces = bitwiseUtility.clearBit(whitePieces, opponentIndex);
                } else {
                    blackPieces = bitwiseUtility.clearBit(blackPieces, opponentIndex);
                }
                movePiece(sourceIndex, destinationIndex, isBlack);
            }
        }
    }

    public static void main(String[] args) {
        BitwiseUtility util = new BitwiseUtility();

        CheckersBitboard board = new CheckersBitboard();

        board.displayBoardInBinary();
        board.displayBoardInHexadecimal();

        if (board.isMoveLegal(33)) {
            board.movePiece(40, 33, true);
            System.out.println("Moved black piece from 40 to 33.");
        }

        if (board.canCapture(33, 23, 14, true)) {
            board.capturePiece(33, 23, 14, true);
            System.out.println("Captured white piece at position 23.");
        }

        board.displayBoardInBinary();
        board.displayBoardInHexadecimal();

        System.out.println("Set Bit Example: " + util.setBit(0, 3));
        System.out.println("Clear Bit Example: " + util.clearBit(15, 1));
        System.out.println("Toggle Bit Example: " + util.toggleBit(8, 3));
        System.out.println("Get Bit Example: " + util.getBit(8, 3));

        System.out.println("Addition Example: " + util.add(5, 3));
        System.out.println("Subtraction Example: " + util.subtract(10, 4));
        System.out.println("Multiplication Example: " + util.multiply(5, 4));
        System.out.println("Division Example: " + util.divide(20, 4));

        System.out.println("Decimal to Binary Example: " + util.decimalToBinary(10));
        System.out.println("Decimal to Hexadecimal Example: " + util.decimalToHexadecimal(255));
        System.out.println("Binary to Decimal Example: " + util.binaryToDecimal("1010"));
        System.out.println("Hexadecimal to Decimal Example: " + util.hexadecimalToDecimal("ff"));
    }
}
