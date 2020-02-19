package ru.geekbrains;

public class DoubleLinkedList<T> {

    private Node<T> pre;
    private Node<T> post;

    public DoubleLinkedList() {
        pre = new Node<>(null);
        post = new Node<>(null);
        pre.next = post;
        post.prev = pre;
    }

    public void insertTail(T value) {
        Node<T> last = post.prev;
        Node<T> newNode = new Node<>(value);
        newNode.next = post;
        newNode.prev = last;
    }

    public void insertHead(T value) {
        //TODO реализовать в качестве ДЗ
    }

    public T deleteHead() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    public T deleteTail() {
        //TODO реализовать в качестве ДЗ
        return null;
    }

    //TODO реализовать итератор в качестве ДЗ

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
