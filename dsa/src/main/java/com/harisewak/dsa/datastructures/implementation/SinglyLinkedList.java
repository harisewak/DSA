package com.harisewak.dsa.datastructures.implementation;


public class SinglyLinkedList {
    Node head;
    Node tail;
    private int size;

    public class Node<T> {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public SinglyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Node elem) {

        if (isEmpty()) {
            head = tail = elem;
        } else {
            elem.next = head;
            head = elem;
        }

        ++size;
    }

    public void remove() {
        removeFirst();
    }

    public void removeFirst() {

        if (isEmpty()) throw new RuntimeException("Empty List");

        Node temp = head.next;
        // cleaning existing head memory
        head.data = null;
        head.next = null;
        head = null;
        // assigning next element as head
        head = temp;

        --size;
    }

    private void removeLast() {

        if (isEmpty()) throw new RuntimeException("Empty List");

        Node trav = head;
        Node prev = null;

        while (trav != null) {

            // reached last element
            if (trav.next == null) {
                trav = tail = null;
                prev.next = null;
                --size;
                break;
            }

            prev = trav;
            trav = trav.next;
        }
    }
}
