package labs;

import java.io.Serializable;

public class LinkedListVector implements Vector, Cloneable, Serializable {
    //Вспомогательный внутренний класс, реализует элемент связного списка.
    private class Node implements Cloneable {
        //Значение, которое хранит элемент связного списка.
        double value = Double.NaN;
        //Ссылка на предыдущий элемент связного списка.
        Node prev = null;
        //Ссылка на следующий элемент связного списка.
        Node next = null;

        public Node(double value, Node prev, Node next) {// Конструктор внутреннего класса
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
            super();
        }

        public Node clone() {
            try {
                return (Node) super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println("Клонирование невозможнО!");
                return this;
            }
        }
    }

    //Ссылка на голову связного списка.
    private Node head = new Node();

    /*блок инициализации, зацикливающий ссылки головы списка в момент создания объекта.*/ {
        head.prev = head;
        head.next = head;
    }

    //Текущая длина связного списка.
    private int size = 0;
    //Ссылка на последний использовавшийся элемент связного списка.
    private Node current = head;
    /*Номер последнего использовавшиегося элемента связного списка. Значение "-1" соответствует голове.*/
    private int currentIndex = -1;

    /*Вспомогательный метод доступа к элементу списка.
       Должен использоваться для доступа из всех остальных методов, т.к. реализует механизм "памяти". index - номер требующегося элемента*/
    private Node gotoNumber(int index) {
        if ((index >= 0) && (index < size)) {
            if (index < currentIndex) {
                if (index < currentIndex - index) {
                    current = head;
                    for (int i = -1; i < index; i++)
                        current = current.next;
                } else {
                    for (int i = currentIndex; i > index; i--)
                        current = current.prev;
                }
            } else {
                if (index - currentIndex < size - index) {
                    for (int i = currentIndex; i < index; i++)
                        current = current.next;
                } else {
                    current = head;
                    for (int i = size; i > index; i--)
                        current = current.prev;
                }
            }
            currentIndex = index;
            return current;
        } else
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public void addElement(double val) {
        Node newNode = new Node(val, head.prev, head);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
        size++;
        current = newNode;
        currentIndex++;
    }

    public void addElement(int index, double val) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Некорректный индекс Index: " + index + ", Size: " + size);
        if (index == size) {
            addElement(val);
        } else {
            Node e = gotoNumber(index);
            Node newNode = new Node(val, e.prev, e);
            newNode.prev.next = newNode;
            newNode.next.prev = newNode;
            size++;
            current = newNode;
            currentIndex++;
        }
    }

    public void deleteElement(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Некорректный индекс Index: " + index + ", Size: " + size);
        Node elementDel = gotoNumber(index);
        elementDel.prev.next = elementDel.next;
        elementDel.next.prev = elementDel.prev;
        current = elementDel.next;
        elementDel.prev = null;
        elementDel.next = null;
        elementDel.value = Double.NaN;
        size--;
    }


    @Override
    public int getLength() {
        return size;
    }

    @Override
    public double getElement(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Некорректный индекс Index: " + index + ", Size: " + size);
        return gotoNumber(index).value;
    }

    @Override
    public double getNorma() {
        int length = getLength();
        double s = 0;
        for (int i = 0; i < length; i++) {
            s = s + getElement(i);
        }
        return Math.sqrt(s);
    }

    @Override
    public void setElement(int index, double value) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Некорректный индекс Index: " + index + ", Size: " + size);
        gotoNumber(index).value = value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("| Class:" + getClass().getName() + " | Length " + String.valueOf(getLength()) + " | ");
        for (int i = 0; i < getLength(); i++) {
            stringBuffer.append("Element[" + i + "] = " + getElement(i) + " | ");
        }
        String string = new String(stringBuffer);
        return string;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vector) {
            if (getLength() == ((Vector) obj).getLength()) {
                for (int i = 0; i < getLength(); i++) {
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
        Node current = head.next;
        while (current != head) {
            t = Double.doubleToLongBits(current.value);
            result ^= (((int) (t >> 32)) ^ (int) (t & 0x00000000FFFFFFFF));
            current = current.next;
        }
        return result;
    }

    public Object clone() {
        try {
            return super.clone();

            Node head = gotoNumber(-1).clone();

            for(int i = -1;i<getLength();i++){

            }


        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование невозможнО!");
            return this;
        }
    }
}
