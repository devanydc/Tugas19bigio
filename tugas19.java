import java.util.*;

public class tugas19 {

    /* Class untuk objek node */
    static class Node {
        int data;
        Node next;
    }

    static void printList(Node head, int jumlah_array) {
        int a = 0;
        if (head == null) {
            return;
        }

        while (head.next != null && a < jumlah_array) {
            System.out.print(head.data + "->");
            head = head.next;
            a++;
        }
        System.out.print(head.data + "\n");
    }

    // print Linked List
    static void createCircular(Node head) {
        Node first = head;

        if (head == null) {
            return;
        }

        while (head.next != null && head.next != head) {
            head = head.next;
        }

        head.next = first;
    }

    // Cek siklus
    static boolean isCircular(Node head) {

        // Jika tidak ada data
        if (head == null)
            return false;

        // Geser node
        Node node = head.next;

        // Loop selama bukan data terakhir
        while (node != null && node != head) {
            node = node.next;
        }

        // return hasil looping
        return (node == head);
    }

    // Fungsi buat node baru
    static Node newNode(Node head_ref, int data) {
        Node new_node = new Node();

        new_node.data = data;

        new_node.next = head_ref;

        head_ref = new_node;

        return head_ref;
    }

    public static void main(String args[]) {

        int[] angka = { 1, 2, 3 };
        int jumlah_array = angka.length;
        Node head = null;

        // Buat linked list dari array angka
        if (angka.length >= 0 && angka.length <= 1000) {

            for (int i = angka.length - 1; i >= 0; i--) {
                head = newNode(head, angka[i]);
            }

        }

        // print isi linked list
        printList(head, jumlah_array);

        // Nilai siklus linked list sebelum menjadi circular
        System.out.println("Siklus: " + (isCircular(head) ? "1" : "0"));

        // Buat linked list menjadi circular
        createCircular(head);

        // print isi linked list setelah menjadi circular
        printList(head, jumlah_array);

        // Nilai siklus linked list setelah menjadi circular
        System.out.println("Siklus: " + (isCircular(head) ? "1" : "0"));

    }
}
