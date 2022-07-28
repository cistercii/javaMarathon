package Day14;

public class InvalidFileException extends Exception {

    private final int count_numbers;

    InvalidFileException() {
        count_numbers = 0;
    }

    InvalidFileException (int count) {
        count_numbers = count;
    }

    public int getCount_numbers() {
        return count_numbers;
    }
}
