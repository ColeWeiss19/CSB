import java.io.*;
import java.util.*;

// Node class representing an element in the circular linked list
class Node {
    String name; // Name of the person
    Node next; // Reference to the next node

    Node(String name) {
        this.name = name;
    }
}

// CircularLinkedList class for managing the game logic
class CircularLinkedList {
    private Node head; // Head of the list
    private Node tail; // Tail of the list

    // Adds a new node with the given name to the circular linked list
    void add(String name) {
        Node newNode = new Node(name);
        if (head == null) { // If the list is empty
            head = newNode;
            tail = newNode;
            tail.next = head; // Points back to head to make it circular
        } else { // Add to the end of the list
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Maintain circular structure
        }
    }

    // Removes the current node, adjusting pointers to maintain the list
    void remove(Node previous, Node current) {
        if (current == head) { // If removing the head
            head = head.next;
            tail.next = head; // Update tail's next to the new head
        }
        previous.next = current.next; // Skip over the current node
    }

    // Returns the head of the list
    Node getHead() {
        return head;
    }

    // Checks if the list contains only one element
    boolean hasOneElement() {
        return head == head.next;
    }

    // Prints all names in the list
    void printList() {
        if (head == null) return; // If the list is empty
        Node temp = head;
        do {
            System.out.print(temp.name); // Print the current name
            temp = temp.next;
            if (temp != head) System.out.print(", "); // Add commas between names
        } while (temp != head);
        System.out.println(); // End the line
    }
}

// Main class to run the circular list game
public class CircularListGame {
    public static void main(String[] args) throws IOException {
        // Initialize the circular linked list and special name
        CircularLinkedList list = new CircularLinkedList();
        String specialName = "YourName"; // Change this to your special name

        // Read names from the file and add to the list
        try (BufferedReader reader = new BufferedReader(new FileReader("names.txt"))) {
            String name;
            while ((name = reader.readLine()) != null) {
                list.add(name);
            }
        }

        System.out.println("Initial List:");
        list.printList();

        Random random = new Random(); // Random number generator

        // Continue until only one person is left
        while (!list.hasOneElement()) {
            // Ensure the size is valid before generating the random number
            int size = getSize(list);
            if (size < 4) {
                throw new IllegalStateException("List size must be at least 4 to continue the game.");
            }

            // Generate a random count between 4 and the size of the list
            int count = random.nextInt(4, size);
            System.out.println("Random number is: " + count);

            Node prev = null; // Tracks the previous node
            Node current = list.getHead(); // Start at the head

            // Move around the list based on the random count
            for (int i = 1; i < count; i++) {
                prev = current;
                current = current.next;
            }

            // Check if the special name is selected
            if (current.name.equals(specialName)) {
                System.out.println("Giudice lands on " + current.name + " (special). Rejoining at the head.");
                specialNameRejoin(list, prev, current);
            } else {
                System.out.println("Del " + current.name);
                list.remove(prev, current);
            }

            System.out.println("New List:");
            list.printList();
        }

        // Announce the winner
        System.out.println("Winner is: " + list.getHead().name + "!!!");
    }

    // Calculates the size of the circular linked list
    private static int getSize(CircularLinkedList list) {
        Node temp = list.getHead();
        int size = 0;
        do {
            size++;
            temp = temp.next;
        } while (temp != list.getHead()); // Loop until we return to the head
        return size;
    }

    // Handles the special case where the special name re-enters the list
    private static void specialNameRejoin(CircularLinkedList list, Node prev, Node special) {
        if (prev != null) {
            prev.next = special.next; // Remove the special node from its current position
        }
        list.add(special.name); // Add the special node back to the list at the end
    }
}
