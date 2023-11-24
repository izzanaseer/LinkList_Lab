public class Main {
    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();

        list1.insertAtBeginning(10);
        list1.insertAtBeginning(20);
        list1.insertAtBeginning(30);
        list1.insertAtBeginning(40);

        System.out.println("Original Linked List:");
        list1.display();

        list1.deleteNode(20);
        list1.deleteNode(30);

        System.out.println("Linked List after deletion:");
        list1.display();

        list1.reverseIterative();
        System.out.println("Reversed Linked List (Iterative):");
        list1.display();

        list1.reverseRecursive();
        System.out.println("Reversed Linked List (Recursive):");
        list1.display();

        LinkedList.Node cycleStartNode = list1.detectCycle();
        if (cycleStartNode != null) {
            System.out.println("Cycle found. Starting node of the cycle: " + cycleStartNode.data);
        } else {
            System.out.println("No cycle found.");
        }

        LinkedList.Node middleNode = list1.findMiddle();
        if (middleNode != null) {
            System.out.println("Middle Node: " + middleNode.data);
        } else {
            System.out.println("The list is empty.");
        }

        LinkedList list2 = new LinkedList();
        list2.insertAtBeginning(35);
        list2.insertAtBeginning(25);
        list2.insertAtBeginning(15);

        System.out.println("First Sorted List:");
        list1.display();

        System.out.println("Second Sorted List:");
        list2.display();

        LinkedList mergedList = LinkedList.mergeSortedListsAtBeginning(list1, list2);
        System.out.println("Merged Sorted List:");
        mergedList.display();
    }
}