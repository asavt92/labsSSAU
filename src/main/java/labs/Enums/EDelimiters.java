package labs.Enums;

public enum EDelimiters {
    SLASH("/"), SPACE(" ");

    private final String delimiter;

    EDelimiters(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
