package ru.shikhov.lesson2.task2;


public class MyArrayList<E> {
    private Object[] data = new Object[10];
    private final float GROWN_CONST = 1.5f;
    private int indexOfLast = 0;

    public MyArrayList() {
    }

    public void add(E item) {
        if(indexOfLast == data.length) {
            grownArray();
        }
        data[indexOfLast] = item;
        indexOfLast++;
    }

    private void grownArray() {
        Object[] newData = new Object[(int)(data.length*GROWN_CONST)];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    public void put(int index, E item) {
        if(index >= indexOfLast) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (item == null) {
            throw new NullPointerException();
        }
        if(indexOfLast == data.length) {
            grownArray();
        }
        System.arraycopy(data, index, data, index+1, indexOfLast - index);
        data[index] = item;
        indexOfLast++;
    }

    public void delete(int index) {
        if(index >= indexOfLast) {
            return;
        }
        //System.out.println(indexOfLast);
        System.arraycopy(data, index + 1, data, index, indexOfLast - index - 1);
        indexOfLast--;
    }

    public E get(int index) {
        if(index >= indexOfLast) {
            throw new NullPointerException();
        }
        return (E) data[index];
    }

    public int getSize(){
        return indexOfLast;
    }
}
