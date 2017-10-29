package labs.Threads;

public class WriteThreadRun implements Runnable {
    private Thread thread;
    private String name;
    private VectorSynchronizer vectorSynchronizer;


    public WriteThreadRun(VectorSynchronizer vectorSynchronizer) {
        this.vectorSynchronizer = vectorSynchronizer;
        name = "Поток записи координат";
        thread = new Thread(this, name);
        System.out.println("Поток создан" + thread);
        thread.start();
    }

    public WriteThreadRun(String name) {
        this.name = name;
        thread = new Thread(this, name);
        System.out.println("Поток создан" + thread);
        thread.start();
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (true){
            double element = Math.random();
            vectorSynchronizer.write(element);}

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

