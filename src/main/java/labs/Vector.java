package labs;

public interface Vector {

    int getLength();
    double getElement(int n) throws ArrayIndexOutOfBoundsException;
    double getNorma();

    void setElement(int n, double element) throws ArrayIndexOutOfBoundsException;
}
