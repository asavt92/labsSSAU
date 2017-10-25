package labs;

import java.io.*;

public class Vectors {

    static private String delimiter = EDelimiters.SLASH.getDelimiter();


    public static void mult(Vector vector, double a) throws ArrayIndexOutOfBoundsException{
        int length = vector.getLength();
        for (int i = 0; i < length; i++) {
            vector.setElement(i, vector.getElement(i) * a);
        }
    }

    public static void sum(Vector vector1, Vector vector2) throws ArrayIndexOutOfBoundsException {
        int length;
        if (vector1.getLength() >= vector2.getLength()) {
            length = vector1.getLength();
        } else {
            length = vector2.getLength();
        }
        for (int i = 0; i < length; i++) {
            vector1.setElement(i, vector1.getElement(i) + vector2.getElement(i));
        }
    }

    public static void scalarMult(Vector vector1, Vector vector2) throws ArrayIndexOutOfBoundsException{
        int length;
        if (vector1.getLength() >= vector2.getLength()) {
            length = vector1.getLength();
        } else {
            length = vector2.getLength();
        }
        for (int i = 0; i < length; i++) {
            vector1.setElement(i, vector1.getElement(i) * vector2.getElement(i));
        }
    }

    // Записать в файлик длину вектора и его координаты
    public static void outputVector(Vector v, OutputStream out) throws IOException, ArrayIndexOutOfBoundsException {
        DataOutputStream dos = new DataOutputStream(out);
        int n = v.getLength();
        dos.writeInt(n);
        for (int i = 0; i < n; i++) {
            dos.writeDouble(v.getElement(i));
        }
        dos.flush();
        dos.close();
    }

    // Создать ArrayVector из файлика
    public static Vector inputVector(InputStream in) throws IOException,ArrayIndexOutOfBoundsException {
        DataInputStream dis = new DataInputStream(in);
        Vector v;

        int length = dis.readInt();
        v = new ArrayVector(length);
        for (int i = 0; i < length; i++) {
            v.setElement(i, dis.readDouble());
        }
        dis.close();
        return v;
    }

    public static void writeVector(Vector v, Writer out) throws ArrayIndexOutOfBoundsException {
        PrintWriter pw = new PrintWriter(out);
        int length = v.getLength();
        pw.write(String.valueOf(length));
        for (int i = 0; i < length; i++) {
            pw.write(delimiter+String.valueOf(v.getElement(i)));
        }
        pw.flush();
        pw.close();
    }

    public static Vector readVector(Reader in) throws IOException,ArrayIndexOutOfBoundsException{
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        String[] tokens = str.split(delimiter);
        int length = Integer.parseInt(tokens[0]);
        Vector v = new ArrayVector(length);
        for (int i = 1;i<length;i++){
            v.setElement(i-1,Double.parseDouble(tokens[i]));
        }
        return v;
    }

}

