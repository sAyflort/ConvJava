package ru.shikhov.lesson2.task1;


public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;

    private int size = 0;

    public int getSize() {
        return size;
    }

    public E get(int index) {
        Node<E> temp = first;
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = 0; temp != null; i++) {
            if (i == index) {
                return temp.value;
            }
            temp = temp.next;
        }
        throw new NullPointerException();
    }

    public void put(int index, E item) {
        Node<E> temp = first;
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = 0; temp != null; i++) {
            if (i == index) {
                Node<E> node = new Node<>(temp.prev, temp, item);
                if(temp.prev == null) {
                    temp.prev = node;
                    first = node;
                } else {
                    temp.prev.next = node;
                    temp.prev = node;
                }
                size++;
                return;
            }
            temp = temp.next;
        }
    }

    public void delete(int index) {
        Node<E> temp = first;
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = 0; temp != null; i++) {
            if (i == index) {
                removeNode(temp);
                return;
            }
            temp = temp.next;
        }
    }

    public void delete(E item) {
        Node<E> temp = first;
        while (temp != null) {
            if(temp.value.equals(item)) {
                removeNode(temp);
                return;
            }
            temp = temp.next;
        }
    }

    private void removeNode(Node<E> node) {
        if(node.prev == null) {
            node.next.prev = null;
            first = node.next;
        } else if(node.next == null) {
            node.prev.next = null;
            last = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    public void add(E item) {
        Node<E> l = last;
        Node<E> newLast = new Node<>(l, null, item);
        last = newLast;
        if(l == null) {
            first = newLast;
        } else {
            l.next = newLast;
        }
        size++;
    }

    public MyLinkedList() {
    }

    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E value;

        public Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
