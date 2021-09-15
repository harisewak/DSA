package com.harisewak.dsa.datastructures.implementation;


public class DoublyLinkedList {
    Node head;
    Node tail;
    private int size;

    public DoublyLinkedList() {
        // empty constructor
    }

    public static class Node<T> {
        T data;
        Node next;
        Node prev;

        private Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public T getData() {
            return data;
        }

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public DoublyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
        add at the end
        update tail's next pointer to this node
        update this node's prev pointer to tail
        update tail to this node
    * */

    public void add(Node elem) {

        if (isEmpty()) {
            head = tail = elem;
        } else {
            tail.next = elem;
            elem.prev = tail;
            tail = elem;
        }

        ++size;
    }

    /*
    function add_first:
    set prev of head as this element
    set prev of this element as NULL
    set next of this element as head
    set this element as head
    * */
    public void addFirst(Node elem) {

        if (isEmpty()) {
            head = tail = elem;
        } else {
            head.prev = elem;
            elem.prev = null;
            elem.next = head;
            head = elem;
        }

        ++size;
    }

     /*
    removing :
    at the end
    get tail's prev node
    set its next pointer to NULL
    set tail to NULL
    set prev node as tail
    decrement size
    * */

    private Node removeLast() {

        if (isEmpty()) throw new RuntimeException("Empty List");

        Node last = tail;

        if (size == 1) {

            tail = head = null;

        } else {

            Node prev = tail.prev;
            prev.next = null;
            tail = null;
            tail = prev;

        }

        --size;

        return last;
    }

    public Node remove() {
        return removeLast();
    }

    @Override
    public String toString() {

        if (isEmpty()) return "[]";

        StringBuilder builder = new StringBuilder();

        builder.append("[");

        Node trav = head;

        while (trav != null) {
            builder.append(trav.data);
            builder.append(", ");
            trav = trav.next;
        }

        // removing extra ','
        builder.deleteCharAt(builder.lastIndexOf(","));

        builder.deleteCharAt(builder.length() - 1);

        builder.append("]");

        return builder.toString().trim();
    }
}
