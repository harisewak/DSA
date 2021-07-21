package com.harisewak.dsa.datastructures.implementation;

public class Stack {

    private DoublyLinkedList stack;

    public Stack() {
        stack = new DoublyLinkedList(null, null);
    }

    public void push(DoublyLinkedList.Node node) {
        stack.add(node);
    }

    public DoublyLinkedList.Node pop() {
        return stack.remove();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
