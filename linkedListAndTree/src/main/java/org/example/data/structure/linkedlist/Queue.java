package org.example.data.structure.linkedlist;

public class Queue {

    Node head;
    static class Node {
        final int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void push(Queue queue, int data) {
        Node curr = queue.head;
        Node newNode = new Node(data);
        if (curr == null) {
            queue.head = newNode;
            return;
        }

        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
    }

    public static int pop(Queue queue) {
        Node curr = queue.head;
        queue.head = queue.head.next;
        return curr.data;
    }

    public static int queue() {

        Queue queue = new Queue();

        Queue.push(queue, 1);
        Queue.push(queue, 2);
        Queue.push(queue, 3);
        Queue.push(queue, 4);

        Queue.pop(queue);

        return Queue.pop(queue);

    }
}
