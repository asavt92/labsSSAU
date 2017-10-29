package labs.MyExceptions;

import java.io.IOException;

public class VectorIndexOutOfBoundsException extends IOException {
    public VectorIndexOutOfBoundsException() {
        super();
    }

    public VectorIndexOutOfBoundsException(String message) {
        super(message);
    }
}
