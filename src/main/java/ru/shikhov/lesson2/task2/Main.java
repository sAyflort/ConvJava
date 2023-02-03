package ru.shikhov.lesson2.task2;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }

        myArrayList.delete(2);
        myArrayList.delete(0);

        myArrayList.put(2, 1000);
        myArrayList.put(2, 1000);
        myArrayList.put(2, 1000);
        myArrayList.put(2, 1000);

        for (int i = 0; i < myArrayList.getSize(); i++) {
            System.out.println(myArrayList.get(i));
        }
        System.out.println(myArrayList.getSize());
    }
}
