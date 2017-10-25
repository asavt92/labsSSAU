package labs;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, ArrayIndexOutOfBoundsException {
        ArrayVector arrayVector1 = new ArrayVector(8);
        for (int i = 0; i < arrayVector1.getLength();i++){
            System.out.println(arrayVector1.getElement(i));
        }

//        Writer out = new FileWriter("out2.txt");
//        Vectors.writeVector(arrayVector1,out);

//        Reader in = new FileReader("out2.txt");
//        ArrayVector v = (ArrayVector) Vectors.readVector(in);
//        System.out.println(v.getLength());
//
//        System.out.println(v.getElement(5));

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));
        objectOutputStream.writeObject(arrayVector1);
        System.out.println(arrayVector1.getElement(2) + "    " + arrayVector1.getLength());
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"));
        ArrayVector arrayVector = (ArrayVector) objectInputStream.readObject();
        System.out.println(arrayVector.getElement(2) + "    " + arrayVector.getLength());


    }

}
