package labs;

public interface Vector {

    int getLength();
    double getElement(int n);
    double getNorma();

    void setElement(int n, double element) throws ArrayIndexOutOfBoundsException;
}
