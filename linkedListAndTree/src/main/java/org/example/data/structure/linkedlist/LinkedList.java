package org.example.data.structure.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LinkedList<I extends Number> {
    Node head;
    static class Node {
        final int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    EspNode headEsp;
    static class EspNode {
        final int data;
        EspNode right, down;

        EspNode(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }

    public static LinkedList<Number> insert(LinkedList<Number> list, int data) {
        Node insertNode = new Node(data);
        insertNode.next = null;

        if (list.head == null) {
            list.head = insertNode;
        } else {
            Node lastNode = list.head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = insertNode;
        }
        return list;
    }

    public static void printList(LinkedList<Number> list) {
        Node currNode = list.head;

        while(currNode.next != null) {
            System.out.println(currNode.data);
            currNode = currNode.next;
        }
    }

    public static LinkedList<Number> deleteKey(LinkedList<Number> list, int key) {

        if (list.head.data == key) {
            if (list.head.next == null) {
                return null;
            }
            list.head = list.head.next;
        } else {
            Node currNode = list.head;
            Node prevNode = list.head;

            while(currNode != null && currNode.data != key) {
                prevNode = currNode;
                currNode = currNode.next;
            }

            if (currNode != null) {
                prevNode.next = currNode.next;
            }
        }
        return list;
    }

    public static LinkedList<Number> CreateEspLinkedList() {
//        LinkedList L = new LinkedList();
//        L.headEsp = L.push(L.headEsp, 30);
//        L.headEsp = L.push(L.headEsp, 8);
//        L.headEsp = L.push(L.headEsp, 7);
//        L.headEsp = L.push(L.headEsp, 5);
//
//        L.headEsp.right = L.push(L.headEsp.right, 20);
//        L.headEsp.right = L.push(L.headEsp.right, 10);
//
//        L.headEsp.right.right = L.push(L.headEsp.right.right, 50);
//        L.headEsp.right.right = L.push(L.headEsp.right.right, 22);
//        L.headEsp.right.right = L.push(L.headEsp.right.right, 19);
//
//        L.headEsp.right.right.right = L.push(L.headEsp.right.right.right, 45);
//        L.headEsp.right.right.right = L.push(L.headEsp.right.right.right, 40);
//        L.headEsp.right.right.right = L.push(L.headEsp.right.right.right, 35);
//        L.headEsp.right.right.right = L.push(L.headEsp.right.right.right, 20);
        return null;
    }

    public static LinkedList<Number> flattenList(LinkedList<Number> list) {
        return list;
    }

    public static Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static Node rotate(int k, LinkedList<Number> list) {
        if (k == 0)
            return null;

        Node current = list.head;

        // Traverse till the end.
        while (current.next != null)
            current = current.next;

        current.next = list.head;
        current = list.head;

        // traverse the linked list to k-1 position which
        // will be last element for rotated array.
        for (int i = 0; i < k - 1; i++)
            current = current.next;

        // update the head_ref and last element pointer to null
        list.head = current.next;
        current.next = null;

        printList(list);
        return list.head;
    }

    public static Node addTwoLinkedList(LinkedList<Number> list1, LinkedList<Number> list2) {

        Node head1 = reverse(list1.head);
        Node head2 = reverse(list2.head);
        LinkedList<Number> linkedListNew = new LinkedList<Number>();

        Node curr1 = head1;
        Node curr2 = head2;
        int carry = 0;

        while (curr1 != null || curr2 != null ) {
            int sum = ((curr1 != null) ? curr1.data : 0) + ((curr2 != null) ? curr2.data : 0) + carry;
            carry = sum/10;

            if (sum >= 10)
                sum = sum%10;

            insert(linkedListNew, sum);

            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }
        if (carry > 0)
            insert(linkedListNew, carry);

        return reverse(linkedListNew.head);
    }

    public static boolean isLooped(LinkedList<Number> list) {

        Map<Integer, Integer> sampleMap = new HashMap<>();
        if (list == null || list.head == null) return false;

        Node curr = list.head;

        while (curr.next != null) {
            if (sampleMap.containsKey(curr.data)){
                return true;
            }
            sampleMap.put(curr.data, curr.data);
            curr = curr.next;
        }
        return false;
    }
}
