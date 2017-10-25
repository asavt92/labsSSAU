package labs;

import java.io.Serializable;

public class ArrayVector implements Vector, Serializable {

    private int length;
    private double[] array;


    public ArrayVector(int length) {
        this.array = new double[length];
        this.length = length;
        for (int i = 0; i < length; i++) {
            array[i] = Math.random() * 100500;
        }
    }

    public int getLength() {
        return length;
    }

    @Override
    public double getElement(int n) {
        return this.array[n];
    }

    @Override
    public double getNorma() {
        double s = 0;
        for (double a : array) {
            s = s + a;
        }
        return Math.sqrt(s);
    }

    @Override
    public void setElement(int n, double element) {
        this.array[n] = element;
    }

}
