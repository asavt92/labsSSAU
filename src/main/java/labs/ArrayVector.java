package labs;

import java.io.Serializable;

public class ArrayVector implements Vector, Serializable, Cloneable {

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

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("| Class:" + getClass().getName() + " | Length " + String.valueOf(getLength()) + " | ");
        for (int i = 0; i < length; i++) {
            stringBuffer.append("Element[" + i + "] = " + getElement(i) + " | ");
        }
        String string = new String(stringBuffer);
        return string;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            if (getLength() == ((Vector) obj).getLength()) {
                for (int i = 0; i < length; i++) {
                    if (getElement(i) == ((Vector) obj).getElement(i)) {
                    } else return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public int hashCode() {
        int result = 0;
        long t;
        for (int i = 0; i < array.length; i++) {
            t = Double.doubleToLongBits(array[i]);
            result ^= (((int) (t >> 32)) ^ (int) (t & 0x00000000FFFFFFFF));
        }
        return result;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование невозможнО!");
            return this;
        }
    }
}



