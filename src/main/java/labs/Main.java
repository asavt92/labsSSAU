package labs;

import labs.MyExceptions.ArrayIndexOutOfBoundsException;
import labs.Threads.*;
import labs.VectorClass.ArrayVector;
import labs.VectorClass.LinkedListVector;
import labs.VectorClass.Vector;
import labs.VectorClass.Vectors;

import java.io.*;

public class Main {

    public static void testOfSerialization() throws Exception {
        /* Создать вектор для теста и вывести его значения  */
        ArrayVector arrayVector1 = new ArrayVector(8);
        for (int i = 0; i < arrayVector1.getLength(); i++) {
            System.out.println(arrayVector1.getElement(i));
        }
        /* Запишем при помощи статического метода Вектор в файл  */
        Writer out = new FileWriter("out2.txt");
        Vectors.writeVector(arrayVector1, out);

        /* Прочтем при помощи статического метода Вектор из файл  */
        Reader in = new FileReader("out2.txt");
        ArrayVector v = (ArrayVector) Vectors.readVector(in);

        /* Протестим, что получилось  */
        System.out.println(v.getLength());
        System.out.println(v.getElement(5));


        /* Тест ObjectOutputStream  */
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));
        objectOutputStream.writeObject(arrayVector1);
        System.out.println(arrayVector1.getElement(2) + "    " + arrayVector1.getLength());
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"));
        ArrayVector arrayVector = (ArrayVector) objectInputStream.readObject();
        System.out.println(arrayVector.getElement(2) + "    " + arrayVector.getLength());

          /* Тест toString()  */
        System.out.println(arrayVector1.toString());

        /* Сравниваем объекты переопределенным методом  */
        System.out.println(arrayVector.equals(arrayVector1));

        /* Сравниваем ссылки */
        System.out.println(arrayVector == arrayVector1);

    }

    public static void cloneTest() {
        /* Клонирование объекта ArrayVector */
        ArrayVector arrayVector = new ArrayVector(8);
        Vector Clone = (ArrayVector) arrayVector.clone();

        /* Клонирование Связного списка*/
        LinkedListVector linkedListVector = new LinkedListVector();
        linkedListVector.addElement(4.5);
        linkedListVector.addElement(6.7);
        System.out.println("+Список создан+");
        LinkedListVector linkedListVector1 = (LinkedListVector) linkedListVector.clone();
        linkedListVector1.setElement(0, 0.1);
        System.out.println("Поля ссылаются на одни и те же объекты : " + (linkedListVector.getElement(0) == linkedListVector1.getElement(0) ? "Yes, переделывать нужно" : "No, Склонировалось нормально"));
    }

    public static void threadsTest() {
        // Создадим тестовый вектор с полями = 0
        Vector vector = new LinkedListVector(8);
        // Создадим поток записи
        WriteThread writeThread = new WriteThread(vector);
        // Создадим поток чтения
        ReadThread readThread = new ReadThread(vector);
        try {
            readThread.join();
            writeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void threadTestSyncro(){
        // Создадим тестовый вектор с полями = 0 и синхронайзер
        Vector vector = new LinkedListVector(8);
        Vector vector1 = new ArrayVector(8);
        VectorSynchronizer vectorSynchronizer = new VectorSynchronizer(vector);

        // Создадим поток записи
        WriteThreadRun writeThreadRun = new WriteThreadRun(vectorSynchronizer);
        // Создадим поток чтения
        ReadThreadRun readThreadRun = new ReadThreadRun(vectorSynchronizer);
    }

    public static void main(String[] args) throws Exception {
        threadTestSyncro();
    }
}
