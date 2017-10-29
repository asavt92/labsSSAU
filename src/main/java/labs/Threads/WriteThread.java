package labs.Threads;

import labs.VectorClass.Vector;

public class WriteThread extends Thread {

    private Vector vector;

    public WriteThread(Vector vector) {
        super("Поток записи координат вектора");
        this.vector = vector;
        System.out.println("Поток создан " + this);
        setPriority(4);
        start();
    }

    public void run() {
        int length = vector.getLength();
        for (int i = 0; i < length; i++) {
            double element = Math.random() * 100500;
            vector.setElement(i, element);
            System.out.println(getName() + " Write: " + element + " to position " + i);
        }
        System.out.println(getName()+ " is closed");
    }
}
