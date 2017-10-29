package labs.Threads;

import labs.VectorClass.Vector;

public class ReadThread extends Thread {

    Vector vector;

    public ReadThread(Vector vector) {
        super("Поток чтения координат вектора");
        this.vector = vector;
        System.out.println("Поток создан " + this);
        start();
    }

    public void run() {
        int length = vector.getLength();
        for (int i = 0; i < length; i++) {
            double element = vector.getElement(i);
            System.out.println(getName() + " Read: " + element + " from position " + i);
        }
        System.out.println(getName() + " is closed");
    }
}
