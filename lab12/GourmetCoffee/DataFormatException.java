/**
 * Thrown when malformed data is detected while parsing a file.
 */
public class DataFormatException extends Exception {

    public DataFormatException() {
    }

    public DataFormatException(String message) {
        super(message);
    }
}
