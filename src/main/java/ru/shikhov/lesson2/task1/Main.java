package ru.shikhov.lesson2.task1;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.add("word1");
        mll.add("word2");
        mll.add("word3");
        mll.add("word4");
        mll.add("word5");
        showMyLinkedList(mll);

        mll.delete("word2");
        showMyLinkedList(mll);

        mll.delete(0);
        mll.delete(2);
        showMyLinkedList(mll);

        mll.put(0, "word0.1");
        showMyLinkedList(mll);
    }

    public static void showMyLinkedList(MyLinkedList<String> eMyLinkedList) {
        System.out.println("*****");
        for(int i = 0; i < eMyLinkedList.getSize(); i++) {
            System.out.println(eMyLinkedList.get(i));
        }
        System.out.println("*****");
    }
}

