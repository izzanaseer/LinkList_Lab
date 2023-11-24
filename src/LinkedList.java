public class LinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteNode(int key) {
        Node current = head;
        Node prev = null;

        // If the head node holds the key to be deleted
        if (current != null && current.data == key) {
            head = current.next;
            return;
        }

        // Search for the key to be deleted, keeping track of the previous node
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // If the key was not found in the list
        if (current == null) {
            return;
        }

        // Unlink the node from the list
        prev.next = current.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverseIterative() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's next pointer
            prev = current;      // Move prev to the current node
            current = next;      // Move current to the next node
        }

        // Update the head to the last node (prev)
        head = prev;
    }

    public void reverseRecursive() {
        head = reverseRecursiveUtil(head, null);
    }

    private Node reverseRecursiveUtil(Node current, Node prev) {
        // Base case: If we reach the end of the list, return the current node
        if (current == null) {
            return prev;
        }

        Node next = current.next;   // Store the next node
        current.next = prev;        // Reverse the current node's next pointer
        return reverseRecursiveUtil(next, current);
    }

    public Node detectCycle() {
        Node slow = head;
        Node fast = head;

        // Move slow and fast pointers until they meet or fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If there's a cycle, the slow and fast pointers will meet
            if (slow == fast) {
                break;
            }
        }

        // If there's no cycle (fast reached the end), return null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Move one pointer to the head and keep the other at the meeting point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // Return the starting node of the cycle
        return slow;
    }

    public Node findMiddle() {
        if (head == null) {
            return null; // The list is empty
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;      // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps
        }

        return slow;
    }

    public static LinkedList mergeSortedListsAtBeginning(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.insertAtBeginning(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insertAtBeginning(current2.data);
                current2 = current2.next;
            }
        }

        // If one of the lists has remaining elements, add them to the merged list
        while (current1 != null) {
            mergedList.insertAtBeginning(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.insertAtBeginning(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }
}