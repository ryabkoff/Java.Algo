package ru.geekbrains;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> pre;
    private Node<T> post;

    public DoubleLinkedList() {
        pre = new Node<>(null);
        post = new Node<>(null);
        pre.next = post;
        post.prev = pre;
    }

    public void insertTail(T value) {

        Node<T> newNode = new Node<>(value);
        if (post.prev == pre) {
            pre.next = newNode;
        }
        else {
            Node<T> last = post.prev;
            newNode.prev = last;
            last.next = newNode;
        }
        post.prev = newNode;
    }

    public void insertHead(T value) {

        Node<T> newNode = new Node<>(value);
        if (pre.next == post) {
            post.prev = newNode;
        }
        else {
            Node<T> first = pre.next;
            newNode.next = first;
            first.prev = newNode;
        }
        pre.next = newNode;
    }

    public T deleteHead() {

        if (pre.next == post) {
            return null;
        }
        else {
            Node<T> first = pre.next;
            Node<T> newFirst = first.next;

            if (newFirst == null) {
                pre.next = post;
                post.prev = pre;
            }
            else {
                pre.next = newFirst;
                newFirst.prev = null;
            }
            first.next = null;

            return first.value;
        }
    }

    public T deleteTail() {

        if (pre.next == post) {
            return null;
        }
        else {
            Node<T> last = post.prev;
            Node<T> newLast = last.prev;

            if (newLast == null) {
                pre.next = post;
                post.prev = pre;
            }
            else {
                post.prev = newLast;
                newLast.next = null;
            }
            last.prev = null;

            return last.value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> curr = pre.next;

            @Override
            public boolean hasNext() {

                //return curr != post.prev;
                return curr != post && curr != null;
                //return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.insertHead(1);
        doubleLinkedList.insertHead(2);
        doubleLinkedList.insertHead(3);
        doubleLinkedList.forEach(System.out::print);
        System.out.println();

        doubleLinkedList.insertTail(1);
        doubleLinkedList.insertTail(2);
        doubleLinkedList.insertTail(3);
        doubleLinkedList.forEach(System.out::print);
        System.out.println();

        doubleLinkedList.deleteHead();
        doubleLinkedList.forEach(System.out::print);
        System.out.println();

        doubleLinkedList.deleteHead();
        doubleLinkedList.forEach(System.out::print);
        System.out.println();

        doubleLinkedList.deleteHead();
        doubleLinkedList.forEach(System.out::print);
        System.out.println();

        doubleLinkedList.deleteTail();
        doubleLinkedList.forEach(System.out::print);
        System.out.println();

        doubleLinkedList.deleteTail();
        doubleLinkedList.forEach(System.out::print);
        System.out.println();

        doubleLinkedList.deleteTail();
        doubleLinkedList.forEach(System.out::print);
        System.out.println();


    }
}
