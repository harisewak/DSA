package com.harisewak.dsa.datastructures.implementation;

public class Queue {

    private DoublyLinkedList queue;

    public Queue() {
        queue = new DoublyLinkedList(null, null);
    }

    public void push(DoublyLinkedList.Node node) {
        queue.addFirst(node);
    }

    public DoublyLinkedList.Node pop() {
        return queue.remove();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
