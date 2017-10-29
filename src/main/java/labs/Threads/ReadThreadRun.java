package labs.Threads;

public class ReadThreadRun implements Runnable {

    private Thread thread;
    private String name;
    private VectorSynchronizer vectorSynchronizer;


    public ReadThreadRun(VectorSynchronizer vectorSynchronizer) {
        this.vectorSynchronizer = vectorSynchronizer;
        name = "Поток чтения координат";
        thread = new Thread(this, name);
        System.out.println("Поток создан " + thread);
        thread.start();
    }

    public String getName() {
        return name;
    }
    @Override
    public void run() {
        try {
            while (true){
            vectorSynchronizer.read();}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
